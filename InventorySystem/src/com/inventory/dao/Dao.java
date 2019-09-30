package com.inventory.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
/**
 * the dao class is used to write the query of database
 * @author Rivak
 *
 */
public class Dao {
	
	private static final  String GET_INVENTORY_LIST_QUERY = "SELECT * FROM Inventory";  
	
	/**
	 * used to get complete details of imvenotry for //GET REQUEST
	 * @return
	 * @throws SQLException
	 */
	public ResultSet getDataOfInvenotry() throws SQLException {
		
		return SqlConnector.executeQuery(GET_INVENTORY_LIST_QUERY);	
	}

	/**
	 * function is used to the imformation of perticlaur item using //GET REQUEST
	 * @param item
	 * @return
	 * @throws SQLException
	 */
	public ResultSet getItemImformation(String item) throws SQLException {
		final  String GET_IMFORMATION_OF_ITEM = "SELECT * FROM Inventory WHERE name ='"+item+"'";
		System.out.println(GET_IMFORMATION_OF_ITEM);
		return SqlConnector.executeQuery(GET_IMFORMATION_OF_ITEM);
	}

	/**
	 * function is used to delete the specific data from inventory //GET REQUEST
	 * @param item
	 * @return
	 * @throws SQLException
	 */
	public int deleteItemImformation(String item) throws SQLException {
		final  String DELETE_ITEM_FROM_INVENTORY = "DELETE FROM  Inventory WHERE name ='"+item+"'";
		return SqlConnector.executeUpdateQuery(DELETE_ITEM_FROM_INVENTORY);
	}

	/**
	 * function is used to UPDATE THE DATA FROM INVENTORY USing //PUT REQUEST
	 * @param item
	 * @param quantity
	 * @return
	 * @throws SQLException
	 */
	public int updateItemImformation(String item , int quantity) throws SQLException {
		final  String UPDATE_ITEM_FROM_INVENTORY = "UPDATE  Inventory set name = '"+item+"' , quantity = '"+quantity+"'  WHERE name ='"+item+"'";
		return SqlConnector.executeUpdateQuery(UPDATE_ITEM_FROM_INVENTORY);
	}

	/**
	 * function is used to insert the data using //POST REUEST
	 * @param item
	 * @param quantity
	 * @return
	 * @throws SQLException
	 */
	public int insertItemImformation(String item, int quantity) throws SQLException {
		final  String INSERT_ITEM_INTO_INVENTORY = "INSERT INTO Inventory(name , quantity) values('"+item+"' , "+quantity+");";
		return SqlConnector.executeUpdateQuery(INSERT_ITEM_INTO_INVENTORY);
	}
}
