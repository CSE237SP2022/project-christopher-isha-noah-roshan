package UnitTests;
import static org.junit.jupiter.api.Assertions.*;

import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import src.Date;
import src.DateRange;

public class DateRangeTests {
	private DateRange dr;
	
	@BeforeEach
	void setup() {
		dr = new DateRange();
	}
	
	@Test
	void testGetRangeAsString() {
		Date day1 = new Date();
		Date day2 = new Date();
		Date day3 = new Date();
		Date day4 = new Date();
		Date day5 = new Date();
		Date day6 = new Date();
		Date day7 = new Date();
		dr.addDateToDates(day1);
		dr.addDateToDates(day2);
		dr.addDateToDates(day3);
		dr.addDateToDates(day4);
		dr.addDateToDates(day5);
		dr.addDateToDates(day6);
		dr.addDateToDates(day7);
		day1.setDateString("19991220");
		day7.setDateString("19991227");
		String rangeString = dr.getRangeAsString();
		assertTrue("19991220-19991227".equals(rangeString));
	}
	@Test
	void testComputeAverageTemps() {
		Date day = new Date();
		day.setPredictedTemperatures("49.0", "70.0");
		day.setRealTemperatures("56.0", "77.0");
		for (int i=0; i < 7; ++i) {
			dr.addDateToDates(day);
		}
		dr.computeAverageTemps();
		assertEquals(49.0,dr.getAvgLowPredTemp(),0.05);
		assertEquals(70.0,dr.getAvgHighPredTemp(),0.05);
		assertEquals(56.0,dr.getAvgLowRealTemp(),0.05);
		assertEquals(77.0,dr.getAvgHighRealTemp(),0.05);
	}
	@Test
	void testComputeAverageTempsWithEmptyValues() {
		Date day1 = new Date();
		Date day2 = new Date();
		day1.setPredictedTemperatures("70.0", "80.0");
		day1.setRealTemperatures("65.0", "75.0");
		day2.setPredictedTemperatures("65.0", "75.0");
		day2.setRealTemperatures("60.0", "70.0");
		dr.addDateToDates(day1);
		dr.addDateToDates(day2);
		for (int i =2; i<7;++i) {
			Date day = new Date();
			dr.addDateToDates(day);
		}
		dr.computeAverageTemps();
		assertEquals(67.5,dr.getAvgLowPredTemp(),0.05);
		assertEquals(77.5,dr.getAvgHighPredTemp(),0.05);
		assertEquals(62.5,dr.getAvgLowRealTemp(),0.05);
		assertEquals(72.5,dr.getAvgHighRealTemp(),0.05);
	}
	@Test
	void testComputeTotalPrecips() {
		double predPrecip = 2.35;
		double realPrecip = 1.7;
		for (int i=0; i < 7; ++i) {
			Date day = new Date();
			day.setPredictedPrecipitation(String.valueOf(predPrecip));
			day.setRealPrecipitation(String.valueOf(realPrecip));
			dr.addDateToDates(day);
			predPrecip += 0.15;
			realPrecip += 0.2;
		}
		dr.computeTotalPrecips();
		assertEquals(0.9,dr.getTotalPredPrecip(),0.05);
		assertEquals(1.2,dr.getTotalRealPrecip(),0.05);
	}
	@Test
	void testComputeTotalPrecipsWithMissingData() {
		for (int i = 0; i <7; ++i) {
			Date day = new Date();
			dr.addDateToDates(day);
		}
		dr.computeTotalPrecips();
		assertTrue("null".equals(String.valueOf(dr.getTotalPredPrecip())));
		assertTrue("null".equals(String.valueOf(dr.getTotalRealPrecip())));
		
	}

}
