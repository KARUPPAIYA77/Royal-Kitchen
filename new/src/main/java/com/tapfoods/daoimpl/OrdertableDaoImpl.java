package com.tapfoods.daoimpl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;

import com.tapfoods.DBUtils.DBUtils;
import com.tapfoods.model.OrderTable;

public class OrdertableDaoImpl {
	Connection con;
	private PreparedStatement pstmt;
	private Statement stmt;
	private ResultSet resultSet;
	private ArrayList<OrderTable> ordertableList;
	ArrayList<OrderTable> orderTable;
	private OrderTable ordertable;
	private static final String ADD_ORDERTABLE="insert into `ordertable`(`fk_restaurantId`,`fk_userId`,`orderTime`,`totalAmount`,`status`,`paymentMode`) values(?,?,?,?,?,?)";
	private static final String SELECT_ALL="select * from `ordertable`";
	private static final String SELECT_ON_ID="select * from `ordetable` where `orderId`=?";
	
	
	int status=0;
	
	
	
	public OrdertableDaoImpl() {
		try {
			con=DBUtils.myconnect(); 
			
			}
		catch(Exception e){
			e.printStackTrace();
		}
	}
	
	
public int addOrdertable(OrderTable o) {
		
		try {
			pstmt=con.prepareStatement(ADD_ORDERTABLE);
			pstmt.setInt(1, o.getOrderId());
			pstmt.setInt(2, o.getUserId());
			pstmt.setInt(3, o.getOrderTime());
			pstmt.setFloat(4, o.getTotalAmount());
			pstmt.setString(5, o.getStatus());
			pstmt.setString(6, o.getPaymentMode());
			
			status=pstmt.executeUpdate();
		}
		
		catch(Exception e) {
			e.printStackTrace();
		}
		return status;
		
	}


public ArrayList<OrderTable> getAllOrdertables() {
	
	try {
		
		stmt=con.createStatement();
		resultSet=stmt.executeQuery(SELECT_ALL);
		orderTable=extractOrdertableFromResultSet(resultSet);
		
	}
	
	catch(Exception e) {
		e.printStackTrace();
	}
	return orderTable;
}


public OrderTable getOrdertable(int orderId) {
	
	try {
			pstmt=con.prepareStatement(SELECT_ON_ID);
			pstmt.setInt(1, orderId);
			
			resultSet =pstmt.executeQuery();
		    ordertableList =extractOrdertableFromResultSet(resultSet);
		    ordertable=ordertableList.get(0);
		}
		catch(Exception e) {
			e.printStackTrace();
		}
	return ordertable;
	}
	

ArrayList<OrderTable> extractOrdertableFromResultSet(ResultSet result) {
	
	try {
	while(resultSet.next()) {
		orderTable.add(new OrderTable(resultSet.getInt("orderId"),
		resultSet.getInt("fk_restaurantId"),
		resultSet.getInt("fk_userId"),
		resultSet.getInt("orderTime"),
		resultSet.getFloat("totalAmount"),
		resultSet.getString("status"),
		resultSet.getString("paymentMode")));
	}
	}
	catch(Exception e) {
		e.printStackTrace();
	}
	return orderTable;
}
}
