package com.fssa.recipe.util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Utilities {
	public Connection getConnection() throws ClassNotFoundException {
		Connection con = null;
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			return con = DriverManager.getConnection("jdbc:mysql://localhost:3306/project", "root", "1234567890");
		} catch (ClassNotFoundException | SQLException e) {
			
			
		}
		return con;
		

	} 
}
