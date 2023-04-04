package com.masaischool.dto;

import java.time.LocalDate;

public interface Product {
	public Integer getProdId();
	public void setProdId(Integer prodId);
	public String getProdName();
	public void setProdName(String prodName);
	public Double getMRP();
	public void setMRP(Double mRP);
	public LocalDate getMFGDate();
	public void setMFGDate(LocalDate mFGDate);
	public Category getCategory();
	public void setCategory(Category category);
}
