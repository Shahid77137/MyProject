package com.masaischool.dao;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.masaischool.dto.User;
import com.masaischool.dto.UserImpl;
import com.masaischool.exception.NoRecordFoundException;
import com.masaischool.exception.SomeThingWrongException;

public class UserDAOImpl implements UserDAO {
	@Override
	public void addUser(User user) throws SomeThingWrongException{
		Connection connection = null;
		try {
			//connect to database
			connection = DBUtils.connectToDatabase();
			//prepare the query
			String INSERT_QUERY = "INSERT INTO user (user_id, name, username, password, registration_date) VALUES (?, ?, ?, ?, ?)";
			
			//get the prepared statement object
			PreparedStatement ps = connection.prepareStatement(INSERT_QUERY);
			
			//stuff the data in the query
			ps.setInt(1, user.getUserId());
			ps.setString(2, user.getName());
			ps.setString(3, user.getUsername());
			ps.setString(4, user.getPassword());
			ps.setDate(5, Date.valueOf(user.getRegistrationDate()));
			
			//execute query
			ps.executeUpdate();
		}catch(SQLException sqlEx) {
			sqlEx.printStackTrace();
			//code to log the error in the file
			throw new SomeThingWrongException();
		}finally {
			try {
				//close the exception
				DBUtils.closeConnection(connection);				
			}catch(SQLException sqlEX) {
				throw new SomeThingWrongException();
			}
		}
	}
	
	/**
	 * converts the resultset to the list of User objects
	 * @param resultSet - the resultset to be converted to list of users
	 * @return List<User> - list of users
	 * @throws SQLException - if anything went wrong during this operation
	 */
	private List<User> getUserListFromResultSet(ResultSet resultSet) throws SQLException{
		List<User> list = new ArrayList<>();
		while(resultSet.next()) {
			//Create an object of Employee
			User user = new UserImpl();
			user.setUserId(resultSet.getInt("user_id"));
			user.setName(resultSet.getString("name"));
			user.setUsername(resultSet.getString("username"));
			user.setRegistrationDate(resultSet.getDate("registration_date").toLocalDate());
			list.add(user);
		}
		return list;
	}
	
	@Override
	public List<User> getAllUsersList() throws SomeThingWrongException, NoRecordFoundException{
		Connection connection = null;
		List<User> list = null;
		try {
			//connect to database
			connection = DBUtils.connectToDatabase();
			//prepare the query
			String SELECT_QUERY = "SELECT * FROM user";
			
			//get the prepared statement object
			PreparedStatement ps = connection.prepareStatement(SELECT_QUERY);
			
			//execute query
			ResultSet resultSet = ps.executeQuery();
			
			//check if result set is empty
			if(DBUtils.isResultSetEmpty(resultSet)) {
				throw new NoRecordFoundException("No user Found");
			}
			
			list = getUserListFromResultSet(resultSet);
		}catch(SQLException sqlEx) {
			//code to log the error in the file
			throw new SomeThingWrongException();
		}finally {
			try {
				//close the exception
				DBUtils.closeConnection(connection);				
			}catch(SQLException sqlEX) {
				throw new SomeThingWrongException();
			}
		}
		return list;
	}

	@Override
	public void updateNameOfUser(String name) throws SomeThingWrongException{
		Connection connection = null;
		try {
			//connect to database
			connection = DBUtils.connectToDatabase();
			//prepare the query
			String UPDATE_QUERY = "UPDATE user SET name = ? WHERE user_id = ?";
			
			//get the prepared statement object
			PreparedStatement ps = connection.prepareStatement(UPDATE_QUERY);
			
			//stuff the data in the query
			ps.setString(1, name);
			ps.setInt(2, LoggedINUser.loggedInUserId);
			
			//execute query
			ps.executeUpdate();
		}catch(SQLException sqlEx) {
			sqlEx.printStackTrace();
			//code to log the error in the file
			throw new SomeThingWrongException();
		}finally {
			try {
				//close the exception
				DBUtils.closeConnection(connection);				
			}catch(SQLException sqlEX) {
				throw new SomeThingWrongException();
			}
		}
	}
	
