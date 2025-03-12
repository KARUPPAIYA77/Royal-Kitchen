package com.tapfoods.daoimpl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;

import com.tapfoods.DBUtils.DBUtils;
import com.tapfoods.model.OrderHistory;

public class OrderhistoryDaoImpl {
	
	Connection con;
	private PreparedStatement pstmt;
	private Statement stmt;
	private ResultSet resultSet;
	private ArrayList<OrderHistory> orderhistoryList;
	private OrderHistory orderhistory;
	private ArrayList<OrderHistory> orderHistory;
	private static final String ADD_ORDERHISTORY="insert into `orderhistory`(`orderId`,`userId`,`orderDate`,`totalAmount`,`status`) values(?,?,?,?,?)";
	private static final String SELECT_ALL="select * from `orderhistory`";
	private static final String SELECT_ON_ID="select * from `orderhistory` where `orderHistoryId`=?";
	
	
	int status=0;

	
	
	public OrderhistoryDaoImpl() {
		try {
			con=DBUtils.myconnect(); 
			
			}
		catch(Exception e){
			e.printStackTrace();
		}
	}
	
	
	
	
public int addOrderhistory(OrderHistory o) {
		
		try {
			pstmt=con.prepareStatement(ADD_ORDERHISTORY);
			pstmt.setInt(1, o.getOrderHistoryId());
			pstmt.setFloat(4, o.getOrderId());
			pstmt.setInt(5, o.getUserId());
			pstmt.setInt(6, o.getOrderDate());
			
			status=pstmt.executeUpdate();
		}
		
		catch(Exception e) {
			e.printStackTrace();
		}
		return status;
		
	}


public ArrayList<OrderHistory>  getAllOrderhistorys() {
	
	try {
		
		stmt=con.createStatement();
		resultSet=stmt.executeQuery(SELECT_ALL);
		orderHistory=extractgetOrderHistoryFromResultSet(resultSet);
		
	}
	
	catch(Exception e) {
		e.printStackTrace();
	}
	return orderHistory;
}

public OrderHistory getOrderHistory(int orderHistoryId) {
	
	try {
			pstmt=con.prepareStatement(SELECT_ON_ID);
			pstmt.setInt(1, orderHistoryId);
			
			resultSet =pstmt.executeQuery();
		    orderhistoryList =extractgetOrderHistoryFromResultSet(resultSet);
		    orderhistory=orderhistoryList.get(0);
		}
		catch(Exception e) {
			e.printStackTrace();
		}
	return orderhistory;
	}



ArrayList<OrderHistory> extractgetOrderHistoryFromResultSet(ResultSet result) {
	
	try {
	while(resultSet.next()) {
		orderHistory.add(new OrderHistory(resultSet.getInt("orderHistoryId"),
		resultSet.getInt("orderId"),
		resultSet.getInt("userId"),
		resultSet.getInt("orderDate"),
		resultSet.getFloat("totalAmount"),
		resultSet.getString("status")));
	}
	}
	catch(Exception e) {
		e.printStackTrace();
	}
	return orderHistory;
}
}
