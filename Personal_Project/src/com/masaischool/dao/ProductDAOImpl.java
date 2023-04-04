package com.masaischool.dao;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.masaischool.dto.CategoryImpl;
import com.masaischool.dto.Product;
import com.masaischool.dto.ProductImpl;
import com.masaischool.exception.NoRecordFoundException;
import com.masaischool.exception.SomeThingWrongException;

public class ProductDAOImpl implements ProductDAO {
	private CategoryDAO categoryDAO;
	
	public ProductDAOImpl() {
		categoryDAO = new CategoryDAOImpl();
	}
	
	@Override
	public void addProduct(Product product) throws SomeThingWrongException{
		Connection connection = null;
		try {
			//connect to database
			connection = DBUtils.connectToDatabase();
			//prepare the query
			String INSERT_QUERY = "INSERT INTO product (pro_id, pro_name, MRP, MFG_DATE, cat_id) VALUES (?, ?, ?, ?, ?)";
			
			//get the prepared statement object
			PreparedStatement ps = connection.prepareStatement(INSERT_QUERY);
			
			//stuff the data in the query
			ps.setInt(1, product.getProdId());
			ps.setString(2, product.getProdName());
			ps.setDouble(3, product.getMRP());
			ps.setDate(4, Date.valueOf(product.getMFGDate()));
			ps.setInt(5, product.getCategory().getCategoryId());
			
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
	
	/**
	 * converts the resultset to the list of product objects
	 * @param resultSet - the resultset to be converted to list of products
	 * @return List<Product> - list of products
	 * @throws SQLException - if anything went wrong during this operation
	 */
	private List<Product> getProductListFromResultSet(ResultSet resultSet) throws SQLException{
		List<Product> list = new ArrayList<>();
		while(resultSet.next()) {
			Product product = new ProductImpl();
			product.setProdId(resultSet.getInt("pro_id"));
			product.setProdName(resultSet.getString("pro_name"));
			product.setMRP(resultSet.getDouble("MRP"));
			product.setMFGDate(resultSet.getDate("MFG_DATE").toLocalDate());
			
			if(resultSet.getInt("cat_id") == 0) {
				//you are here means the product does not belong to any category
				product.setCategory(null);
			}else {
				//you are here means the product belongs to a category
				product.setCategory(new CategoryImpl(resultSet.getInt("cat_id"), resultSet.getString("cat_name")));
			}

			list.add(product);
		}
		return list;
	}
	
	@Override
	public List<Product> getAllProducts() throws SomeThingWrongException, NoRecordFoundException{
		Connection connection = null;
		List<Product> list = null;
		try {
			//connect to database
			connection = DBUtils.connectToDatabase();
			//prepare the query
			String SELECT_QUERY = "SELECT pro_id, pro_name, MRP, MFG_DATE, P.cat_id, C.cat_name FROM product P LEFT JOIN category C ON P.cat_id = C.cat_id";
			
			//get the prepared statement object
			PreparedStatement ps = connection.prepareStatement(SELECT_QUERY);
			
			//execute query
			ResultSet resultSet = ps.executeQuery();
			
			//check if result set is empty
			if(DBUtils.isResultSetEmpty(resultSet)) {
				throw new NoRecordFoundException("No product Found");
			}
			
			list = getProductListFromResultSet(resultSet);
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
	public List<Product> getProductsByCategoryId(Integer categoryId) throws SomeThingWrongException, NoRecordFoundException{
		Connection connection = null;
		List<Product> list = null;
		try {
			//connect to database
			connection = DBUtils.connectToDatabase();
			//prepare the query
			String SELECT_QUERY = "SELECT * FROM product WHERE cat_id = ?";
			
			//get the prepared statement object
			PreparedStatement ps = connection.prepareStatement(SELECT_QUERY);
			ps.setInt(1, categoryId);
			
			//execute query
			ResultSet resultSet = ps.executeQuery();
			
			//check if result set is empty
			if(DBUtils.isResultSetEmpty(resultSet)) {
				throw new NoRecordFoundException("No product Found in this category");
			}
			
			list = getProductListFromResultSet(resultSet);
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
	public List<Product> getProductsByName(String name) throws SomeThingWrongException, NoRecordFoundException{
		Connection connection = null;
		List<Product> list = null;
		try {
			//connect to database
			connection = DBUtils.connectToDatabase();
			//prepare the query
			String SELECT_QUERY = "SELECT * FROM product WHERE pro_name LIKE ?";
			
			//get the prepared statement object
			PreparedStatement ps = connection.prepareStatement(SELECT_QUERY);
			ps.setString(1, "%" + name + "%");
			
			//execute query
			ResultSet resultSet = ps.executeQuery();
			
			//check if result set is empty
			if(DBUtils.isResultSetEmpty(resultSet)) {
				throw new NoRecordFoundException("No product Found for given name");
			}
			
			list = getProductListFromResultSet(resultSet);
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
		return list;
	}
	
	@Override
	public Product getProductById(Integer productId) throws SomeThingWrongException, NoRecordFoundException{
		Connection connection = null;
		Product product = null;
		try {
			//connect to database
			connection = DBUtils.connectToDatabase();
			//prepare the query
			String SELECT_QUERY = "SELECT * FROM product WHERE pro_id = ?";
			
			//get the prepared statement object
			PreparedStatement ps = connection.prepareStatement(SELECT_QUERY);
			ps.setInt(1, productId);
			
			//execute query
			ResultSet resultSet = ps.executeQuery();
			
			//check if result set is empty
			if(DBUtils.isResultSetEmpty(resultSet)) {
				throw new NoRecordFoundException("No product Found for given id");
			}
			
			resultSet.next();
			
			if(resultSet.getInt("cat_id") == 0) {
				//you are here means the product does not belong to any category
				product = new ProductImpl(resultSet.getInt("pro_id"), resultSet.getString("pro_name"), resultSet.getDouble("MRP"), 
						resultSet.getDate("MFG_DATE").toLocalDate(), null);
			}else {
				//you are here means the product belongs to a category
				try {
					product = new ProductImpl(resultSet.getInt("pro_id"), resultSet.getString("pro_name"), resultSet.getDouble("MRP"),
							resultSet.getDate("MFG_DATE").toLocalDate(), categoryDAO.getCategoryById(resultSet.getInt("cat_id")));
				}catch(NoRecordFoundException | SomeThingWrongException ex) {
					
				}				
			}
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
		return product;
	}
	
	@Override
	public void updateProduct(Product product) throws SomeThingWrongException, NoRecordFoundException{
		//if no product for given product id then this line will throw NoRecordFoundException
		getProductById(product.getProdId());
		
		Connection connection = null;
		try {
			//connect to database
			connection = DBUtils.connectToDatabase();
			//prepare the query
			String UPDATE_QUERY = "UPDATE product set pro_name = ?, MRP = ?, MFG_DATE = ?, cat_id = ? WHERE pro_id = ?";
			
			//get the prepared statement object
			PreparedStatement ps = connection.prepareStatement(UPDATE_QUERY);
			
			//stuff the data in the query
			ps.setString(1, product.getProdName());
			ps.setDouble(2, product.getMRP());
			ps.setDate(3, Date.valueOf(product.getMFGDate()));
			ps.setInt(4, product.getCategory().getCategoryId());
			ps.setInt(5, product.getProdId());
			
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
	public void deleteProduct(Integer productId) throws SomeThingWrongException, NoRecordFoundException{
		//if no product for given product id then this line will throw NoRecordFoundException
		getProductById(productId);
		
		Connection connection = null;
		try {
			//connect to database
			connection = DBUtils.connectToDatabase();
			//prepare the query
			String DELETE_QUERY = "DELETE FROM product WHERE pro_id = ?";
			
			//get the prepared statement object
			PreparedStatement ps = connection.prepareStatement(DELETE_QUERY);
			
			//stuff the data in the query
			ps.setInt(1, productId);
			
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
}
