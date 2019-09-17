package com.metacube.metaparking.controller;




import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.dao.DuplicateKeyException;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.util.FileCopyUtils;
import org.springframework.validation.BindingResult;
import org.springframework.validation.ObjectError;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.metacube.metaparking.dto.*;
import com.metacube.metaparking.model.*;
import com.metacube.metaparking.model.GatePass;
import com.metacube.metaparking.service.ParkingServiceImpl;
import com.metacube.metaparking.utils.CustomeValidations;
import com.metacube.metaparking.utils.DtoUtils;


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
	public String loginAuth(@ModelAttribute("employeeCommand") @Validated  EmployeeLogin  employee , BindingResult errorResult , Model model , HttpServletRequest req , RedirectAttributes redirectAttributes) {
		
		if(errorResult.hasErrors()) {
			return "home";
		} else {
			System.out.println(employee.getPassword());
			try {
				Employee employeeData = parkingserviceObj.getAllData(employee.getEmail(), employee.getPassword());
				if(employeeData != null) {
					HttpSession session=req.getSession(false);
					session.setAttribute("email", employeeData.getEmail());
					session.setAttribute("id", employeeData.getId());
					return "redirect:/Profile";
				} else {
					ObjectError oe = new ObjectError("authenticatedFailed", "Wrong id and password");
					errorResult.addError(oe);
					return "home";
				}
			} catch(EmptyResultDataAccessException e) { 
				ObjectError oe = new ObjectError("authenticatedFailed", "Email Not  find Please Sign Up First");
				errorResult.addError(oe);
				return "home";

			} catch (Exception e) {
				System.out.println(e);
				ObjectError oe1 = new ObjectError("authenticatedFailed", "something went wrong try after some time");
				errorResult.addError(oe1);
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
		return "register";
	}
	
	
	@PostMapping("/Register")
	public String userRegisterAuthentication(
			@ModelAttribute("employeeRegister") @Validated EmployeeRegister employee,
			BindingResult errorResult, Model model, HttpServletRequest req , RedirectAttributes redicAttributes) {
		
		passwordValidator.passwordMisMatch(employee, errorResult);
		if (errorResult.hasErrors()) {
			return "register";
		} else {
			String email = employee.getEmail();
			String name = employee.getName();
			try {
				parkingserviceObj.addEmployee(DtoUtils.map(employee, Employee.class));
				HttpSession session = req.getSession(false);
				session.setAttribute("email", email);
				redicAttributes.addFlashAttribute("AccountCreated", "Welcome "+name+" Your Account is Create Succefully");
				return "redirect:/Vehicleform";
				
			} catch (DuplicateKeyException e) {
				model.addAttribute("duplicateEmail", "email allready Used");
				return "register";
			} catch(Exception e) {
				model.addAttribute("sqlException", e);
				return "register";
			}
		}

	}
	
	
	@GetMapping("/Vehicleform")
	public String vehicleRegister(Model model , HttpServletRequest req) {
		HttpSession session = req.getSession(false);
		if(session.getAttribute("email") != null) {
			model.addAttribute("vechile", new Vechile());
			model.addAttribute("url",1);
			try {
				Employee employeeData = parkingserviceObj.getDataByEmail(String.valueOf(session.getAttribute("email")));
				model.addAttribute("employeeId" , employeeData.getId());
				session.setAttribute("id", employeeData.getId());
			} catch (Exception e) {
				System.out.println("ddd");
				return "VehicleRegister";
			}
		}
		System.out.println("Come Inside Vechile Form");
		return "VehicleRegister";
	}
	

	@PostMapping("/Vehicleform")
	public String vechileRegister(@ModelAttribute("vechile") @Validated  Vechile  vechileObj , BindingResult errorResult , Model model , HttpServletRequest req , RedirectAttributes flashAttributes) {
		if(errorResult.hasErrors()) {
			return "VehicleRegister";
		} else {
			try {
				HttpSession session = req.getSession(false);
				Employee employeeData = parkingserviceObj.getDataByEmail(String.valueOf(session.getAttribute("email")));
				boolean idResult = parkingserviceObj.checkIdIsSame(vechileObj.getEmpId() , employeeData.getId());
				System.out.println(idResult);
				if(!idResult) {    
					
					
					flashAttributes.addFlashAttribute("idResult" , "Id is Not Valid");
					return "redirect:/Vehicleform";
				} else {		
					boolean result = parkingserviceObj.addEmployeeVechile(DtoUtils.map(vechileObj, VechileRegister.class));
					if(result) {
						model.addAttribute("Success" ,"Vechile Register Succefully");
					}
				}
			} catch (DuplicateKeyException e) {
				model.addAttribute("duplicateNumber", "Vechile allready Register");
			} catch (Exception e) {
				System.out.println(e);
				return "VehicleRegister";
			}
			return "VehicleRegister"; 
		}
	
	}
	
	
	@GetMapping("/FriendList")
	public String getFriendList(Model model , HttpServletRequest req) {
		HttpSession session = req.getSession(false);
		String email = String.valueOf(session.getAttribute("email"));
		if(email!=null){
			ArrayList<EmployeeFriend> employeeFriendData = parkingserviceObj.getEmployeeFriendList(email);
			model.addAttribute("EmployeeFriend" , employeeFriendData);
			model.addAttribute("url", 2);
		}
		
		return "userfriendlist";
	}
	
	
	
	@GetMapping("/Profile")
	public String getUserProfile(Model model , HttpServletRequest req) {
		HttpSession session = req.getSession(false);
		System.out.println(session.getAttribute("email")+"email");
		if(session.getAttribute("email") != null  && session.getAttribute("id")!=null) {
			model.addAttribute("url", 3);
			try {
				Employee employeeData = parkingserviceObj.getDataById(String.valueOf(session.getAttribute("id")));
				model.addAttribute("EmployeeDetails" , employeeData);
			} catch (Exception e) {
				return "rediret:/home";
			}
		}
		return "profile";
	}
	
	
	@GetMapping("/GatePass")
	public String takeGatePass(Model model  , HttpServletRequest req) {
		try {
			HttpSession session = req.getSession(false);
			String id = String.valueOf(session.getAttribute("id"));
			ArrayList<VechileRegister> vechileRegister = parkingserviceObj.getVechileDataByEmployeeId(id);
			model.addAttribute("VechileData", vechileRegister);
		} catch (Exception e) {
			System.out.println(e);
			return "gatePass";
		}
		model.addAttribute("url", 4);
		return "gatePass";
	}
	
	
	@GetMapping("/frndProfile/{id}")
	public String getFriendProfile(Model model , @PathVariable("id") String id) {
		boolean result = parkingserviceObj.validatePathId(id);
		if(result){
			EmployeeFriend employeeFriendData = parkingserviceObj.getEmployeeFriendListById(id);
			model.addAttribute("ProfileImformation",employeeFriendData);
			return "frndProfile";
		} else {
			return "redirect:/FriendList";
		}
		
	}
	
	
	
	@GetMapping("/takeGatePass/{id}")
	public String GatePass(Model model, @PathVariable("id") String id) {
		boolean result = parkingserviceObj.validatePathId(id);
		if(result){
			model.addAttribute("gatepass", new GatePass());
			Price price = parkingserviceObj.getPriceOfVechileById(id);
			model.addAttribute("price", price);
			return "bookGatePass";
		}
		return "redirect:/GatePass";
	}
	
	@PostMapping("/takeGatePass/{id}")
	public String bookGatePass(@ModelAttribute("gatepass") @Validated  GatePass  gatePassObj , BindingResult errorResult , Model model , @PathVariable("id") String id , RedirectAttributes flashAttributes) {
		boolean result = parkingserviceObj.validatePathId(id);
		if(errorResult.hasErrors()) {
			return "redirect:/takeGatePass/"+id+"";
		} else if(!result) {
			return "redirect:/GatePass";
		}
		else {
			try {
				result = parkingserviceObj.issueGatePass(DtoUtils.map(gatePassObj, GatePass.class) , id);
				System.out.println(result);
				if(result){
					flashAttributes.addFlashAttribute("price" , gatePassObj.getPrice());
					flashAttributes.addFlashAttribute("Success" , "Your GatePass is issued");
				}
			} catch (Exception e) {
				System.out.println(e);
				model.addAttribute("wrongid", "some thing went wrong try after some time");
				return "redirect:/takeGatePass/"+id+"";
			}
			return "redirect:/finalCompleted";
		}
	}
	@GetMapping("/finalCompleted")
	public String showPassResult(Model model) {
		return "Success";
	}
	
	@GetMapping("/editProfile")
	public String editProfile(Model model , HttpServletRequest req){
		HttpSession session = req.getSession(false);
		if(session.getAttribute("email") != null  && session.getAttribute("id")!=null) {
			model.addAttribute("url", 3);
			try {
				Employee employeeData = parkingserviceObj.getDataById(String.valueOf(session.getAttribute("id")));
				model.addAttribute("EmployeeDetails" , employeeData);
			} catch (Exception e) {
				return "rediret:/Profile";
			}
		}
		model.addAttribute("editProfile", new EditProfile());
		return "editProfile";
	}
	
	@PostMapping("/editProfile")
	public String updateEditProfile(@ModelAttribute("editProfile") @Validated  EditProfile EditProfileObj , BindingResult errorResult , Model model , MultipartFile file ,HttpServletRequest req) throws IOException {
		 String fileName = "user.png";
		 HttpSession session = req.getSession(false);
		 String id = String.valueOf(session.getAttribute("id"));
		if(errorResult.hasErrors()){
			return "editProfile";
		} else {
			if(!EditProfileObj.getProfile().isEmpty()){
				 MultipartFile multipartFile = EditProfileObj.getProfile();
		         String uploadPath = "C:/Users/Rivak/Desktop/SpringBootPeoject/metaparking/src/main/resources/static/image/"+EditProfileObj.getProfile().getOriginalFilename();
		         //Now do something with file...
		         FileCopyUtils.copy( EditProfileObj.getProfile().getBytes(), new File(uploadPath));
		         fileName = multipartFile.getOriginalFilename();
		         System.out.println(fileName);
			} 
			boolean result = parkingserviceObj.updateEmployeeData(fileName,
					EditProfileObj.getPassword(),
					EditProfileObj.getOrganisation(),
					EditProfileObj.getMobileNumber(), EditProfileObj.getName() ,id);
			return "redirect:/Profile";
		}
		
	}
	
	@GetMapping("/logout")
	public String logout(HttpServletRequest req) {
		HttpSession session=req.getSession(false);
		if(session.getAttribute("email") != null) {
			session.removeAttribute("email");
			session.removeAttribute("id");
		} 
		return "redirect:/home";
	}

}
