package com.tapfoods.dao;

import java.util.ArrayList;

import com.tapfoods.model.OrderHistory;

public interface OrderhistoryDao {

	int addOrderhistory(OrderHistory o);
	ArrayList<OrderHistory> getAllOrderhistorys();
	OrderHistory getorderhistory(int OrderHistoryId);
}
