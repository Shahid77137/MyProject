package com.masaischool.ui;
import java.util.Scanner;

import com.masaischool.dao.LoggedINUser;

public class Main {
	private static CategeryUI categoryUI;
	private static ProductUI productUI;
	private static UserUI userUI;
	private static OrderUI orderUI;

	static void displayAdminMenu() {
		System.out.println("1. Add new Category");
		System.out.println("2. View all Categories");
		System.out.println("3. Update a Category");
		System.out.println("4. Delete a Category");
		System.out.println("5. Search categories by Name");
		System.out.println("6. Search category by Id");
		System.out.println("7. View all products for a Category");
		System.out.println("8. Add new Product");
		System.out.println("9. View All Products");
		System.out.println("10. Update a Product");
		System.out.println("11. delete a Product");
		System.out.println("12. Search products by Name");
		System.out.println("13. Search product by Id");
		System.out.println("14. Add new User");
		System.out.println("15. View all Users");
		System.out.println("16. View all Orders");
		System.out.println("0. for Exit");
	}
	
	static void adminMenu(Scanner sc) {
		int choice = 0;
		do {
			displayAdminMenu();
			System.out.print("Enter selection ");
			choice = sc.nextInt();
			switch(choice) {
				case 0:
					System.out.println("Bye Bye admin");
					break;
				case 1:
					categoryUI.addCategory();
					break;
				case 2:
					categoryUI.viewAllCategories();
					break;
				case 3:
					categoryUI.updateCategory();
					break;
				case 4:
					categoryUI.deleteCategory();
					break;
				case 5:
					categoryUI.searchCategoriesByName();
					break;
				case 6:
					categoryUI.searchCategoryById();
					break;
				case 7:
					productUI.viewProductsByCategoryId();
					break;
				case 8:
					productUI.addProduct();
					break;
				case 9:
					productUI.viewAllProducts();
					break;
				case 10:
					productUI.updateProduct();
					break;
				case 11:
					productUI.deleteProduct();
					break;
				case 12:
					productUI.searchProductsByName();
					break;
				case 13:
					productUI.searchProductById();
					break;
				case 14:
					userUI.addUser();
					break;
				case 15:
					userUI.viewAllUsers();
					break;
				case 16:
					orderUI.viewAllOrders();
					break;
				default:
					System.out.println("Invalid Selection, try again");
			}
		}while(choice != 0);
	}
	
	static void adminLogin(Scanner sc) {
		System.out.print("Enter username ");
		String username = sc.next();
		System.out.print("Enter password ");
		String password = sc.next();
		
		if(username.equalsIgnoreCase("admin") && password.equalsIgnoreCase("admin")) {
			adminMenu(sc);
		}else {
			System.out.println("Invalid Username and Password");
		}
	}
	
	static void displayCustomerMenu() {
		System.out.println("1. View All Products");
		System.out.println("2. Purchase a Product");
		System.out.println("3. View Order History");
		System.out.println("4. Update My Name");
		System.out.println("5. Update My Password");
		System.out.println("6. Delete My Account");
		System.out.println("0. Logout");
	}
	
	static void customerLogin(Scanner sc) {
		if(!userUI.login())
			return;

		//you are here means login is successful
		int choice = 0;
		do {
			displayCustomerMenu();
			System.out.print("Enter selection ");
			choice = sc.nextInt();
			switch(choice) {
				case 1:
					productUI.viewAllProducts();
					break;
				case 2:
					orderUI.purchaseProduct();
					break;
				case 3:
					orderUI.viewOrderDetails();
					break;
				case 4:
					userUI.updateNameOfUser();
					break;
				case 5:
					userUI.changePassword();
					break;
				case 6:
					userUI.deleteUser();
					try{
						Thread.sleep(2000);
					}catch(InterruptedException ex) {
						
					}
					//no break statement here i.e. after deletion of user account, logout will also take place
				case 0:
					userUI.logout();
					break;
				default:
					System.out.println("Invalid Selection, try again");
			}
		}while(LoggedINUser.loggedInUserId != 0);
	}
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		categoryUI = new CategeryUI(sc);
		productUI = new ProductUI(sc);
		userUI = new UserUI(sc);
		orderUI = new OrderUI(sc);
		
		int choice = 0;
		do {
			System.out.println("1. Admin Login\n2. Customer Login\n0. Exit");
			choice = sc.nextInt();
			switch(choice) {
				case 0:
					System.out.println("Thank you, Visit again");
					break;
				case 1:
					adminLogin(sc);
					break;
				case 2:
					customerLogin(sc);
					break;
				default:
					System.out.println("Invalid Selection, try again");
			}
		}while(choice != 0);
		sc.close();
	}
}
