package com.tapfoods.daoimpl;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;

import com.tapfoods.DBUtils.DBUtils;
import com.tapfoods.dao.UserDao;
import com.tapfoods.model.User;

public class userDaoImpl implements UserDao {
	
	Connection con;
	private PreparedStatement pstmt;
	private Statement stmt;
	private ResultSet resultSet;
	ArrayList<User> userList=new ArrayList<User>();
	User user;
	private static final String ADD_USER="insert into `user`(`username`,`email`,`phonenumber`,`password`,`address`) values(?,?,?,?,?)";
	private static final String SELECT_ALL="select * from `user`";
	private static final String SELECT_ON_EMAIL="select * from `user` where `email`=?";
	private static final String UPDATE_ON_EMAIL="update `user` set `username` =?, `phonenumber`=?,`password`=? ,`address`=? where `email=?";
	private static final String DELETE_ON_EMAIL="delete from `user` where `email=?";
	
	
	int status=0;
	
	
	
	public userDaoImpl() {
		try {
			con=DBUtils.myconnect(); 
			
			}
		catch(Exception e){
			e.printStackTrace();
		}
	}

	
	public int addUser(User u) {
		
		try {
			pstmt=con.prepareStatement(ADD_USER);
			pstmt.setString(1, u.getUsername());
			pstmt.setString(2, u.getEmail());
			pstmt.setInt(3, u.getPhonenumber());
			pstmt.setString(4, u.getPassword());
			pstmt.setString(5, u.getAddress());
			
			status=pstmt.executeUpdate();
		}
		
		catch(Exception e) {
			e.printStackTrace();
		}
		return status;
		
	}
	
	
	public ArrayList<User> getAllUsers() {
		
		try {
			
			stmt=con.createStatement();
			resultSet=stmt.executeQuery(SELECT_ALL);
			userList=extractUserFromResultSet(resultSet);
			
		}
		
		catch(Exception e) {
			e.printStackTrace();
		}
		return userList;
	}

	
	public User getUsers(String email) {
		
	try {
			pstmt=con.prepareStatement(SELECT_ON_EMAIL);
			pstmt.setString(1, email);
			
			resultSet =pstmt.executeQuery();
		    userList =extractUserFromResultSet(resultSet);
		    user=userList.get(0);
		}
		catch(Exception e) {
			e.printStackTrace();
		}
	return user;
	}

	
	public int updateUser(User u) {
		
	try {
			pstmt=con.prepareStatement(UPDATE_ON_EMAIL);
			pstmt.setString(1, u.getUsername());
			pstmt.setInt(2, u.getPhonenumber());
			pstmt.setString(3, u.getPassword());
			pstmt.setString(4, u.getAddress());
			pstmt.setString(5, u.getEmail());
			
			pstmt.executeUpdate();
			
		}
		catch(Exception e) {
			e.printStackTrace();
		}
	return status;
	}
	
	
	ArrayList<User> extractUserFromResultSet(ResultSet result) {
		
		try {
		while(resultSet.next()) {
			userList.add(new User(resultSet.getInt("userId"),
			resultSet.getString("username"),
			resultSet.getString("email"),
			resultSet.getInt("phonenumber"),
			resultSet.getString("password"),
			resultSet.getString("address")));
		}
		}
		catch(Exception e) {
			e.printStackTrace();
		}
		return userList;
	}


	public int deleteUser(String email) {
		
		try {
			pstmt =con.prepareStatement(DELETE_ON_EMAIL);
			pstmt.setString(1, email);
		}
		catch(Exception e) {
			e.printStackTrace();
		}
		return status;
	}
}