package com.demo.ServletPractise;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


public class Login extends HttpServlet {
	private static final long serialVersionUID = 1L;
    
 	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		PrintWriter out=response.getWriter();
		response.setContentType("text/html");
		out.println("<form action='LoginVerify' method='get'>");
		out.println("Username:<input type='text' name='uname'>");
		out.println("Password:<input type='password' name='pass'>");
		out.println("<input type='submit' value='login'>");
	}


}
