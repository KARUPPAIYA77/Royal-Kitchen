package com.tap.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class LoginServlet extends HttpServlet{
	
	
	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		PrintWriter printWritter=resp.getWriter();
		String un=req.getParameter("email");
		String pwd=req.getParameter("pwd");
		
		//validate email
		
		
		//fetching suitable data from table
		
		
		
		//displaying info 
		printWritter.println("username :"+un+ " password :"+pwd);
	}
}
