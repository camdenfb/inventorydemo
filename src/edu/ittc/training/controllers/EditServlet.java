package edu.ittc.training.controllers;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import edu.ittc.training.model.Item;
import edu.ittc.training.model.ItemDAO;
import edu.ittc.training.model.ItemDAOImpl;

/**
 * Servlet implementation class EditServlet
 */
@WebServlet("/admin-EditServlet")
public class EditServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
  
	protected void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		// TODO Auto-generated method stub	
		res.setContentType("text/html");
		String stockId = req.getParameter("stockId");
		String itemName = req.getParameter("itemName");
		double unitPrice = Double.parseDouble(req.getParameter("unitPrice"));
		int onStock = Integer.parseInt(req.getParameter("onStock"));
		
		HttpSession session = req.getSession();
		ItemDAO itemDB = new ItemDAOImpl();
		PrintWriter out = res.getWriter();
		Item item;
		
		try{
			item = new Item(stockId, itemName, unitPrice, onStock);
			//itemDB.openConnection();
			
			if(itemDB.saveItem(item)){
				out.println("Item successfully updated");
				session.setAttribute("searchresult", item);	
			} else {
				out.println("Edit item failed");
			}
			RequestDispatcher rd = req.getRequestDispatcher("/shared-SearchResults.jsp");
			rd.include(req, res);
			//itemDB.closeConnection();
			
		}catch(Exception ex){
			ex.printStackTrace();
		}
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
