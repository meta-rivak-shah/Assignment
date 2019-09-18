package com.metacube.demo.dto;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

/**
 * student pojos class which contain the filled of student in this class we have
 * diffrent filled like first name last name father name and all in this we are
 * doing validation by using
 * 
 * @author Rivak
 *
 */
public class StudentDto {
	int id;
	@Size(min = 3, max = 30)
	@NotBlank(message = "{name}")
	@NotNull
	@Pattern(regexp = "^[A-za-z\\s]+", message = "{NumberNotaccepted}")
	String firstName;
	
	@Size(min = 3, max = 30)
	@NotBlank(message = "{name}")
	@NotNull
	@Pattern(regexp = "^[A-za-z\\s]+", message = "{NumberNotaccepted}")
	String lastName;
	
	@Size(min = 3, max = 30)
	@NotBlank(message = "{name}")
	@NotNull
	@Pattern(regexp = "^[A-za-z\\s]+", message = "{NumberNotaccepted}")
	String fatherName;
	
	@NotNull
	@NotBlank(message = "{blackemail}")
	@Pattern(regexp = "^[A-Za-z0-9.]+@[A-Za-z0-9]+\\.[A-Za-z0-9]{2,4}$", message = "{EmailNotaccepted}")
	String email;
	
	@NotNull
	@NotBlank(message = "{class}")
	@Size(min = 1, max = 12)
	@Pattern(regexp = "^[0-9]+", message = "{validclass}")
	String studentClass;
	
	@NotNull
	@NotBlank(message = "{age}")
	@Size(min = 1, max = 20)
	@Pattern(regexp = "^[0-9]+", message = "{validage}")
	String studentAge;

	public StudentDto() {

	}

	/**
	 * Constructor to start all the filled
	 * 
	 * @param firstName
	 * @param lastName
	 * @param fatherName
	 * @param sClass
	 * @param email
	 * @param studentAge
	 */
	public StudentDto(int id, String firstName, String lastName,
			String fatherName, String studentClass, String email,
			String studentAge) {
		this.id = id;
		this.firstName = firstName;
		this.lastName = lastName;
		this.fatherName = fatherName;
		this.studentClass = studentClass;
		this.email = email;
		this.studentAge = studentAge;

	}

	/**
	 * 
	 * @return
	 */
	public String getFirstName() {
		return firstName;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getStudentClass() {
		return studentClass;
	}

	public void setStudentClass(String studentClass) {
		this.studentClass = studentClass;
	}

	public String getStudentAge() {
		return studentAge;
	}

	public void setStudentAge(String studentAge) {
		this.studentAge = studentAge;
	}

	/**
	 * 
	 * @param firstName
	 */
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	/**
	 * 
	 * @return
	 */
	public String getLastName() {
		return lastName;
	}

	/**
	 * 
	 * @param lastName
	 */
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	/**
	 * 
	 * @return
	 */
	public String getFatherName() {
		return fatherName;
	}

	/**
	 * 
	 * @param fatherName
	 */
	public void setFatherName(String fatherName) {
		this.fatherName = fatherName;
	}

	public String getEmail() {
		return email;
	}

	/**
	 * 
	 * @param email
	 */
	public void setEmail(String email) {
		this.email = email;
	}

}
