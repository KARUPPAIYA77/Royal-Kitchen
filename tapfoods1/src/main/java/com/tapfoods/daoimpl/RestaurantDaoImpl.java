package com.tapfoods.daoimpl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;

import com.tapfoods.DBUtils.DBUtils;
import com.tapfoods.model.Restaurant;

public class RestaurantDaoImpl {

	Connection con;
	private PreparedStatement pstmt;
	private Statement stmt;
	private ResultSet resultSet;
	private ArrayList<Restaurant> restuarantList;
	Restaurant restuarant;;
	private static final String ADD_RESTUARANT="insert into `restuarant`(`restaurantName`,`delivireyTime`,`cuisineType`,`address`,`ratings`,`isActive`,`fk_adminId`,`imgPath`) values(?,?,?,?,?,?,?,?)";
	private static final String SELECT_ALL="select * from `restuarant`";
	private static final String SELECT_ON_ID="select * from `restuarant` where `restuarantId`=?";
	private static final String UPDATE_ON_ID="update `restuarant` set `restaurantName` =?, `delivireyTime`=?,`cuisineType`=? ,`address`=?,`ratings`=?,`isActive`=?,`fk_adminId`=?,`imgPath`=? where `email=?";
	private static final String DELETE_ON_ID="delete from `restuarant` where `restuarantId=?";
	
	
       int status=0;
	
	
	
	
	public RestaurantDaoImpl() {
		try {
			con=DBUtils.myconnect(); 
			
			}
		catch(Exception e){
			e.printStackTrace();
		}
	}
	
	
public int addRestaurant(Restaurant r) {
		
		try {
			pstmt=con.prepareStatement(ADD_RESTUARANT);
			pstmt.setString(1, r.getRestaurantName());
			pstmt.setInt(2, r.getDeliveryTime());
			pstmt.setString(3, r.getCuisineType());
			pstmt.setString(4, r.getAddress());
			pstmt.setString(5, r.getAddress());
			pstmt.setFloat(6, r.getRatings());
			pstmt.setInt(7, r.getIsActive());
			pstmt.setInt(8, r.getAdminId());
			
			status=pstmt.executeUpdate();
		}
		
		catch(Exception e) {
			e.printStackTrace();
		}
		return status;
		
	}

public ArrayList<Restaurant> getAllRestaurant() {
	
	try {
		
		stmt=con.createStatement();
		resultSet=stmt.executeQuery(SELECT_ALL);
		restuarantList=extractRestuarantFromResultSet(resultSet);
		
	}
	
	catch(Exception e) {
		e.printStackTrace();
	}
	return restuarantList;
}
	


public Restaurant getRestuarant(int restuarantId) {
	
try {
		pstmt=con.prepareStatement(SELECT_ON_ID);
		pstmt.setInt(1, restuarantId);
		
		resultSet =pstmt.executeQuery();
	    restuarantList =extractRestuarantFromResultSet(resultSet);
	    restuarant=restuarantList.get(0);
	}
	catch(Exception e) {
		e.printStackTrace();
	}
return restuarant;
}

public int updateRestuarant(Restaurant r) {
	
	try {
			pstmt=con.prepareStatement(UPDATE_ON_ID);
			pstmt.setString(1, r.getRestaurantName());
			pstmt.setInt(2, r.getDeliveryTime());
			pstmt.setString(3, r.getCuisineType());
			pstmt.setString(4, r.getAddress());
			pstmt.setFloat(5, r.getRatings());
			pstmt.setInt(6, r.getIsActive());
			pstmt.setInt(7, r.getAdminId());
			
			pstmt.executeUpdate();
			
		}
		catch(Exception e) {
			e.printStackTrace();
		}
	return status;
	}
	

ArrayList<Restaurant> extractRestuarantFromResultSet(ResultSet result) {
	
	try {
	while(resultSet.next()) {
		restuarantList.add(new Restaurant(resultSet.getInt("restuarantId"),
		resultSet.getString("restuarantname"),
		resultSet.getInt("delivireyTime"),
		resultSet.getString("cuisineType"),
		resultSet.getString("address"),
		resultSet.getFloat("ratings"),
		resultSet.getInt("isActive"),
		resultSet.getInt("adminId")));
	}
	}
	catch(Exception e) {
		e.printStackTrace();
	}
	return restuarantList;
}
public int deleteUser(String restuarantId) {
	
	try {
		pstmt =con.prepareStatement(DELETE_ON_ID);
		pstmt.setString(1, restuarantId);
	}
	catch(Exception e) {
		e.printStackTrace();
	}
	return status;
}

}
