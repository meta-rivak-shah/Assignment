package com.metacube.demo.dao;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.hibernate5.HibernateTemplate;
import org.springframework.stereotype.Component;

import com.metacube.demo.entity.StudentEntity;



@Transactional
@Component
public class StudentDao {

	@Autowired
	HibernateTemplate template;

	public StudentDao() {
		
	}

	@Autowired
	public void setTemplate(HibernateTemplate template) {
		this.template = template;
	}


	/**
	 * Gets All the Students
	 * @return {List<Student>} list of students
	 */
	public List<StudentEntity> getAll(){
		return template.loadAll(StudentEntity.class);
	}
	
	
	
	/**
	 * Add Student to the database
	 * @param student  is the student to be added
	 * @return 
	 * @return {int} number of rows added
	 */
	public int add(StudentEntity sObj) {
		return (int) template.save(sObj);
	}

	/**
	 * check duplicate entry
	 * @param sObj
	 * @return
	 */
	public List<StudentEntity> duplicateEmail(StudentEntity sObj) {
		return template.findByExample(sObj);
	}

	public List<StudentEntity> findByID(StudentEntity sObj) {
		return template.findByExample(sObj);
	}
	
}