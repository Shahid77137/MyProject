package com.masaischool.ui;

import java.time.LocalDate;
import java.util.List;
import java.util.Scanner;

import com.masaischool.dao.UserDAO;
import com.masaischool.dao.UserDAOImpl;
import com.masaischool.dto.User;
import com.masaischool.dto.UserImpl;
import com.masaischool.exception.NoRecordFoundException;
import com.masaischool.exception.SomeThingWrongException;

public class UserUI {
	private UserDAO userDAO;
	private Scanner scanner;
	
	public UserUI(Scanner scanner) {
		this.userDAO = new UserDAOImpl();
		this.scanner = scanner;
	}	
	
	public void addUser() {
		//code to take input product details
		System.out.print("Enter user id ");
		int userId = scanner.nextInt();
		System.out.print("Enter name ");
		String name = scanner.next();
		System.out.print("Enter username ");
		String username = scanner.next();
		
		//create object for user with all details
		User user = new UserImpl(userId, name, username, "abc123", LocalDate.now());
		
		try {
			userDAO.addUser(user);;
			System.out.println("User registered successfully");
		}catch(SomeThingWrongException ex) {
			System.out.println(ex);
		}
	}
	
	public void viewAllUsers() {
		try {
			List<User> listUsers = userDAO.getAllUsersList();
			listUsers.forEach(System.out::println);
		}catch(SomeThingWrongException | NoRecordFoundException ex) {
			System.out.println(ex);
		}
	}
	
	public void updateNameOfUser() {
		//code to take input new name
		System.out.print("Enter name ");
		String name = scanner.next();
		
		try {
			userDAO.updateNameOfUser(name);
			System.out.println("Name updated successfully");
		}catch(SomeThingWrongException ex) {
			System.out.println(ex);
		}
	}
	
	public void deleteUser() {
		try {
			userDAO.deleteUser();
			System.out.println("You are Logged out.\nDeleted your account");
		}catch(SomeThingWrongException ex) {
			System.out.println(ex);
		}
	}
	
	public void changePassword() {
		//code to take input new name
		System.out.print("Enter old password ");
		String oldPassword = scanner.next();
		
		System.out.print("Enter new password ");
		String newPassword = scanner.next();
		
		System.out.print("Re-type new password ");
		String newPasswordAgain = scanner.next();
		if(newPassword.equals(newPasswordAgain)) {
			try {
				userDAO.changePassword(oldPassword, newPassword);
				System.out.println("Password updated successfully");
			}catch(SomeThingWrongException | NoRecordFoundException ex) {
				System.out.println(ex);
			}			
		}else {
			System.out.println("New password mismatched with re-typed new password");
		}
	}
	
	public boolean login() {
		boolean loginSuccessful = false;
		//code to take input username and password
		System.out.print("Enter username ");
		String username = scanner.next();
		
		System.out.print("Enter password ");
		String password = scanner.next();
		
		try {
			userDAO.Login(username, password);
			loginSuccessful = true;
		}catch(SomeThingWrongException | NoRecordFoundException ex) {
			System.out.println(ex);
		}
		return loginSuccessful;
	}
	
	public void logout() {
		userDAO.logout();
	}
}
