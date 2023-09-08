package com.fssa.recipe.model;


public class User {

	private String email;
	private String UserName;
	private String password;
	private String confirmpassword;

	public User(String email, String username, String password, String confirmpassword) {
		super();
		this.email = email;
		UserName = username;
		this.password = password;
		this.confirmpassword = confirmpassword;
	}

	public String getConfirmpassword() {
		return confirmpassword;
	}

	public void setConfirmpassword(String confirmpassword) {
		this.confirmpassword = confirmpassword;
	}

	public User( String username, String email, String password) {
		super();
		this.email = email;
		this.UserName = username;
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
		this.UserName = username;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getEmail() {
		return email;
	}
 
	public String getUsername() {
		return UserName;
	}

	public String getPassword() {
		return password;
	}

	@Override
	public String toString() {
		return "User [email=" + email + ", username=" + UserName + ", password=" + password + "]";
	}

}