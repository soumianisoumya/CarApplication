package com.mindtree.carapp.app;

import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.mindtree.carapp.entity.Car;
import com.mindtree.carapp.exception.ServiceException;
import com.mindtree.carapp.service.CarService;
import com.mindtree.carapp.service.serviceimpl.CarServiceImpl;

public class MainApp {

	static AbstractApplicationContext context = new ClassPathXmlApplicationContext("Beans.xml");
	static CarService carSer = context.getBean("carServiceBean", CarServiceImpl.class);

	public static void main(String args[]) {
		
		try {
			
			System.out.println(carSer.getCarById(1101));
		} catch (ServiceException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

}
