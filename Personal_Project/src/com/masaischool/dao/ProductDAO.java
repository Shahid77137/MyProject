package com.masaischool.dao;

import java.util.List;

import com.masaischool.dto.Product;
import com.masaischool.exception.NoRecordFoundException;
import com.masaischool.exception.SomeThingWrongException;

public interface ProductDAO {
	public void addProduct(Product product) throws SomeThingWrongException;
	public void updateProduct(Product product) throws SomeThingWrongException, NoRecordFoundException;
	public void deleteProduct(Integer productId) throws SomeThingWrongException, NoRecordFoundException;	
	public List<Product> getAllProducts() throws SomeThingWrongException, NoRecordFoundException;
	public List<Product> getProductsByName(String name) throws SomeThingWrongException, NoRecordFoundException;	
	public Product getProductById(Integer productId) throws SomeThingWrongException, NoRecordFoundException;
	public List<Product> getProductsByCategoryId(Integer categoryId) throws SomeThingWrongException, NoRecordFoundException;
}
