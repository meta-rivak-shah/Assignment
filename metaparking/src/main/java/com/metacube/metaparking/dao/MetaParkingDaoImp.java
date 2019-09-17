package com.metacube.metaparking.dao;

import java.util.ArrayList;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.metacube.metaparking.mapper.*;
import com.metacube.metaparking.model.*;

@Repository
public class MetaParkingDaoImp implements MetaParkingDao {

	private final String INSERT_EMPLOYEE_DATA = "INSERT INTO User (full_name , Email_Id , Password ,Contact_number, Organisation  , Gender) values(?,?,?,?,?,?)";
	private final String INSERT_VECHILE_DATA = "INSERT INTO Vehicle (Name , Type , Vehicle_Number ,Employee_Id, identification) values(?,?,?,?,?)";
	private final String GETALL_EMPLOYEE_DATA = "SELECT * FROM User WHERE Email_id = ? AND Password = ?";
	private final String GET_EMPLOYEE_DATA_BY_ID = "SELECT * FROM User WHERE  id = ?";
	private final String GET_EMPLOYEE_DATA_BY_EMAIL = "SELECT * FROM User WHERE  Email_id = ?";
	private final String GET_EMPLOYEE_FRIEND_DETAILS_BY_EMAIL = "SELECT id ,full_name , Email_Id , Contact_number , Organisation , Gender , profile FROM User WHERE  Organisation = (SELECT Organisation FROM User WHERE Email_Id = ?) AND Email_Id!=?";
	private final String GET_EMPLOYEE_FRIEND_DETAILS_BY_Id = "SELECT id ,full_name , Email_Id , Contact_number , Organisation , Gender  , profile FROM User  where id = ?";
	private final String GET_VECHILE_DETAILS_BY_ID = "SELECT * FROM Vehicle where Employee_Id = ?";
	private final String GET_VECHILE_PRICE_BY_Id = "SELECT * FROM Price WHERE Type = (SELECT Type FROM Vehicle WHERE id = ?)";
	private final String INSERT_GATEPASS_DATA = "INSERT INTO user_vehicle (price , vehicle_id) VALUES(? ,?)";
	private final String UPDATE_EMPLOYEE_DATA = "UPDATE User SET full_name = ? , Password = ? , Contact_number = ? , Organisation = ? , profile = ? where id = ? ";
	
	private JdbcTemplate jdbcTemplate;
	
	@Autowired
	public void metaDaoMpl(DataSource dataSource) {
		jdbcTemplate = new JdbcTemplate(dataSource);
	}
	

	@Override
	public boolean addEmployee(Employee emp) {
		System.out.println(INSERT_EMPLOYEE_DATA);
		return jdbcTemplate.update(INSERT_EMPLOYEE_DATA , emp.getName() , emp.getEmail() , emp.getPassword() , emp.getMobileNumber() , emp.getOrganisation() , emp.getGender()) > 0;
	}


	@Override
	public Employee getAllData(String email , String password) {
		
		return jdbcTemplate.queryForObject(GETALL_EMPLOYEE_DATA, new Object[]{email , password} , new EmployeeDetailsMapper());
	}


	@Override
	public Employee getDataById(String id) {
		return jdbcTemplate.queryForObject(GET_EMPLOYEE_DATA_BY_ID, new Object[]{id} , new EmployeeDetailsMapper());
	}


	@Override
	public Employee getDataByEmail(String email) {
		return jdbcTemplate.queryForObject(GET_EMPLOYEE_DATA_BY_EMAIL, new Object[]{email} , new EmployeeDetailsMapper());
	}


	@Override
	public ArrayList<EmployeeFriend> getEmployeeFriendList(String email) {	
		return (ArrayList<EmployeeFriend>) jdbcTemplate.query(GET_EMPLOYEE_FRIEND_DETAILS_BY_EMAIL, new Object[]{email , email} , new EmployeeFriendDetailsMapper());
	}


	@Override
	public EmployeeFriend getEmployeeFriendListById(String id) {
		return jdbcTemplate.queryForObject(GET_EMPLOYEE_FRIEND_DETAILS_BY_Id, new Object[]{id} , new EmployeeFriendDetailsMapper());
	}


	@Override
	public boolean addEmployeeVechile(VechileRegister vechile) {
		return jdbcTemplate.update(INSERT_VECHILE_DATA , vechile.getName() , vechile.getType() ,vechile.getNumber() , vechile.getEmpId() , vechile.getIdentify()) > 0;
	}


	@Override
	public ArrayList<VechileRegister> getVechileDataByEmployeeId(String id) {
		return (ArrayList<VechileRegister>) jdbcTemplate.query(GET_VECHILE_DETAILS_BY_ID, new Object[]{Integer.parseInt(id)} , new VechileDataMapper());
	}


	@Override
	public Price getPriceOfVechileById(String id) {
		return jdbcTemplate.queryForObject(GET_VECHILE_PRICE_BY_Id, new Object[]{Integer.parseInt(id)} , new PriceMapper());
	}


	@Override
	public boolean issueGatePass(GatePass gatepass, String id) {
		return jdbcTemplate.update(INSERT_GATEPASS_DATA , gatepass.getPrice() , Integer.parseInt(id)) > 0;
	}


	@Override
	public boolean updateEmployeeData(String fileName, String password,
			String organisation, String mobileNumber, String name, String id) {
		return jdbcTemplate.update(UPDATE_EMPLOYEE_DATA , name ,password ,mobileNumber ,organisation, fileName ,id) > 0;
	}


	

}
