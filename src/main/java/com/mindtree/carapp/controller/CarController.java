package com.mindtree.carapp.controller;

import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;

import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import com.mindtree.carapp.entity.Car;
import com.mindtree.carapp.exception.ServiceException;
import com.mindtree.carapp.service.CarService;

@RestController
public class CarController {

	static AbstractApplicationContext context = new ClassPathXmlApplicationContext("Beans.xml");
	static CarService carSer = (CarService) context.getBean("carServiceBean");

	@RequestMapping(value = "/home", method = RequestMethod.GET)
	public String home() {
		return "home";
	}

	@RequestMapping(value = "/car", method = RequestMethod.GET)
	public ModelAndView car() {
		return new ModelAndView("car", "command", new Car());
	}

	@RequestMapping(value = "/addcar", method = RequestMethod.POST)
	public String addCar(@ModelAttribute("SpringWeb") Car car, ModelMap model, HttpServletRequest req) {

		try {
			carSer.addCar(car);
			model.addAttribute("modelNum", car.getModelNum());
			model.addAttribute("modelName", car.getModelName());
			model.addAttribute("price", car.getPrice());
			return "result";
		} catch (ServiceException e) {
			return "wrongin";
		}

	}

	@RequestMapping(value = "/getCar", method = RequestMethod.GET)
	public ModelAndView getCarById() {
		return new ModelAndView("carById", "command", new Car());
	}

	@RequestMapping(value = "/getCarId", method = RequestMethod.POST)
	public String getCar(@ModelAttribute("SpringWeb") Car car, ModelMap model, HttpServletRequest req) {
		try {
			Car queryCar = carSer.getCarById(car.getModelNum());
			model.addAttribute("modelNum", queryCar.getModelNum());
			model.addAttribute("modelName", queryCar.getModelName());
			model.addAttribute("price", queryCar.getPrice());
			model.addAttribute("message","Retrieved Car details are :");
			return "carDetails";
		} catch (ServiceException e) {
			return "wrongin";
		}
	}

	@RequestMapping(value = "/carListDisplay", method = RequestMethod.GET)
	public ModelAndView displayCar() {
		try {
			ModelAndView model = new ModelAndView();
			ArrayList<Car> carList = (ArrayList<Car>) carSer.getAllCars();
			model.addObject("cars", carList);
			return model;
		} catch (ServiceException e) {
			return null;
		}
	}
	
	@RequestMapping(value="/deleteCar",method=RequestMethod.GET)
	public ModelAndView deleteCar() {
		return new ModelAndView("deleteCar", "command", new Car());
	}
	
	@RequestMapping(value="/deleteCarId",method=RequestMethod.POST)
	public String deleteCarById(@ModelAttribute("SpringWeb") Car car, ModelMap model, HttpServletRequest req) {
		
		try {
			Car queryCar= carSer.getCarById(car.getModelNum());
			carSer.deleteCarById(car.getModelNum());
			model.addAttribute("modelNum", queryCar.getModelNum());
			model.addAttribute("modelName", queryCar.getModelName());
			model.addAttribute("price", queryCar.getPrice());
			model.addAttribute("message","Deleted car details are :");
			return "carDetails";
		} catch (ServiceException e) {
			return "wrongin";
		}
		
	}
}
