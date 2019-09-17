package com.metacube.metaparking.dto;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

public class EmployeeRegister {
	
	private Long id;
	

	@Size(min=3, max=30)
	@NotBlank(message = "{name}" )
	@Pattern(regexp = "^[A-za-z\\s]+" , message = "{NumberNotaccepted}")
	private String name;
	
	@NotBlank(message = "{blackemail}" )
	@Pattern(regexp = "^[A-Za-z0-9.]+@[A-Za-z0-9]+\\.[A-Za-z0-9]{2,4}$" , message = "{EmailNotaccepted}")
	private String email;
	
	@Pattern(regexp = "^[A-za-z\\s0-9]+" , message = "{passwordPattern}")
	@NotBlank(message = "{password}")
	@Size(min=8 , max =30)
	private String password;
	
	@NotBlank(message = "{password}")
	private String confirmPassword;
	
	@NotBlank(message = "{gender}")
	private String gender;
	
	@NotBlank(message = "{organsations}")
	private String organisation;
	
	@NotBlank(message = "{Mobile}")
	@Size(min=10 , max=10 , message="{contact}")
	@Pattern(regexp = "^[0-9]+" , message = "{validContact}")
	private String mobileNumber;	
	public EmployeeRegister() {
	}

	
	public EmployeeRegister( String name, String email, String password,
			String confirmPassword, String gender, String organisation,
			String mobileNumber) {
		this.name = name;
		this.email = email;
		this.password = password;
		this.confirmPassword = confirmPassword;
		this.gender = gender;
		this.organisation = organisation;
		this.mobileNumber = mobileNumber;
	}

	public Long getId() {
		return id;
	}


	public void setId(Long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getEmail() {
		return email;
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

	public String getConfirmPassword() {
		return confirmPassword;
	}

	public void setConfirmPassword(String confirmPassword) {
		this.confirmPassword = confirmPassword;
	}

	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}

	public String getOrganisation() {
		return organisation;
	}

	public void setOrganisation(String organisation) {
		this.organisation = organisation;
	}

	public String getMobileNumber() {
		return mobileNumber;
	}

	public void setMobileNumber(String mobileNumber) {
		this.mobileNumber = mobileNumber;
	}
	
}
