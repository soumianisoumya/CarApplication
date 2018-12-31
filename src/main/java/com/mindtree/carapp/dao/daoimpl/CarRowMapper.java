package com.mindtree.carapp.dao.daoimpl;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.jdbc.core.RowMapper;

import com.mindtree.carapp.entity.Car;

public class CarRowMapper implements RowMapper<Car>{

	@Override
	public Car mapRow(ResultSet rs, int rowNum) throws SQLException {
		try (AbstractApplicationContext context = new ClassPathXmlApplicationContext("Beans.xml")) {
		Car car = (Car) context.getBean("carBean");
		car.setModelNum(rs.getInt(1));
		car.setModelName(rs.getString(2));
		car.setPrice(rs.getDouble(3));
		return car;
		}
	}
}
