package com.metacube.demo.model;



public class StudentModel {

	int id;
	String firstName;
	String lastName;
	String fatherName;
	String email;
	String studentClass;
	String studentAge;
	
	public StudentModel() {
	}
	
	//Getter Setter methods
	public String getStudentAge() {
		return studentAge;
	}
	
	public void setStudentAge(String studentAge) {
		this.studentAge = studentAge;
	}
	
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getFatherName() {
		return fatherName;
	}

	public void setFatherName(String fatherName) {
		this.fatherName = fatherName;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getStudentClass() {
		return studentClass;
	}

	public void setStudentClass(String studentClass) {
		this.studentClass = studentClass;
	}
}