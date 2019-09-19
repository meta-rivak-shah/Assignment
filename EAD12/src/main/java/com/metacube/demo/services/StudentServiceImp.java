package com.metacube.demo.services;



import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.metacube.demo.entity.StudentEntity;
import com.metacube.demo.repository.StudentRepository;

@Service
public class StudentServiceImp implements StudentService{
	
	@Autowired
	StudentRepository studentRepo;
	
	public void getRepository(StudentRepository studentRepo) {
		this.studentRepo = studentRepo;
	}
	
	
	@Override
	public void insertData(StudentEntity sObj) {
		//studentdaoObj.add(sObj);
		studentRepo.save(sObj);
	}

	
	@Override
	public List<StudentEntity> getAll() {
		return studentRepo.findAll();
	}
	
	
	@Override
	public List<StudentEntity> duplicateEmail(StudentEntity sObj) {
		return studentRepo.findByEmailContainingIgnoreCase(sObj.getEmail());
		//return studentdaoObj.duplicateEmail(sObj);
	}
	
	
	@Override
	public List<StudentEntity> findByID(StudentEntity sObj) {
		return studentRepo.findByLastNameAndFirstName(sObj.getLastName() , sObj.getFirstName());
		//return studentdaoObj.findByID(sObj);
	}
	
	
	

}
