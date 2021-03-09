package internalSystem;
///////////////////////////////////////////////////////////////////////////////////
//
//C212
//
//Released:  4/1/20
//
//Final Project
//@Author  Sam Wojcik, Nick Murphy, Brian Ward, Nick Gao
//Last Edited:  5/1/20
//COPYRIGHT (C) 2020 Sam Wojcik, Nick Murphy, Brian Ward, Nick Gao. All Rights Reserved
//
//Final Project: Parking Lot Management
//
//
//////////////////////////////////////////////////////////////////////////////////
public class Car 
{
	private int carType;
	
	public Car()
	{
		setCarType(0);
	}
	
	//creating a car
	public Car(int cT)
	{
		setCarType(cT);
	}
	
	//Getters and Settres
	public int getCarType() {
		return carType;
	}
	public void setCarType(int carType) {
		this.carType = carType;
	}
}
