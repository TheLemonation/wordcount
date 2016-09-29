package com.demo.ServletPractise;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
public class LoginVerify extends HttpServlet {
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String name=request.getParameter("uname");
		String password=request.getParameter("pass");
		if(name.equals("pavan") && password.equals("karampudi")){
			HttpSession session=request.getSession();
			session.setAttribute("uname", name);
			response.sendRedirect("SelectOwnerName");
		}
		else{
			PrintWriter out=response.getWriter();
			//out.println(name);
			response.sendRedirect("Login");
		}
	}
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
