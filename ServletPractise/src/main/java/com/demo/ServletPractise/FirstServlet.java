package com.demo.ServletPractise;



import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Servlet implementation class FirstServlet
 */
public class FirstServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
  
    public FirstServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
//		RequestDispatcher rd= request.getRequestDispatcher("SecondServlet");
//		rd.forward(request, response);
		String str=request.getParameter("t1");
	HttpSession session=request.getSession();
	session.setAttribute("t2", str);
		response.sendRedirect("SecondServlet");
	}

	
}
