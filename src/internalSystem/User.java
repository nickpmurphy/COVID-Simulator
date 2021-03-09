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
public class User 
{
	//can create a username and password
	private String username,password;
	//Each user has a Car(s)
	private Object userCar;
	//Each user carries a fee with them 
	private int fee;
	
	public User()
	{
		setUsername("u");
		setPassword("p");
		Sedan s = new Sedan(2);
		setUserCar(s);
		setFee(50);
	}
	
	//Create the User
	public User(String u, String p, Car c, int f)
	{
		setUsername(u);
		setPassword(p);
		setUserCar(c);
		setFee(f);
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


	public Car getUserCar() {
		return (Car) userCar;
	}


	public void setUserCar(Car userCar) {
		this.userCar = userCar;
	}


	public int getFee() {
		return fee;
	}


	public void setFee(int fee) {
		this.fee = fee;
	}
	
	
	
	
}
