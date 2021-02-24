package rentalProject;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class Test5 {

	@Test
	void test() {
		rentalAgreement test = new rentalAgreement("JAKR", 9 ,0, "7/2/15");
		assertEquals("JAKR", test.ToolCode);
		assertEquals("Jackhammer", test.ToolType);
		assertEquals("Ridgid", test.ToolBrand);
		assertEquals(9, test.RentalDays);
		assertEquals("7/2/15", test.CheckOut);
		assertEquals("7/11/15",test.DueDate);
		assertEquals(1.49, test.DailyCharge);
		assertEquals(5,test.ChargedDays);
		assertEquals(7.45,test.SubTotal);
		assertEquals(0,test.discountPercent);
		assertEquals("0", test.fDiscountAmount);
		assertEquals("7.45",test.fFinalCharge);
	}

}
