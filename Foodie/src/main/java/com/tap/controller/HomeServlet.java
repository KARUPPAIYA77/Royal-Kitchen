package com.tap.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.tapfoods.dao.RestaurantDao;
import com.tapfoods.daoimpl.RestaurantDaoImpl;
import com.tapfoods.model.Restaurant;
@WebServlet("/HomeServlet")
public class HomeServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	RestaurantDao restaurantDao;
	
	protected void service (HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		restaurantDao=new RestaurantDaoImpl();
		List<Restaurant>restaurantList=restaurantDao.getAllRestaurant();
		HttpSession session=request.getSession();
		session.setAttribute("restuarantList", restaurantList);
		response.sendRedirect("/Home.jsp");
	}
}
