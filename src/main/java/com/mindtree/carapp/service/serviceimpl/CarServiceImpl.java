package com.mindtree.carapp.service.serviceimpl;

import java.util.ArrayList;
import java.util.List;

import com.mindtree.carapp.dao.CarDao;
import com.mindtree.carapp.entity.Car;
import com.mindtree.carapp.exception.DaoException;
import com.mindtree.carapp.exception.ServiceException;
import com.mindtree.carapp.service.CarService;

public class CarServiceImpl implements CarService {

	private CarDao carDao;

	public void setCarDao(CarDao carDao) {
		this.carDao = carDao;
	}

	@Override
	public String addCar(Car car) throws ServiceException {
		try {
			return carDao.insert(car);
		} catch (DaoException e) {
			throw new ServiceException(e.getMessage(), e.getCause());
		}
	}

	@Override
	public Car getCarById(int carId) throws ServiceException {
		try {
			return carDao.getCar(carId);
		} catch (DaoException e) {
			e.printStackTrace();
			throw new ServiceException(e.getMessage(), e.getCause());
		}
	}

	@Override
	public List<Car> getAllCars() throws ServiceException {

		try {
			ArrayList<Car> carList = (ArrayList<Car>) carDao.displayCar();
			return carList;
		} catch (DaoException e) {
			throw new ServiceException(e.getMessage(), e.getCause());
		}
	}

	@Override
	public void deleteCarById(int carId) throws ServiceException {
		try {
			carDao.deleteCar(carId);
		} catch (DaoException e) {
			throw new ServiceException(e.getMessage(), e.getCause());
		}
	}
}
