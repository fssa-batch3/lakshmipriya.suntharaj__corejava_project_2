package com.fssa.recipe.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.fssa.recipe.model.User;
import com.fssa.recipe.util.Utilities;

public class UserDAO {

	
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
