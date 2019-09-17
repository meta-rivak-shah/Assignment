package com.metacube.metaparking.service;



import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.metacube.metaparking.dao.MetaParkingDao;
import com.metacube.metaparking.model.Employee;
import com.metacube.metaparking.model.EmployeeFriend;
import com.metacube.metaparking.model.GatePass;
import com.metacube.metaparking.model.Price;
import com.metacube.metaparking.model.VechileRegister;

@Service
public class ParkingServiceImpl implements ParkingService {

	@Autowired
	MetaParkingDao metaparkingdaoObj;
	@Override
	public boolean checkDuplicateEmail(String email) {
		return false;
	}

	@Override
	public boolean addEmployee(Employee emp) {
		return metaparkingdaoObj.addEmployee(emp);
	}

	@Override
	public Employee getAllData(String email , String password) {
		return metaparkingdaoObj.getAllData(email , password);
	}

	@Override
	public Employee getDataById(String id) {
		 return metaparkingdaoObj.getDataById(id);
	}

	@Override
	public Employee getDataByEmail(String email) {
		 return metaparkingdaoObj.getDataByEmail(email);
	}

	@Override
	public ArrayList<EmployeeFriend> getEmployeeFriendList(String email) {
		return metaparkingdaoObj.getEmployeeFriendList(email);
	}

	@Override
	public boolean validatePathId(String id) {
		return id.matches("^[0-9]+");
	}
	
	@Override
	public EmployeeFriend getEmployeeFriendListById(String id) {
		return metaparkingdaoObj. getEmployeeFriendListById(id);
	}

	public boolean checkIdIsSame(String empId, Long id) {
		if(empId.matches("^[0-9]+")) {
			if(Integer.parseInt(empId) == id) {
				return true;
			} 
		}
		return false;
	}

	@Override
	public boolean addEmployeeVechile(VechileRegister vechile) {
		return metaparkingdaoObj.addEmployeeVechile(vechile);
	}
	
	@Override
	public ArrayList<VechileRegister> getVechileDataByEmployeeId(String id) {
		
		return metaparkingdaoObj.getVechileDataByEmployeeId(id);
	}

	@Override
	public Price getPriceOfVechileById(String id) {
		
		return metaparkingdaoObj.getPriceOfVechileById(id);
	}
	
	@Override
	public boolean issueGatePass(GatePass gatepass,
			String id) {
		return metaparkingdaoObj.issueGatePass(gatepass,id);
	}
	
	@Override
	public boolean updateEmployeeData(String fileName, String password,
			String organisation, String mobileNumber, String name, String id) {
	
		return metaparkingdaoObj.updateEmployeeData( fileName,  password,
				 organisation,  mobileNumber,  name , id);
	}


	
	
}
