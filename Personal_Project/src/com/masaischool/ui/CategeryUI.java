package com.masaischool.ui;

import com.masaischool.dto.Category;
import com.masaischool.dto.CategoryImpl;
import com.masaischool.dao.CategoryDAO;
import com.masaischool.dao.CategoryDAOImpl;
import com.masaischool.exception.NoRecordFoundException;
import com.masaischool.exception.SomeThingWrongException;

import java.util.List;
import java.util.Scanner;

public class CategeryUI {
	private CategoryDAO categoryDAO;
	private Scanner scanner;
	
	public CategeryUI(Scanner scanner){
		categoryDAO = new CategoryDAOImpl();
		this.scanner = scanner;
	}
	
	public void addCategory() {
		//code to take input category details
		System.out.print("Enter categroy id ");
		int catId = scanner.nextInt();
		System.out.print("Enter categroy name ");
		String catName = scanner.next();
		
		//create object for category with category id and name
		Category category = new CategoryImpl(catId, catName);
		
		try {
			categoryDAO.addCategory(category);
			System.out.println("Category added successfully");
		}catch(SomeThingWrongException ex) {
			System.out.println(ex);
		}
	}
	
	public void viewAllCategories() {
		try {
			List<Category> listCategories = categoryDAO.getAllCategories();
			listCategories.forEach(System.out::println);
		}catch(SomeThingWrongException | NoRecordFoundException ex) {
			System.out.println(ex);
		}
	}

	public void updateCategory() {
		//code to take input category details
		System.out.print("Enter categroy id ");
		int catId = scanner.nextInt();
		System.out.print("Enter categroy name ");
		String catName = scanner.next();
		
		//create object for category with category id and name
		Category category = new CategoryImpl(catId, catName);
		
		try {
			categoryDAO.updateCategory(category);
			System.out.println("Category updated successfully");
		}catch(SomeThingWrongException | NoRecordFoundException ex) {
			System.out.println(ex);
		}
	}
	
	public void deleteCategory() {
		//code to take input category details
		System.out.print("Enter categroy id ");
		int catId = scanner.nextInt();
		
		try {
			categoryDAO.deleteCategory(catId);
			System.out.println("Category deleted successfully");
		}catch(SomeThingWrongException | NoRecordFoundException ex) {
			System.out.println(ex);
		}
	}
	
	public void searchCategoriesByName() {
		//code to take input category name
		System.out.print("Enter categroy name ");
		String catName = scanner.next();
		
		try {
			List<Category> listCategories = categoryDAO.getCategoriesByName(catName);
			listCategories.forEach(System.out::println);
		}catch(SomeThingWrongException | NoRecordFoundException ex) {
			System.out.println(ex);
		}
	}
	
	public void searchCategoryById() {
		//code to take input category name
		System.out.print("Enter categroy id");
		int catId = scanner.nextInt();
		
		try {
			Category category = categoryDAO.getCategoryById(catId);
			System.out.println(category);
		}catch(SomeThingWrongException | NoRecordFoundException ex) {
			System.out.println(ex);
		}
	}
}
