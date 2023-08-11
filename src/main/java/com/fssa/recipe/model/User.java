package com.fssa.recipe.model;


public class User {

	private String email;
	private String username;
	private String password;
	

	public User(String email, String username, String password) {
		super();
		this.email = email;
		this.username = username;
		this.password = password;
		
	}

	public User(String email, String password) {
		super();
		this.email = email;
		this.password = password;
	}

	
	public void setEmail(String email) {
		this.email = email;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getEmail() {
		return email;
	}
 
	public String getUsername() {
		return username;
	}

	public String getPassword() {
		return password;
	}

	@Override
	public String toString() {
		return "User [email=" + email + ", username=" + username + ", password=" + password + "]";
	}

}