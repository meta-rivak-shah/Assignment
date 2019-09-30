package com.metacube.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.ObjectError;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import com.metacube.demo.dto.SearchStudentDto;
import com.metacube.demo.dto.StudentDto;
import com.metacube.demo.entity.StudentEntity;
import com.metacube.demo.services.StudentService;
import com.metacube.demo.util.DtoUtil;

/**
 * class to controller all Activity like web page request tranfer array list 
 * @author Rivak
 *
 */
@Controller
public class Home {
	
	@Autowired
	private StudentService studentObj;
	
	@Value("${home.message}")
	private String message;

	/**
	 * request come from web server /Home then page redirect is home.jsp
	 * @param model
	 * @return
	 */
	@GetMapping("/home")
	public String getHome(Model model) {
		model.addAttribute("message" ,message);
		return "home";
	}

	/**
	 * when web server request /showStudent then page showStudent.jsp will show
	 * @param model
	 * @return
	 */
	@GetMapping("/showStudent")
	public String displayStudent(Model model) {
		model.addAttribute("studentDetails", studentObj.getAll());
		return "showStudent";
		
	}
	

	/**
	 * when web server signUp page is refect then it return addStudent
	 * @param model
	 * @return
	 */
	@GetMapping("/signUp")
	public String doSignUp(Model model) {
		model.addAttribute("studentCommand", new StudentDto());
		System.out.println("come inside add student details");
		return "addStudent";
	}
	
	/**
	 * when user request as post method then this function is called
	 * @param student
	 * @param errorResult
	 * @param model
	 * @return
	 */
	@PostMapping("/signUp")
	public String doSignupByPost(@ModelAttribute("studentCommand") @Validated StudentDto student , BindingResult errorResult , Model model) {
		if(errorResult.hasErrors()) {
			ObjectError oe = new  ObjectError("Email","Fill The Form");
			errorResult.addError(oe);
			return "addStudent";
		} else {
			List<StudentEntity> studentData = studentObj.duplicateEmail(DtoUtil.map(student,StudentEntity.class));
			if(studentData.size()>0) {
				
				model.addAttribute("succes", "Student Email Exit");
				return "addStudent";
			} 
			studentObj.insertData(DtoUtil.map(student,StudentEntity.class));
			model.addAttribute("succes", "Student Add Succefulyy");
			return "addStudent";
		}
	}

	@GetMapping("/searchStudent") 
	public String searchStudentByGet(Model model) {
		model.addAttribute("SearchCommand", new SearchStudentDto());
		return "Search";
	}
	
	
	@PostMapping("/searchStudent") 
	public String searchStudentByPost(@ModelAttribute("SearchCommand") @Validated SearchStudentDto student , BindingResult errorResult , Model model) {
		List<StudentEntity> studentData = studentObj.findByID(DtoUtil.map(student,StudentEntity.class));
		if(studentData.size()>0) {
			System.out.println(studentData.get(0).getEmail());
			model.addAttribute("studentData", studentData);
			return "Search";
		}
		model.addAttribute("succes", "No Student  Find");
		return "Search";
	}
}
