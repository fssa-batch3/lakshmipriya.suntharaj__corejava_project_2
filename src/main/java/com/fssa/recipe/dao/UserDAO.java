package com.fssa.recipe.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.fssa.recipe.dao.exception.DAOException;
import com.fssa.recipe.model.User;

import com.fssa.recipe.util.Utilities;

public class UserDAO {

	/**
	 * Authenticates a user by checking their email and password against the
	 * database.
	 *
	 * @param user The User object containing the email and password for
	 *             authentication.
	 * @return True if the user is authenticated, false otherwise.
	 * @throws SQLException           If a database access error occurs.
	 * @throws DAOException
	 * @throws ClassNotFoundException If the required database driver class is not
	 *                                found.
	 */
	// Get user from DB
	public boolean login(User user) throws DAOException {
		String query = "SELECT * FROM USER WHERE email = ? AND password = ?";

		try (Connection connection = Utilities.getConnection();

				PreparedStatement pmt = connection.prepareStatement(query);) {
			pmt.setString(1, user.getEmail());
			pmt.setString(2, user.getPassword());
 
			ResultSet rs = pmt.executeQuery();

			return rs.next();
		} catch (SQLException | ClassNotFoundException e) {
			throw new DAOException("Error while authenticating the user: " + e.getMessage());
		}
	}

	/**
	 * Registers a user by inserting their information into the USER table.
	 *
	 * @param user The User object containing the user's information.
	 * @return True if the user was successfully registered, false otherwise.
	 * @throws SQLException           If a database access error occurs.
	 * @throws ClassNotFoundException If the database driver class is not found.
	 */

	public boolean register(User user) throws DAOException, ClassNotFoundException {
		String query = "INSERT INTO USER (Username ,email,password) VALUES (?,?,?)";
		try (Connection connection = Utilities.getConnection();

				PreparedStatement pmt = connection.prepareStatement(query);) {
			pmt.setString(1, user.getUsername());
			pmt.setString(2, user.getEmail());
			pmt.setString(3, user.getPassword());

			int rows = pmt.executeUpdate();

			return rows >= 1;

		} catch (SQLException e) {
			throw new DAOException("Error while registering the user: " + e.getMessage());
		}
	}

// update user 

	/**
	 * Updates the username of a user based on their email address.
	 *
	 * @param user The User object containing the updated username and email.
	 * @return True if the user was successfully updated, false otherwise.
	 * @throws SQLException           If a database access error occurs.
	 * @throws ClassNotFoundException If the database driver class is not found.
	 */
	public boolean updateUser(User user) throws DAOException {
		String query = "UPDATE USER SET user_name=?, phone_number=? WHERE email=? AND is_deleted = 0";
		try (Connection connection = Utilities.getConnection();
				PreparedStatement pstmt = connection.prepareStatement(query)) {
			pstmt.setString(1, user.getUsername());

			pstmt.setString(2, user.getEmail());
			int rows = pstmt.executeUpdate();
			return rows == 1;
		} catch (SQLException | ClassNotFoundException e) {
			throw new DAOException("Error while updating user information: " + e.getMessage());
		}
	}

	 public User getUserByEmail(String email) throws DAOException {
	        String query = "SELECT * FROM user WHERE email = ?";
	        User user = new User();

	        try (Connection connection = Utilities.getConnection();
	             PreparedStatement preparedStatement = connection.prepareStatement(query)) {
	            preparedStatement.setString(1, email);
	            ResultSet resultSet = preparedStatement.executeQuery();

	            if (resultSet.next()) {
	                
	                user.setUserid(resultSet.getInt("Userid"));
	                user.setUsername(resultSet.getString("Username"));
	                user.setPassword(resultSet.getString("password"));
	                
	            }
	        } catch (SQLException | ClassNotFoundException e) {
	            throw new DAOException("Error fetching user by email: " + e.getMessage());
	        }

	        return user;
	    }


	public User findUserByUserid(int userid) throws DAOException {
		User user = new User();
		String selectQuery = "SELECT * FROM user WHERE Userid=?";

		try (Connection connection = Utilities.getConnection();
				PreparedStatement pst = connection.prepareStatement(selectQuery)) {
			pst.setInt(1, userid);
			ResultSet rs = pst.executeQuery();

			if (rs.next()) {
				user.setUserid(rs.getInt("Userid"));
				user.setUsername(rs.getString("Username"));
				user.setEmail(rs.getString("email"));

			}

			return user;
		} catch (SQLException | ClassNotFoundException e) {
			throw new DAOException("Error finding user by Userid");
		}
	}
	
	
	
	

	
	}



