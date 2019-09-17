package com.metacube.metaparking.dto;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

public class Vechile {

	@NotBlank(message="{vechileName}")
	private String name;
	@NotBlank
	private String type;
	@NotBlank(message="{vechileNumber}")
	@Pattern(regexp = "^[A-Za-z]{2}[0-9]{6}$" , message = "{vechileNumberFormate}")
	private String number;
	@NotBlank(message="{identify}")
	@Size(min=10 , max=100)
	private String identify;
	@NotBlank
	private String empId;
	
	public Vechile(){
	}
	
	public Vechile(String name, String type, String number, String identify,
			String empId) {
		super();
		this.name = name;
		this.type = type;
		this.number = number;
		this.identify = identify;
		this.empId = empId;
	}
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
	public String getNumber() {
		return number;
	}
	public void setNumber(String number) {
		this.number = number;
	}
	public String getIdentify() {
		return identify;
	}
	public void setIdentify(String identify) {
		this.identify = identify;
	}
	public String getEmpId() {
		return empId;
	}
	public void setEmpId(String empId) {
		this.empId = empId;
	}
	
}
