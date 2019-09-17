package com.metacube.metaparking.dao;

import java.util.ArrayList;

import org.springframework.stereotype.Repository;

import com.metacube.metaparking.model.Employee;
import com.metacube.metaparking.model.EmployeeFriend;
import com.metacube.metaparking.model.GatePass;
import com.metacube.metaparking.model.Price;
import com.metacube.metaparking.model.VechileRegister;

@Repository
public interface MetaParkingDao {

	public boolean addEmployee(Employee emp);
	public  Employee getAllData(String email , String password);
	public Employee getDataById(String id);
	public Employee getDataByEmail(String email);
	public ArrayList<EmployeeFriend> getEmployeeFriendList(String email);
	public EmployeeFriend getEmployeeFriendListById(String id);
	public boolean addEmployeeVechile(VechileRegister vechile);
	public ArrayList<VechileRegister> getVechileDataByEmployeeId(String id);
	public Price getPriceOfVechileById(String id);
	public boolean issueGatePass(GatePass gatepass, String id);
	public boolean updateEmployeeData(String fileName, String password,
			String organisation, String mobileNumber, String name, String id);
}
