package rentalProject;


//Class for defining the tool class, with boolean variables for determining if a tool is charged on the weekends/holidays.
public class tool {
	public String toolType;
	public String brand;
	public String ToolCode;
	public double dailyCharge;
	public boolean weekdayCharge;
	public boolean weekendCharge;
	public boolean holidayCharge;
	
	
	
	
	
	//Constructor with parameters
	//There is no default contructor
	public tool(String toolType, String brand, String toolCode, double d, boolean weekdayCharge,
			boolean weekendCharge, boolean holidayCharge) {
		super();
		this.toolType = toolType;
		this.brand = brand;
		ToolCode = toolCode;
		this.dailyCharge = d;
		this.weekdayCharge = weekdayCharge;
		this.weekendCharge = weekendCharge;
		this.holidayCharge = holidayCharge;
	}
	//Getters and Setters for class variables
	public double getDailyCharge() {
		return dailyCharge;
	}
	public void setDailyCharge(int dailyCharge) {
		this.dailyCharge = dailyCharge;
	}
	public boolean isWeekdayCharge() {
		return weekdayCharge;
	}
	public void setWeekdayCharge(boolean weekdayCharge) {
		this.weekdayCharge = weekdayCharge;
	}
	public boolean isWeekendCharge() {
		return weekendCharge;
	}
	public void setWeekendCharge(boolean weekendCharge) {
		this.weekendCharge = weekendCharge;
	}
	public boolean isHolidayCharge() {
		return holidayCharge;
	}
	public void setHolidayCharge(boolean holidayCharge) {
		this.holidayCharge = holidayCharge;
	}

	
	public String getToolType() {
		return toolType;
	}
	public void setToolType(String toolType) {
		this.toolType = toolType;
	}
	public String getBrand() {
		return brand;
	}
	public void setBrand(String brand) {
		this.brand = brand;
	}
	String getToolCode() {
		return ToolCode;
	}
	public void setToolCode(String toolCode) {
		ToolCode = toolCode;
	}

}