	private boolean isOldPasswordCorrect(String oldPassword) throws SomeThingWrongException {
		Connection connection = null;
		boolean isPasswordValid = false;
		try {
			//connect to database
			connection = DBUtils.connectToDatabase();
			//prepare the query
			String CHECK_PASSWORD_QUERY = "SELECT count(*) as count FROM user WHERE password = ? AND user_id = ?";
			
			//get the prepared statement object
			PreparedStatement ps = connection.prepareStatement(CHECK_PASSWORD_QUERY);
			
			//stuff the data in the query
			ps.setString(1, oldPassword);
			ps.setInt(2, LoggedINUser.loggedInUserId);
			
			//execute query
			ResultSet resultSet = ps.executeQuery();
			resultSet.next();
			
			isPasswordValid = resultSet.getInt("count") == 1;
		}catch(SQLException sqlEx) {
			sqlEx.printStackTrace();
			//code to log the error in the file
			throw new SomeThingWrongException();
		}finally {
			try {
				//close the exception
				DBUtils.closeConnection(connection);				
			}catch(SQLException sqlEX) {
				throw new SomeThingWrongException();
			}
		}
		return isPasswordValid;
	}
	
	@Override
	public void changePassword(String oldPassword, String newPassword) throws SomeThingWrongException, NoRecordFoundException{
		if(!isOldPasswordCorrect(oldPassword)) {
			throw new NoRecordFoundException("Invalid old password!");
		}
		
		//you are here means old password matched
		Connection connection = null;
		try {
			//connect to database
			connection = DBUtils.connectToDatabase();
			//prepare the query
			String UPDATE_QUERY = "UPDATE user SET password = ? WHERE user_id = ?";
			
			//get the prepared statement object
			PreparedStatement ps = connection.prepareStatement(UPDATE_QUERY);
			
			//stuff the data in the query
			ps.setString(1, newPassword);
			ps.setInt(2, LoggedINUser.loggedInUserId);
			
			//execute query
			ps.executeUpdate();
		}catch(SQLException sqlEx) {
			sqlEx.printStackTrace();
			//code to log the error in the file
			throw new SomeThingWrongException();
		}finally {
			try {
				//close the exception
				DBUtils.closeConnection(connection);				
			}catch(SQLException sqlEX) {
				throw new SomeThingWrongException();
			}
		}
	}
	
	@Override
	public void deleteUser() throws SomeThingWrongException{
		Connection connection = null;
		try {
			//connect to database
			connection = DBUtils.connectToDatabase();
			
			//prepare the query
			String DELETE_QUERY = "DELETE FROM user WHERE user_id = ?";
			
			//get the prepared statement object
			PreparedStatement ps = connection.prepareStatement(DELETE_QUERY);
			
			//stuff the data in the query
			ps.setInt(1, LoggedINUser.loggedInUserId);
			
			//execute query
			ps.executeUpdate();
		}catch(SQLException sqlEx) {
			//code to log the error in the file
			throw new SomeThingWrongException();
		}finally {
			try {
				//close the exception
				DBUtils.closeConnection(connection);				
			}catch(SQLException sqlEX) {
				throw new SomeThingWrongException();
			}
		}
	}
	
	@Override
	public void Login(String username, String password) throws SomeThingWrongException, NoRecordFoundException{
		Connection connection = null;
		try {
			//connect to database
			connection = DBUtils.connectToDatabase();
			//prepare the query
			String LOGIN_QUERY = "SELECT user_id FROM user WHERE username = ? AND password = ?";
			
			//get the prepared statement object
			PreparedStatement ps = connection.prepareStatement(LOGIN_QUERY);
			
			//stuff the data in the query
			ps.setString(1, username);
			ps.setString(2, password);
			
			//execute query
			ResultSet resultSet = ps.executeQuery();
			if(DBUtils.isResultSetEmpty(resultSet)) {
				throw new NoRecordFoundException("Invalid Username and Password");
			}
			
			//you are here means username and password combination is correct
			resultSet.next();
			LoggedINUser.loggedInUserId = resultSet.getInt("user_id");
		}catch(SQLException sqlEx) {
			//code to log the error in the file
			throw new SomeThingWrongException();
		}finally {
			try {
				//close the exception
				DBUtils.closeConnection(connection);				
			}catch(SQLException sqlEX) {
				throw new SomeThingWrongException();
			}
		}
	}
	
	@Override
	public void logout() {
		LoggedINUser.loggedInUserId = 0;
	}
}
