package com.masaischool.dto;

import java.time.LocalDate;

public interface Orders {
	public Product getProduct();
	public void setProduct(Product product);
	public User getUser();
	public void setUser(User user);
	public int getQuantity();
	public void setQuantity(int quantity);
	public LocalDate getPurchaseDate();
	public void setPurchaseDate(LocalDate registrationDate);
}
