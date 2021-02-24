package rentalProject;
import java.util.*;
import java.util.ArrayList;


//Class for creating an ArrayList of tool objects with the given rental information.
public class toolDatabase {
	ArrayList<tool> database = new ArrayList<tool>();
//Default contructor
public toolDatabase() {
	
	tool ladder = new tool("Ladder","Werner","LADW",1.99, true, true, false);
	tool chainsaw = new tool("Chainsaw","Stihl","CHNS",1.49, true, false, true);
	tool jackhammer = new tool("Jackhammer","Ridgid","JAKR",1.49, true, false, false);
	tool jackhammer2 = new tool("Jackhammer","DeWalt","JAKD",1.49, true, false, false);
	database.add(ladder);
	database.add(chainsaw);
	database.add(jackhammer);
	database.add(jackhammer2);
	
}
public ArrayList<tool> getDatabase(){
	return database;
}

//Search database method using ToolCode and returns place in ArrayList as int.
private int parseDatabase(String ToolCode) {
	for (int i = 0; i<database.size(); i++) {
		if(ToolCode.equals(database.get(i).getToolCode())) {
			return i;
		}
	}
	return 0;
}
//Search ArrayList methods.
public double searchCharge(String ToolCode) {
	return database.get(parseDatabase(ToolCode)).getDailyCharge();

}
public String searchBrand(String ToolCode) {
	return database.get(parseDatabase(ToolCode)).getBrand();
}
public String searchType(String ToolCode) {
	return database.get(parseDatabase(ToolCode)).getToolType();
}
//Getters for weekday, weekend, holiday charge booleans
public boolean isWeekday(String ToolCode) {
	return database.get(parseDatabase(ToolCode)).isWeekdayCharge();
}
public boolean isWeekend (String ToolCode) {
	return database.get(parseDatabase(ToolCode)).isWeekendCharge();
}
public boolean isHoliday (String ToolCode) {
	return database.get(parseDatabase(ToolCode)).isHolidayCharge();
}


}
