package com.metacube.metaparking.mapper;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import com.metacube.metaparking.model.VechileRegister;

public class VechileDataMapper implements RowMapper<VechileRegister> {

	@Override
	public VechileRegister mapRow(ResultSet resultSet, int arg1) throws SQLException {
		VechileRegister vechileDetails = new VechileRegister(resultSet.getLong("id"),
				resultSet.getString("Name"),
				resultSet.getString("Type"),
				resultSet.getString("Vehicle_Number"),
				resultSet.getString("Employee_Id"),
				resultSet.getString("identification")
		);

		return vechileDetails;
	}

}