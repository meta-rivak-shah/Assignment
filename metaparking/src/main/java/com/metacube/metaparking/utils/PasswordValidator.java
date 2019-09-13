package com.metacube.metaparking.utils;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;
import org.springframework.validation.BindingResult;
import org.springframework.validation.ObjectError;

import com.metacube.metaparking.model.EmployeeRegister;

@Qualifier("PasswordValidator")
@Component
public class PasswordValidator implements CustomeValidations   {
	@Override
	public void passwordMisMatch(Object target, BindingResult errors) {
		 EmployeeRegister employee = (EmployeeRegister)target;
	        String password = employee.getPassword();
	        String confPassword = employee.getConfirmPassword();
	        //Business validation
	        if(!(password.equals(confPassword))){
	        	ObjectError oe = new ObjectError("confirmPassword", "password must be same");
	        	errors.addError(oe);
	        }
	}

	
}
