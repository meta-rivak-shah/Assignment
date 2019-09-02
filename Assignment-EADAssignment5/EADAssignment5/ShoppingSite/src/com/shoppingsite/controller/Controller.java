package com.shoppingsite.controller;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.shoppingsite.model.Product;
import com.shoppingsite.model.ShoppingCart;
import com.shoppingsite.model.User;
import com.shoppingsite.service.Service;

/**
 * 
 * @author Rivak
 *
 */
public class Controller {
	Service serviceObj = new Service();
	/**
	 * 
	 * @param id
	 * @param password
	 * @return
	 * @throws SQLException 
	 */
	public boolean authenticatUser(int id, String password) throws SQLException {
		boolean result = serviceObj.authenticatUser(id , password);
		return result;
	}
	/**
	 * 
	 * @param id
	 * @param quntity 
	 * @param productId 
	 * @throws SQLException 
	 */
	public boolean addProduct(int id, String productId, String quntity) throws SQLException {
		boolean result = serviceObj.addProduct(id , productId , quntity);
		return result;
		
	}

	/**
	 * 
	 * @param id
	 *@return arrayList
	 * @throws SQLException 
	 */
	public List<ShoppingCart> showCart(int id) throws SQLException {
		ArrayList<ShoppingCart> result = serviceObj.showCart(id);
		return result;
	}

	/**
	 * @return result arraylist
	 * @throws SQLException 
	 */
	public ArrayList<Product> getProduct() throws SQLException {
		ArrayList<Product> result = serviceObj.getProduct();
		return result;
	}
	/**
	 * 
	 * @param id
	 * @param quntity 
	 * @param cId 
	 * @throws SQLException 
	 */
	public boolean editCart(int id, int cId, int quantity) throws SQLException {
		boolean result =  serviceObj.editCart( id,  cId,  quantity);
		return result;
	}
	/**
	 * 
	 * @param id
	 * @param cId 
	 * @param quantity 
	 * @throws SQLException 
	 */
	public boolean deleteRowFromCart(int id, int cId, int quantity) throws SQLException {
		boolean result =  serviceObj.deleteRowFromCart( id,  cId,  quantity);
		return result;
		
	}

}
