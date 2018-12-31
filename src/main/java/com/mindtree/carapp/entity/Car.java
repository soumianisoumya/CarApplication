package com.mindtree.carapp.entity;

public class Car {
	
	private int modelNum;
	private String modelName;
	private double price;

	public Car() {
		super();
	}
	
	public Car(int i, String string, int j) {
		// TODO Auto-generated constructor stub
		this.modelNum=i;
		this.modelName=string;
		this.price=j;
	}

	@Override
	public String toString() {
		return "Car [modelNum=" + modelNum + ", modelName=" + modelName + ", price=" + price + "]";
	}

	public int getModelNum() {
		return modelNum;
	}

	public void setModelNum(int modelNum) {
		this.modelNum = modelNum;
	}

	public String getModelName() {
		return modelName;
	}

	public void setModelName(String modelName) {
		this.modelName = modelName;
	}

	public double getPrice() {
		return price;
	}

	public void setPrice(double price) {
		this.price = price;
	}

}
