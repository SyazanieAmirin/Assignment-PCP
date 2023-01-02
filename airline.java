import java.util.*;

public class airline {
	
	// Variables declaration
	public String custIC, custNoPhone, custName, custDate, custDestinationFromWhere, custDestinationToWhere;
	public String custAirline, departingTime, classType, addonStatus;
	public String airlineSeat;
	public int airlineGate;
	public int custAge;
	public double baseFlightPrice = 70.00, additionalPriceBetweenAirports = 0.00;
	public double additionalPriceBetweenAirlines = 0.00;
	public double additionalPriceBetweenClasses = 0.00, additionalPriceBetweenAges = 0.00;
	public double additionalPriceOfAddon = 0.00, additionalPriceOfLuggages = 0.00;
	public double luggagesWeightOverall;
	public double sumOfFlightPrice;
	// Important: sumOfFlightPrice
	
	// Arrays declaration
	public String airportDestination[] = {"KLIA", "Langkawi", "Kuching", "Penang", "KK", "Senai"};
	public String airlinesType[] = {"MAS", "AirAsia", "Batik"};
	public String airlineClassType[] = {"Economy", "First Class", "Business Class"};

	
	// Others declaration
	// This is just a list of airport locations
	public String airportLocations = "(KLIA/Langkawi/Kuching/Penang/KK/Senai)";
	
	// Boolean declarations
	public boolean isAddon = false;
	
	public static void main(String args[]) {
		
		// Constructor of current class
		airline air = new airline();
		
		// Need to put air. because this main function is static
		air.MainMenu();
		air.CustDetails();
		air.FlightDetails();
		air.AirlineTickets();
		air.AirlinePrices();
	}
	
