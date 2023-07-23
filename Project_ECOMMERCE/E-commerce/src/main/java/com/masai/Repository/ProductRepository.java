package com.masai.Repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.masai.Model.Customers;
import com.masai.Model.Products;
@Repository
public interface ProductRepository extends JpaRepository<Products, Integer>{

	@Query("SELECT p FROM Products p WHERE p.productName = ?1")
    public List<Products> findByName(String productName);
	
	public boolean existsByproductName(String productName);
	
	
	@Query("SELECT p FROM Products p WHERE p.productBrand = ?1")
	public List<Products> findByBrand(String productBrand);
	
	public boolean existsByproductBrand(String productBrand);

	@Query("SELECT p FROM Products p WHERE p.productType = ?1")
	public List<Products> findByType(String productType);
	
	public boolean existsByproductType(String productType);
	
	@Query("SELECT p FROM Products p WHERE p.rating = ?1")
	public List<Products> findByRating(double rating);
	
	public boolean existsByRating(double rating);
	
	@Query("SELECT p FROM Products p WHERE p.isAvailable = ?1")	
	public List<Products> findByisAvailable(boolean isAvailable);

	
}
