package edu.ittc.training.filters;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebFilter(filterName = "AuthenticationFilter", urlPatterns = "/*")
public class AuthenticationFilter implements Filter {
	private int count = 0;
	
    public AuthenticationFilter() {
        // TODO Auto-generated constructor stub
    }

	public void destroy() {
		// TODO Auto-generated method stub
	}

	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) 
			throws IOException, ServletException {
		response.setContentType("text/html");
		HttpServletRequest req = (HttpServletRequest) request;
		HttpServletResponse res = (HttpServletResponse) response;

		HttpSession session = req.getSession(false);
		String path = req.getRequestURI().substring(req.getContextPath().length());
		if( session == null ) {
			System.out.println("Passing thru Authentication Filter.");
			
			if(path.startsWith("/log") /*|| path.startsWith("/main")*/) {
				chain.doFilter(request, response);
			} else {
				res.sendRedirect(req.getContextPath()+"/login.html");
			}
		} else {
			User user = (User) session.getAttribute("authenticatedUser");
			PrintWriter out = res.getWriter();
			if(user != null) {
				System.out.println("Username: " + user.getUsername());
				System.out.println("Password: " + user.getPassword());
				
				//insert else if to separate access to admin from client pages
				if((path.startsWith("/admin") || path.startsWith("/log") || path.startsWith("/shared")) && user.getRole().contentEquals("admin")){
					chain.doFilter(request, response);
				}
				else if((path.startsWith("/client") || path.startsWith("/log") || path.startsWith("/shared")) && user.getRole().contentEquals("client")){
					chain.doFilter(request, response);
				}
				else{
					out.println("You do not have access to that page/function");
					RequestDispatcher rd = request.getRequestDispatcher("shared-BacktoMenu");
					rd.include(request, response);	
				}
				
				//chain.doFilter(request, response);
			} else {
				res.sendRedirect(req.getContextPath()+"/login.html");
			}
		}
		
	}

	@Override
	public void init(FilterConfig arg0) throws ServletException {
		// TODO Auto-generated method stub
	}
}
