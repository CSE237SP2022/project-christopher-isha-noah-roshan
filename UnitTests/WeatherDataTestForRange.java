package UnitTests;

import static org.junit.Assert.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.io.FileNotFoundException;

import org.junit.jupiter.api.Test;

import src.Date;
import src.DateRange;
import src.WeatherData;

public class WeatherDataTestForRange {
	
	//To run this test you must enter "2" and then "19400619" into the console
	@Test
	void testUserInputDateRange19400619() throws FileNotFoundException {
		WeatherData testRun = new WeatherData();
		testRun.promptUserForDateOrRange();
		DateRange range = testRun.getInputRange().getDatesInRange();
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
