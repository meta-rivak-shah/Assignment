package com.shoppingsite.model;
/**
 * the class is poojos which is used to insert complete data of product inside
 *it and then used it get other details
 * @author Rivak
 *
 */
public class Product {
	private int id;
	private String type;
	private String name;
	private double price;
	/**
	 * 
	 * @param id
	 * @param type
	 * @param name
	 * @param price
	 */
	public Product(int id, String type, String name, double price) {
		super();
		this.id = id;
		this.type = type;
		this.name = name;
		this.price = price;
	}
	/**
	 * 
	 * @return product id
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
	 * @return type of product
	 */
	public String getType() {
		return type;
	}
	/**
	 * 
	 * @param type
	 */
	public void setType(String type) {
		this.type = type;
	}
	/**
	 * 
	 * @return name of product
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
	 * @return price of product
	 */
	public double getPrice() {
		return price;
	}
	/**
	 * 
	 * @param price
	 */
	public void setPrice(double price) {
		this.price = price;
	}
	
}
