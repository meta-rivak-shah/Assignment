package com.metacube.metaparking.service;



import org.springframework.stereotype.Service;

@Service
public class ParkingServiceImpl implements ParkingService {
	@Override
	public boolean authenticatedUser(String email, String password) {
		String email1 = "shahrivak6@gmail.com";
		String password1 = "Rivak@12345";
		if(email.equals(email1) && password.equals(password1)) {
			return true;
		} else {
			return false;
		}
	}

	@Override
	public boolean checkDuplicateEmail(String email) {
		return true;
	}

	

	
}
