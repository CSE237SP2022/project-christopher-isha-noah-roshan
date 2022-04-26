package UnitTests;

import static org.junit.jupiter.api.Assertions.*;

import java.io.FileNotFoundException;

import org.junit.jupiter.api.Test;

import src.Date;
import src.WeatherData;

public class WeatherDataTests {
	
	//To run this test you must input "1" and then "19880116" into the console"
	@Test
	void testUserInputDate19880116() throws FileNotFoundException {
		WeatherData testRun = new WeatherData();
		testRun.promptUserForDateOrRange();
		Date day = testRun.getInputDate().getDateWeatherData();
		assertTrue("19880116".equals(day.getDateString()));
		assertTrue("66.6".equals(day.getPredLow()));
		assertTrue("80.4".equals(day.getPredHigh()));
		assertTrue("69.0".equals(day.getRealLow()));
		assertTrue("81.0".equals(day.getRealHigh()));
		assertTrue("1.07".equals(day.getPredPrecip()));
		assertTrue("1.13".equals(day.getRealPrecip()));
		
	}

		

}
