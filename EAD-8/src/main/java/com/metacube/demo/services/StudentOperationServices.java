package com.metacube.demo.services;

import java.util.ArrayList;

import org.springframework.stereotype.Component;

import com.metacube.demo.dto.Student;

/**
 * interface is used to implement same method in diffrent child funtion
 * @author Rivak
 *
 */
@Component
public interface StudentOperationServices {

	ArrayList<Student> getAllStudentDetails();
}
