package Mysql.JDBC;

import java.sql.Date;

public class AllOrderOfUser {

	private String status;
	private String name;
	private int totalAmount;
	private Date dateCreated;
	private int orderId;
	
	public String getStatus() {
		return status;
	}
	
	public String getName() {
		return name;
	}
	public AllOrderOfUser(String status, String name, int totalAmount,
			Date dateCreated, int orderId) {
		super();
		this.status = status;
		this.name = name;
		this.totalAmount = totalAmount;
		this.dateCreated = dateCreated;
		this.orderId = orderId;
	}

	public int getTotalAmount() {
		return totalAmount;
	}
	
	public Date getDateCreated() {
		return dateCreated;
	}
	
	public int getOrderId() {
		return orderId;
	}
	
}
