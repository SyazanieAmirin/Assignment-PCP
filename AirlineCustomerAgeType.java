import java.util.*;

public class AirlineCustomerAgeType {
	
	public double additionalPriceBetweenAges = 0.00;
	
	public AirlineCustomerAgeType(int custAge) {
		
		// Customer age 12
		if(custAge < 13) {
			this.additionalPriceBetweenAges = 0.00;
		}
		
		if(custAge < 51) {
			this.additionalPriceBetweenAges = 10.00;
		}
		
		if(custAge >= 51) {
			this.additionalPriceBetweenAges = 5.00;
		}
	}

}
