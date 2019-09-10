package com.metacube.demo.controller;

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

import com.metacube.demo.dto.Student;
import com.metacube.demo.services.StudentOperationServices;

/**
 * class to controller all Activity like web page request tranfer array list 
 * @author Rivak
 *
 */
@Controller
public class Home {
	
	@Autowired
	private StudentOperationServices studentObj;
	
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
		model.addAttribute("studentDetails" ,studentObj.getAllStudentDetails());
		return "showStudent";
		
	}
	

	/**
	 * when web server signUp page is refect then it return addStudent
	 * @param model
	 * @return
	 */
	@GetMapping("/signUp")
	public String doSignUp(Model model) {
		model.addAttribute("studentCommand", new Student());
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
	public String doSignupByPost(@ModelAttribute("studentCommand") @Validated Student student , BindingResult errorResult , Model model) {
		if(errorResult.hasErrors()) {
			ObjectError oe = new  ObjectError("Email","Fill The Form");
			errorResult.addError(oe);
			return "addStudent";
		} else {
			System.out.println("Your First Name is =>"+student.getFirstName());
			System.out.println("Your Last Name is =>"+student.getLastName());
			System.out.println("Your Email  is =>"+student.getEmail());
			System.out.println("Your Class Name is =>"+student.getsClass());
			System.out.println("Your Father Name is =>"+student.getFatherName());
			model.addAttribute("success" ,"Your Account Created Sucefully");
			model.addAttribute("Name", student.getFirstName());
			model.addAttribute("lname", student.getLastName());
			model.addAttribute("fathername", student.getFatherName());
			model.addAttribute("classs", student.getsClass());
			model.addAttribute("Email", student.getEmail());
			return "succesfuly";
		}
	}
}
