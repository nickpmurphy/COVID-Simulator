package internalSystem;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
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



public class Machine
{

	public static  ArrayList <String> usernameList = new ArrayList <>();	//ArrayList to hold corresponding username's and passwords
	public static ArrayList <String> passwordList = new ArrayList <>();
	public static ArrayList <String> stewardUser = new ArrayList <>();
	public static ArrayList <String> stewardPass = new ArrayList <>();
	public static ArrayList <String> blacklistList = new ArrayList <>();

	public static Map <String, Integer> userNFee = new HashMap<>();



	public static void main(String[] args) {


		//Base username and password --> fills the arrayList 
		String username = "IU";
		String password = "123";
		//Create a scanner
		Scanner myScan = new Scanner (System.in);




		//Defined admin login information
		String usernameA = "Admin123";
		String passwordA = "AdminPass";

		//add admin to login information lists
		Admin createAdmin = new Admin(usernameA, passwordA);

		//add admin to the username and login list
		usernameList.add(createAdmin.getUsername());
		passwordList.add(createAdmin.getPassword());
		


		boolean signedIn = false;

		//if user already has an account

		System.out.println("Do you already have an account? (y/n)");
		String yN = myScan.nextLine();

		if (yN.equals("y"))
		{
			//prompt login
			System.out.println("******LOGIN******");
			System.out.println("Enter username: ");
			username = myScan.nextLine();
			System.out.println("Enter password: ");
			password = myScan.nextLine();

			//Loop through the list of usernames
			for (int i = 0; i < usernameList.size(); i++)
			{
				//loop through the list of Blacklist names
				for (int j = 0; j < blacklistList.size(); j++)
				{
					//if on the blacklist names --> tell them
					if (username.equals(blacklistList.get(j)))
					{
						System.out.println("Sorry, your account has been blacklisted");
						break;
					}
							
				}
				//else check there information --> if matches then signed in
				if (username.equals(usernameList.get(i)))
				{
					if (password.equals(passwordList.get(i)))
					{
						System.out.println("Signed In");
					}
				}
			}
		}
		else
		{
			//Creating an account
			System.out.println("***CREATE ACCOUNT***");
			System.out.println("Enter username: ");
			username = myScan.nextLine();
			System.out.println("Enter password: ");
			password = myScan.nextLine();
			//check for unique username
			for (int i = 0; i < usernameList.size(); i++)
			{
				//if username already exists
				if (username.equals(usernameList.get(i)))
				{
					//invalid
					System.out.println("Username already exists");
					//new Login information
					System.out.println("Please enter a new username: ");
					username = myScan.nextLine();

					System.out.println("Enter password: ");
					password = myScan.nextLine();

					//add username and password to list 
					usernameList.set(i, username);
					passwordList.set(i, password);
				}
				else
				{
					//add to list of login information
					usernameList.set(i,username);
					passwordList.set(i,password);
					//break loop
					signedIn = true;
					System.out.println("Signed In");
				}
			}
		}
		
		//Add default steward to list's
		stewardUser.add("defaultSteward");
		stewardPass.add("StewPass");
		//create new steward object
		Steward stew = new Steward (username, password);
		
		//loop through all stewards Usernames
		for (int i = 0; i < stewardUser.size(); i++)
		{
			//if correct username and password
			if (username.equals(stewardUser.get(i)) && password.equals(stewardPass.get(i)))
			{
				//Prompt Steward with his commands
				System.out.println("What would you like to do?");
				System.out.println(" 1: View Parking Lot");
				System.out.println(" 2: Grant Coupon");
				int stewardOption = myScan.nextInt();
				
				//If view parking lot
				if (stewardOption == 1)
				{
					//call parking lot function
					stew.viewParkingLot();
					break;
				}
				//if give out random coupon
				else if (stewardOption == 2)
				{
					//get the value of the the random coupon
					int value = stew.randomCoupon();
					//tell the steward when he gives out a coupon
					System.out.println("Gave out a coupon, Value: " + "$" + value);
					break;
				}
				else 
				{
					//else invalid function for steward
					System.out.println("Invalid");
					break;
				}
			}
		}

		int adminChoice = 0;
		boolean continueRunning = true;
		//Admin Login
		if (username.equals("Admin123") && password.equals("AdminPass"))
		{				
			//While the Admin is done 'admining'
			while (continueRunning == true)
			{
				continueRunning = false;
				//Prompt the admin with their options
				System.out.println("What would you like to do?");
				System.out.println("1 : Add/Remove Lots" + "\n" + '2'  + " : Change Capacity " + "\n" + '3' + " : Add/Remove a Steward" + "\n" + '4' + " : BlackList User" 
						+ "\n" + '5' + " : See Parking Lot" + "\n" + "6 : Quit");
				adminChoice = myScan.nextInt();
				myScan.nextLine();

				//If add/remove lots
				if (adminChoice == 1)
				{
					//which lot to add
					System.out.println("Would you like to remove a lot or add?");
					String addRemove = myScan.nextLine();
					{
						if (addRemove.equals('a') || addRemove.equals("add"))
						{
							//call function in admin
							createAdmin.addLot();

							break;
						}
						else if (addRemove.equals('r') || addRemove.equals("remove"))
						{
							//call function in Admin
							createAdmin.removeLot();
							break;
						}
					}

				}
				//if Change capacity
				else if (adminChoice == 2)
				{
					//call the method in Admin
					createAdmin.changeCapacity();
					break;
				}
				//if Add/remove steward
				else if (adminChoice == 3)
				{
					System.out.println("Would you like to add or a remove a steward?");
					String addRemove = myScan.nextLine();
					if (addRemove.equals('a') || addRemove.equals("add"))
					{
						//call method in Admin
						createAdmin.addSteward();

						break;
					}
					else if (addRemove.equals('r') || addRemove.equals("remove"))
					{
						//call method in Admin
						createAdmin.removeSteward();
						break;
					}
				}
				//If blacklist user
				else if (adminChoice == 4)
				{
					//call blacklist user method
					createAdmin.blacklistUser();
				}
				//if print Parking Lot call the method
				else if (adminChoice == 5)
				{
					createAdmin.print();
				}
				//done --> break
				else if (adminChoice == 6)
				{
					break;

				}

			}
		}
		//User Options
		else 
		{
			//What does the user want to do, Park or Leave
			System.out.println("Do you want to park, or take your car? ('1' to park, '2' to leave)");
			int choice = myScan.nextInt();
			//Have user pick which car
			System.out.println("What car would you like to choose (1 for Truck, 2 for Sedan, 3 for SUV)");
			int type = myScan.nextInt();

			//initialize car
			Car baseCar = new Car();

			//While the car type is valid
			while (!(type == 1 || type == 2 || type == 3))
			{
				//Truck
				if (type == 1)
				{
					Truck truck1 = new Truck(type);
					baseCar = new Truck(type);
				}
				//Sedan
				else if (type == 2)
				{
					Sedan sedan1 = new Sedan(type);
					baseCar = new Sedan(type);
				}
				//SUV
				else if (type == 3)
				{
					SUV suv1 = new SUV(type);
					baseCar = new SUV (type);


				}
				else
				{
					System.out.println("Invalid");
				}
			}


			int fee = 0;
			ParkingLot pl = new ParkingLot(500);
			//IF USER WANTS TO PARK
			if (choice == 1)
			{
				//Display rates
				System.out.println("RATES****** Regular: $30");
				System.out.println("**********  Premium: $50");
				//Which lot
				System.out.println("Would you like regular or premium parking? ('regular'  or 'r' , 'premium' or 'p')");
				myScan.nextLine();
				String parking = myScan.nextLine();

				if (parking.equals("regular") || parking.equals("r"))
				{
					//Which spot
					System.out.println("Which spot do you want? (0-400)");
					int parkingSpot = myScan.nextInt();
					//If the spot isnt open then you cant park
					if(pl.isOpenRegular(parkingSpot) == true)
					{
						//re-ask for new spot
						System.out.println("Spot taken");
						System.out.println("Which spot do you want? (0-400)");
						parkingSpot = myScan.nextInt();

					}
					//else update the parking spot
					pl.updateRegular(parkingSpot, baseCar);
					fee += 30;
					

					//Add car to regular parking arrayList
					//regularParking.put
				}
				//If premium parking
				else if (parking.equals("premium") || parking.equals("p"))
				{
					//Which spot
					System.out.println("Which spot do you want? (0-100)");
					int premiumSpot = myScan.nextInt();

					//Check if the spot is open
					if(pl.isOpenPremium(premiumSpot) == true)
					{
						System.out.println("Spot taken");
						System.out.println("Which spot do you want? (0-100)");
						premiumSpot = myScan.nextInt();
					}
					pl.updatePremium(premiumSpot, baseCar);
					fee += 50;
				}
				//Once user is fully parked --> create user object
				userNFee.put(username, fee);
				User currentUser = new User(username, password, baseCar, fee);
			}
			//IF USER WANTS TO TAKE CAR
			User user = new User();
			 if (choice == 2)
			{
				 //Which lot is your car in 
				System.out.println("What lot is your car in? (Premium or Regular)");
				myScan.nextLine();
				String parking = myScan.nextLine();
				//If premium
				if (parking.equals("premium") || parking.equals("p"))
				{
					//Which spot/car do you want
					System.out.println("Which spot do you want to remove from?");
					int removeCarIndex = myScan.nextInt();
					//remove car from parking lot
					pl.removePremium(removeCarIndex);
					//Prompt user to pay bill
					System.out.println("Pay Bill: ");
					double rand = Math.random();
					//If < .2
					if (rand < .2)
					{
						//User gets a random coupon
						System.out.println("Congrats, you've recieved a coupon!");
						//take the users fee
						fee = user.getFee();
						//Apply the coupon
						fee -= stew.randomCoupon();
						user.setFee(fee);
						//Display the bill
						System.out.println("Your bill is now: " + user.getFee());
					}
					else
					{
						//No coupon --> display bill
						System.out.println("Your bill is now: " + user.getFee());
					}
					
					
				}
				else if (parking.equals("regular") || parking.equals("r")) 
				{
					//Which spot
					System.out.println("Which spot do you want to remove from?");
					int removeCarIndex = myScan.nextInt();
					//remove from list
					pl.removeRegular(removeCarIndex);
					//If coupon
					System.out.println("Pay Bill: ");
					double rand = Math.random();
					if (rand < .2)
					{	//update fee
						System.out.println("Congrats, you've recieved a coupon!");
						fee = user.getFee();
						fee -= stew.randomCoupon();
						user.setFee(fee);
						//Display Bill
						System.out.println("Your bill is now: " + user.getFee());
					}
					else
					{	//No coupon --> display bill
						System.out.println("Your bill is now: " + user.getFee());
					}
					
				}
			}
		}
	}
}
