package com.shoppingsite.model;
/**
 * the class is pojos which is used get data of user cart
 * @author Rivak
 *
 */
public class ShoppingCart {
	private int id;
	private int userId;
	private int productId;
	private int quntity;
	
	public int getUserId() {
		return userId;
	}
	/**
	* @return user id
	**/
	public void setUserId(int userId) {
		this.userId = userId;
	}
	
	public ShoppingCart(int id, int productId, int quntity, int userId) {
		super();
		this.id = id;
		this.productId = productId;
		this.quntity = quntity;
		this.userId = userId;
	}
	/**
	 * 
	 * @return id of cart
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
	 * @return product id
	 */
	public int getProductId() {
		return productId;
	}
	/**
	 * 
	 * @param productId
	 */
	public void setProductId(int productId) {
		this.productId = productId;
	}
	/**
	 * 
	 * @return quantity
	 */
	public int getQuntity() {
		return quntity;
	}
	/**
	 * 
	 * @param quntity
	 */
	public void setQuntity(int quntity) {
		this.quntity = quntity;
	}
}
