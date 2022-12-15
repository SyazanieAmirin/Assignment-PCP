import java.util.*;

public class airline {
	
	// Variables declaration
	public static String custIC, custNoPhone, custName, custDate, custDestinationFromWhere, custDestinationToWhere, custSeatClass;
	public static String custAirline;
	public static String departingTime, arrivalTime;
	public static String classType;
	public static int custAge;
	public static double baseFlightPrice = 70.00, additionalPriceBetweenAirports = 0.00, sumOfFlightPrice;
	public static double additionalPriceBetweenTimeFrame = 0.00, additionalPriceBetweenAirlines = 0.00;
	public static double additionalPriceBetweenClasses = 0.00, additionalPriceBetweenAges = 0.00;
	public static double additionalPriceOfAddon = 0.00;
	// Important: sumOfFlightPrice
	
	// Arrays declaration
	public static String airportDestination[] = {"KLIA", "Langkawi", "Kuching", "Penang", "KK", "Senai"};
	public static String airlinesType[] = {"MAS", "AirAsia", "Batik"};
	public static String airlineClassType[] = {"Economy", "First Class", "Business Class"};

	
	// Others declaration
	// This is just a list of airport locations
	public static String airportLocations = "(KLIA/Langkawi/Kuching/Penang/KK/Senai)";
	
	// Boolean declarations
	public static boolean isLuggage = false, isAddon = false;
	
	public static void main(String args[]) {
		MainMenu();
		CustDetails();
		FlightDetails();
	}
	
	public static void MainMenu() {
		
		// Left side stars
		for(int i = 0; i < 10; i++)
			System.out.print("*");
		
		// Main title
		System.out.print(" Welcome To TUAH Reservation System ");
		
		// Right side stars
		for(int i = 0; i < 10; i++)
			System.out.print("*");
		
		// Spacing before divider
		System.out.print("\n");
		
		// Divider
		for(int i = 0; i < 45; i++)
			System.out.print("-");
	}
	
