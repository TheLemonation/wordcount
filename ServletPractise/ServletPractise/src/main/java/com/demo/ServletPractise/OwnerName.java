package com.demo.ServletPractise;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Servlet implementation class OwnerName
 */
public class OwnerName extends HttpServlet {

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		HttpSession session = request.getSession();
		if (session.getAttribute("uname") == null) {
			response.sendRedirect("Login");
		}
		PrintWriter out = response.getWriter();
		if (request.getParameter("search") != null) {
			String name = request.getParameter("ownername");
			OwnerDAO1 od = new OwnerDAO1();
			OwnerDTO o = od.findOwnerByName(name);
			// out.println(name);
			out.println("<table><tr><td>" + o.getId());
			out.println("</td><td>" + o.getFname());
			out.println("</td><td>" + o.getLname());
			out.println("</td><td>" + o.getAddress());
			out.println("</td><td>" + o.getCity());
			out.println("</td><td>" + o.getTelephone());
			out.println("</tr></table>");
			out.println("<form action='Logout'><input type='submit' value='Logout'></form>");

		}
		
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
