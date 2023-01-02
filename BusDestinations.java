import java.util.*;

public class BusDestinations {
	
	// Variables declarations
	public String busFromWhere, busToWhere;

	// Arrays declarations
	public String busLocations[] = {"TBS", "Ipoh", "Penang"};
	
	public BusDestinations() {
		
		Scanner sc = new Scanner(System.in);
		
		// Bus Locations
		System.out.print("\n    Availabe Bus Locations:- \n");
		
		// Show all the bus locations
		for(int i = 0; i < busLocations.length; i++) {
			System.out.println("    [X] " + busLocations[i]);
		}
		
		// From where
		System.out.print("\n    From: ");
		busFromWhere = sc.nextLine();
		
		// To where
		System.out.print("\n    To: ");
		busToWhere = sc.nextLine();
		
		// -------
		
		// TBS -> Ipoh
		if(busFromWhere.equalsIgnoreCase("TBS") && busToWhere.equalsIgnoreCase("Ipoh")) {
			BusSystem.addLocations = 20.00;
		}
		
		// TBS -> Penang
		if(busFromWhere.equalsIgnoreCase("TBS") && busToWhere.equalsIgnoreCase("Penang")) {
			BusSystem.addLocations = 40.00;
		}
		
		// Ipoh -> TBS
		if(busFromWhere.equalsIgnoreCase("Ipoh") && busToWhere.equalsIgnoreCase("TBS")) {
			BusSystem.addLocations = 20.00;
		}
		
		// Ipoh -> Penang
		if(busFromWhere.equalsIgnoreCase("Ipoh") && busToWhere.equalsIgnoreCase("Penang")) {
			BusSystem.addLocations = 20.00;
		}
		
		// Penang -> Ipoh
		if(busFromWhere.equalsIgnoreCase("Penang") && busToWhere.equalsIgnoreCase("Ipoh")) {
			BusSystem.addLocations = 20.00;
		}
		
		// Penang -> TBS
		if(busFromWhere.equalsIgnoreCase("Penang") && busToWhere.equalsIgnoreCase("TBS")) {
			BusSystem.addLocations = 40.00;
		}
		
	}
	
}
