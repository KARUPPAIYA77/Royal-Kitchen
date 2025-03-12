package com.tapfoods.dao;
import java.util.ArrayList;

import com.tapfoods.model.Restaurant;
	
	public interface RestaurantDao {
		
		int addRestaurant(Restaurant r);
		ArrayList<Restaurant> getAllRestaurant();
		Restaurant getRestaurant(int restaurantId);
	}