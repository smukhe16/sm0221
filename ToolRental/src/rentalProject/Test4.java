package rentalProject;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class Test4 {

	@Test
	void test() {
		rentalAgreement test = new rentalAgreement("JAKD", 6 ,0, "9/3/15");
		assertEquals("JAKD", test.ToolCode);
		assertEquals("Jackhammer", test.ToolType);
		assertEquals("DeWalt", test.ToolBrand);
		assertEquals(6, test.RentalDays);
		assertEquals("9/3/15", test.CheckOut);
		assertEquals("9/9/15", test.DueDate);
		assertEquals(1.49, test.DailyCharge);
		assertEquals(3,test.ChargedDays);
		assertEquals(4.47,test.SubTotal);
		assertEquals(0,test.discountPercent);
		assertEquals("0", test.fDiscountAmount);
		assertEquals("4.47",test.fFinalCharge);
	}

}
