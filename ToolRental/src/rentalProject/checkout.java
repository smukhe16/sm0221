package rentalProject;
import java.util.*;
import java.text.*;
import java.io.*;

public class checkout {
	
//Checkout class that acts as the main method, takes command line args for to create and display a Rental Agreement.
	public static void main(String[] args) {
	
		String recieveToolCode = args[0];
		String checkoutDate = args[1];
		int rentalDayCount = Integer.parseInt(args[2]);
		//Catches if days rented < 0 and throws error.
		try {
			if(rentalDayCount <= 0);
		}
		catch(Exception e){
			System.out.println("Days rented must be 1 or higher.");
			System.exit(1);
		}
		//Catches if discount percent as int is greater than 100.
		int discountPercent = Integer.parseInt(args[3]);
		try {
			if(discountPercent > 100);
			
		}
		catch (Exception e) {
			System.out.println("Discount percentage must be a whole number from 0-100.");
			System.exit(1);
		}
		
		rentalAgreement rentaltest = new rentalAgreement(recieveToolCode, rentalDayCount, discountPercent, checkoutDate);
		rentaltest.rentalOutput();
	}
	
	//Additional methods for Junit testing
protected void run(String string) throws Exception { }
    
    protected void logException() { }

    protected static checkout instance = null;
    
    private static checkout newApplication() {
        return instance == null ? new checkout() : instance;
    }
}
