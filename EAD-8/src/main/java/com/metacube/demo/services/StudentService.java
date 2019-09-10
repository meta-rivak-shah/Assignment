package com.metacube.demo.services;

import java.util.ArrayList;

import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Component;

import com.metacube.demo.dto.Student;

@Primary
@Component
public class StudentService implements StudentOperationServices{
	ArrayList<Student> studentDetails = new ArrayList<Student>();
	@Override
	public ArrayList<Student> getAllStudentDetails() {
		if(studentDetails.size() > 0) {
			return studentDetails;
		} else {
			studentDetails.add(new Student("Rivak", "Shah", "Ravi shah", "12", "shah@gmail.com"));
			studentDetails.add(new Student("Ram", "Shah", "Ravishankar shah", "11", "shah12@gmail.com"));
			studentDetails.add(new Student("Remu", "Shah", "Ravimahan shah", "10", "shah1@gmail.com"));
		}
		return studentDetails;
		
	}

}
