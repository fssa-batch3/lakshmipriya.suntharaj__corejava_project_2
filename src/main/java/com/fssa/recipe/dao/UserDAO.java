package com.fssa.recipe.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.fssa.recipe.model.User;
import com.fssa.recipe.util.Utilities;

public class UserDAO {

	/**
	 * Authenticates a user by checking their email and password against the database.
	 *
	 * @param user The User object containing the email and password for authentication.
	 * @return True if the user is authenticated, false otherwise.
	 * @throws SQLException         If a database access error occurs.
	 * @throws ClassNotFoundException If the required database driver class is not found.
	 */
	// Get user from DB
	public boolean login(User user) throws SQLException, ClassNotFoundException {
		String query = "SELECT * FROM USER WHERE email = ? AND password = ?";
		
		try (Connection connection = Utilities.getConnection();
		
		PreparedStatement pmt = connection.prepareStatement(query);){
		pmt.setString(1, user.getEmail());
		pmt.setString(2, user.getPassword());
 
		ResultSet rs = pmt.executeQuery();
		
		return rs.next();
	} 
	}
	
	
	/**
	 * Registers a user by inserting their information into the USER table.
	 *
	 * @param user The User object containing the user's information.
	 * @return True if the user was successfully registered, false otherwise.
	 * @throws SQLException If a database access error occurs.
	 * @throws ClassNotFoundException If the database driver class is not found.
	 */
	
	
	public boolean register(User user) throws SQLException, ClassNotFoundException {
		String query = "INSERT INTO USER (Username ,email,password) VALUES (?,?,?)";
		try(
		Connection connection = Utilities.getConnection(); 
		
		PreparedStatement pmt = connection.prepareStatement(query);){
		pmt.setString(1, user.getUsername());
		pmt.setString(2, user.getEmail());
		pmt.setString(3, user.getPassword());
		
		int rows = pmt.executeUpdate(); 

		return rows >= 1; 

	}
	}
	
// update user 
	
	
	
	/**
	 * Updates the username of a user based on their email address.
	 *
	 * @param user The User object containing the updated username and email.
	 * @return True if the user was successfully updated, false otherwise.
	 * @throws SQLException If a database access error occurs.
	 * @throws ClassNotFoundException If the database driver class is not found.
	 */
	public boolean updateUser(User user) throws SQLException, ClassNotFoundException {
		
		String query = "UPDATE USER SET userName = ? WHERE email = ?";
		try(
	    Connection connection = Utilities.getConnection(); 
	    
	    PreparedStatement pmt = connection.prepareStatement(query);){
	    pmt.setString(1, user.getEmail());
		pmt.setString(2, user.getUsername());
	    int rows = pmt.executeUpdate();

	    
	    
	    return rows == 1;
	    

	    
	}
	
	}
}
