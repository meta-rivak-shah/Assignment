package com.inventory.model;


/**
 * the class is work as pojos for getting data and update data and all
 * @author Rivak
 *
 */
public class Inventory {

	
	private int id;
	private String name;
	private int quantity;
	
	
	
	public Inventory() {
//		super();
	}

	/**
	 * 
	 * @param id
	 * @param name
	 * @param quantity
	 */
	public Inventory(int id, String name, int quantity) {
		this.id = id;
		this.name = name;
		this.quantity = quantity;
	}
	
	/**
	 * 
	 * @param name
	 * @param quantity
	 */
	public Inventory( String name, int quantity) {
		this.name = name;
		this.quantity = quantity;
	}
	
	/**
	 * 
	 * @return
	 */
	public int getId() {
		return id;
	}
	
	/**
	 * 
	 * @param id
	 */
	public void setId(int id) {
		this.id = id;
	} 
	
	/**
	 * 
	 * @return
	 */
	public String getName() {
		return name;
	} 
	
	/**
	 * 
	 * @param name
	 */
	public void setName(String name) {
		this.name = name;
	} 
	
	/**
	 * 
	 * @return
	 */
 	public int getQuantity() {
		return quantity;
	} 
 	
 	/**
 	 * 
 	 * @param quantity
 	 */
 	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}
}
