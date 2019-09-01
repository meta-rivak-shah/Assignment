package com.shoppingsite.service;
import com.shoppingsite.dao.SqlConnector;
import com.shoppingsite.model.Product;
import com.shoppingsite.model.ShoppingCart;
import com.shoppingsite.model.User;

import java.sql.*;
import java.util.ArrayList;
import java.util.Scanner;

/**
 * 
 * @author Rivak
 *the class service is used to execute all Business logic
 *business logic are like @sql query all validation fucntion
 * 
 */
public class Service {
	Scanner sc = new Scanner(System.in);
	ArrayList<User> user = new ArrayList<User>();
	ArrayList<Product> product = new ArrayList<Product>();

	/**
	 * the function is used to validate the user details
	 * @param id
	 * @param password
	 * @return
	 * @throws SQLException
	 */
	public boolean authenticatUser(int id, String password) throws SQLException {
		System.out.println(id + "<-userId");
		String query = "SELECT id , password  FROM user where id = " + id
				+ " AND password='" + password + "'";
		ResultSet rs = SqlConnector.executeQuery(query);
		while (rs.next()) {
			user.add(new User(rs.getInt("id"), rs.getString("password")));
		}
		if (user.size() > 0) {
			return true;
		} else {
			return false;
		}

	}

	/**
	 * this function is used to add the item in the cart
	 * @param id
	 * @param quntity 
	 * @param productId 
	 * @return
	 * @throws SQLException
	 */
	public boolean addProduct(int id, String productId, String quntity) throws SQLException {
		if (!(Integer.parseInt(quntity) <= 0)) {
			for (int i = 0; i < product.size(); i++) {
				if (product.get(i).getId() == Integer.parseInt(productId)) {
					String query = "INSERT INTO CART (user_Id , product_Id , quntity) VALUES ("
							+ id + " , " + Integer.parseInt(productId) + " , " + Integer.parseInt(quntity) + ")";
					// System.out.println(query);
					int result = SqlConnector.executeUpdateQuery(query);
					if (result == 1) {
						return true;
					}

				}
			}
		}
		return false;
	}

	/**
	 * this function is used to get complete product details of the user
	 * @return
	 * @throws SQLException
	 */
	public ArrayList<Product>  getProduct() throws SQLException {
		String query = "SELECT * FROM PRODUCT";
		ResultSet rs = SqlConnector.executeQuery(query);
		while (rs.next()) {
			product.add(new Product(rs.getInt("id"), rs.getString("type"), rs
					.getString("name"), rs.getFloat("price")));
		}
		return product;
	}

	/**
	* this function is used to show to complete cart
	*details of the user which is login
	@return list cart;
	**/
	public ArrayList<ShoppingCart> showCart(int id) throws SQLException {
		return this.getCartData();
	}

	/**
	*this is helper method which is used to get the complete data of user cart
	*it will return cart type list to user
	*@return cart list type
	**/
	private ArrayList<ShoppingCart> getCartData() throws SQLException {
		ArrayList<ShoppingCart> cart = new ArrayList<ShoppingCart>();
		String query = "SELECT * FROM cart";
		ResultSet rs = SqlConnector.executeQuery(query);
		while (rs.next()) {
			cart.add(new ShoppingCart(rs.getInt("id"), rs.getInt("product_id"),
					rs.getInt("quntity"), rs.getInt("user_id")));

		}
		return cart;
	}

	/**
	*the function editCart is used to edit total quantity from the cart
	*if user enter the number quantity 12 then it will edit it to 12  
	**/
	public boolean editCart(int id, int CId, int quantity) throws SQLException {
		// TODO Auto-generated method stub
		String query = "Update cart SET quntity = "+quantity+" where user_id ="+id+" And id ="+CId;
		System.out.println(query);
		 int result = SqlConnector.executeUpdateQuery(query);
		 if(result == 1) {
			 return true;
		 }
		return false;
	}

	/**
	* the function is used to delete row from cart  based on the id and quntity
	* if Quantity is zero then it will delete complete row from cart
	**/
	public boolean deleteRowFromCart(int id, int cId, int quantity) throws SQLException {
		// TODO Auto-generated method stub
		String query = "DELETE FROM cart where user_id ="+id+" AND  Id="+cId;
		 int result = SqlConnector.executeUpdateQuery(query);
		 if(result == 1) {
			 return true;
		 }
		return false;
	}
}

