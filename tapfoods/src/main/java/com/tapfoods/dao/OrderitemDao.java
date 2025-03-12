package com.tapfoods.dao;

import java.util.ArrayList;

import com.tapfoods.model.Orderitem;

public interface OrderitemDao {

	int addOrderitem(Orderitem o);
	ArrayList<Orderitem> getAllOrderitem();
	Orderitem getOrderItems(int orderItemId);
}
