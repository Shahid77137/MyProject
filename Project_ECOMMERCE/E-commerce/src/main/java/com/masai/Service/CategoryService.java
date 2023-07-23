package com.masai.Service;

import java.util.List;

import com.masai.Exception.CategoryException;
import com.masai.Model.Category;

public interface CategoryService {

	public Category addCategory(Category category)throws CategoryException;
	public Category getAllProductsByCategoryId(int catid)throws CategoryException;
	public Category updateCategoryById(int catId,Category category)throws CategoryException;
	public Category deleteCategoryById(int catId)throws CategoryException;
	public List<Category> getAllCategory()throws CategoryException;
	
	
}