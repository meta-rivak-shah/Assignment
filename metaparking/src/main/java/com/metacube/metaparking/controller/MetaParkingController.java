package com.metacube.metaparking.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.ObjectError;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import com.metacube.metaparking.model.*;
import com.metacube.metaparking.service.ParkingServiceImpl;
import com.metacube.metaparking.utils.CustomeValidations;


@Controller
public class MetaParkingController {
	
	@Autowired
	ParkingServiceImpl  parkingserviceObj;
	
	@Autowired
	@Qualifier("PasswordValidator")
	CustomeValidations passwordValidator;
	
	
	
	@GetMapping("/home")
	public String homePage(Model model , HttpServletRequest req) {
		HttpSession session=req.getSession(true);
		if(session.getAttribute("email") != null) {
			return "redirect:/Profile";
		}
		model.addAttribute("employeeCommand", new EmployeeLogin());
		System.out.println("come inside add student details");
		return "home";
	}
	
	
	@PostMapping("/home")
	public String loginAuth(@ModelAttribute("employeeCommand") @Validated  EmployeeLogin  employee , BindingResult errorResult , Model model , HttpServletRequest req) {
		
		if(errorResult.hasErrors()) {
			return "home";
		} else {
			System.out.println(employee.getPassword());
			boolean result = parkingserviceObj.authenticatedUser(employee.getEmail() , employee.getPassword());
			if(result) {
				HttpSession session=req.getSession(false);
				session.setAttribute("email", "1");
				return "redirect:/Profile";
			} else {
				ObjectError oe = new ObjectError("authenticatedFailed", "Wrong id and password");
				errorResult.addError(oe);
				return "home";
			}
		}
	
	}
	
	
	@GetMapping("/Register")
	public String registerPage(Model model , HttpServletRequest req) {
		HttpSession session=req.getSession(true);
		if(session.getAttribute("email") != null) {
			return "redirect:/Profile";
		}
		model.addAttribute("employeeRegister", new EmployeeRegister());
		System.out.println("come inside EmployeeRegister details");
		
		return "register";
	}
	
	
	@PostMapping("/Register")
	public String userRegisterAuthentication(@ModelAttribute("employeeRegister") @Validated  EmployeeRegister  employee , BindingResult errorResult , Model model,HttpServletRequest req) {
		passwordValidator.passwordMisMatch(employee, errorResult);
		if(errorResult.hasErrors()) {
			return "register";
		} else {
			System.out.println(employee.getPassword());
			boolean result = parkingserviceObj.checkDuplicateEmail(employee.getEmail());
			if(result) {
				HttpSession session=req.getSession(false);
				session.setAttribute("email", "1");
				return "redirect:/Vehicleform";
			} else {
				ObjectError oe = new ObjectError("authenticatedFailed", "Email id Already used");
				errorResult.addError(oe);
				return "register";
			}
		}
	
	}
	
	
	@GetMapping("/Vehicleform")
	public String vehicleRegister(Model model , HttpServletRequest req) {
		model.addAttribute("vechile", new Vechile());
		model.addAttribute("url",1);
		System.out.println("Come Inside Vechile Form");
		return "VehicleRegister";
	}
	

	@PostMapping("/Vehicleform")
	public String vechileRegister(@ModelAttribute("vechile") @Validated  Vechile  vechileObj , BindingResult errorResult , Model model) {
		if(errorResult.hasErrors()) {
			return "VehicleRegister";
		} else {
			System.out.println("succefully");
			model.addAttribute("Success" ,"Vechile Register Succefully");
			return "VehicleRegister"; 
		}
	
	}
	
	
	@GetMapping("/FriendList")
	public String getFriendList(Model model) {
		model.addAttribute("url", 2);
		return "userfriendlist";
	}
	
	
	
	@GetMapping("/Profile")
	public String getUserProfile(Model model) {
		model.addAttribute("url", 3);
		return "profile";
	}
	
	
	@GetMapping("/GatePass")
	public String takeGatePass(Model model) {
		model.addAttribute("url", 4);
		return "gatePass";
	}
	
	
	@GetMapping("/frndProfile")
	public String getFriendProfile(Model model) {
		return "frndProfile";
	}
	
	
	
	@GetMapping("/takeGatePass")
	public String GatePass(Model model) {
		model.addAttribute("gatepass", new GatePass());
		return "bookGatePass";
	}
	
	@PostMapping("/takeGatePass")
	public String bookGatePass(@ModelAttribute("gatepass") @Validated  GatePass  gatePassObj , BindingResult errorResult , Model model) {
		if(errorResult.hasErrors()) {
			return "bookGatePass";
		} else {
			return "redirect:/finalCompleted";
		}
	}
	
	@GetMapping("/finalCompleted")
	public String showPassResult(Model model) {
		model.addAttribute("success", "Your GatePass is Issued Thanks.!");
		return "Success";
	}
	
	@GetMapping("/editProfile")
	public String editProfile(Model model){
		model.addAttribute("editProfile", new EditProfile());
		return "editProfile";
	}
	
	@PostMapping("/editProfile")
	public String updateEditProfile(@ModelAttribute("editProfile") @Validated  EditProfile EditProfileObj , BindingResult errorResult , Model model){
		if(errorResult.hasErrors()){
			return "editProfile";
		} else {
			return "redirect:/Profile";
		}
		
	}
	
	@GetMapping("/logout")
	public String logout(HttpServletRequest req) {
		HttpSession session=req.getSession(false);
		if(session.getAttribute("email") != null) {
			session.removeAttribute("email");
		} 
		return "redirect:/home";
	}

}
