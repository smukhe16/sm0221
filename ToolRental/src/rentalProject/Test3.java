package rentalProject;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class Test3 {

	@Test
	void test() {
		rentalAgreement test = new rentalAgreement("CHNS", 5 ,25, "7/2/15");
		assertEquals("CHNS", test.ToolCode);
		assertEquals("Chainsaw", test.ToolType);
		assertEquals("Stihl", test.ToolBrand);
		assertEquals(5, test.RentalDays);
		assertEquals("7/2/15", test.CheckOut);
		assertEquals("7/7/15", test.DueDate);
		assertEquals(1.49, test.DailyCharge);
		assertEquals(3,test.ChargedDays);
		assertEquals(4.47,test.SubTotal);
		assertEquals(25,test.discountPercent);
		assertEquals("1.12", test.fDiscountAmount);
		assertEquals("3.35",test.fFinalCharge);
	}

}
