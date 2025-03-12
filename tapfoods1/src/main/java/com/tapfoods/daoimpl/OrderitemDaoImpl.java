package com.tapfoods.daoimpl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;

import com.tapfoods.DBUtils.DBUtils;
import com.tapfoods.model.Orderitem;

public class OrderitemDaoImpl {
	
	Connection con;
	private PreparedStatement pstmt;
	private Statement stmt;
	private ResultSet resultSet;
	Orderitem orderitem;
	private static final String ADD_ORDERITEM="insert into `orderitem`(`fk_orderId`,`fk_menuId`,`quantity`) values(?,?,?)";
	private static final String SELECT_ALL="select * from `orderitem`";
	private static final String SELECT_ON_ID="select * from `orderitem` where `orderItemId`=?";
	
	
	int status=0;
	private ArrayList<Orderitem> Orderitem;
	private ArrayList<com.tapfoods.model.Orderitem> OrderitemList;
	
	
	
	public OrderitemDaoImpl() {
		try {
			con=DBUtils.myconnect(); 
			
			}
		catch(Exception e){
			e.printStackTrace();
		}
	}
	
	
	
public int  addOrderItem(Orderitem o) {
		
		try {
			pstmt=con.prepareStatement(ADD_ORDERITEM);
			pstmt.setInt(1, o.getOrderId());
			pstmt.setInt(2, o.getMenuId());
			pstmt.setInt(3, o.getQuantity());
			pstmt.setFloat(4, o.getSubTotal());
			
			status=pstmt.executeUpdate();
		}
		
		catch(Exception e) {
			e.printStackTrace();
		}
		return status;
		
	}


public ArrayList<Orderitem> getAllOrderitems() {
	
	try {
		
		stmt=con.createStatement();
		resultSet=stmt.executeQuery(SELECT_ALL);
		Orderitem=extractorderitemFromResultSet(resultSet);
		
	}
	
	catch(Exception e) {
		e.printStackTrace();
	}
	return Orderitem;
}


public ArrayList<Orderitem> getOrderItems(int orderItemId) {
	
	try {
			pstmt=con.prepareStatement(SELECT_ON_ID);
			pstmt.setInt(1, orderItemId);
			
			resultSet =pstmt.executeQuery();
			OrderitemList =extractorderitemFromResultSet(resultSet);
			orderitem=OrderitemList.get(0);
		}
		catch(Exception e) {
			e.printStackTrace();
		}
	return OrderitemList;
	}

ArrayList<Orderitem> extractorderitemFromResultSet(ResultSet result) {
	
	try {
	while(resultSet.next()) {
		Orderitem.add(new Orderitem(resultSet.getInt("orderItemId"),
		resultSet.getInt("fk_orderId"),
		resultSet.getInt("fk_menuId"),
		resultSet.getInt("quantity"),
		resultSet.getFloat("subTotal")));
	}
	}
	catch(Exception e) {
		e.printStackTrace();
	}
	return Orderitem;
}


}