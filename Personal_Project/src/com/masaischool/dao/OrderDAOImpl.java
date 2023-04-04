package com.masaischool.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.masaischool.dto.Orders;
import com.masaischool.dto.OrdersImpl;
import com.masaischool.dto.ProductImpl;
import com.masaischool.dto.UserImpl;
import com.masaischool.exception.NoRecordFoundException;
import com.masaischool.exception.SomeThingWrongException;

public class OrderDAOImpl implements OrderDAO {
	@Override
	public void purchaseProduct(int prodId, int quantity) throws SomeThingWrongException{
		Connection connection = null;
		try {
			//connect to database
			connection = DBUtils.connectToDatabase();
			//prepare the query
			String INSERT_QUERY = "INSERT INTO orders (pro_id, user_id, quantity) VALUES (?, ?, ?)";
			
			//get the prepared statement object
			PreparedStatement ps = connection.prepareStatement(INSERT_QUERY);
			
			//stuff the data in the query
			ps.setInt(1, prodId);
			ps.setInt(2, LoggedINUser.loggedInUserId);
			ps.setInt(3, quantity);
			
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
	private List<Orders> getOrderListFromResultSet(ResultSet resultSet) throws SQLException{
		List<Orders> list = new ArrayList<>();
		while(resultSet.next()) {
			//Create an object of Employee
			Orders orders = new OrdersImpl();
			orders.setProduct(new ProductImpl(null , resultSet.getString("pro_name"), null, null, null));
			orders.setUser(new UserImpl(null, resultSet.getString("name"), null, null, null));
			orders.setQuantity(resultSet.getInt("quantity"));
			orders.setPurchaseDate(resultSet.getDate("purchase_date").toLocalDate());
			list.add(orders);
		}
		return list;
	}
	
	@Override
	public List<Orders> getAllOrders() throws SomeThingWrongException, NoRecordFoundException{
		Connection connection = null;
		List<Orders> list = null;
		try {
			//connect to database
			connection = DBUtils.connectToDatabase();
			
			//prepare the query
			String SELECT_QUERY = "SELECT P.pro_name, U.name, quantity, purchase_date "
					+ "FROM orders O INNER JOIN Product P ON O.pro_id = P.pro_id INNER JOIN user U "
					+ "ON U.user_id = O.user_id";
			
			//get the prepared statement object
			PreparedStatement ps = connection.prepareStatement(SELECT_QUERY);
			
			//execute query
			ResultSet resultSet = ps.executeQuery();
			
			//check if result set is empty
			if(DBUtils.isResultSetEmpty(resultSet)) {
				throw new NoRecordFoundException("No Order Found");
			}
			
			list = getOrderListFromResultSet(resultSet);
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
	public List<Orders> getOrdersOfLoggedInUser() throws SomeThingWrongException, NoRecordFoundException{
		Connection connection = null;
		List<Orders> list = null;
		try {
			//connect to database
			connection = DBUtils.connectToDatabase();
			
			//prepare the query
			String SELECT_QUERY = "SELECT P.pro_name, U.name, quantity, purchase_date "
					+ "FROM orders O INNER JOIN Product P ON O.pro_id = P.pro_id INNER JOIN user U "
					+ "ON U.user_id = O.user_id AND O.user_id = ?";
			
			//get the prepared statement object
			PreparedStatement ps = connection.prepareStatement(SELECT_QUERY);
			ps.setInt(1, LoggedINUser.loggedInUserId);
			
			//execute query
			ResultSet resultSet = ps.executeQuery();
			
			//check if result set is empty
			if(DBUtils.isResultSetEmpty(resultSet)) {
				throw new NoRecordFoundException("No Order Found");
			}
			
			list = getOrderListFromResultSet(resultSet);
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
}
