package com.masaischool.dto;

import java.time.LocalDate;

public class ProductImpl implements Product {
	private Integer prodId;
	private String prodName;
	private Double MRP;
	private LocalDate MFGDate;
	private Category category;
	
	public ProductImpl() {}
	
	public ProductImpl(Integer prodId, String prodName, Double mRP, LocalDate mFGDate, Category category) {
		super();
		this.prodId = prodId;
		this.prodName = prodName;
		MRP = mRP;
		MFGDate = mFGDate;
		this.category = category;
	}
	
	@Override
	public Integer getProdId() {
		return prodId;
	}
	
	@Override
	public void setProdId(Integer prodId) {
		this.prodId = prodId;
	}
	
	@Override
	public String getProdName() {
		return prodName;
	}
	
	@Override
	public void setProdName(String prodName) {
		this.prodName = prodName;
	}
	
	@Override
	public Double getMRP() {
		return MRP;
	}
	
	@Override
	public void setMRP(Double mRP) {
		MRP = mRP;
	}
	
	@Override
	public LocalDate getMFGDate() {
		return MFGDate;
	}
	
	@Override
	public void setMFGDate(LocalDate mFGDate) {
		MFGDate = mFGDate;
	}
	
	@Override
	public Category getCategory() {
		return category;
	}
	
	@Override
	public void setCategory(Category category) {
		this.category = category;
	}

	@Override
	public int hashCode() {
		return prodId;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		ProductImpl other = (ProductImpl) obj;
		return prodId.equals(other.prodId);
	}

	@Override
	public String toString() {
		String productDetails ="Product Id: " + prodId + ", Product Name: " + prodName + ", MRP: " + MRP + ", MFGDate: " + MFGDate; 
		if(category != null)
			return  productDetails + ", Category Name: " + category.getCategoryName();
		return productDetails + ", Category Name: Null";
	}
}