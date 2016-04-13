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
@WebServlet("/admin-DeleteServlet")
public class DeleteServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
  
	protected void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		// TODO Auto-generated method stub	
		res.setContentType("text/html");
		HttpSession session = req.getSession();
		ItemDAO itemDB = new ItemDAOImpl();
		Item item = (Item) session.getAttribute("searchresult");
		String id = item.getStockId();
		
		try{
			//itemDB.openConnection();
			
			PrintWriter out = res.getWriter();
			
			if(itemDB.deleteItem(id)){
				out.println("Item successfully deleted");
				RequestDispatcher rd = req.getRequestDispatcher("/shared-ListAllServlet");
				rd.include(req, res);
			} else {
				out.println("Delete item failed");
				RequestDispatcher rd = req.getRequestDispatcher("/shared-SearchResults.jsp");
				rd.include(req, res);
			}
	
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
