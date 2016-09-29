package com.demo.ServletPractise;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Servlet implementation class SelectOwnerName
 */
public class SelectOwnerName extends HttpServlet {

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		HttpSession session = request.getSession();
		if (session.getAttribute("uname") == null) {
			response.sendRedirect("Login");
		}
		PrintWriter out = response.getWriter();
		response.setContentType("text/html");
		OwnerDAO1 od = new OwnerDAO1();
		List<String> list = od.displayOwnerNames();
		out.println("<form action='OwnerName' method='get'>Select name:<select name='ownername'>");
		for (String x : list) {
			out.println("<option value=" + x + ">" + x + "</option>");
			
		}
		out.write("/t");
		// out.println("<br>");
		out.println("<input type='submit' name='search' value='Search'></form>");
		
		out.println("<form action='Logout'><input type='submit' value='Logout'></form>");
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
