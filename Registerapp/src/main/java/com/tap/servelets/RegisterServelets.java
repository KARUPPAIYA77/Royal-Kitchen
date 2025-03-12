package com.tap.servelets;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class RegisterServelets extends HttpServlet{
	private PrintWriter pw;
	String url="jdbc:mysql://localhost:3306/jee";
	String username="root";
	String pwd="root";
	private Connection con;
	private PreparedStatement pstmt;
	
	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		HttpSession session=req.getSession();	
		String name=(String) session.getAttribute("name");
		String email=(String) session.getAttribute("email");
		String phoneNumber1=(String) session.getAttribute("phoneNumber");
		String password=(String) session.getAttribute("password");
		String cpassword=(String) session.getAttribute("cpassword");
		String address=(String) session.getAttribute("address");
		
		Long phoneNumber=Long.parseLong(phoneNumber1);
		System.out.println("Output from Register+ "+name+" "+email+" "+phoneNumber+" "+password+" "+cpassword+" "+address);
		
		
		pw=resp.getWriter();
		String sql="insert into `user`(`name`,`email`,`phoneNumber`,`password`,`address`)"
				+ " value(?,?,?,?,?)";
		try {
		if(password.equals(cpassword)) {
			Class.forName("com.mysql.cj.jdbc.Driver");
			con=DriverManager.getConnection(url,username,pwd);
			pstmt=con.prepareStatement(sql);
		
		pstmt.setString(1, name);
		pstmt.setString(2, email);
		pstmt.setString(4, password);
		pstmt.setString(5, address);
		pstmt.setLong(3, phoneNumber);
		
		int x=pstmt.executeUpdate();
		if(x!=0) {
			pw.println(name+" has Registered");
		}
		else {
			pw.println(name+" was not Registered");
		}
		}
		else {
			pw.println(name+" password and confirm password does not match!");
		}
		} 
		catch (Exception e) {
			pw.println(e.getMessage());
			e.printStackTrace();
		}
	}
	}