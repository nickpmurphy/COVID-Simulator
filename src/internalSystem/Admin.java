package internalSystem;


import java.util.Scanner;
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


public class Admin 
{
	//Pre-set username and password
	
	private final String username = "AdminUser";
	private final String password = "Admin1234";
	private Scanner myScan = new Scanner (System.in);

	public Admin(String u, String p)
	{

	}
	

	public String getUsername() {
		return username;
	}



	public String getPassword() {
		return password;
	}



	//Can view parking lot
	public void print()
	{
		ParkingLot pl = new ParkingLot(50);
		
		System.out.println(pl.toString());
		
	}
	//Change parking capacity of a ParkingLot
	public  void changeCapacity()
	{
		//Parking lot obj
		ParkingLot pl = new ParkingLot(500);
		//Which lot do you want to adjust
		System.out.println("Would you like to adjust the regular or premium sized lot?");
		String regOrPremium = myScan.nextLine();
		
		//If regular
		if (regOrPremium.equals("regular"))
		{		
			//whats the new size
			System.out.println("What size would you like the lot to be?");
			int lotSize = myScan.nextInt();
			//set the new size of the lot
			pl.setRegularSize(lotSize);
		}
		//if premium
		else if (regOrPremium.equals("premium"))
		{		
			//what size
			System.out.println("What size would you like the lot to be?");
			int lotSize = myScan.nextInt();
			//set the new size of the lot
			pl.setPremiumSize(lotSize);
		}
	}
	
	public void addLot()
	{
		//Parking lot obj
		ParkingLot pl = new ParkingLot(500);
		//Which type of lot to add
		System.out.println("Would you like to add a regular or premium lot?");
		String whichLot = myScan.nextLine();
		//if regular 
		if (whichLot.equals("regular"))
		{
			//Add lot #
			System.out.println("Which lot are you creating? (#)");
			int lotNum = myScan.nextInt();
			//add new lot the list at the lot number position
			pl.addRegularLot(lotNum);
		}
		else if (whichLot.equals("premium"))
		{
			System.out.println("Which lot are you creating? (#)");
			int lotNum = myScan.nextInt();
			
			pl.addPremiumLot(lotNum);			
		}	
	}
	
	public void removeLot()
	{
		ParkingLot pl = new ParkingLot(500);
		System.out.println("Would you like to remove a regular or premium lot?");
		String whichLot = myScan.nextLine();
		//if regular 
		if (whichLot.equals("regular"))
		{
			//which lot are you removing
			System.out.println("Which lot are you removing? (#)");
			int lotNum = myScan.nextInt();
			//remove from list
			pl.removeRegularLot(lotNum);

		}
		else if (whichLot.equals("premium"))
		{
			//Which lot # are you removing
			System.out.println("Which lot are you removing? (#)");
			int lotNum = myScan.nextInt();
			//remove from list
			pl.removePremiumLot(lotNum);			
		}
	}
	//Can add or remove Steward's (Remove an object)
	public void addSteward()
	{
	//Machine object
		Machine editMachine = new Machine();
		System.out.println("Enter Steward's Username: ");
		String stewUser = myScan.nextLine();
		System.out.println("Enter Steward's Password: ");
		String stewPass = myScan.nextLine();
		
		//Steward object
		Steward addS = new Steward(stewUser, stewPass);
		//update the list that hold the Stewards username and password
		editMachine.stewardUser.add(stewUser);
		editMachine.stewardPass.add(stewPass);
		
	}
	
	public void removeSteward()
	{
		Machine editMachine = new Machine();
		//Get information of which steward to remove from the list
		System.out.println("Enter Steward's Username: ");
		String stewUser = myScan.nextLine();
		System.out.println("Enter Steward's Password: ");
		String stewPass = myScan.nextLine();
		
		//loop through the list to find the corresponding username and password to remove
		for (int i = 0; i < editMachine.stewardPass.size(); i++)
		{
			if (stewUser.equals(editMachine.stewardUser.get(i)))
			{
				//remove from lists
				editMachine.stewardPass.remove(i);
				editMachine.stewardUser.remove(i);
			}
			
		}
	}
	//Blacklist a user (Remove an object) 
	public void blacklistUser()
	{
		Machine editMachine = new Machine();
		//Which username would you like to blacklist
		System.out.println("What is the user's username that you would like to blacklist?");
		String bUsername = myScan.nextLine();
		//Add the username to the list of blacklisted names
		editMachine.blacklistList.add(bUsername);
		
	}
}
