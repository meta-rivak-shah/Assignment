package com.metaparking.service;

import java.sql.*;
import java.util.ArrayList;

import javax.servlet.http.HttpSession;
import javax.servlet.http.HttpServletRequest;

import com.metaparking.dao.DaoLayer;
import com.metaparking.model.Price;
import com.metaparking.model.User;
import com.metaparking.model.UserFriendList;
import com.metaparking.model.VehicleDetails;
/**
 * the class service layer which is used to write business logic
 * @author Rivaks
 *
 */
public class ServiceLayer {
	DaoLayer DaoLayerObj = new DaoLayer();
	
	/**
	 * funtion is used to validate the data of user and register user after validate 
	 * 
	 * @param name
	 * @param email
	 * @param organisation
	 * @param password
	 * @param passwordC
	 * @param gender
	 * @param contact
	 * @return
	 * @throws SQLException
	 */
	public ArrayList<String> validateUserData(String name, String email,
			String organisation, String password, String passwordC,
			String gender, String contact) throws SQLException {
		ArrayList<String> errorList = new ArrayList<String>();
		if (name.length() <= 3) {
			errorList.add("size must be greter then 3");

		} else if (!(name.matches("^[A-Za-z\\s]+$"))) {
			errorList.add("digit is not allowed");
		}

		if (!(email.matches("^[A-Za-z0-9.]+@[A-Za-z0-9]+\\.[A-Za-z0-9]{2,4}$"))) {
			errorList.add("invalid emial formate");
		}

		if ("null".equals(organisation)) {
			errorList.add("please select the Organisation");
		}

		if (password.length() < 8) {
			errorList.add("password length greter then 8");
		} else if (!password.equals(passwordC)) {
			errorList.add("password not match");
		} else if(!(password.matches(".*[0-9].*") && password.matches(".*[A-Z].*") && password.matches(".*[a-z].*"))) {
			errorList.add("password have 1 uppercase 1 lowwecase and number");
		}
		if (contact.length() != 10) {
			errorList.add("contact length must be 10");
		}  else if(!(contact.matches("^[0-9]+$"))) {
			errorList.add("contact length must be Number");
		}
		
		if(gender == null) {
			errorList.add("select gender");
		}

		if (errorList.size() <= 0) {
			int result = DaoLayerObj.registerUser(name, email, organisation,
					password, gender, contact);
			if (result == 1) {
				return null;
			} 
		}
		return errorList;
	}

	/**
	 * function is used to authenticate the user
	 * @param password
	 * @param email
	 * @return
	 * @throws SQLException
	 */
	public ResultSet authenticateUser(String password, String email) throws SQLException {
		ResultSet rs =  DaoLayerObj.authenticateUser(password , email);
		return rs;
	
	}

	/**
	 * function is used to validate the data of vechile when user is going to register
	 * @param veichleName
	 * @param vehicleNum
	 * @param vType
	 * @param employeeid
	 * @param identity
	 * @param request
	 * @return
	 * @throws SQLException
	 */
	public ArrayList<String> validateVeichleData(String veichleName, String vehicleNum, String vType,  String employeeid, String identity ,HttpServletRequest request) throws SQLException {
		ArrayList<String> errorList = new ArrayList<String>();
		HttpSession session = request.getSession(false);
		System.out.println(employeeid+"ssss"+session.getAttribute("user"));
		if(veichleName.length() <= 2) {
			errorList.add("veichle Name Should be greter then 2");
		}
		
		if(!(vehicleNum.matches("^[A-Za-z]{2}[0-9]{6}$"))) {
			errorList.add("veichle Nyumber Alphbate and number");
		}
		
		if(!(employeeid.equals(String.valueOf(session.getAttribute("user"))))) {
			errorList.add("Employee Id  Is Wrong");
		}
		
		if(vType.equals("none")) {
			errorList.add("Select Viechle Type");
		}
		
		if(identity.length()<10) {
			errorList.add("identity length must be greater then 10 words");
		}
		if (errorList.size() <= 0) {
			int result = DaoLayerObj.validateVeichleData(veichleName ,vehicleNum ,vType ,employeeid  , identity);
			if (result == 1) {
				return null;
			} 
		}
		return errorList;
	}

