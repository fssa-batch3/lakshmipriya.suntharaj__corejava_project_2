package com.fssa.recipe.util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Utilities {
	public static Connection getConnection() throws ClassNotFoundException {
		Connection con = null;
		
		// Cloud DB
				final String DB_URL = System.getenv("DB_URL_1");
				final String DB_USER = System.getenv("DB_USER_1");
				final String DB_PASSWORD = System.getenv("DB_PASSWORD_1");

		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			return con = DriverManager.getConnection(DB_URL, DB_USER, DB_PASSWORD);
		} catch (ClassNotFoundException | SQLException e) {
			
			
		}
		return con;
		

	} 
	
	
	
}
