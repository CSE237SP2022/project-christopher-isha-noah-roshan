package UnitTests;
import static org.junit.jupiter.api.Assertions.*;

import java.io.FileNotFoundException;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import src.Date;
import src.InputValidation;


public class InputValidationTests {
	private InputValidation dateValidation;
	@BeforeEach 
	void setup() throws FileNotFoundException {
		dateValidation = new InputValidation();
	}
	//*** For CheckInputValidFormat Tests ***
	//Couldn't create tests for the actual method so we reconstructed the method within the tests
	@Test
	void testCheckInputValidFormatValid() {
		boolean validFormat = false;
		String testDate = "19770404";
		if (testDate.length() == 8 && dateValidation.isNumeric(testDate)) {
			validFormat = true;
		}
		assertTrue(validFormat);
	}
	@Test
	void testCheckInputValidFormatInvalidNonNumeric() {
		boolean validFormat = false;
		String testDate = "YYYYMMDD";
		if (testDate.length() == 8 && dateValidation.isNumeric(testDate)) {
			validFormat = true;
		}
		assertFalse(validFormat);
	}
	@Test
	void testCheckInputValidFormatInvalidWrongLength() {
		boolean validFormat = false;
		String testDate = "200109271";
		if (testDate.length() == 8 && dateValidation.isNumeric(testDate)) {
			validFormat = true;
		}
		assertFalse(validFormat);
	}
	
	@Test
	void testIsNumericFalse() {
		boolean isNumeric = dateValidation.isNumeric("notnumeric");
		assertFalse(isNumeric);
	}
	@Test
	void testIsNumericTrue() {
		boolean isNumeric = dateValidation.isNumeric("19990404");
		assertTrue(isNumeric);
	}

	@Test
	void testCheckInputInValidDateRangeInvalidYear() throws FileNotFoundException {
		String testDate = "19031229";
		boolean dateRangeValid = dateValidation.checkInputInValidDateRange(testDate);
		assertFalse(dateRangeValid);
	}
	@Test
	void testCheckInputInValidDateRangeInvalidMonth() throws FileNotFoundException {
		String testDate = "19771413";
		boolean dateRangeValid = dateValidation.checkInputInValidDateRange(testDate);
		assertFalse(dateRangeValid);
	}
	@Test
	void testCheckInputInValidDateRangeInvalidDay() throws FileNotFoundException {
		String testDate = "19870229";
		boolean dateRangeValid = dateValidation.checkInputInValidDateRange(testDate);
		assertFalse(dateRangeValid);
	}
	@Test
	void testCheckInputInValidDateRangeValidDate() throws FileNotFoundException {
		String testDate = "19870205";
		boolean dateRangeValid = dateValidation.checkInputInValidDateRange(testDate);
		assertTrue(dateRangeValid);
	}
	@Test
	void testCheckInputInCSVTrue() throws FileNotFoundException {
		String testDate = "20000229";
		boolean inCSV = dateValidation.checkInputInCSV(testDate);
		assertTrue(inCSV);
	}
	@Test
	void testCheckInputInCSVFalse() throws FileNotFoundException {
		String testDate = "19400515";
		boolean inCSV = dateValidation.checkInputInCSV(testDate);
		assertFalse(inCSV);
	}
}
