package com.tapfoods.dao;

import java.util.ArrayList;

import com.tapfoods.model.Menu;

public interface MenuDao {
	
	int addMenu(Menu m);
	ArrayList<Menu> getAllMenus();
	Menu getMenus(int menuID);
}
