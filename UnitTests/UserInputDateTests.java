package UnitTests;
import static org.junit.jupiter.api.Assertions.*;

import java.io.FileNotFoundException;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import src.Date;
import src.UserInputDate;

public class UserInputDateTests {
	private UserInputDate inputDate;
	
	@BeforeEach 
	void setup() throws FileNotFoundException {
		inputDate = new UserInputDate();
	}
	
	@Test
	void testCheckDateInCSVForTemp() {
		String line = "19430513,69.0,83.0,71.2,84.6";
		Date day = inputDate.getDateWeatherData();
		day.setDateString("19430513");
		inputDate.checkDateInCSVForTemp(line);
		assertTrue("71.2".equals(day.getPredLow()));
		assertTrue("84.6".equals(day.getPredHigh()));
		assertTrue("69.0".equals(day.getRealLow()));
		assertTrue("83.0".equals(day.getRealHigh()));
	}
	@Test
	void testSetTempData() {
		String line = "19840408,72.0,84.0,69.8,82.7";
		inputDate.setTempData(line);
		Date day = inputDate.getDateWeatherData();
		assertTrue("69.8".equals(day.getPredLow()));
		assertTrue("82.7".equals(day.getPredHigh()));
		assertTrue("72.0".equals(day.getRealLow()));
		assertTrue("84.0".equals(day.getRealHigh()));
	}
	@Test
	void testCheckDateInCSVForPrecip() {
		String line = "19430513,18.06,7.26";
		Date day = inputDate.getDateWeatherData();
		day.setDateString("19430513");
		inputDate.checkDateInCSVForPrecip(line);
		assertTrue("7.26".equals(day.getPredPrecip()));
		assertTrue("18.06".equals(day.getRealPrecip()));
	}
	@Test
	void testSetPrecipData() {
		String line = "19840408,1.98,6.45";
		inputDate.setPrecipData(line);
		Date day = inputDate.getDateWeatherData();
		assertTrue("6.45".equals(day.getPredPrecip()));
		assertTrue("1.98".equals(day.getRealPrecip()));
	}
	@Test
	void testCheckEmptyDateEmpty() {
		String emptyData = "";
		emptyData = inputDate.checkEmptyData(emptyData);
		assertTrue("N/A".equals(emptyData));
	}
	@Test
	void testCheckEmptyDateNotEmpty() {
		String notEmptyData = "17.3";
		notEmptyData = inputDate.checkEmptyData(notEmptyData);
		assertTrue("17.3".equals(notEmptyData));
	}
	//This test covers all UserInputDate methods that are not tested individually
	//To run this test you must input "20200404" into the console
	@Test
	void testUserInputDate20200404() throws FileNotFoundException {
		inputDate = new UserInputDate();
		inputDate.gatherUserInput();
		Date day = inputDate.getDateWeatherData();
		assertTrue("20200404".equals(day.getDateString()));
		assertTrue("69.5".equals(day.getPredLow()));
		assertTrue("82.4".equals(day.getPredHigh()));
		assertTrue("69.0".equals(day.getRealLow()));
		assertTrue("83.0".equals(day.getRealHigh()));
		assertTrue("6.31".equals(day.getPredPrecip()));
		assertTrue("5.78".equals(day.getRealPrecip()));
		
	}
	
}
