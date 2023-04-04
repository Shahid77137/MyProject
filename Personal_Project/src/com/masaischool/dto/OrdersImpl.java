package com.masaischool.dto;

import java.time.LocalDate;

public class OrdersImpl implements Orders {
	private Product product;
	private User user;
	private int quantity;
	private LocalDate purchaseDate;
	
	public OrdersImpl() {}
	
	public OrdersImpl(Product product, User user, int quantity) {
		this.product = product;
		this.user = user;
		this.quantity = quantity;
	}

	public Product getProduct() {
		return product;
	}

	public void setProduct(Product product) {
		this.product = product;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public int getQuantity() {
		return quantity;
	}

	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}

	public LocalDate getPurchaseDate() {
		return purchaseDate;
	}

	public void setPurchaseDate(LocalDate registrationDate) {
		this.purchaseDate = registrationDate;
	}

	@Override
	public String toString() {
		return "Product: " + product.getProdName() + ", Buyer: " + user.getName() + ", Quantity=" + quantity + ", Date of Purchase: "
				+ purchaseDate;
	}
}