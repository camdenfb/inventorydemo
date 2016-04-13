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

@WebServlet("/client-cancel")
public class CancelOrder extends HttpServlet {
	private static final long serialVersionUID = -6124073838468626461L;

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		resp.setContentType("text/html");
		
		HttpSession session = req.getSession();
		MyCart myCart = (MyCart) session.getAttribute("cart");
		myCart.getList().clear();
		session.setAttribute("red", false);
		session.setAttribute("message", "Orders cancelled");
		resp.sendRedirect(req.getContextPath()+"/client-shop.jsp");
	}
	
}
