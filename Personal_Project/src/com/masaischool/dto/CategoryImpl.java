package com.masaischool.dto;
import java.util.Set;

public class CategoryImpl implements Category {
	private Integer categoryId;
	private String categoryName;
	private Set<Product> productSet;
	
	public CategoryImpl() {}
	
	public CategoryImpl(Integer categoryId, String categoryName) {
		super();
		this.categoryId = categoryId;
		this.categoryName = categoryName;
	}

	@Override
	public Integer getCategoryId() {
		return categoryId;
	}

	@Override
	public void setCategoryId(Integer categoryId) {
		this.categoryId = categoryId;
	}

	@Override
	public String getCategoryName() {
		return categoryName;
	}

	@Override
	public void setCategoryName(String categoryName) {
		this.categoryName = categoryName;
	}

	@Override
	public Set<Product> getProductSet() {
		return productSet;
	}

	@Override
	public void setProductSet(Set<Product> productSet) {
		this.productSet = productSet;
	}

	@Override
	public int hashCode() {
		return categoryId;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		CategoryImpl other = (CategoryImpl) obj;
		return categoryId.equals(other.categoryId);
	}

	@Override
	public String toString() {
		return "Category Id: " + categoryId + ", Category Name: " + categoryName;
	}	
}