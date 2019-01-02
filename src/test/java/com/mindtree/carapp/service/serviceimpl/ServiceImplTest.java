package com.mindtree.carapp.service.serviceimpl;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.when;

import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.mockito.junit.MockitoJUnit;
import org.mockito.junit.MockitoJUnitRunner;
import org.mockito.junit.MockitoRule;
import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.mindtree.carapp.dao.CarDao;
import com.mindtree.carapp.entity.Car;
import com.mindtree.carapp.exception.DaoException;
import com.mindtree.carapp.exception.ServiceException;
import com.mindtree.carapp.service.CarService;

@RunWith(MockitoJUnitRunner.Silent.class)
public class ServiceImplTest {

	static AbstractApplicationContext context = new ClassPathXmlApplicationContext("Beans.xml");
	static Car car = new Car();

	@Mock
	CarDao carDao;

	@InjectMocks
	static CarService carSer = context.getBean("carServiceBean", CarServiceImpl.class);

	@Rule
	public MockitoRule rule = MockitoJUnit.rule();

	@Before
	public void setup() {
		MockitoAnnotations.initMocks(this);
		car.setModelNum(1101);
		car.setModelName("FordXT18");
		car.setPrice(1250);
	}

	@Test
	public void testAddCar() throws ServiceException {
		try {
			when(carDao.insert(car)).thenReturn("success");
			assertEquals("success", carSer.addCar(car));
		} catch (DaoException e) {
			throw new ServiceException(e.getMessage(), e.getCause());
		}
	}

	@Test
	public void testFetchCar() throws ServiceException {
		try {
			when(carDao.getCar(1101)).thenReturn(car);
			assertEquals("FordXT18", carSer.getCarById(1101).getModelName());
		} catch (DaoException e) {
			throw new ServiceException(e.getMessage(), e.getCause());
		}
	}
}
