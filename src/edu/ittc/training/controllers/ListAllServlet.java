package edu.ittc.training.controllers;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.util.ArrayList;
import java.util.List;

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
import edu.ittc.training.testdb.DBUtil;

@WebServlet("/shared-ListAllServlet")
public class ListAllServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		// TODO Auto-generated method stub
		HttpSession session = req.getSession();
		ItemDAO itemDB = new ItemDAOImpl();
		
		try{
			//itemDB.openConnection();
			PrintWriter out = res.getWriter();
			
			List<Item> allitems = new ArrayList<Item>();
			allitems = itemDB.getAllItems();
			
			if(allitems==null){
				out.println("0 Results to Display");							
			}
			else{
				session.setAttribute("listall", allitems);
			}
			//itemDB.closeConnection();
			RequestDispatcher rd = req.getRequestDispatcher("/shared-ListAll.jsp");
			rd.include(req, res);
			
		}catch(Exception ex){
			ex.printStackTrace();
		}finally{
		}
		
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
