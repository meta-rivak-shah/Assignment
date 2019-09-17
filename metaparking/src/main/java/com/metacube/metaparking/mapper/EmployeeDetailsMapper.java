package com.metacube.metaparking.mapper;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import com.metacube.metaparking.model.Employee;

public class EmployeeDetailsMapper implements RowMapper<Employee> {

	@Override
	public Employee mapRow(ResultSet resultSet, int arg1) throws SQLException {
		Employee employee = new Employee(resultSet.getLong("id"),
				resultSet.getString("full_name"),
				resultSet.getString("Email_id"),
				resultSet.getString("Contact_number"),
				resultSet.getString("Organisation"),
				resultSet.getString("Gender"),
				resultSet.getString("Password"),
				resultSet.getString("profile")
		);

		return employee;
	}

}