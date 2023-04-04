package com.masaischool.ui;

import java.util.List;
import java.util.Scanner;

import com.masaischool.dao.OrderDAO;
import com.masaischool.dao.OrderDAOImpl;
import com.masaischool.dto.Orders;
import com.masaischool.exception.NoRecordFoundException;
import com.masaischool.exception.SomeThingWrongException;

public class OrderUI {
	private OrderDAO orderDAO;
	private Scanner scanner;
	
	public OrderUI(Scanner scanner){
		orderDAO = new OrderDAOImpl();
		this.scanner = scanner;
	}
	
	public void purchaseProduct() {
		//code to take input product id and quantity
		System.out.print("Enter product id ");
		int proId = scanner.nextInt();
		
		System.out.print("Enter quantity ");
		int quantity = scanner.nextInt();
		
		try {
			orderDAO.purchaseProduct(proId, quantity);
			System.out.println("Order placed successfully");
		}catch(SomeThingWrongException ex) {
			System.out.println(ex);
		}
	}
	
	public void viewAllOrders() {
		try {
			List<Orders> orderList  = orderDAO.getAllOrders();
			orderList.forEach(System.out::println);
		}catch(SomeThingWrongException | NoRecordFoundException ex) {
			System.out.println(ex);
		}
	}
	
	public void viewOrderDetails() {
		try {
			List<Orders> orderList  = orderDAO.getOrdersOfLoggedInUser();
			orderList.forEach(System.out::println);
		}catch(SomeThingWrongException | NoRecordFoundException ex) {
			System.out.println(ex);
		}
	}
}