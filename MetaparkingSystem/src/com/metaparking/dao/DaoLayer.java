package com.metaparking.dao;

import java.sql.*;

/**
 * class is dao layer which contain only query and get data from tables
 * @author Rivak
 *
 */
public class DaoLayer {

	/**
	 * function is used to insert the data of user into database
	 * @param name
	 * @param email
	 * @param organisation
	 * @param password
	 * @param gender
	 * @param contact
	 * @return
	 * @throws SQLException
	 */
	public int registerUser(String name, String email, String organisation, String password, String gender, String contact) throws SQLException {
		final String query = "INSERT INTO User(full_name , Email_Id , Organisation, Password , Gender ,Contact_number)VALUES('" + name + "','" + email +
				"','" + organisation + "','" + password + "','" + gender + "','" + contact + "');";
		System.out.println(query);
		int result =SqlConnector.executeUpdateQuery(query);
		return result;
	}

	/**
	 * functio is used to Authenticate the data of user
	 * @param password
	 * @param email
	 * @return
	 * @throws SQLException
	 */
	public ResultSet authenticateUser(String password, String email) throws SQLException {
		final String query = "SELECT * FROM User WHERE Password = '"+password+"'And Email_Id = '"+email+"'";
		ResultSet rs =SqlConnector.executeQuery(query);
		return rs;
	}

	/**
	 * function is used to register the vechile of user
	 * @param veichleName
	 * @param vehicleNum
	 * @param vType
	 * @param employeeid
	 * @param identity
	 * @return
	 * @throws SQLException
	 */
	public int validateVeichleData(String veichleName, String vehicleNum,
			String vType, String employeeid, String identity) throws SQLException {
		final String query = "INSERT INTO Vehicle (Name , Type , Vehicle_Number, Employee_Id, identification) VALUES ('" + veichleName + "','" + vType +
				"','" + vehicleNum + "','" + Integer.parseInt(employeeid) + "','" + identity + "');";
		System.out.println(query);
		int result =SqlConnector.executeUpdateQuery(query);
		System.out.println(result+"dddddddddd");
		return result;
				
	}

	/**
	 * function is used to get the imformation of user
	 * @param empId
	 * @return
	 * @throws SQLException
	 */
	public ResultSet getVeichleDetails(String empId) throws SQLException {
		final String query = "SELECT * FROM Vehicle WHERE Employee_Id = '"+Integer.parseInt(empId)+"'";
		ResultSet rs =SqlConnector.executeQuery(query);
		return rs;
	}

	/**
	 * function is used to get price of all vechile from data base
	 * @param vechileType
	 * @return
	 * @throws SQLException
	 */
	public ResultSet getPriceOfVechile(String vechileType) throws SQLException {
		final String query = "SELECT * FROM Price WHERE Type = '"+vechileType+"'";
		ResultSet rs =SqlConnector.executeQuery(query);
		return  rs;

	}

	/**
	 * function is used to enter gate pass taken by user into the table
	 * @param price
	 * @param vid
	 * @param uid
	 * @return
	 * @throws SQLException
	 */
	public int createAGatePAss(int price, int vid, int uid) throws SQLException {
		final String query = "INSERT INTO user_vehicle (price , vehicle_id , user_id) VALUES ('" + price + "','" + vid +
				"','" + uid + "');";
		System.out.println(query);
		int result =SqlConnector.executeUpdateQuery(query);
		return result;
	}

	/**
	 * funciton is used to get the data of user form table
	 * @param userID
	 * @return
	 * @throws SQLException
	 */
	public ResultSet  gateUserData(String userID) throws SQLException {
		final String query = "SELECT * FROM User WHERE id = '"+Integer.parseInt(userID)+"'";
		System.out.println(query);
		ResultSet rs =SqlConnector.executeQuery(query);
		return  rs;
	}

	/**
	 * function is used to Update thr data of user
	 * @param name
	 * @param password
	 * @param contact
	 * @param userID
	 * @return
	 * @throws SQLException
	 */
	public int UpdateUserData(String name, String password, String contact , String userID) throws SQLException {
		String query = "UPDATE User set  full_name = '"+name+"' , Password = '"+password+"' , Contact_number = '"+contact+"' WHERE id = '"+Integer.parseInt(userID)+"'";
		System.out.println(query);
		int result =SqlConnector.executeUpdateQuery(query);
		System.out.println(result+"dddddddddd");
		return result;
	}
	
	/**
	 * function is used to get the data of user frinds
	 * @param user
	 * @return
	 * @throws SQLException
	 */
	 public ResultSet getFriendOfUser(String user) throws SQLException {
		 String query2 = "Select id, full_name ,Organisation ,Email_id,Contact_number from User where Organisation IN (Select Organisation from User where ID ="
		 + Integer.parseInt(user) + ")";
		 ResultSet rs = SqlConnector.executeQuery(query2);
		 return rs;
		 }
	
	

}
