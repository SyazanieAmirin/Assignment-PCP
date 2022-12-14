import java.util.*;

public class airline {
	
	// Variables declaration
	public static String custIC, custNoPhone, custName, custDate, custDestinationFromWhere, custDestinationToWhere, custSeatClass;
	public static String departingTime, arrivalTime;
	public static String classType;
	public static int custAge;
	public static double baseFlightPrice = 70.00, additionalPriceBetweenAirports = 5.00, sumOfFlightPrice;
	
	// Arrays declaration
	public static String airportDestination[] = {"KLIA", "Langkawi", "Kuching", "Penang", "KK", "Senai"};
	public static String timeFrame[] = {"0000 - 0500", "0600 - 1200", "1300 - 1800", "1900 - 1159"};
	public static String flightList[] = {"MAS", "AirAsia", "Batik"};
	
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
		airline airs = new airline();
		airline tuah = new airline();
		
		airs.custAge = 5;
		tuah.custAge = 10;
		airs.custAge = 15;
		
		System.out.println("\n" + airs.custAge + tuah.custAge);
		
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
		
		System.out.print("    Price: RM70.00 + " + additionalPriceBetweenAirports + " = RM" + sumOfFlightPrice);
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
		
		System.out.print("    Price: RM70.00 + " + additionalPriceBetweenAirports + " = RM" + sumOfFlightPrice);
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
			
		System.out.print("    Price: RM70.00 + " + additionalPriceBetweenAirports + " = RM" + sumOfFlightPrice);
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
				
		System.out.print("    Price: RM70.00 + " + additionalPriceBetweenAirports + " = RM" + sumOfFlightPrice);
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
					
		System.out.print("    Price: RM70.00 + " + additionalPriceBetweenAirports + " = RM" + sumOfFlightPrice);
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
						
		System.out.print("    Price: RM70.00 + " + additionalPriceBetweenAirports + " = RM" + sumOfFlightPrice);
	}
}

// Flight details
// Makanan - Wifi - Same shit
// Class (Economy, Biz, First)
// 
