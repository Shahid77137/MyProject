package com.masaischool.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.masaischool.dto.Category;
import com.masaischool.dto.CategoryImpl;
import com.masaischool.exception.NoRecordFoundException;
import com.masaischool.exception.SomeThingWrongException;

public class CategoryDAOImpl implements CategoryDAO {
	@Override
	public void addCategory(Category category) throws SomeThingWrongException {
		Connection connection = null;
		try {
			//connect to database
			connection = DBUtils.connectToDatabase();
			//prepare the query
			String INSERT_QUERY = "INSERT INTO category (cat_id, cat_name) VALUES (?, ?)";
			
			//get the prepared statement object
			PreparedStatement ps = connection.prepareStatement(INSERT_QUERY);
			
			//stuff the data in the query
			ps.setInt(1, category.getCategoryId());
			ps.setString(2, category.getCategoryName());
			
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
	 * converts the resultset to the list of category objects
	 * @param resultSet - the resultset to be converted to list of categories
	 * @return List<Category> - list of categories
	 * @throws SQLException - if anything went wrong during this operation
	 */
	private List<Category> getCategoryListFromResultSet(ResultSet resultSet) throws SQLException{
		List<Category> list = new ArrayList<>();
		while(resultSet.next()) {
			//Create an object of Employee
			Category category = new CategoryImpl();
			category.setCategoryId(resultSet.getInt("cat_id"));
			category.setCategoryName(resultSet.getString("cat_name"));
			list.add(category);
		}
		return list;
	}
	
	@Override
	public List<Category> getAllCategories() throws SomeThingWrongException, NoRecordFoundException {
		Connection connection = null;
		List<Category> list = null;
		try {
			//connect to database
			connection = DBUtils.connectToDatabase();
			//prepare the query
			String SELECT_QUERY = "SELECT * FROM category";
			
			//get the prepared statement object
			PreparedStatement ps = connection.prepareStatement(SELECT_QUERY);
			
			//execute query
			ResultSet resultSet = ps.executeQuery();
			
			//check if result set is empty
			if(DBUtils.isResultSetEmpty(resultSet)) {
				throw new NoRecordFoundException("No category Found");
			}
			
			list = getCategoryListFromResultSet(resultSet);
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
	public void updateCategory(Category category) throws SomeThingWrongException, NoRecordFoundException {
		//if no category for given category id then this line will throw NoRecordFoundException
		getCategoryById(category.getCategoryId());
		//you are here means category found for the given category id

		Connection connection = null;
		try {
			//connect to database
			connection = DBUtils.connectToDatabase();
			
			//prepare the query
			String UPDATE_QUERY = "UPDATE category SET cat_name = ? WHERE cat_id = ?";
			
			//get the prepared statement object
			PreparedStatement ps = connection.prepareStatement(UPDATE_QUERY);
			
			//stuff the data in the query
			ps.setString(1, category.getCategoryName());
			ps.setDouble(2, category.getCategoryId());
			
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
	public void deleteCategory(Integer categoryId) throws SomeThingWrongException, NoRecordFoundException {
		//if no category for given category id for given category id then this line will throw NoRecordFoundException
		getCategoryById(categoryId);
		//you are here means category found for the given category id

		Connection connection = null;
		try {
			//connect to database
			connection = DBUtils.connectToDatabase();
			//prepare the query
			String DELETE_QUERY = "DELETE FROM category WHERE cat_id = ?";
			
			//get the prepared statement object
			PreparedStatement ps = connection.prepareStatement(DELETE_QUERY);
			
			//stuff the data in the query
			ps.setInt(1, categoryId);
			
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
	public List<Category> getCategoriesByName(String name) throws SomeThingWrongException, NoRecordFoundException {
		Connection connection = null;
		List<Category> list = null;
		try {
			//connect to database
			connection = DBUtils.connectToDatabase();
			//prepare the query
			String SELECT_QUERY = "SELECT * FROM category WHERE cat_name LIKE ?";
			
			//get the prepared statement object
			PreparedStatement ps = connection.prepareStatement(SELECT_QUERY);
			ps.setString(1, "%" + name + "%");
			
			//execute query
			ResultSet resultSet = ps.executeQuery();
			
			//check if result set is empty
			if(DBUtils.isResultSetEmpty(resultSet)) {
				throw new NoRecordFoundException("No category Found for given name");
			}
			
			list = getCategoryListFromResultSet(resultSet);
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
		// TODO Auto-generated method stub
		return list;
	}

	@Override
	public Category getCategoryById(Integer categoryId) throws SomeThingWrongException, NoRecordFoundException {
		Connection connection = null;
		Category category = null;
		try {
			//connect to database
			connection = DBUtils.connectToDatabase();
			//prepare the query
			String SELECT_QUERY = "SELECT * FROM category WHERE cat_id = ?";
			
			//get the prepared statement object
			PreparedStatement ps = connection.prepareStatement(SELECT_QUERY);
			ps.setInt(1, categoryId);
			
			//execute query
			ResultSet resultSet = ps.executeQuery();
			
			//check if result set is empty
			if(DBUtils.isResultSetEmpty(resultSet)) {
				throw new NoRecordFoundException("No category Found for given id");
			}
			resultSet.next();
			category = new CategoryImpl(resultSet.getInt("cat_id"), resultSet.getString("cat_name"));
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
		return category;
	}
}
