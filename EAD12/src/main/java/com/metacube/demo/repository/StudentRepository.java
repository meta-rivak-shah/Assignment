package com.metacube.demo.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.metacube.demo.entity.StudentEntity;

@Repository
public interface StudentRepository extends JpaRepository<StudentEntity, Integer>{



	/**
	 * Method to find student with first name
	 * @param studentFirstName is the student's first name
	 * @return {List<Student>}
	 */
	public List<StudentEntity> 	findByLastNameAndFirstName(String studentFirstName , String studentLastName);
	/**
	 * Method to find student with email id
	 * @param studentEmail is the student's email
	 * @return {List<Student>}
	 */
	public List<StudentEntity> findByEmailContainingIgnoreCase(String studentEmail);  
}