	public void MainMenu() {
		
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
	public void CustDetails() {
		
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
	public void FlightDetails() {
		
		double luggagesWeight;
		
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
			if(custDestinationFromWhere.equalsIgnoreCase(airportDestination[i])) {
				custDestinationFromWhere = airportDestination[i];
			}
		}
		
		// Functions that only related to airlines are called here
		CustomerFromWhere();
		CustomerToWhere();
		FlightPrice();
		AirlineTypes();
		AirlineTime();
		AirlineClassType();
		AirlineAddons();
		
		System.out.println("\nLUGGAGES");
		
		System.out.print("    Luggages weight [IN KG]: ");
		luggagesWeight = sc.nextDouble();
		
		// Get luggages weight
		AirlineLuggages(luggagesWeight);
		AirlineSeating();
		AirlineGate();
		
	}
	
	// Get customer's destination of departure
	public void CustomerFromWhere() {
		
		Scanner sc = new Scanner(System.in);
				
		// Check if Senai is the selected answer
		if(custDestinationFromWhere.equalsIgnoreCase("Senai")) {
			airportLocations = airportLocations.replace("/Senai", "");
		}
		
		// If KLIA is the selected answer
		else if(custDestinationFromWhere.equalsIgnoreCase("KLIA")) {
			airportLocations = airportLocations.replace("KLIA/", "");
		}
		
		// Other than KLIA and Senai. This one will remove the airport's name
		else
			airportLocations = airportLocations.replace(custDestinationFromWhere, "");

		// Remove the double slash after removing the airport's name
		airportLocations = airportLocations.replace("//", "/");
	}
	
	// Get customer's destination of arrival
	public void CustomerToWhere() {
		
		Scanner sc = new Scanner(System.in);
		
		// Asking the user on where they want to go
		System.out.print("    To  " + airportLocations + ": ");
		custDestinationToWhere = sc.next();
	}
	
	// Show prices according to customer's destination of departure
	public void FlightPrice() {

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
		public void FlightFromKLIA() {
							
			if(custDestinationToWhere.equalsIgnoreCase("Langkawi")) {
				
				additionalPriceBetweenAirports = 10.00;
				sumOfFlightPrice = baseFlightPrice + additionalPriceBetweenAirports;
			}
			
			if(custDestinationToWhere.equalsIgnoreCase("Kuching")) {
				additionalPriceBetweenAirports = 50.00;
				sumOfFlightPrice = baseFlightPrice + additionalPriceBetweenAirports;
			}
			
			if(custDestinationToWhere.equalsIgnoreCase("Penang")) {
				additionalPriceBetweenAirports = 5.00;
				sumOfFlightPrice = baseFlightPrice + additionalPriceBetweenAirports;
			}
			
			if(custDestinationToWhere.equalsIgnoreCase("KK")) {
				additionalPriceBetweenAirports = 55.00;
				sumOfFlightPrice = baseFlightPrice + additionalPriceBetweenAirports;
			}
			
			if(custDestinationToWhere.equalsIgnoreCase("Senai")) {
				additionalPriceBetweenAirports = 5.00;
				sumOfFlightPrice = baseFlightPrice + additionalPriceBetweenAirports;
			}
			
			// System.out.print("    Price: RM70.00 + " + additionalPriceBetweenAirports + " = RM" + sumOfFlightPrice);
		}
		
		// Langkawi
		public void FlightFromLangkawi() {
			
			if(custDestinationToWhere.equalsIgnoreCase("KLIA")) {
				
				additionalPriceBetweenAirports = 10.00;
				sumOfFlightPrice = baseFlightPrice + additionalPriceBetweenAirports;
			}
			
			if(custDestinationToWhere.equalsIgnoreCase("Kuching")) {
				additionalPriceBetweenAirports = 70.00;
				sumOfFlightPrice = baseFlightPrice + additionalPriceBetweenAirports;
			}
			
			if(custDestinationToWhere.equalsIgnoreCase("Penang")) {
				additionalPriceBetweenAirports = 5.00;
				sumOfFlightPrice = baseFlightPrice + additionalPriceBetweenAirports;
			}
			
			if(custDestinationToWhere.equalsIgnoreCase("KK")) {
				additionalPriceBetweenAirports = 75.00;
				sumOfFlightPrice = baseFlightPrice + additionalPriceBetweenAirports;
			}
			
			if(custDestinationToWhere.equalsIgnoreCase("Senai")) {
				additionalPriceBetweenAirports = 15.00;
				sumOfFlightPrice = baseFlightPrice + additionalPriceBetweenAirports;
			}
			
			// System.out.print("    Price: RM70.00 + " + additionalPriceBetweenAirports + " = RM" + sumOfFlightPrice);
		}
		
		// Kuching
		public void FlightFromKuching() {
				
			if(custDestinationToWhere.equalsIgnoreCase("KLIA")) {
					
				additionalPriceBetweenAirports = 50.00;
				sumOfFlightPrice = baseFlightPrice + additionalPriceBetweenAirports;
			}
				
			if(custDestinationToWhere.equalsIgnoreCase("Langkawi")) {
				additionalPriceBetweenAirports = 70.00;
				sumOfFlightPrice = baseFlightPrice + additionalPriceBetweenAirports;
			}
				
			if(custDestinationToWhere.equalsIgnoreCase("Penang")) {
				additionalPriceBetweenAirports = 60.00;
				sumOfFlightPrice = baseFlightPrice + additionalPriceBetweenAirports;
			}
				
			if(custDestinationToWhere.equalsIgnoreCase("KK")) {
				additionalPriceBetweenAirports = 5.00;
				sumOfFlightPrice = baseFlightPrice + additionalPriceBetweenAirports;
			}
				
			if(custDestinationToWhere.equalsIgnoreCase("Senai")) {
				additionalPriceBetweenAirports = 30.00;
				sumOfFlightPrice = baseFlightPrice + additionalPriceBetweenAirports;
			}
				
			// System.out.print("    Price: RM70.00 + " + additionalPriceBetweenAirports + " = RM" + sumOfFlightPrice);
		}
		
		// Penang
		public void FlightFromPenang() {
					
			if(custDestinationToWhere.equalsIgnoreCase("KLIA")) {
						
				additionalPriceBetweenAirports = 5.00;
				sumOfFlightPrice = baseFlightPrice + additionalPriceBetweenAirports;
			}
				
			if(custDestinationToWhere.equalsIgnoreCase("Langkawi")) {
				additionalPriceBetweenAirports = 5.00;
				sumOfFlightPrice = baseFlightPrice + additionalPriceBetweenAirports;
			}
					
			if(custDestinationToWhere.equalsIgnoreCase("Kuching")) {
				additionalPriceBetweenAirports = 60.00;
				sumOfFlightPrice = baseFlightPrice + additionalPriceBetweenAirports;
			}
					
			if(custDestinationToWhere.equalsIgnoreCase("KK")) {
				additionalPriceBetweenAirports = 60.00;
				sumOfFlightPrice = baseFlightPrice + additionalPriceBetweenAirports;
			}
					
			if(custDestinationToWhere.equalsIgnoreCase("Senai")) {
				additionalPriceBetweenAirports = 20.00;
				sumOfFlightPrice = baseFlightPrice + additionalPriceBetweenAirports;
			}
					
			// System.out.print("    Price: RM70.00 + " + additionalPriceBetweenAirports + " = RM" + sumOfFlightPrice);
		}
		
		// Kota Kinabalu
		public void FlightFromKK() {
						
			if(custDestinationToWhere.equalsIgnoreCase("KLIA")) {
						
				additionalPriceBetweenAirports = 55.00;
				sumOfFlightPrice = baseFlightPrice + additionalPriceBetweenAirports;
			}
					
			if(custDestinationToWhere.equalsIgnoreCase("Langkawi")) {
				additionalPriceBetweenAirports = 75.00;
				sumOfFlightPrice = baseFlightPrice + additionalPriceBetweenAirports;
			}
						
			if(custDestinationToWhere.equalsIgnoreCase("Kuching")) {
				additionalPriceBetweenAirports = 10.00;
				sumOfFlightPrice = baseFlightPrice + additionalPriceBetweenAirports;
			}
					
			if(custDestinationToWhere.equalsIgnoreCase("Penang")) {
				additionalPriceBetweenAirports = 60.00;
				sumOfFlightPrice = baseFlightPrice + additionalPriceBetweenAirports;
			}
					
			if(custDestinationToWhere.equalsIgnoreCase("Senai")) {
				additionalPriceBetweenAirports = 30.00;
				sumOfFlightPrice = baseFlightPrice + additionalPriceBetweenAirports;
			}
						
			// System.out.print("    Price: RM70.00 + " + additionalPriceBetweenAirports + " = RM" + sumOfFlightPrice);
		}
		
		// Senai
		public void FlightFromSenai() {
						
		if(custDestinationToWhere.equalsIgnoreCase("KLIA")) {
						
			additionalPriceBetweenAirports = 5.00;
			sumOfFlightPrice = baseFlightPrice + additionalPriceBetweenAirports;
		}
					
		if(custDestinationToWhere.equalsIgnoreCase("Langkawi")) {
			additionalPriceBetweenAirports = 15.00;
			sumOfFlightPrice = baseFlightPrice + additionalPriceBetweenAirports;
		}
						
		if(custDestinationToWhere.equalsIgnoreCase("Kuching")) {
			additionalPriceBetweenAirports = 30.00;
			sumOfFlightPrice = baseFlightPrice + additionalPriceBetweenAirports;
		}
				
		if(custDestinationToWhere.equalsIgnoreCase("Penang")) {
			additionalPriceBetweenAirports = 20.00;
			sumOfFlightPrice = baseFlightPrice + additionalPriceBetweenAirports;
		}
					
		if(custDestinationToWhere.equalsIgnoreCase("KK")) {
			additionalPriceBetweenAirports = 30.00;
			sumOfFlightPrice = baseFlightPrice + additionalPriceBetweenAirports;
		}
		
		// System.out.print("    Price: RM70.00 + " + additionalPriceBetweenAirports + " = RM" + sumOfFlightPrice);
						
	}
	
	public void AirlineTypes() {
		
		Scanner sc = new Scanner(System.in);
		
		//For numbered bullet points
		int j = 1;
		
		System.out.println("\nAIRLINES");
		
		System.out.println("    Available Airlines -");
		
		// Shows all available airlines.
		for(int i = 0; i < airlinesType.length; i++) {
			
			System.out.println("       " + j + ". " + airlinesType[i]);
			j++;
			
		}
		
		// Get the chosen airline by the user
		System.out.print("\n    Airline [Write its name]: ");
		custAirline = sc.next();
		
		// To set the customer's selected airline
			/*
			 [0] - MAS
			 [1] - AirAsia
			 [2] - Batik 
			 */
		for(int i = 0; i < airlinesType.length; i++) {
			if(custAirline.equalsIgnoreCase(airlinesType[i])) {
				custAirline = airlinesType[i];
			}
		}
		
		// MAS
		if(custAirline.equalsIgnoreCase("MAS")) {
			
			additionalPriceBetweenAirlines = 100.00;
			sumOfFlightPrice += additionalPriceBetweenAirlines;			
		}
		
		// AirAsia
		else if(custAirline.equalsIgnoreCase("AirAsia")) {
			
			additionalPriceBetweenAirlines = 50.00;
			sumOfFlightPrice += additionalPriceBetweenAirlines;			
		}
		
		// Batik (Malindo)
		else if(custAirline.equalsIgnoreCase("Batik")) {
			
			additionalPriceBetweenAirlines = 20.00;
			sumOfFlightPrice += additionalPriceBetweenAirlines;			
		}
		
		// If none
		else {
			System.out.println("Airline you have selected is not available. Please try again.");
		}
		
		// System.out.println("\n    Price: " + sumOfFlightPrice);

	}
	
	public void AirlineTime() {
		
		// Tanya depa mcm mn nk bg lg okie part ni. Sbb arrival time xde estimation
		
		Scanner sc = new Scanner(System.in);
		
		System.out.println("\nDATES");
		
		// Just save it as a string. No calculations involved.
		System.out.print("    Depart time on " + custDate + " [12 Hours Format. Example: 12PM]: ");
		departingTime = sc.next();
		
	}
	
	public void AirlineClassType() {
		
		Scanner sc = new Scanner(System.in);
		
		// For numbered bullet points 
		int j = 1;
		
		System.out.println("\nAIRLINE CLASSES");
		
		System.out.println("    Available Classes -");
		
		// To show all the available class in that particular airline. Economy, etc
		for(int i = 0; i < airlineClassType.length; i++) {
			System.out.println("    " + j + ". " + airlineClassType[i]);
			j++;
		}
		
		System.out.print("\n    Airline Class [Write its name]: ");
		classType = sc.nextLine();
		
		if(classType.equalsIgnoreCase("Economy")) {
			additionalPriceBetweenClasses = 0.00;
			sumOfFlightPrice += additionalPriceBetweenClasses;
		}
		
		else if(classType.equalsIgnoreCase("First Class")) {
			additionalPriceBetweenClasses = 100.00;
			sumOfFlightPrice += additionalPriceBetweenClasses;
		}
		
		else if(classType.equalsIgnoreCase("Business Class")) {
			additionalPriceBetweenClasses = 50.00;
			sumOfFlightPrice += additionalPriceBetweenClasses;
		}
		
		else {
			System.out.println("Class that you have selected in not valid. Please try again.");
		}
	}
	
	public void AirlineAddons() {
		
		Scanner sc = new Scanner(System.in);
		
		System.out.println("\nADDONS");
		
		System.out.print("    Addons? (Wi-Fi, Food) [YES] [NO]: ");
		addonStatus = sc.next();
		
		// If YES
		if(addonStatus.equalsIgnoreCase("YES")) {
			isAddon = true;
		}
		
		// If NO
		else if(addonStatus.equalsIgnoreCase("NO")) {
			isAddon = false;
		}
		
		else {
			System.out.println("    Addons input not valid. Please try again.");
		}
		
		// If customer wants addon
		if(isAddon == true) {
			additionalPriceOfAddon = 30.00;
			sumOfFlightPrice += additionalPriceOfAddon;
		}
		
		// If customer dont want addon
		else if(isAddon == false) {
			additionalPriceOfAddon = 0.00;
		}
	}
	
	public void AirlineLuggages(double luggagesWeight) {
		
		Scanner sc = new Scanner(System.in);
		
		// 20 KG and above
		if(luggagesWeight > 20) {
			additionalPriceOfLuggages = 10.00;
			sumOfFlightPrice += additionalPriceOfLuggages;
		}
		
		// 40 KG and above
		if(luggagesWeight > 40 ) {
			additionalPriceOfLuggages = 50.00;
			sumOfFlightPrice += additionalPriceOfLuggages;
		}
		
		// 60KG and above
		if(luggagesWeight > 60 ) {
			additionalPriceOfLuggages = 150.00;
			sumOfFlightPrice += additionalPriceOfLuggages;
		}
		
		sc.close();
		
	}
	
	public void AirlineSeating() {
		// Get random numbers for the seating numbers
		int min = 1;
		int max = 4;
		int randNum = (int) (Math.random() * (max-min + 1) + min);
		
		// Declare all the seatings' alphabets
		String seatingsAlphabets[] = {"A", "B", "C", "D", "E", "F", "G", "H", "I", "J", "K", "L", "M", "N", "O", "P", "Q", "R", "S", "T", "U", "V", "W", "X", "Y", "Z"};
		
		// Get random numbers of alphabets' position
		int minSeat = 0;
		int maxSeat = 25;
		int randSeat = 	(int) (Math.random() * (maxSeat-minSeat + 1) + minSeat);
		
		System.out.println("\nSEATINGS");
		
		// randNum will display random numbers from 1-4 and followed by random alphabets from seatAlphabets array
		System.out.println("    Your assigned seat: " + randNum + seatingsAlphabets[randSeat]);
		
		// Set the airlineSeat
		airlineSeat = randNum + seatingsAlphabets[randSeat];
	}
	
	public void AirlineGate() {
		// Get random numbers for the gate numbers
		int min = 1;
		int max = 10;
		int randNum = (int) (Math.random() * (max-min + 1) + min);
		
		System.out.println("\nGATES");
		
		// Show the gate's number
		System.out.println("    Your assigned gate: " + "Gate " + randNum);
		
		// Set the airlineGate
		airlineGate = randNum;
	}
	
	public void AirlineTickets() {
		
		System.out.println("\nTICKETS");
		
		System.out.println("\n           _\r\n"
				+ "         -=\\`\\\r\n"
				+ "     |\\ ____\\_\\__\r\n"
				+ "   -=\\c`\"\"\"\"\"\"\" \"`)\r\n"
				+ "      `~~~~~/ /~~`\r\n"
				+ "        -==/ /\r\n"
				+ "          '-'");
		
		System.out.println("\n------------------------");
		System.out.println("\nFlight: " + custAirline);
		System.out.println("Name: " + custName);
		System.out.println("Age: " + custAge);
		System.out.println("Date: " + custDate);
		System.out.println("From: " + custDestinationFromWhere);
		System.out.println("To: " + custDestinationToWhere);
		System.out.println("Class: " + classType);
		System.out.println("Boarding Time: " + departingTime);
		System.out.println("Gate: " + airlineGate);
		System.out.println("Seat: " + airlineSeat);
		System.out.println("\n------------------------");
	}
	
	public void AirlinePrices() {
		
		// Calling age constructor
		AirlineCustomerAgeType age = new AirlineCustomerAgeType(custAge);
		
		System.out.println("\nRECEIPT");
		
		System.out.println("\n------------------------");
		System.out.println("\nBase Price: RM" + baseFlightPrice);
		System.out.println("Flight Cost: " + "+ RM" + additionalPriceBetweenAirlines);
		System.out.println("Class Cost: " + "+ RM" + additionalPriceBetweenClasses);
		System.out.println("Age Cost: " + "+ RM" + age.additionalPriceBetweenAges);
		System.out.println("Addons Cost: " + "+ RM" + additionalPriceOfAddon);
		System.out.println("Luggages Cost: " + "+ RM" + additionalPriceOfLuggages);
		System.out.println("Location Cost: " + " +RM" + additionalPriceBetweenAirports);
		System.out.println("Total Cost: RM" + sumOfFlightPrice);
		System.out.println("\n------------------------");
	}
	
	// Receipt and ticket are diff
}
