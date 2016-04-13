package edu.ittc.training.controllers;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import edu.ittc.training.model.Item;
import edu.ittc.training.model.ItemDAO;
import edu.ittc.training.model.ItemDAOImpl;
import edu.ittc.training.testdb.DBUtil;

/**
 * Servlet implementation class ItemDB
 */
@WebServlet("/admin-AddServlet")
public class AddServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	protected void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		res.setContentType("text/html");
		String stockId = req.getParameter("stockId");
		String itemName = req.getParameter("itemName");
		double unitPrice = Double.parseDouble(req.getParameter("unitPrice"));
		int onStock = Integer.parseInt(req.getParameter("onStock"));
		
		ItemDAO itemDB = new ItemDAOImpl();
		
		Item item;
		
		try{
			item = new Item(stockId, itemName, unitPrice, onStock);
			//itemDB.openConnection();
			PrintWriter out = res.getWriter();
			
			if(itemDB.addNewItem(item)){
				out.println("Item successfully added");
				RequestDispatcher rd = req.getRequestDispatcher("/shared-ListAllServlet");
				rd.include(req, res);
			} else {
				out.println("Add item failed");
				RequestDispatcher rd = req.getRequestDispatcher("/admin-AddItem.html");
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
