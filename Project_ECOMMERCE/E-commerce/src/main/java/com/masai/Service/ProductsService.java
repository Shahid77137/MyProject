package com.masai.Service;

import java.util.List;

import org.springframework.data.jpa.repository.Query;

import com.masai.Exception.ProductsException;
import com.masai.Model.Products;

public interface ProductsService {

	public Products addProduct(Products product)throws ProductsException;
 	public Products getProductById(int prodId)throws ProductsException;
 	public List<Products> getAllProducts()throws ProductsException;
 	public Products updateProduct(int prodId,Products products)throws ProductsException;
 	public Products deleteProduct(int prodId)throws ProductsException;

//    Custom methods
 	
 	public List<Products> searchByName(String productName)throws ProductsException;
 	
 	public List<Products> searchByBrand(String productBrand)throws ProductsException;

 	public List<Products> searchByType(String productType)throws ProductsException;

 	public List<Products> searchByRating(double rating)throws ProductsException;

 	public List<Products> searchByisAvailable(boolean isAvailable)throws ProductsException;

}
