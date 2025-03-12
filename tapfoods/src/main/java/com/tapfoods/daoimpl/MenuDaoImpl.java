package com.tapfoods.daoimpl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;

import com.tapfoods.DBUtils.DBUtils;
import com.tapfoods.model.Menu;
import com.tapfoods.model.OrderTable;

public class MenuDaoImpl {
	
	Connection con;
	private PreparedStatement pstmt;
	private Statement stmt;
	private ResultSet resultSet;
	private ArrayList<Menu> menuList;
	ArrayList<OrderTable> orderTable;
	private static final String ADD_MENU="insert into `menu`(`restaurentId`,`menuName`,`price`,`description`,`isAvailable`,`imgPath`) values(?,?,?,?,?,?)";
	private static final String SELECT_ALL="select * from `menu`";
	private static final String SELECT_ON_ID="select * from `menu` where `menuId`=?";
	
	
	int status=0;
	private Menu menu;
	
	
	
	public MenuDaoImpl() {
		try {
			con=DBUtils.myconnect(); 
			
			}
		catch(Exception e){
			e.printStackTrace();
		}
	}

	
public int addMenu(Menu m) {
		
		try {
			pstmt=con.prepareStatement(ADD_MENU);
			pstmt.setInt(1, m.getRestaurantId());
			pstmt.setString(2, m.getMenuName());
			pstmt.setFloat(3, m.getPrice());
			pstmt.setString(4, m.getDescription());
			pstmt.setInt(5, m.isAvailable());
			pstmt.setString(5, m.getImgPath());
			
			status=pstmt.executeUpdate();
		}
		
		catch(Exception e) {
			e.printStackTrace();
		}
		return status;
		
	}
	
	
public ArrayList<Menu> getAllMenus() {
	
	try {
		
		stmt=con.createStatement();
		resultSet=stmt.executeQuery(SELECT_ALL);
		menuList=extractMenuFromResultSet(resultSet);
		
	}
	
	catch(Exception e) {
		e.printStackTrace();
	}
	return menuList;
}

public Menu getMenus(int menuID) {
	
	try {
			pstmt=con.prepareStatement(SELECT_ON_ID);
			pstmt.setInt(1, menuID);
			
			resultSet =pstmt.executeQuery();
		    menuList =extractMenuFromResultSet(resultSet);
		    menu=menuList.get(0);
		}
		catch(Exception e) {
			e.printStackTrace();
		}
	return menu;
	}

	
ArrayList<Menu> extractMenuFromResultSet(ResultSet result) {
	
	try {
	while(resultSet.next()) {
		menuList.add(new Menu(resultSet.getInt("menuID"),
		resultSet.getInt("restaurentId"),
		resultSet.getString("menuName"),
		resultSet.getFloat("price"),
		resultSet.getString("description"),
		resultSet.getInt("isAvailable"),
		resultSet.getString("imgPath")));
		
	}
	}
	catch(Exception e) {
		e.printStackTrace();
	}
	return menuList;
}


}
