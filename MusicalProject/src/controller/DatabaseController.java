package controller;

import java.sql.ResultSet;

import database.Database;
import database.User;

public class DatabaseController {
	
	
	public User getUser(String name) {
		User user = Database.get(name);
		if (user != null) 
			return user;
		user = new User();
		user.setName(name);
		user.setTopScore(0);
		return user;
	}

}
