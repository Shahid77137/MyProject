package com.masaischool.ui;

import java.time.LocalDate;
import java.util.List;
import java.util.Scanner;

import com.masaischool.dao.ProductDAO;
import com.masaischool.dao.ProductDAOImpl;
import com.masaischool.dto.CategoryImpl;
import com.masaischool.dto.Product;
import com.masaischool.dto.ProductImpl;
import com.masaischool.exception.NoRecordFoundException;
import com.masaischool.exception.SomeThingWrongException;

public class ProductUI {
	private ProductDAO productDAO;
	private Scanner scanner;
	
	public ProductUI(Scanner scanner){
		productDAO = new ProductDAOImpl();
		this.scanner = scanner;
	}
	
	public void addProduct() {
		//code to take input product details
		System.out.print("Enter product id ");
		int proId = scanner.nextInt();
		System.out.print("Enter product name ");
		String proName = scanner.next();
		System.out.print("Enter MRP ");
		double MRP = scanner.nextDouble();
		System.out.print("Enter MFG. Date ");
		LocalDate MFGDate = LocalDate.parse(scanner.next());
		System.out.print("Enter category id ");
		int catId = scanner.nextInt();
		
		//create object for product with all details
		Product product= new ProductImpl(proId, proName, MRP, MFGDate, new CategoryImpl(catId, null));
		
		try {
			productDAO.addProduct(product);;
			System.out.println("Product added successfully");
		}catch(SomeThingWrongException ex) {
			System.out.println(ex);
		}
	}
	
	public void viewAllProducts() {
		try {
			List<Product> listProducts = productDAO.getAllProducts();
			listProducts.forEach(System.out::println);
		}catch(SomeThingWrongException | NoRecordFoundException ex) {
			System.out.println(ex);
		}
	}

	public void updateProduct() {
		//code to take input product details
		System.out.print("Enter product id ");
		int proId = scanner.nextInt();
		System.out.print("Enter product name ");
		String proName = scanner.next();
		System.out.print("Enter MRP ");
		double MRP = scanner.nextDouble();
		System.out.print("Enter MFG. Date ");
		LocalDate MFGDate = LocalDate.parse(scanner.next());
		System.out.print("Enter category id ");
		int catId = scanner.nextInt();
		
		//create object for product with all details
		Product product= new ProductImpl(proId, proName, MRP, MFGDate, new CategoryImpl(catId, null));
		
		try {
			productDAO.updateProduct(product);
			System.out.println("Product updated successfully");
		}catch(SomeThingWrongException | NoRecordFoundException ex) {
			System.out.println(ex);
		}
	}
	
	public void deleteProduct() {
		//code to take input product details
		System.out.print("Enter product id ");
		int productId = scanner.nextInt();
		
		try {
			productDAO.deleteProduct(productId);
			System.out.println("Product deleted successfully");
		}catch(SomeThingWrongException | NoRecordFoundException ex) {
			System.out.println(ex);
		}
	}
	
	public void searchProductsByName() {
		//code to take input product name
		System.out.print("Enter product name ");
		String productName = scanner.next();
		
		try {
			List<Product> listProducts = productDAO.getProductsByName(productName);
			listProducts.forEach(System.out::println);
		}catch(SomeThingWrongException | NoRecordFoundException ex) {
			System.out.println(ex);
		}
	}
	
	public void searchProductById() {
		//code to take input product name
		System.out.print("Enter product id");
		int productId = scanner.nextInt();
		
		try {
			Product product = productDAO.getProductById(productId);
			System.out.println(product);
		}catch(SomeThingWrongException | NoRecordFoundException ex) {
			System.out.println(ex);
		}
	}
	
	public void viewProductsByCategoryId() {
		//code to take input category details
		System.out.print("Enter category id ");
		int categoryId = scanner.nextInt();
		try {
			List<Product> listProducts = productDAO.getProductsByCategoryId(categoryId);
			listProducts.forEach(System.out::println);
		}catch(SomeThingWrongException | NoRecordFoundException ex) {
			System.out.println(ex);
		}
	}
}
