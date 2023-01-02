import java.util.*;

public class AirlineCustomerAgeType {
	
	public double additionalPriceBetweenAges = 0.00;
	
	public AirlineCustomerAgeType(int custAge) {
		
		airline air = new airline();
		
		// Customer age 12
		if(custAge < 13) {
			this.additionalPriceBetweenAges = 0.00;
			air.sumOfFlightPrice += additionalPriceBetweenAges;
		}
		
		if(custAge < 51) {
			this.additionalPriceBetweenAges = 10.00;
			air.sumOfFlightPrice += additionalPriceBetweenAges;
		}
		
		if(custAge >= 51) {
			this.additionalPriceBetweenAges = 5.00;
			air.sumOfFlightPrice += additionalPriceBetweenAges;
		}
	}

}
