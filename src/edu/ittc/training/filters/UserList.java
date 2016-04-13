package edu.ittc.training.filters;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import edu.ittc.training.model.ItemDAO;
import edu.ittc.training.model.ItemDAOImpl;

public class UserList {
	private HashMap<String,User> userList = new HashMap<String,User>();
	
	public UserList() {
		try {
			ItemDAO itemDB = new ItemDAOImpl();
			List<User> allusers = new ArrayList<User>();
			allusers = itemDB.getAllUsers();
			for (User user : allusers) {
				userList.put(user.getUsername(), new User(user.getUsername(), user.getPassword(), user.getRole()));
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public User authenticateUser(String username, String password) {
		if(userList.containsKey(username)) {
			System.out.println(username);
			User user = (User) userList.get(username);
			System.out.println("USER Details " + user.getUsername()+":"+user.getPassword());
			if(user.getUsername().equals(username) && user.getPassword().equals(password)) {
				System.out.println("authenticated");
				return user;
			}
		}
		return null;
	}
	
	

}
