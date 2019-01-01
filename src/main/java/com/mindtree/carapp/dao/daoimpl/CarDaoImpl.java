package com.mindtree.carapp.dao.daoimpl;

import java.util.List;

import javax.sql.DataSource;

import org.springframework.jdbc.core.JdbcTemplate;

import com.mindtree.carapp.dao.CarDao;
import com.mindtree.carapp.entity.Car;
import com.mindtree.carapp.exception.DaoException;

public class CarDaoImpl implements CarDao {

	private JdbcTemplate jdbcTemplate;

	public void setDataSource(DataSource dataSource) {
		this.jdbcTemplate = new JdbcTemplate(dataSource);
	}

	@Override
	public String insert(Car car) throws DaoException {
		try {
			String sql = "insert into car (modelnum,modelname,price) values(?,?,?)";
			jdbcTemplate.update(sql, new Object[] { car.getModelNum(), car.getModelName(), car.getPrice() });
			return "success";
		} catch (Exception e) {
			throw new DaoException("Cannot add car", e.getCause());
		}
	}

	public Car getCar(int carId) throws DaoException {
		try {
			String sql = "select * from car where modelnum=" + carId;
			return jdbcTemplate.query(sql, new CarRowMapper()).get(0);
		} catch (Exception e) {
			throw new DaoException("Cannot get car data", e.getCause());
		}
	}

	@Override
	public List<Car> displayCar() throws DaoException {
		try {
			String sql = "select * from car";
			return jdbcTemplate.query(sql, new CarRowMapper());
		} catch (Exception e) {
			throw new DaoException("Cannot get car data", e.getCause());
		}
	}
	
	@Override
	public void deleteCar(int carId) throws DaoException{
		try {
		String sql = "delete from car where modelnum=" + carId;
		jdbcTemplate.execute(sql);
		} catch (Exception e) {
			throw new DaoException("Cannot get car data", e.getCause());
		}
	}

}
