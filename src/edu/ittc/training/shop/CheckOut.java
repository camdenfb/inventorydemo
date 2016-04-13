package edu.ittc.training.shop;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import edu.ittc.training.filters.User;
import edu.ittc.training.model.Item;
import edu.ittc.training.model.ItemDAO;
import edu.ittc.training.model.ItemDAOImpl;

@WebServlet("/client-checkout")
public class CheckOut extends HttpServlet {
	private static final long serialVersionUID = 1L;     

    public CheckOut() {
        super();
    }

	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		log("Checkout");
		
		HttpSession session = req.getSession();
		ItemDAO itemDB = new ItemDAOImpl();
		MyCart myCart = (MyCart) session.getAttribute("cart");
		ArrayList<Item> original = (ArrayList<Item>) session.getAttribute("original");
		boolean redtrue = (boolean) session.getAttribute("red");
		
		try{
			//itemDB.openConnection();
			if (redtrue==true){
				session.setAttribute("message", "Transaction failed, not enough stock");
			}
			else{
				for(ItemPurchase it: myCart.getList()) {
					for(Item orig: original){
						if(it.getItemId().contentEquals(orig.getStockId())){
							//update orders table
							//String userId = req.getRemoteHost();
							User activeUser = (User) session.getAttribute("authenticatedUser");
							String userId = activeUser.getUsername();
							Order neworder = new Order(userId, it.getItemId(), it.getNoItems(), (it.getNoItems()*it.getUnitPrice()));
							itemDB.addNewOrder(neworder);
							//update items table
							int stockleft = orig.getOnStock()-it.getNoItems();
							Item updated = new Item(orig.getStockId(), orig.getItemName(), orig.getUnitPrice(), stockleft);
							itemDB.saveItem(updated);
						}
					}
				}	
				session.setAttribute("message", "Transaction successful");
			}
			myCart.getList().clear();
			session.setAttribute("red", false);
			//itemDB.closeConnection();
			resp.sendRedirect(req.getContextPath()+"/client-shop.jsp");
		}catch(Exception ex){
			ex.printStackTrace();
		}
	}

}
