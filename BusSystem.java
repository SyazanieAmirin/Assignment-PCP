import java.util.*;

public class BusSystem {
	
	// Variables declarations
	public String custIC, custNoPhone, custName;
	public String busBoardingDate, busBoardingTime, busType, busBrand;
	public String busSeat, busFromWhere, busToWhere;
	public int custAge;
	public double baseBusPrice = 20.00;
	public double addBusBrands, addBusTypes;
	public static double addLocations;
	public double totalFee = 0.00;
	
	// Arrays declaration
	public String busTypes[] = {"Single Decker", "Double Decker"};
	public String busTime[] = {"8AM", "12PM", "6PM", "10PM"};
	public String busBrands[] = {"Aeroline", "KKKL", "Rapid"};

	
	public static void main(String args[]) {
		
		BusSystem bus = new BusSystem();
		
		bus.MainMenu();
		bus.CustDetails();
		bus.DateAndTime();
		bus.BusDetails();
		bus.Receipt();
	}
	
	public void MainMenu() {
		
		// Left  stars
		for(int i = 0; i < 10; i++)
			System.out.print("*");
				
		// The title
		System.out.print(" Welcome To BUS Reservation System ");
				
		// Right stars
		for(int i = 0; i < 10; i++)
					System.out.print("*");
				
		// Spacer
		System.out.print("\n");
				
		// Divider
		for(int i = 0; i < 55; i++)
			System.out.print("-");
	}
	
	// Get customer's personal details
	public void CustDetails() {
			
		Scanner sc = new Scanner(System.in);
		
		System.out.println("\nYOUR DETAILS");
			
		// Customer's name
		System.out.print("    Name: ");
		custName = sc.next();
			
		// Customer's age
		System.out.print("    Age: ");
		custAge = sc.nextInt();
			
		// Customer's no.phone
		System.out.print("    Number Phone: ");
		custNoPhone = sc.next();
			
		// Customer's IC
		System.out.print("    IC: ");
		custIC = sc.next();
	}
	
	// Get customer's preferred date and time
	public void DateAndTime() {
		
		Scanner sc = new Scanner(System.in);
		
		System.out.println("\nDATE AND TIME");
		
		// Boarding date
		System.out.print("    Boarding Date [Example - 2/5/2022]: ");
		busBoardingDate = sc.nextLine();
		
		// Spacer
		System.out.println("\n    Available Times:-");
		
		// Bus time
		for(int i = 0; i < busTime.length; i++) {
			System.out.println("    [X] " + busTime[i]);
		}
		
		// Choose the time
		System.out.print("\n    Choose Time: ");
		busBoardingTime = sc.nextLine();
		
		// Set the busBoardingTime var as the array's value
		for(int i = 0; i < busTime.length; i++) {
			if(busBoardingTime.equalsIgnoreCase(busTime[i])) {
				busBoardingTime = busTime[i];
			}
		}
	}
	
	public void BusDetails() {
		
		Scanner sc = new Scanner(System.in);
		
		// -----------
		
		System.out.println("\nBUS DETAILS");
		
		// Bus brands
		System.out.print("\n    Available Brands:- \n");
		
		// Show all the bus brands
		for(int i = 0; i < busBrands.length; i++) {
			System.out.println("    [X] " + busBrands[i]);
		}
		
		System.out.print("\n    Choose bus brands: ");
		busBrand = sc.nextLine();
		
		// Call the BusBrands
		BusBrands();
		
		// Set the busBrand var as the array's value
		for(int i = 0; i < busBrands.length; i++) {
			if(busBrand.equalsIgnoreCase(busBrands[i])) {
				busBrand = busBrands[i];
			}
		}
		
		// -----------
		
		// Bus types
		System.out.print("\n    Available Types:- \n");
				
		// Show all the bus types
		for(int i = 0; i < busTypes.length; i++) {
			System.out.println("    [X] " + busTypes[i]);
		}
				
		System.out.print("\n    Choose bus types: ");
		busType = sc.nextLine();
				
		// Set the busType var as the array's value
		for(int i = 0; i < busTypes.length; i++) {
			if(busType.equalsIgnoreCase(busTypes[i])) {
				busType = busTypes[i];
			}
		}
		
		// Call the BusTypes
		BusTypes();
		
		// ------------
		// Call the class BusDestinations / constructor
		BusDestinations bd = new BusDestinations();
		
		// Set the variable to be the same as in class BusDestinations
		busFromWhere = bd.busFromWhere;
		busToWhere = bd.busToWhere;
		
	}
	
	public void BusBrands() {
		if(busBrand.equalsIgnoreCase("Rapid")) {
			addBusBrands = 5.00;
		}
		
		else if(busBrand.equalsIgnoreCase("KKKL")) {
			addBusBrands = 15.00;
		}
		
		else if(busBrand.equalsIgnoreCase("Aeroline")) {
			addBusBrands = 45.00;
		}
		
		totalFee += addBusBrands;
	}
	
	public void BusTypes() {
		if(busType.equalsIgnoreCase("Single Decker")) {
			addBusTypes = 0.00;
		}
		
		else if(busType.equalsIgnoreCase("Double Decker")) {
			addBusTypes = 20.00;
		}
		
		totalFee += addBusTypes;

	}
	
	public void Seatings() {
		// Get random numbers for the seating numbers
		int min = 1;
		int max = 25;
		int randNum = (int) (Math.random() * (max-min + 1) + min);
				
		// Declare all the seatings' alphabets
		String seatingsAlphabets[] = {"A", "B", "C", "D", "E", "F", "G", "H", "I", "J", "K", "L", "M", "N", "O", "P", "Q", "R", "S", "T", "U", "V", "W", "X", "Y", "Z"};
				
		// Get random numbers of alphabets' position
		int minSeat = 0;
		int maxSeat = 25;
		int randSeat = 	(int) (Math.random() * (maxSeat-minSeat + 1) + minSeat);
				
		// Set the airlineSeat
		busSeat = randNum + seatingsAlphabets[randSeat];
	}
	
	public void Receipt() {
		
		System.out.println("\nRECEIPT");
		
		// Total fee plus baseBusPrice and addLocations
		totalFee += (baseBusPrice + addLocations);
		
		// Call the seatings function
		Seatings();
		
		// Bus receipts
		System.out.print("\n    Base Price = RM" + baseBusPrice);
		System.out.print("\n    Boarding Date = " + busBoardingDate);
		System.out.print("\n    Boarding Time = " + busBoardingTime);
		System.out.print("\n    Seat Assigned = " + busSeat);
		System.out.print("\n    From = " + busFromWhere);
		System.out.print("\n    To = " + busToWhere);
		System.out.print("\n    Bus Brand = " + busBrand);
		System.out.print("\n    Base Type = " + busType);
		System.out.print("\n    Extra Charge for Bus Brand = RM" + addBusBrands);
		System.out.print("\n    ExtraCharge for Bus Type = RM" + addBusTypes);
		System.out.print("\n    Extra Charge for Bus Locations = RM" + addLocations);
		System.out.print("\n    --------------------------------------------------");
		System.out.print("\n    Total = RM" + totalFee);

	}

}
