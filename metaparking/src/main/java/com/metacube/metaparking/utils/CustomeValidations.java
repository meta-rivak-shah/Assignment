package com.metacube.metaparking.utils;
import org.springframework.stereotype.Component;
import org.springframework.validation.BindingResult;

@Component
public interface CustomeValidations   {

	public void passwordMisMatch(Object target, BindingResult errors);
}
