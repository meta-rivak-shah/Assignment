package com.shoppingsite.model;
/**
 * 
 * @author Rivak
 *
 */
public class User {
	
	private int userId;
	private String password;
	/**
	 * 
	 * @return user id
	 */
	public int getUserId() {
		return userId;
	}
	/**
	 * 
	 * @param userId
	 */
	public void setUserId(int userId) {
		this.userId = userId;
	}
	/**
	 * 
	 * @return password
	 */
	public String getPassword() {
		return password;
	}
	/**
	 * 
	 * @param password
	 */
	public void setPassword(String password) {
		this.password = password;
	}
	/**
	 * 
	 * @param userId
	 * @param password
	 */
	public User(int userId, String password) {
		super();
		this.userId = userId;
		this.password = password;
	}
	
}
