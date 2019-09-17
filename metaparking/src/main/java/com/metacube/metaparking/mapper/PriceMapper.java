package com.metacube.metaparking.mapper;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import com.metacube.metaparking.model.Price;

public class PriceMapper implements RowMapper<Price> {

	@Override
	public Price mapRow(ResultSet resultSet, int arg1) throws SQLException {
		Price priceObj = new Price(resultSet.getInt("id"),
				resultSet.getString("Type"),
				resultSet.getInt("DAILY"),
				resultSet.getInt("Monthly"),
				resultSet.getInt("Yearly")
		);

		return priceObj;
	}

}