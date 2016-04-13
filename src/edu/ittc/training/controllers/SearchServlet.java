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
 * Servlet implementation class Search
 */
@WebServlet("/shared-SearchServlet")
public class SearchServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
   
	protected void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		// TODO Auto-generated method stub
		res.setContentType("text/html");
		String stockId = req.getParameter("searchBar");
		
		HttpSession session = req.getSession();
		ItemDAO itemDB = new ItemDAOImpl();
		
		try{
			//itemDB.openConnection();
			
			PrintWriter out = res.getWriter();
			
			Item item = itemDB.findItemById(stockId);
			
			if(item==null){
				out.println("0 Results to Display");
				//itemDB.closeConnection();	
				RequestDispatcher rd = req.getRequestDispatcher("/shared-Search.html");
				rd.include(req, res);							
			}
			else{
				session.setAttribute("searchresult", item);
				//itemDB.closeConnection();								
				RequestDispatcher rd = req.getRequestDispatcher("/shared-SearchResults.jsp");
				rd.forward(req, res);
			}
			
		}catch(Exception ex){
			ex.printStackTrace();
		}
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
