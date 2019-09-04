package com.metaparking.model;

/**
 * pojos is used to get complete details of user
 * @author Rivak
 *
 */
public class User {
	private int id;
	private String name;
	private String password;
	private String contat;
	
	
	public User(int id, String name, String password, String contat) {
		super();
		this.id = id;
		this.name = name;
		this.password = password;
		this.contat = contat;
	}
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getContat() {
		return contat;
	}
	public void setContat(String contat) {
		this.contat = contat;
	}
}