	/**
	 * function is used to get the  vechile details from table
	 * @param empId
	 * @return
	 * @throws SQLException
	 */
	public ArrayList<VehicleDetails> getVeichleDetails(String empId) throws SQLException {
		ResultSet rs = DaoLayerObj. getVeichleDetails(empId);
		ArrayList<VehicleDetails> employeeVehicleDetails = new ArrayList<VehicleDetails>();
		while(rs.next()){
			employeeVehicleDetails.add(new VehicleDetails(rs.getInt("id"), rs.getString("Vehicle_Number"), rs.getString("Type")));
		}
		return employeeVehicleDetails;
		
	}

	/**
	 * function is used to validate the vechile details when data come from the get method
	 * @param vehcileId
	 * @param vechileType
	 * @return
	 */
	public boolean validateVehicleData(String vehcileId, String vechileType) {
		boolean id = true;
		boolean type = true;
		if(!(vehcileId.matches("^[0-9]+$"))) {
			id= false;
		}
		
		if(!(vechileType.matches("^[A-Za-z\\s]+$"))) {
			 type = false;
		}
		
		if(id&&type) {
			return true;
		} else {
			return false;
		}
	}

	/**
	 * function is used to get complete price of vechile type
	 * @param vechileType
	 * @return
	 * @throws SQLException
	 */
	public ArrayList<Price> getPriceOfVechile( String vechileType) throws SQLException {
		ArrayList<Price> priceOfVechile = new ArrayList<Price>();
		ResultSet rs = DaoLayerObj.getPriceOfVechile(vechileType);
		while(rs.next()){
			priceOfVechile.add(new Price(rs.getInt("id") ,rs.getString("Type") ,rs.getInt("DAILY") ,rs.getInt("Monthly"),rs.getInt("Yearly")));
		}
		return priceOfVechile;
		
	}

	/**
	 * function is used to register the gate pass in table
	 * @param price
	 * @param vid
	 * @param uid
	 * @return
	 * @throws SQLException
	 */
	public int createAGatePAss(int price, int vid, int uid) throws SQLException {
		return DaoLayerObj.createAGatePAss(price, vid, uid);
	}

	/**
	 * function is used to get complete imformation about user
	 * @param userID
	 * @return
	 * @throws SQLException
	 */
	public ArrayList<User> getUserData(String userID) throws SQLException {
		ArrayList<User> alluserData = new ArrayList<User>();
		ResultSet rs = DaoLayerObj.gateUserData(userID);
		while(rs.next()){
			alluserData.add(new User(rs.getInt("id"), rs.getString("full_name"), rs.getString("Password"), rs.getString("Contact_number")));
		}
		return alluserData;
	}

	/**
	 * function is used to update the data of user
	 * @param name
	 * @param password
	 * @param contact
	 * @param userID
	 * @return
	 * @throws SQLException
	 */
	public int UpdateUserData(String name, String password, String contact , String userID) throws SQLException {
		return DaoLayerObj.UpdateUserData(name, password, contact ,userID);
		
		
	}
	
	/**
	 * function is used to get the data of user friends list
	 * @param user
	 * @return
	 * @throws SQLException
	 */
	public ArrayList<UserFriendList> getFriendOfUser(String user) throws SQLException {
		ArrayList<UserFriendList> user_friend = new ArrayList<UserFriendList>();
		ResultSet rs =  DaoLayerObj.getFriendOfUser(user);
		while(rs.next()){
		user_friend.add(new UserFriendList(rs.getInt("id"),rs.getString("full_name"),rs.getString("Organisation"),rs.getString("Contact_number"),rs.getString("Email_Id")));
		}
		return user_friend;
		}
	
	
}
