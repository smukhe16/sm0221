package rentalProject;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class Test6 {

	@Test
	void test() {
		rentalAgreement test = new rentalAgreement("JAKR",4 ,50 ,"7/2/20");
		assertEquals("JAKR", test.ToolCode);
		assertEquals("Jackhammer", test.ToolType);
		assertEquals("Ridgid", test.ToolBrand);
		assertEquals(4, test.RentalDays);
		assertEquals("7/2/20", test.CheckOut);
		assertEquals("7/6/20",test.DueDate);
		assertEquals(1.49, test.DailyCharge);
		assertEquals(1,test.ChargedDays);
		assertEquals(1.49,test.SubTotal);
		assertEquals(50,test.discountPercent);
		assertEquals("0.74", test.fDiscountAmount);
		assertEquals("0.74",test.fFinalCharge);
	}

}
