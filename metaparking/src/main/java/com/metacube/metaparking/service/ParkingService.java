package com.metacube.metaparking.service;

import org.springframework.stereotype.Service;

@Service
public interface ParkingService {

	boolean authenticatedUser(String email , String password);
	public boolean checkDuplicateEmail(String email);
}
