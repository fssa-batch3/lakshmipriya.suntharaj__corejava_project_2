package com.fssa.recipe.util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class utilities {
	public Connection getConnection() throws SQLException {
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
		} catch (ClassNotFoundException e) {
			
			e.printStackTrace();
		}
		return DriverManager.getConnection("jdbc:mysql://localhost:3306/project", "root", "1234567890");

	} 
}
