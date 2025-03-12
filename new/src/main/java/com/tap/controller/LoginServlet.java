package com.tap.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.tapfoods.dao.UserDao;
import com.tapfoods.daoimpl.userDaoImpl;
import com.tapfoods.model.User;

@WebServlet("/Login")
public class LoginServlet extends HttpServlet {
	
	private static final long serialVersionUID = 1L;

	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String email =req.getParameter("email");
		String password = req.getParameter("password");
		
		UserDao userDao = new userDaoImpl();
		User user=userDao.getUsers(email);
		
		if(password.equals(user.getPassword())) {
			resp.sendRedirect("Home.jsp");
		}
		else {
			resp.sendRedirect("Failure.jsp");
		}
	}
}
