package edu.ittc.training.shop;

import java.io.IOException;
import java.util.Enumeration;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import edu.ittc.training.shop.DataService;
import edu.ittc.training.model.Item;

@WebServlet("/client-purchase")
public class Purchase extends HttpServlet {
	private static final long serialVersionUID = -6124073838468626461L;

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		
		String itemId = req.getParameter("item");
		int qnty = Integer.parseInt(req.getParameter("qnty"));
		
		HttpSession session = req.getSession();
		MyCart myCart = (MyCart) session.getAttribute("cart");
		DataService service = (DataService) session.getAttribute("dataservice");
		
		if(myCart == null) {
			myCart = new MyCart();
			session.setAttribute("cart", myCart);
			session.setAttribute("red", false); 
			session.setAttribute("message", "");
		}
		
		//if(service == null) {
			service = new DataService();
			session.setAttribute("dataservice", service);
			session.setAttribute("original", service.getAsList()); //throw to JSTL
		//}
		
		session.removeAttribute("message");
		
		// TODO: validation for item and quantity ordered
		Item item = service.retrieveItem(itemId.trim());
		
		if(item != null) {
			boolean match = false;
			int oldorder = 0;
			int neworder = 0;
			ItemPurchase temp = null;
			
			for(ItemPurchase it: myCart.getList()) {	
			//to check if item is already in arraylist	
				if(it.getItemId().contentEquals(item.getStockId())){
					match = true;
					oldorder = it.getNoItems();
					neworder = qnty+oldorder;
					temp = it;
					break;
				}
			}
			
			//if stock is not enough, red is true
			if(match==false){
				if(qnty>item.getOnStock()){
					session.setAttribute("red", true);
				}
				myCart.addToCart(new ItemPurchase(item, qnty));
			}
			else {
				if(neworder>item.getOnStock()){
					session.setAttribute("red", true);
				}
				myCart.remove(temp);
				myCart.addToCart(new ItemPurchase(item, neworder));
			}	
			session.setAttribute("message", "Item: "+ item.getItemName() +" Qnty: " + qnty + " Price: " + item.getUnitPrice() + " sent to cart.");
			
			int i = 0;
			for(ItemPurchase it: myCart.getList()) {
				log("Item: "+ (++i) + " " + it.getItemName());
			}
			
		} else {
			session.setAttribute("message", itemId + ", Item not found...");
		}
		//RequestDispatcher rd = req.getRequestDispatcher("/shop.jsp");
		resp.sendRedirect(req.getContextPath()+"/client-shop.jsp");
	}
	
}
