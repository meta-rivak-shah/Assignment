package com.metacube.metaparking.dto;

import javax.validation.constraints.NotBlank;

public class EmployeeLogin {
	@NotBlank(message = "{blackemail}" )
	private String email;
	
	@NotBlank(message = "{password}")
	private String password;
	
	public EmployeeLogin() {
	}

	public String getEmail() {
		return this.email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	
}
