package com.masaischool.dto;

import java.util.Set;

public interface Category {
	/**
	 * return id of the calling category object
	 * @return - The id of category
	 */
	public Integer getCategoryId();
	
	/**
	 * Sets the id of the calling category object
	 * @param categoryId - The id of category 
	 */
	public void setCategoryId(Integer categoryId);
	
	/**
	 * return name of the calling category object
	 * @return - The category name
	 */
	public String getCategoryName();
	
	/**
	 * Sets the name of the calling category object
	 * @param categoryName - The name of category
	 */
	public void setCategoryName(String categoryName);

	/**
	 * return set of products for calling category object
	 * @return - The set of products
	 */
	public Set<Product> getProductSet();
	
	/**
	 * Sets the Set of products for the calling category object
	 * @param productSet - The set of products
	 */
	public void setProductSet(Set<Product> productSet);
}