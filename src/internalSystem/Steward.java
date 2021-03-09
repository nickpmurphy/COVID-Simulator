package internalSystem;

import java.util.ArrayList;
import java.util.Map;
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
public class Steward extends Admin {

	//each steward has a username and password
	private String username, password;
	
	private ArrayList <Steward> allStewards = new ArrayList <Steward>();
 	
	//Create one steward per lot
	public Steward(String u, String p)
	{
		super(u,p);
	}
	
	public ArrayList <Steward> getAllStewards() {
		return allStewards;
	}

	public void setAllStewards(ArrayList <Steward> allStewards) {
		this.allStewards = allStewards;
	}

	//Getters and Setters
	public String getUsername() {
		return username;
	}


	public void setUsername(String username) {
		this.username = username;
	}


	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	//Steward can view all parking lot spots
	public void viewParkingLot()
	{
		ParkingLot stewardsLot = new ParkingLot(500);
		System.out.println(stewardsLot.toString());
	}
	
	//Can randomly assing users Coupons
	public int randomCoupon()
	{

		return (int) Math.random() * 10;
	}
}
