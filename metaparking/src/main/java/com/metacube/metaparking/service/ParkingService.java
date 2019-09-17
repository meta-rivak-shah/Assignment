package com.metacube.metaparking.service;

import java.util.ArrayList;

import org.springframework.stereotype.Service;

import com.metacube.metaparking.model.Employee;
import com.metacube.metaparking.model.EmployeeFriend;
import com.metacube.metaparking.model.GatePass;
import com.metacube.metaparking.model.Price;
import com.metacube.metaparking.model.VechileRegister;

@Service
public interface ParkingService {

	public boolean checkDuplicateEmail(String email);
	public boolean addEmployee(Employee emp);
	public Employee getAllData(String email , String password);
	public Employee getDataById(String id);
	public Employee getDataByEmail(String valueOf);
	public ArrayList<EmployeeFriend> getEmployeeFriendList(String email);
	boolean validatePathId(String id);
	EmployeeFriend getEmployeeFriendListById(String id);
	boolean addEmployeeVechile(VechileRegister vechile);
	ArrayList<VechileRegister> getVechileDataByEmployeeId(String id);
	Price getPriceOfVechileById(String id);
	boolean issueGatePass(GatePass gatepass, String id);
	boolean updateEmployeeData(String fileName, String password,
			String organisation, String mobileNumber, String name, String id);
}
