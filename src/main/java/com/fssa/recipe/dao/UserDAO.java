package com.fssa.recipe.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.fssa.recipe.dao.exception.DAOException;
import com.fssa.recipe.model.User;

public class UserDAO {

	// connect to database
	public Connection getConnection() throws SQLException {
		return DriverManager.getConnection("jdbc:mysql://localhost:3306/project", "root", "1234567890");
	}

	// Get user from DB
	public boolean login(User user) throws SQLException {

		Connection connection = getConnection();
		String query = "SELECT * FROM USER WHERE email = ? AND PASSWORD = ?";
		PreparedStatement pmt = connection.prepareStatement(query);
		pmt.setString(1, user.getEmail());
		pmt.setString(2, user.getPassword());

		ResultSet rs = pmt.executeQuery();
//		
		return rs.next();
	}
	// Add new task to DB

	// Add new user to DB - Register
	public boolean register(User user) throws SQLException {
		Connection connection = getConnection();
		String query = "INSERT INTO USER (email ,username,password) VALUES (?,?,?)";
		PreparedStatement pmt = connection.prepareStatement(query);
		pmt.setString(1, user.getEmail());
		pmt.setString(2, user.getUsername());
		pmt.setString(3, user.getPassword());
		
		
		int rows = pmt.executeUpdate();

		// Return successful or not

		pmt.close();
		connection.close();

		return rows == 1;

	}
	
	
// update user 
	public boolean updateUser(User user) throws SQLException {
	    Connection connection = getConnection();
	    String query = "UPDATE USER SET name = ? WHERE email = ?";
	    PreparedStatement pmt = connection.prepareStatement(query);
	    pmt.setString(1, user.getEmail());
		pmt.setString(2, user.getUsername());
	    int rows = pmt.executeUpdate();

	    return rows == 1;
	}
	
	
}