	// Get customer's personal details
	public static void CustDetails() {
		
		Scanner sc = new Scanner(System.in);
	
		System.out.println("\nCUSTOMER DETAILS");
		
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
	
	// All about the flights
	public static void FlightDetails() {
		
		Scanner sc = new Scanner(System.in);
		
		System.out.println("\n FLIGHT DETAILS");
		
		// Customer's Date of Departure
		System.out.print("    Date of Departure (DD/MM/YYYY): ");
		custDate = sc.next();
				
				
		// Customer's Departure Location
		System.out.print("    Departing From  " + airportLocations + ": ");
		custDestinationFromWhere = sc.next();
		
		// Check to get the destination of departure
		for(int i = 0; i < airportDestination.length; i++) {
			if(custDestinationFromWhere.equals(airportDestination[i])) {
				custDestinationFromWhere = airportDestination[i];
			}
		}
		
		CustomerFromWhere();
		CustomerToWhere();
		FlightPrice();
		AirlineTypes();
		AirlineTime();
		AirlineClassType();
		AirlineCustomerAgeType();
	}
	
	// Get customer's destination of departure
	public static void CustomerFromWhere() {
		
		Scanner sc = new Scanner(System.in);
				
		// Check if Senai is the selected answer
		if(custDestinationFromWhere.equals("Senai")) {
			airportLocations = airportLocations.replace("/Senai", "");
		}
		
		// If KLIA is the selected answer
		else if(custDestinationFromWhere.equals("KLIA")) {
			airportLocations = airportLocations.replace("KLIA/", "");
		}
		
		// Other than KLIA and Senai. This one will remove the airport's name
		else
			airportLocations = airportLocations.replace(custDestinationFromWhere, "");

		// Remove the double slash after removing the airport's name
		airportLocations = airportLocations.replace("//", "/");
	}
	
	// Get customer's destination of arrival
	public static void CustomerToWhere() {
		
		Scanner sc = new Scanner(System.in);
		
		// Asking the user on where they want to go
		System.out.print("    To  " + airportLocations + ": ");
		custDestinationToWhere = sc.next();
	}
	
	// Show prices according to customer's destination of departure
	public static void FlightPrice() {

		if(custDestinationFromWhere == "KLIA") {
			FlightFromKLIA();
		}
		
		else if(custDestinationFromWhere == "Langkawi") {
			FlightFromLangkawi();
		}
		
		else if(custDestinationFromWhere == "Kuching") {
			FlightFromKuching();
		}
		
		else if(custDestinationFromWhere == "Penang") {
			FlightFromPenang();
		}
		
		else if(custDestinationFromWhere == "KK") {
			FlightFromKK();
		}
		
		else if(custDestinationFromWhere == "Senai") {
			FlightFromSenai();
		}
		
		else {
			System.out.println("Airport location is not valid. Please try again.");
		}
	}
	
		// KLIA
		public static void FlightFromKLIA() {
							
			if(custDestinationToWhere.equals("Langkawi")) {
				
				additionalPriceBetweenAirports = 10.00;
				sumOfFlightPrice = baseFlightPrice + additionalPriceBetweenAirports;
			}
			
			if(custDestinationToWhere.equals("Kuching")) {
				additionalPriceBetweenAirports = 50.00;
				sumOfFlightPrice = baseFlightPrice + additionalPriceBetweenAirports;
			}
			
			if(custDestinationToWhere.equals("Penang")) {
				additionalPriceBetweenAirports = 5.00;
				sumOfFlightPrice = baseFlightPrice + additionalPriceBetweenAirports;
			}
			
			if(custDestinationToWhere.equals("KK")) {
				additionalPriceBetweenAirports = 55.00;
				sumOfFlightPrice = baseFlightPrice + additionalPriceBetweenAirports;
			}
			
			if(custDestinationToWhere.equals("Senai")) {
				additionalPriceBetweenAirports = 5.00;
				sumOfFlightPrice = baseFlightPrice + additionalPriceBetweenAirports;
			}
			
			// System.out.print("    Price: RM70.00 + " + additionalPriceBetweenAirports + " = RM" + sumOfFlightPrice);
		}
		
		// Langkawi
		public static void FlightFromLangkawi() {
			
			if(custDestinationToWhere.equals("KLIA")) {
				
				additionalPriceBetweenAirports = 10.00;
				sumOfFlightPrice = baseFlightPrice + additionalPriceBetweenAirports;
			}
			
			if(custDestinationToWhere.equals("Kuching")) {
				additionalPriceBetweenAirports = 70.00;
				sumOfFlightPrice = baseFlightPrice + additionalPriceBetweenAirports;
			}
			
			if(custDestinationToWhere.equals("Penang")) {
				additionalPriceBetweenAirports = 5.00;
				sumOfFlightPrice = baseFlightPrice + additionalPriceBetweenAirports;
			}
			
			if(custDestinationToWhere.equals("KK")) {
				additionalPriceBetweenAirports = 75.00;
				sumOfFlightPrice = baseFlightPrice + additionalPriceBetweenAirports;
			}
			
			if(custDestinationToWhere.equals("Senai")) {
				additionalPriceBetweenAirports = 15.00;
				sumOfFlightPrice = baseFlightPrice + additionalPriceBetweenAirports;
			}
			
			// System.out.print("    Price: RM70.00 + " + additionalPriceBetweenAirports + " = RM" + sumOfFlightPrice);
		}
		
		// Kuching
		public static void FlightFromKuching() {
				
			if(custDestinationToWhere.equals("KLIA")) {
					
				additionalPriceBetweenAirports = 50.00;
				sumOfFlightPrice = baseFlightPrice + additionalPriceBetweenAirports;
			}
				
			if(custDestinationToWhere.equals("Langkawi")) {
				additionalPriceBetweenAirports = 70.00;
				sumOfFlightPrice = baseFlightPrice + additionalPriceBetweenAirports;
			}
				
			if(custDestinationToWhere.equals("Penang")) {
				additionalPriceBetweenAirports = 60.00;
				sumOfFlightPrice = baseFlightPrice + additionalPriceBetweenAirports;
			}
				
			if(custDestinationToWhere.equals("KK")) {
				additionalPriceBetweenAirports = 5.00;
				sumOfFlightPrice = baseFlightPrice + additionalPriceBetweenAirports;
			}
				
			if(custDestinationToWhere.equals("Senai")) {
				additionalPriceBetweenAirports = 30.00;
				sumOfFlightPrice = baseFlightPrice + additionalPriceBetweenAirports;
			}
				
			// System.out.print("    Price: RM70.00 + " + additionalPriceBetweenAirports + " = RM" + sumOfFlightPrice);
		}
		
		// Penang
		public static void FlightFromPenang() {
					
			if(custDestinationToWhere.equals("KLIA")) {
						
				additionalPriceBetweenAirports = 5.00;
				sumOfFlightPrice = baseFlightPrice + additionalPriceBetweenAirports;
			}
				
			if(custDestinationToWhere.equals("Langkawi")) {
				additionalPriceBetweenAirports = 5.00;
				sumOfFlightPrice = baseFlightPrice + additionalPriceBetweenAirports;
			}
					
			if(custDestinationToWhere.equals("Kuching")) {
				additionalPriceBetweenAirports = 60.00;
				sumOfFlightPrice = baseFlightPrice + additionalPriceBetweenAirports;
			}
					
			if(custDestinationToWhere.equals("KK")) {
				additionalPriceBetweenAirports = 60.00;
				sumOfFlightPrice = baseFlightPrice + additionalPriceBetweenAirports;
			}
					
			if(custDestinationToWhere.equals("Senai")) {
				additionalPriceBetweenAirports = 20.00;
				sumOfFlightPrice = baseFlightPrice + additionalPriceBetweenAirports;
			}
					
			// System.out.print("    Price: RM70.00 + " + additionalPriceBetweenAirports + " = RM" + sumOfFlightPrice);
		}
		
		// Kota Kinabalu
		public static void FlightFromKK() {
						
			if(custDestinationToWhere.equals("KLIA")) {
						
				additionalPriceBetweenAirports = 55.00;
				sumOfFlightPrice = baseFlightPrice + additionalPriceBetweenAirports;
			}
					
			if(custDestinationToWhere.equals("Langkawi")) {
				additionalPriceBetweenAirports = 75.00;
				sumOfFlightPrice = baseFlightPrice + additionalPriceBetweenAirports;
			}
						
			if(custDestinationToWhere.equals("Kuching")) {
				additionalPriceBetweenAirports = 10.00;
				sumOfFlightPrice = baseFlightPrice + additionalPriceBetweenAirports;
			}
					
			if(custDestinationToWhere.equals("Penang")) {
				additionalPriceBetweenAirports = 60.00;
				sumOfFlightPrice = baseFlightPrice + additionalPriceBetweenAirports;
			}
					
			if(custDestinationToWhere.equals("Senai")) {
				additionalPriceBetweenAirports = 30.00;
				sumOfFlightPrice = baseFlightPrice + additionalPriceBetweenAirports;
			}
						
			// System.out.print("    Price: RM70.00 + " + additionalPriceBetweenAirports + " = RM" + sumOfFlightPrice);
		}
		
		// Senai
		public static void FlightFromSenai() {
						
		if(custDestinationToWhere.equals("KLIA")) {
						
			additionalPriceBetweenAirports = 5.00;
			sumOfFlightPrice = baseFlightPrice + additionalPriceBetweenAirports;
		}
					
		if(custDestinationToWhere.equals("Langkawi")) {
			additionalPriceBetweenAirports = 15.00;
			sumOfFlightPrice = baseFlightPrice + additionalPriceBetweenAirports;
		}
						
		if(custDestinationToWhere.equals("Kuching")) {
			additionalPriceBetweenAirports = 30.00;
			sumOfFlightPrice = baseFlightPrice + additionalPriceBetweenAirports;
		}
				
		if(custDestinationToWhere.equals("Penang")) {
			additionalPriceBetweenAirports = 20.00;
			sumOfFlightPrice = baseFlightPrice + additionalPriceBetweenAirports;
		}
					
		if(custDestinationToWhere.equals("KK")) {
			additionalPriceBetweenAirports = 30.00;
			sumOfFlightPrice = baseFlightPrice + additionalPriceBetweenAirports;
		}
		
		// System.out.print("    Price: RM70.00 + " + additionalPriceBetweenAirports + " = RM" + sumOfFlightPrice);
						
	}
	
	public static void AirlineTypes() {
		
		Scanner sc = new Scanner(System.in);
		
		//For numbered bullet points
		int j = 1;
		
		System.out.println("\n    Available Airlines ");
		
		// Shows all available airlines.
		for(int i = 0; i < airlinesType.length; i++) {
			
			System.out.println("       " + j + ". " + airlinesType[i]);
			j++;
			
		}
		
		System.out.print("\n    Chosen Airline: ");
		custAirline = sc.next();
		
		// To set the customer's selected airline
			/*
			 [0] - MAS
			 [1] - AirAsia
			 [2] - Batik 
			 */
		for(int i = 0; i < airlinesType.length; i++) {
			if(custAirline.equals(airlinesType[i])) {
				custAirline = airlinesType[i];
			}
		}
		
		// MAS
		if(custAirline.equals("MAS")) {
			
			additionalPriceBetweenAirlines = 100.00;
			sumOfFlightPrice += additionalPriceBetweenAirlines;			
		}
		
		// AirAsia
		else if(custAirline.equals("AirAsia")) {
			
			additionalPriceBetweenAirlines = 50.00;
			sumOfFlightPrice += additionalPriceBetweenAirlines;			
		}
		
		// Batik (Malindo)
		else if(custAirline.equals("Batik")) {
			
			additionalPriceBetweenAirlines = 20.00;
			sumOfFlightPrice += additionalPriceBetweenAirlines;			
		}
		
		// If none
		else {
			System.out.println("Airline you have selected is not available. Please try again.");
		}
		
		System.out.println("\n    Price: " + sumOfFlightPrice);

	}
	
	public static void AirlineTime() {
		
		// Tanya depa mcm mn nk bg lg okie part ni. Sbb arrival time xde estimation
		
		Scanner sc = new Scanner(System.in);
		
		System.out.println("\n    Your chosen date: " + custDate);
		
		// Just save it as a string. No calculations involved.
		System.out.print("    Your preffered depart time [24 Hours format - Ex. 15:45: ");
		departingTime = sc.next();
		
	}
	
	public static void AirlineClassType() {
		
		Scanner sc = new Scanner(System.in);
		
		// For numbered bullet points 
		int j = 1;
		
		System.out.println("\n    Available Classes -");
		
		// To show all the available class in that particular airline. Economy, etc
		for(int i = 0; i < airlineClassType.length; i++) {
			System.out.println("    " + j + ". " + airlineClassType[i]);
			j++;
		}
		
		System.out.print("\nAirline Class: ");
		classType = sc.next();
		
		if(classType.equals("Economy")) {
			additionalPriceBetweenClasses = 0.00;
			sumOfFlightPrice += additionalPriceBetweenClasses;
		}
		
		else if(classType.equals("First Class")) {
			additionalPriceBetweenClasses = 50.00;
			sumOfFlightPrice += additionalPriceBetweenClasses;
		}
		
		else if(classType.equals("Business Class")) {
			additionalPriceBetweenClasses = 100.00;
			sumOfFlightPrice += additionalPriceBetweenClasses;
		}
		
		else {
			System.out.println("Class that you have selected in not valid. Please try again.");
		}
	}
	
	public static void AirlineCustomerAgeType() {
		// Customer age 12
		if(custAge < 13) {
			additionalPriceBetweenAges = 0.00;
		}
		
		if(custAge < 51) {
			additionalPriceBetweenAges = 10.00;
		}
		
		if(custAge >= 51) {
			additionalPriceBetweenAges = 5.00;
		}
	}
}

// Flight details
//Makanan - Wifi - Same shit
// Class (Economy, Biz, First)
// 
