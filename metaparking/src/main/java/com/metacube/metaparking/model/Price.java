package com.metacube.metaparking.model;

public class Price {

	private int id;
	private String type;
	private int daily;
	private int monthly;
	private int yearly;
	
	public Price(int ld, String type, int daily, int monthly, int yearly) {
		super();
		this.id = ld;
		this.type = type;
		this.daily = daily;
		this.monthly = monthly;
		this.yearly = yearly;
	}
	
	public int getId() {
		return id;
	}
	
	public void setId(int id) {
		this.id = id;
	}
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
	public int getDaily() {
		return daily;
	}
	public void setDaily(int daily) {
		this.daily = daily;
	}
	public int getMonthly() {
		return monthly;
	}
	

	public void setMonthly(int monthly) {
		this.monthly = monthly;
	}
	public int getYearly() {
		return yearly;
	}
	public void setYearly(int yearly) {
		this.yearly = yearly;
	}
	
}
