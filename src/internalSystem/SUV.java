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
public class SUV extends Car
{
	private int carType;
	//if true -> user has a hitch on car ... less parking space
	//private boolean hitch;
	//Create an SUV
	public SUV(int c)
	{
		super(c);
	}
	
	//Getters and Settres
	public int getCarType() {
		return carType;
	}
	public void setCarType(int carType) {
		this.carType = carType;
	}

}
