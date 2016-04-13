package edu.ittc.training.filters;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebServlet("/loginServlet")
public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html");
		String username = request.getParameter("username");
		String password = request.getParameter("password");
		
		// this will simulate your DB authentication
		UserList service = new UserList();  
		User user = service.authenticateUser(username,password);
		
		System.out.println("\nLoginservlet");
		
		
		if( user != null ) {
			HttpSession session = request.getSession(true);
			session.setAttribute("authenticatedUser", new User(user.getUsername(),user.getPassword(),user.getRole()));
		//upon authentication, identify if admin or client	
			User usertype = (User) session.getAttribute("authenticatedUser");
			RequestDispatcher rd = request.getRequestDispatcher("shared-BacktoMenu");
			rd.forward(request, response);		
		} else {
			PrintWriter out = response.getWriter();
			out.println("<html><body>User NOT Authenticated.</body></html>");
			RequestDispatcher rd = request.getRequestDispatcher("login.html");
			rd.include(request, response);
		}
	}

}
