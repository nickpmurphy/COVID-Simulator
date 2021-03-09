
package internalSystem;
import java.util.ArrayList;
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
public class ParkingLot 
{

	private static int regularSize;
	private static int premiumSize;

	private int numOfSpaces;
	private final static ArrayList <Car> premiumLot = new ArrayList <>(regularSize); 
	private final static ArrayList <Car> regularLot = new ArrayList <>(premiumSize);
	private static ArrayList <ArrayList<Car>> allLots = new ArrayList<>(15);

	Scanner myScan = new Scanner(System.in);



	//Creates the parking lot
	public ParkingLot(int nos)
	{
		setPremiumSize(100);
		setRegularSize(400);
		
		setNumOfSpaces(nos);
		allLots.add(0, premiumLot);
		allLots.add(1, regularLot);
	}

	public int getPremiumSize() {
		return premiumSize;
	}

	public void setPremiumSize(int premiumSize) {
		this.premiumSize = premiumSize;
	}

	public int getRegularSize() {
		return regularSize;
	}

	public void setRegularSize(int regularSize) {
		this.regularSize = regularSize;
	}

	public static ArrayList <ArrayList<Car>> getAllLots() {
		return allLots;
	}

	public static void setAllLots(ArrayList <ArrayList<Car>> allLots) {
		ParkingLot.allLots = allLots;
	}



	public int getNumOfSpaces() {
		return numOfSpaces;
	}

	public void setNumOfSpaces(int numOfSpaces) {
		this.numOfSpaces = numOfSpaces;
	}


	public void updateRegular(int space, Car car)
	{
		regularLot.set(space, car);


	}

	public void updatePremium(int space, Car car)
	{
		premiumLot.set(space, car);

	}

	//Only accessible by Admin
	public void removeRegular(int space)
	{
		regularLot.remove(space);

	}

	public void removePremium(int space)
	{
		premiumLot.remove(space);

	}

	public boolean isOpenRegular(int space)
	{
		//loop through the regular lots
		for (int i = 0; i < regularLot.size(); i++)
		{
			//if there isn't an instance of any car --> space is open
			if (regularLot.get(i) instanceof SUV || regularLot.get(i) instanceof Truck || regularLot.get(i) instanceof Sedan)
			{
				return true;
			}
			else
			{
				return false;
			}
		}

		return false;
	}

	public boolean isOpenPremium(int space)
	{
		//loop throught the lot
		for (int i = 0; i < premiumLot.size(); i++)
		{
			//if there isn't an instance of any car --> space is open
			if (premiumLot.get(i) instanceof SUV || premiumLot.get(i) instanceof Truck || premiumLot.get(i) instanceof Sedan)
			{
				return true;
			}
			else
			{
				
				return false;
			}
		}

		return false;
	}

	public void addRegularLot(int spot)
	{
		//add to list
		allLots.set(spot, regularLot);

	}

	public void addPremiumLot(int spot)
	{
		//add to list
		allLots.set(spot, premiumLot);

	}

	public void removeRegularLot(int spot)
	{
		//remove from list
		allLots.remove(spot);

	}

	public void removePremiumLot(int spot)
	{
		//remove from list
		allLots.remove(spot);

	}

	//returns the String of the Parking lot (Take map and give string)
	public String toString()
	{
		//which lot to print
		System.out.println("What lot do you want to print?");
		int whichLot = myScan.nextInt();
		//get the array, set it to new array (identical)
		ArrayList <Car> toStringList = new ArrayList <>();
		toStringList = allLots.get(whichLot);
		
		String wholeString = "";
		//loop through array
		System.out.println(toStringList.toString());
		for (int i = 0; i < toStringList.size(); i++)
		{

			//After 10 cars --> new row
			if (i % 10 == 0)
			{
				System.out.println();
				wholeString += "\n";
			}
			//if the car in the space is a SUV --> show ascii art of rectangle with space # and SUV
				if (toStringList.get(i) instanceof SUV )
				{
				
					System.out.print("*************" + "\n" + "**" + i + "**" + "\n" +"**         **" + "\n"		+	"**   SUV   **" + "\n" + "*************");
					wholeString += ("*************" + "\n" + "**" + i + "**" + "\n" +"**         **" + "\n"		+	"**   SUV   **" + "\n" + "*************");
				}
				//if the car in the space is a Truck --> show ascii art of rectangle with space # and Truck
				else if (toStringList.get(i) instanceof Truck) 
				{
					System.out.print(("*************" + "\n" + "**" + i + "**" + "\n" +"**         **" + "\n"		+	"**   Truck   **" + "\n" + "*************"));
					wholeString += ("*************" + "\n" + "**" + i + "**" + "\n" +"**         **" + "\n"		+	"**   Truck   **" + "\n" + "*************");
				}	
				//if the car in the space is a Sedan --> show ascii art of rectangle with space # and Sedan
				else if (toStringList.get(i) instanceof Sedan)
				{
					System.out.print(("*************" + "\n" + "**" + i + "**" + "\n" +"**         **" + "\n"		+	"**   Sedan   **" + "\n" + "*************"));
					wholeString += ("*************" + "\n" + "**" + i + "**" + "\n" +"**         **" + "\n"		+	"**   Sedan   **" + "\n" + "*************");
				}
				
				else 
				{
					wholeString += ("*************" + "\n" + "**" + i + "**" + "\n" +"**         **" + "\n"		+	"**   EMPTY   **" + "\n" + "*************");
					System.out.print(("*************" + "\n" + "**" + i + "**" + "\n" +"**         **" + "\n"		+	"**   EMPTY   **" + "\n" + "*************"));
				}
			

		}

		return wholeString;
	}
}
