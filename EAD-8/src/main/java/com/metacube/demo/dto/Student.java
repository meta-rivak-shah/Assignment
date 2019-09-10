package com.metacube.demo.dto;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;
/**
 * student pojos class which contain the filled of student
 * in this class we have diffrent filled like first name last name father name and all
 * in this we are doing validation by using     
 * @author Rivak
 *
 */
public class Student {

	@NotBlank(message = "You must provide a first name.")
	@Size(min = 2, max = 15 , message="name must be between {min} and {max}")
	private String firstName;
	@NotBlank(message = "You must provide a Last name.")
	private String lastName;
	@NotBlank(message = "You must provide a Father name")
	private String fatherName;
	@NotBlank(message = "You must provide a class")
	private String sClass;
	@NotBlank(message = "You must provide a email") 
	@Email
	private String email;
	
	public Student() {
		
	}
	
	

	/**
	 * Constructor to start all the filled 
	 * @param firstName
	 * @param lastName
	 * @param fatherName
	 * @param sClass
	 * @param email
	 */
	public Student(String firstName, String lastName, String fatherName,  String sClass, String email) {
		this.firstName = firstName;
		this.lastName = lastName;
		this.fatherName = fatherName;
		this.sClass = sClass;
		this.email = email;
	}

	/**
	 * 
	 * @return
	 */
	public String getFirstName() {
		return firstName;
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
	
	/**
	 * 
	 * @return
	 */
	public String getsClass() {
		return sClass;
	}
	
	/**
	 * 
	 * @param sClass
	 */
	public void setsClass(String sClass) {
		this.sClass = sClass;
	}
	
	/**
	 * 
	 * @return
	 */
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
	
	@Override
	public String toString(){ 
		return "Student[ firstName = " +firstName+ ", lastName = "+lastName+" , fatherName = "+fatherName+" ,sClass = "+sClass+" , email = "+email+"]";
	}
}
