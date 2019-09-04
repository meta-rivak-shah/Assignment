package com.metaparking.model;

/**
 * pojos is used to get the Vechile details of user
 * @author Rivak
 *
 */
public class VehicleDetails {
	private int id;
	
	public VehicleDetails(int id, String vnumber, String type) {
		super();
		this.id = id;
		this.vnumber = vnumber;
		this.type = type;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getVnumber() {
		return vnumber;
	}
	public void setVnumber(String vnumber) {
		this.vnumber = vnumber;
	}
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
	private String vnumber;
	private String type;
}
