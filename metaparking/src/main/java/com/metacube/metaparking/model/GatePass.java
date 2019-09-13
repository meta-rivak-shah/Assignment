package com.metacube.metaparking.model;

import javax.validation.constraints.NotBlank;

public class GatePass {

	@NotBlank(message="{priceEmpthy}")
	private String price;
	
	public GatePass(String price) {
		super();
		this.price = price;
	}
	
	public GatePass() {
	}

	public String getPrice() {
		return price;
	}

	public void setPrice(String price) {
		this.price = price;
	}
	
	
}
