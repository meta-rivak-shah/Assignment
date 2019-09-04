package com.metaparking.model;
/**
 * class is work as poojos for contain data of price table
 * @author Rivak
 *
 */
public class Price {

	private int id;
	private String type;
	private int daily;
	private int monthly;
	private int yearly;
	
	/**
	 * 
	 * @param id
	 * @param type
	 * @param daily
	 * @param monthly
	 * @param yearly
	 */
	public Price(int id, String type, int daily, int monthly, int yearly) {
		super();
		this.id = id;
		this.type = type;
		this.daily = daily;
		this.monthly = monthly;
		this.yearly = yearly;
	}
	
	/**
	 * 
	 * @return int type data
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
	 * @return
	 */
	public int getDaily() {
		return daily;
	}
	/**
	 * 
	 * @param daily
	 */
	public void setDaily(int daily) {
		this.daily = daily;
	}
	/**
	 * 
	 * @return
	 */
	public int getMonthly() {
		return monthly;
	}
	/**
	 * 
	 * @param monthly
	 */
	public void setMonthly(int monthly) {
		this.monthly = monthly;
	}
	/**
	 * 
	 * @return
	 */
	public int getYearly() {
		return yearly;
	}
	/**
	 * 
	 * @param yearly
	 */
	public void setYearly(int yearly) {
		this.yearly = yearly;
	}
	
}
