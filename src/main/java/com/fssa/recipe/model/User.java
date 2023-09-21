package com.fssa.recipe.model;


public class User {
    private int Userid;


	private String email;
	private String userName;
	private String password;
	private String confirmpassword;
	private boolean loggedemail;
	public int getUserid() {
		return Userid;
	}

	public void setUserid(int userid) {
		Userid = userid;
	}

	public boolean isLoggedemail() {
		return loggedemail;
	}

	public void setLoggedemail(boolean loggedemail) {
		this.loggedemail = loggedemail;
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
		this.userName = username;
		this.password = password;
		
	}

	public User(String email, String password) {
		super();
		this.email = email;
		this.password = password;
	}

	
	public User() {
		// TODO Auto-generated constructor stub
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public void setUsername(String username) {
		this.userName = username;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getEmail() {
		return email;
	}
 
	public String getUsername() {
		return userName;
	}

	public String getPassword() {
		return password;
	}

	@Override
	public String toString() {
		return "User [email=" + email + ", username=" + userName + ", password=" + password + "]";
	}

}