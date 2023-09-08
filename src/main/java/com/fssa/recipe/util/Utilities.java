package com.fssa.recipe.util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Utilities {
	public static Connection getConnection() throws ClassNotFoundException, SQLException {
	    Connection con = null;
	    /**
	     * Establishes a database connection to a local database using environment variables.
	     *
	     * @return Connection object representing the database connection.
	     * @throws ClassNotFoundException if the MySQL JDBC driver class is not found.
	     * @throws SQLException if a SQL-related error occurs during connection.
	     */
	    // local DB
	    final String DB_URL = System.getenv("DB_URL_1");
	    final String DB_USER = System.getenv("DB_USER_1");
	    final String DB_PASSWORD = System.getenv("DB_PASSWORD_1");

	    try {
	        
	        Class.forName("com.mysql.cj.jdbc.Driver");
	        
	        con = DriverManager.getConnection(DB_URL, DB_USER, DB_PASSWORD);
	        
	        return con;
	    } catch (ClassNotFoundException e) {
	        	        throw e;
	    } catch (SQLException e) {
	    
	        throw e;
	    } finally {
	        
	        if (con != null) {
	            try {
	                con.close();
	            } catch (SQLException e) {
	            	throw e;
	            }
	        }
	    }
	}
	
	
	
}
