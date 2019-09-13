package com.metacube.metaparking.model;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

public class EditProfile {
	@Size(min=3, max=16)
	@NotBlank(message = "{name}" )
	@Pattern(regexp = "^[A-za-z\\s]+" , message = "{NumberNotaccepted}")
	private String name;
	
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
	
	@NotBlank
	private String profile;
	
	
	public EditProfile() {
	}

	
	public String getProfile() {
		return profile;
	}


	public void setProfile(String profile) {
		this.profile = profile;
	}
	
	
	public EditProfile( String name, String email, String password,
			String confirmPassword, String gender, String organisation,
			String mobileNumber , String profile) {
		this.name = name;

		this.password = password;
		this.confirmPassword = confirmPassword;
		this.gender = gender;
		this.organisation = organisation;
		this.mobileNumber = mobileNumber;
		this.profile = profile;
	}


	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
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
