package com.tapfoods.dao;

import java.util.ArrayList;

import com.tapfoods.model.User;

public interface UserDao {
	
	int addUser(User u);
	ArrayList<User> getAllUsers();
	User getUsers(String email);
	int updateUser(User u);
	int deleteUser(String email);
	
}
