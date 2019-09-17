package com.metacube.metaparking.model;


public class VechileRegister {

	private Long id;
	private String name;
	private String type;
	private String number;
	private String identify;
	private String empId;
	
	public VechileRegister(){
	}
	
	public VechileRegister( Long id , String name, String type, String number, String identify,
			String empId) {
		super();
		this.setId(id);
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

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}
	
}
