package rentalProject;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

public class Test2 {

	@Test
	void test2() {
		rentalAgreement test = new rentalAgreement("LADW", 3 ,10, "7/2/20");
		assertEquals("LADW", test.ToolCode);
		assertEquals("Ladder", test.ToolType);
		assertEquals("Werner", test.ToolBrand);
		assertEquals(3, test.RentalDays);
		assertEquals("7/2/20", test.CheckOut);
		assertEquals("7/5/20", test.DueDate);
		assertEquals(1.99, test.DailyCharge);
		assertEquals(2,test.ChargedDays);
		assertEquals(3.98,test.SubTotal);
		assertEquals(10,test.discountPercent);
		assertEquals("0.4", test.fDiscountAmount);
		assertEquals("3.58",test.fFinalCharge);
	}

}
