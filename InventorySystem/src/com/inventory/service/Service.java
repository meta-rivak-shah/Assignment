package com.inventory.service;

import java.sql.*;
import java.util.ArrayList;


import java.util.List;

import com.inventory.dao.Dao;
import com.inventory.model.Inventory;

/**
 * the class is used to write the business logics 
 * @author Rivak
 *
 */
public class Service {
	Dao daoObj = new Dao();
	//GET REQUEST FOR COMPLETE INVENTORY
	public List<Inventory> getDataOfInvenotry() throws SQLException {
		List<Inventory> allInvenotryData = new ArrayList<Inventory>();
		
		ResultSet rs =  daoObj.getDataOfInvenotry();
		while(rs.next()) {
			allInvenotryData.add(new Inventory(rs.getInt("id") , rs.getString("name") , rs.getInt("quantity")));
		}
		return allInvenotryData;
	}
	
	// GET REUQUEST FOR PERTICULAR item BYREQUEST PARAMETER
	public List<Inventory> getItemImformation(String item) throws SQLException{
		List<Inventory> ItemImfromation = new ArrayList<Inventory>();
		ResultSet rs =  daoObj.getItemImformation(item);
		while(rs.next()) {
			ItemImfromation.add(new Inventory(rs.getInt("id") , rs.getString("name") , rs.getInt("quantity")));
		}
		return ItemImfromation;
	}

	// GET REQUEST TO DELETE ITEM IN INVENTORY
	public int deleteItemImformation(String parameter1) throws SQLException {
		int rs =  daoObj.deleteItemImformation(parameter1);
		return rs;
	}

	//PUT REQUEST TO UPDATE ITEM IN CART
	public int updateItemImformation(String parameter1 , int quantity) throws SQLException {
		int rs =  daoObj.updateItemImformation(parameter1 , quantity);
		return rs;
	}

	//POST REQUEST TO INSERT ITEM IN CART
	public int insertItemImformation(String parameter1, int quantity) throws SQLException {
		int rs =  daoObj.insertItemImformation(parameter1 , quantity);
		return rs;
	}

}
