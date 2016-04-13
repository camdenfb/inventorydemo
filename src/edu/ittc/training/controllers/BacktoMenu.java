package edu.ittc.training.controllers;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import edu.ittc.training.filters.User;

@WebServlet("/shared-BacktoMenu")
public class BacktoMenu extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html");
		HttpSession session = request.getSession();
		User user = (User) session.getAttribute("authenticatedUser");
		if(user.getRole().contentEquals("admin")){
			RequestDispatcher rd = request.getRequestDispatcher("main-admin.jsp");
			rd.include(request, response);	
		}
		else if(user.getRole().contentEquals("client")){
			RequestDispatcher rd = request.getRequestDispatcher("main-client.jsp");
			rd.include(request, response);	
		}
		
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
