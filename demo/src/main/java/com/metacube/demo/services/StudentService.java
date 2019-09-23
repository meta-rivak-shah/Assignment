package com.metacube.demo.services;


import java.util.List;

import org.springframework.stereotype.Service;
import com.metacube.demo.entity.StudentEntity;

/**
 * interface is used to implement same method in diffrent child funtion
 * @author Rivak
 *
 */
@Service
public interface StudentService {

	void insertData(StudentEntity sObj);

	public List<StudentEntity> getAll();

	List<StudentEntity> duplicateEmail(StudentEntity sObj);

	List<StudentEntity> findByID(StudentEntity map);


}
