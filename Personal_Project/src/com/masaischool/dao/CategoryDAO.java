package com.masaischool.dao;

import java.util.List;

import com.masaischool.dto.Category;
import com.masaischool.exception.NoRecordFoundException;
import com.masaischool.exception.SomeThingWrongException;

public interface CategoryDAO {
	/**
	 * Add a category to the database
	 * @param category object containing all details about the category to be added
	 * @throws SomeThingWrongException - if anything went wrong during this operation
	 */
	public void addCategory(Category category) throws SomeThingWrongException;

	/**
	 * Update the category details in the database
	 * @param category object containing all details about the category to be added
	 * @throws SomeThingWrongException - if anything went wrong during this operation
	 * @throws NoRecordFoundException - if no category in the database for given category id
	 */
	public void updateCategory(Category category) throws SomeThingWrongException, NoRecordFoundException;
	
	/**
	 * Delete the category specified by the category id from the database
	 * @param categoryId - the id of category to be deleted
	 * @throws SomeThingWrongException - if anything went wrong during this operation
	 * @throws NoRecordFoundException - if no category in the database for given category id
	 */
	public void deleteCategory(Integer categoryId) throws SomeThingWrongException, NoRecordFoundException;
	
	/**
	 * return a list containing all categories
	 * @return List<Category> - a list containing all categories 
	 * @throws SomeThingWrongException - if anything went wrong during this operation
	 * @throws NoRecordFoundException - if no category in the database
	 */
	public List<Category> getAllCategories() throws SomeThingWrongException, NoRecordFoundException;
	
	/**
	 * searches the category for the name specified by parameter such that all categories containing the parameter name anywhere in their name will also be returned
	 * @param name - name of the category to be searched for 
	 * @return List<Category> - a list containing all categories that contains the parameter name
	 * @throws SomeThingWrongException - if anything went wrong during this operation
	 * @throws NoRecordFoundException - if no category in the database
	 */
	public List<Category> getCategoriesByName(String name) throws SomeThingWrongException, NoRecordFoundException;
	
	/**
	 * return the category object
	 * @param categoryId - the id of the category
	 * @return - the category object contains details of category whose id is specified by parameter
	 * @throws SomeThingWrongException - if anything went wrong during this operation
	 * @throws NoRecordFoundException - if no category in the database
	 */
	public Category getCategoryById(Integer categoryId) throws SomeThingWrongException, NoRecordFoundException;
}