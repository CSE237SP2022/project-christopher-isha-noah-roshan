package UnitTests;

import static org.junit.Assert.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.io.FileNotFoundException;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import src.Date;
import src.DateRange;
import src.UserInputDateRange;

public class UserInputDateRangeTests {
	private UserInputDateRange inputRange;
	
	@BeforeEach 
	void setup() throws FileNotFoundException {
		inputRange = new UserInputDateRange();
	}
	@Test
	void testSetTempData() {
		String line = "19840408,72.0,84.0,69.8,82.7";
		Date day = new Date();
		inputRange.setTempData(line,day);
		assertTrue("69.8".equals(day.getPredLow()));
		assertTrue("82.7".equals(day.getPredHigh()));
		assertTrue("72.0".equals(day.getRealLow()));
		assertTrue("84.0".equals(day.getRealHigh()));
	}
	@Test
	void testSetPrecipData() {
		String line = "19840408,1.98,6.45";
		Date day = new Date();
		inputRange.setPrecipData(line, day);
		assertTrue("6.45".equals(day.getPredPrecip()));
		assertTrue("1.98".equals(day.getRealPrecip()));
	}
	@Test
	void testCheckEmptyDateEmpty() {
		String emptyData = "null";
		emptyData = inputRange.checkEmptyData(emptyData);
		assertTrue("N/A".equals(emptyData));
	}
	@Test
	void testCheckEmptyDateNotEmpty() {
		String notEmptyData = "17.3";
		notEmptyData = inputRange.checkEmptyData(notEmptyData);
		assertTrue("17.3".equals(notEmptyData));
	}
	//Other UserInputDateRange methods are impossible to test individually due to the use of a file scanner
	//However if testing for gatherUserInput passes, then these methods must be functioning properly 
	//To run this test you have to input "19400619" into the console
	@Test
	void testGatherUserInput19400619() throws FileNotFoundException {
		inputRange.gatherUserInput();
		DateRange range = inputRange.getDatesInRange();
		Date day2 = range.getDates().get(1);
		assertTrue("74.1".equals(day2.getPredLow()));
		assertTrue("87.2".equals(day2.getPredHigh()));
		assertTrue("75.0".equals(day2.getRealLow()));
		assertTrue("86.0".equals(day2.getRealHigh()));
		assertTrue("8.07".equals(day2.getPredPrecip()));
		assertTrue("0.74".equals(day2.getRealPrecip()));
		assertEquals(74.21,range.getAvgLowPredTemp(),0.05);
		assertEquals(87.31,range.getAvgHighPredTemp(),0.05);
		assertEquals(73.29,range.getAvgLowRealTemp(),0.05);
		assertEquals(85.29,range.getAvgHighRealTemp(),0.05);
		assertEquals(0.1,range.getTotalPredPrecip(),0.05);
		assertEquals(0.35,range.getTotalRealPrecip(),0.05);
	}
	

}
