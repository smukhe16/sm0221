package rentalProject;
import java.util.*;
import java.text.*;
import java.io.*;
import java.time.*;
import java.math.*;

//Rental agreement object that checkout creates. Has methods 
public class rentalAgreement {
String ToolCode;
String ToolType;
String ToolBrand;
int RentalDays;
int discountPercent;
String CheckOut;
Date fCheckOut = new Date(); //formatted Checkout date.
String DueDate;
double DailyCharge;
int ChargedDays;
double SubTotal;
double DiscountAmount;
double FinalCharge;
//Formatted string version of discount amount, subtotal and final charge. For removing excess decimals
String fDiscountAmount;
String fSubTotal;
String fFinalCharge;

//Contructor taking in ToolCode, days rented, discount percentage (as an int), and checkout date.
//There is no default contructor.
public rentalAgreement(String recieveToolCode, int rentalDayCount, int discountPercent, String checkoutDate) {
	
	toolDatabase recieve = new toolDatabase();
	ToolCode = recieveToolCode;
	ToolType = recieve.searchType(ToolCode);
	ToolBrand = recieve.searchBrand(ToolCode);
	RentalDays = rentalDayCount;
	this.discountPercent = discountPercent;
	CheckOut = checkoutDate;
	fCheckOut = formatStringToDate(CheckOut);
	DueDate = getDueDate(fCheckOut, rentalDayCount);
	DailyCharge = recieve.searchCharge(ToolCode);
	ChargedDays = getChargeDays(rentalDayCount, fCheckOut, ToolCode, recieve);
	SubTotal = DailyCharge*ChargedDays;
	DiscountAmount = (SubTotal*discountPercent/100);
	FinalCharge = SubTotal - DiscountAmount;
	fSubTotal = decimalFormat(SubTotal);
	fDiscountAmount = decimalFormat(DiscountAmount);
	fFinalCharge = decimalFormat(FinalCharge);
	
	
}

//Formatting methods
public String decimalFormat(double input) {
	DecimalFormat df = new DecimalFormat("###,###,###.##");
	String formatted = df.format(input);
	return formatted;
}
public Date formatStringToDate(String date) {
	Date format = new Date();
	DateFormat dateFormatter = DateFormat.getDateInstance(DateFormat.SHORT);
	try {
 		format = dateFormatter.parse(date);
	   }
	catch (Exception e) {
		System.out.println("Input date cannot be parsed");
	    }
	    
	return format;
}

//Calculating due date with Date class Checkout Date, days rented and the Java Calendar class.
public String getDueDate(Date startDate, int rentDays) {
	DateFormat dateFormatter = DateFormat.getDateInstance(DateFormat.SHORT);
	Calendar c = Calendar.getInstance();
	c.setTime(startDate);
	c.add(c.DATE, rentDays);
	Date datef = c.getTime();
	String endDate = dateFormatter.format(datef);
	return endDate;
}



//Determine if it's 4th of July and observed using calendar class.
public Date IndependenceDayObserved (int nYear)
{
//July 4 unless weekend
Calendar c = Calendar.getInstance();
c.set(Calendar.YEAR, nYear);
c.set(Calendar.MONTH, Calendar.JULY);
c.set(Calendar.DATE, 4);
	 switch(c.get(Calendar.DAY_OF_WEEK))
		 {
			case Calendar.SUNDAY:
				c.set(Calendar.DATE, 5);
				return c.getTime();
			case Calendar.SATURDAY:
				c.set(Calendar.DATE, 3);
				return c.getTime();
			default :
				return c.getTime();
		}
}
//Determine if it's Labor Day and observed using calendar class.
public Date LaborDayObserved (int nYear)
	 {
	// The first Monday in September
Calendar c = Calendar.getInstance();
c.set(Calendar.YEAR, nYear);
c.set(Calendar.MONTH, Calendar.SEPTEMBER);
c.set(Calendar.DATE, 1);
	switch(c.get(Calendar.DAY_OF_WEEK))
 	    {
  		case Calendar.SUNDAY : 
		c.set(Calendar.DATE, 2);
   			return c.getTime();
	case Calendar.MONDAY : 
   			return c.getTime();
	case Calendar.TUESDAY : 
   			c.set(Calendar.DATE, 7);
   			return c.getTime();
   		case Calendar.WEDNESDAY : 
   			c.set(Calendar.DATE, 6);
   			return c.getTime();
	case Calendar.THURSDAY : 
   			c.set(Calendar.DATE, 5);
   			return c.getTime();
	case Calendar.FRIDAY : 
   			c.set(Calendar.DATE, 4);
   			return c.getTime();
   		default : // Saturday
   			c.set(Calendar.DATE, 3);
   			return c.getTime();
  	     }
	 }

//Method to determine charged days based on ToolCode and if holidays+weekends apply.
public int getChargeDays (int rentDays, Date startDate, String pToolCode, toolDatabase recieve) {
	DateFormat  dateFormatter = DateFormat.getDateInstance(DateFormat.SHORT);
	int chargeDays = 0;
	Calendar c = Calendar.getInstance();
	c.setTime(startDate);
	boolean weekend;
	boolean weekday;
	boolean holiday;
	boolean fweekend;
	boolean fholiday;
	c.add(c.DATE, 1); //check out date to be excluded from charge days
	for(int d=0; d <rentDays; d++) {
		weekend = false;
		fweekend = false;
		weekday = false;
		holiday = false;
		fholiday = false;

		if ( c.get(Calendar.DAY_OF_WEEK)==Calendar.SATURDAY || c.get(Calendar.DAY_OF_WEEK)==Calendar.SUNDAY)  {
    			weekend = true; 
		}
		else {
			weekday = true;
		}
		String dDate = dateFormatter.format(c.getTime());
		String iDate = dateFormatter.format(IndependenceDayObserved(c.get(Calendar.YEAR)));
		String lDate = dateFormatter.format(LaborDayObserved(c.get(Calendar.YEAR)));
		
		if ( dDate.equals( iDate) || dDate.equals( lDate)  ) {
    			 holiday = true;
		}
		fweekend = weekend && recieve.isWeekend(pToolCode);
		fholiday = holiday && recieve.isHoliday(pToolCode);
		if (fweekend) 
		  {

			chargeDays++;
		  }
		else if (fholiday){
			chargeDays++;
		}
		else if (weekday && !holiday) {
		       chargeDays++;
		}

		c.add(c.DATE, 1); 
		
		}
		
	return chargeDays;
	}
//Final formatted output of the rentalAgreement and checkout class.
public void rentalOutput() {
	System.out.println("Tool Code: "+ this.ToolCode+ "\n"
				+"Tool Type: "+ this.ToolType + "\n"
				+"Tool Brand: "+ this.ToolBrand+"\n"
				+"Rental Days: "+ this.RentalDays +"\n"
				+"Check-out Date: " + this.CheckOut+ "\n"
				+"Due Date: "+ this.DueDate+"\n"
				+"Daily Rental Charge: $"+this.DailyCharge+ "\n"
				+"Charge Days: "+this.ChargedDays+"\n"
				+"Pre-discount Charge: $"+this.fSubTotal+"\n"
				+"Discount Percent: "+this.discountPercent+"%\n"
				+"Discount Amount: $"+this.fDiscountAmount+"\n"
				+"Final Charge: $"+this.fFinalCharge+"\n"
				);

}

}
