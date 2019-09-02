package com.shoppingsite.controller;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import com.shoppingsite.model.*;

/**
*the class Main is used to display complete details of the operation
* it can be say as view in layer architecture
**/
public class Main {
	public static void main(String[] args) throws SQLException {
		ArrayList<Product> product = new ArrayList<Product>();
		Scanner sc = new Scanner(System.in);
		Controller controllerObj = new Controller();

		System.out.println("Welcome to shopping site");
		System.out.println("Enter your Details  to Login");
		System.out.println("Id");
		int id = sc.nextInt();
		System.out.println("Password");
		sc.nextLine();
		String password = sc.nextLine();
		boolean result = controllerObj.authenticatUser(id, password);
		// loop work as do while until user will not logout
		while (result) {
			try {
				System.out.println("Login Succefully");
				System.out.println("press 1 for Add Product");
				System.out.println("press 2 for Show Cart");
				System.out.println("press 3 for Edit Cart");
				System.out.println("press 4 for Logout");
				sc.nextLine();
				int choise = sc.nextInt();
				switch (choise) {
				case 1:
					if (product.size() == 0) {
						product = controllerObj.getProduct();
					}
					showProductDetails(product);
					System.out.println("Enter Id to insert product into cart");
					sc.nextLine();
					String productId = sc.nextLine();
					System.out.println("Enter Qunity of Product");
					String quntity = sc.nextLine();
					boolean addProductResult = controllerObj.addProduct(id,
							productId, quntity);
					if (addProductResult) {
						System.out.println("Product Add Sucessfully");
					} else {
						System.out.println("Insert valid Quntity");
					}
					break;
				case 2:
					showCartDetails(controllerObj.showCart(id), id);
					break;
				case 3:
					boolean editresult;
					showCartDetails(controllerObj.showCart(id), id);
					System.out.println("Enter the Cart id");
					int cId = sc.nextInt();
					System.out.println("Enter the quntity");
					int quantity = sc.nextInt();
					if (quantity <= 0) {
						editresult = controllerObj.deleteRowFromCart(id, cId,
								quantity);
					} else {
						editresult = controllerObj.editCart(id, cId, quantity);
					}
					if (editresult) {
						System.out.println("succefully edit");
					}
					break;
				case 4:
					result = false;
					System.out.println("Logout Succefully user->" + id);
					break;
				default:
					System.out.println("Invalid choise");
					break;
				}
			} catch (Exception e) {
				System.out.println("invalid input  restart again");
		
			}
		}
		if (!result) {
			System.out.println("Invalid Login id and Password");
		}
		sc.close();
	}
	/**
	*helper method
	* function is used to show Product details
	**/
	private static void showProductDetails(ArrayList<Product> product) {
		System.out
				.println("-------------------------- -----------------------------------------------------------------------");
		System.out
				.println("Product-Id---------------- product-Type------------------product-Name----------------product-Price");
		for (int i = 0; i < product.size(); i++) {
			System.out.println("     " + product.get(i).getId()
					+ "                              "
					+ product.get(i).getType() + "                "
					+ product.get(i).getName() + "                     "
					+ product.get(i).getPrice());
			System.out.println();
		}
		System.out
				.println("-------------------------- -----------------------------------------------------------------------");

	}
	/**
	*helper method
	* function is used to show cart details
	**/
	private static void showCartDetails(List<ShoppingCart> cart, int id) {
		if (cart.size() > 0) {
			System.out
					.println("-------------------------------------------------------------------------------------");
			System.out
					.println("         ID             USER_ID               PRODUCT_ID         Quantity");
			for (int i = 0; i < cart.size(); i++) {
				if (cart.get(i).getUserId() == id) {
					System.out.println("          " + cart.get(i).getId()
							+ "              " + cart.get(i).getUserId()
							+ "                     "
							+ cart.get(i).getProductId()
							+ "                       "
							+ cart.get(i).getQuntity());
					System.out.println();
				}
			}
			System.out
					.println("--------------------------------------------------------------------------------------");
		} else {
			System.out.println("cart Empthy");
		}

	}
}
