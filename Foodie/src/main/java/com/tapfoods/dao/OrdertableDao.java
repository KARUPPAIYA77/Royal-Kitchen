package com.tapfoods.dao;

import java.util.ArrayList;

import com.tapfoods.model.OrderTable;

public interface OrdertableDao {
		
		int addUser(OrderTable o);
		ArrayList<OrderTable> getAllOrdertables();
		OrderTable getUsers(int orderId);
		int updateOrdertable(OrderTable o);
		int deleteOrdertable(String email);
		
	}
