package com.masai.Service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.masai.Exception.CustomersException;
import com.masai.Exception.ProductsException;
import com.masai.Model.Customers;
import com.masai.Model.Products;
import com.masai.Repository.CustomerRepository;
import com.masai.Repository.ProductRepository;

@Service
public class ProductsServiceImpl implements ProductsService{

	@Autowired
	private ProductRepository productRepository;
	
	@Override
	public Products addProduct(Products product) throws ProductsException {
		if(productRepository.existsById(product.getProductId())) {
			throw new ProductsException("product already exists with id "+product.getProductId());
		}
		
		return productRepository.save(product);
	}

	@Override
	public Products getProductById(int prodId) throws ProductsException {
Optional<Products> products = productRepository.findById(prodId);
		
		if(products.isEmpty()) {
			throw new ProductsException("Products doesn't exists with id "+prodId);
		}
		
		return products.get();
	}

	@Override
	public List<Products> getAllProducts() throws ProductsException {
        List<Products> list = productRepository.findAll();
		
		if(list.isEmpty()) {
			throw new ProductsException("No product found");
		}
		
		return list;
	}

	@Override
	public Products updateProduct(int prodId,Products products) throws ProductsException {
Optional<Products> product = productRepository.findById(prodId);
		
		if(product.isEmpty()) {
			throw new ProductsException("Products doesn't exists with id "+prodId);
		}
		
		Products custo = product.get();
		
		
		custo.setImage1(products.getImage1());
		custo.setImage2(products.getImage2());
		custo.setImage3(products.getImage3());
		custo.setProductBrand(products.getProductBrand());
		custo.setProductName(products.getProductName());
		custo.setProductType(products.getProductType());
		custo.setSalePrice(products.getSalePrice());
		custo.setMarkedPrice(products.getMarkedPrice());
		custo.setDiscountPercentage(products.getDiscountPercentage());
		custo.setQuantity(products.getQuantity());
		custo.setIsAvailable(products.getIsAvailable());
		custo.setManufacturedDate(products.getManufacturedDate());
		custo.setRating(products.getRating());
		custo.setDescription(products.getDescription());
		custo.setTotalSold(products.getTotalSold());
		custo.setProductCreatedDate(products.getProductCreatedDate());
		custo.setProductUpdatedDate(products.getProductUpdatedDate());
		
		return productRepository.save(custo);
	}

	@Override
	public Products deleteProduct(int prodId) throws ProductsException {
Optional<Products> products = productRepository.findById(prodId);
		
		if(products.isEmpty()) {
			throw new ProductsException("No product exists with id "+prodId); 
		}
		
		productRepository.delete(products.get());
		
		return products.get();
	}

	@Override
	public List<Products> searchByName(String productName) throws ProductsException {
		
		if(productRepository.existsByproductName(productName)) {
			List<Products> list = productRepository.findByName(productName);
			return list;
		}else {
			throw new ProductsException("No product found with name "+productName);
		}
		
		
	}

	@Override
	public List<Products> searchByBrand(String productBrand) throws ProductsException {
		
		if(productRepository.existsByproductBrand(productBrand)) {
			List<Products> list = productRepository.findByBrand(productBrand);
			return list;
		}else {
			throw new ProductsException("No product found with brand "+productBrand);
		}
		
	}

	@Override
	public List<Products> searchByType(String productType) throws ProductsException {
		
		if(productRepository.existsByproductType(productType)) {
			List<Products> list = productRepository.findByType(productType);
			return list;
		}else {
			throw new ProductsException("No product found with Type "+productType);
		}
		
	}

	@Override
	public List<Products> searchByRating(double rating) throws ProductsException {
		
		if(productRepository.existsByRating(rating)) {
			List<Products> list = productRepository.findByRating(rating);
			return list;
		}else {
			throw new ProductsException("No product found with rating "+rating);
		}
		
	}

	@Override
	public List<Products> searchByisAvailable(boolean isAvailable) throws ProductsException {
		
		
			List<Products> list = productRepository.findByisAvailable(isAvailable);
			return list;
		
		
	}

}
