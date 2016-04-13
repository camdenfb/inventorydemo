package edu.ittc.training.filters;

public class User {
	private String username;
	private String password;
	private String role;
	
	public User(String username, String password) {
		this.username = username;
		this.password = password;
	}
	
	public User(String username, String password, String role) {
		this.username = username;
		this.password = password;
		this.role = role;
	}

	public String getUsername() {
		return username;
	}

	public String getPassword() {
		return password;
	}

	public String getRole() {
		return role;
	}
}
