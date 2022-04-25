package src;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class InputValidation {
	private boolean validInputDate;
	private boolean inputInRange;
	private Date dateWeatherData;
	private Scanner inputDateScanner;
	
	public InputValidation() throws FileNotFoundException {
		this.dateWeatherData = new Date();
		this.validInputDate = false;
		this.inputDateScanner = new Scanner(System.in);
		this.inputInRange = false;
	}
	
	public Date getDateWeatherData() {
		return this.dateWeatherData;
	}
	public void promptUserForDateOrRange() throws FileNotFoundException {
		System.out.println("Would you like to enter a date (1) or date range (2)?");
		int userInput = inputDateScanner.nextInt();
		if (userInput == 1) {
			promptUserForDate();
		} else if (userInput == 2) {
			promptUserForDateRange();
		} else {
			System.out.println("Invalid input. Please try again.");
			promptUserForDateOrRange();
		}
	}

	public void promptUserForDate() throws FileNotFoundException {
		System.out.println("Please enter a date between 1940/05/16 and 2026/12/31 with the format YYYYMMDD: ");
		while (validInputDate == false) { 
			String chosenDate = inputDateScanner.nextLine();
			checkInputValidFormat(chosenDate);
		}
		inputDateScanner.close();
	}

	public void promptUserForDateRange() throws FileNotFoundException {
		System.out.println("Please enter a beginning date for a 7 day range between 1940/05/16 and 2026/12/31 with the format YYYYMMDD: ");
		while (validInputDate == false) { 
			String chosenDate = inputDateScanner.nextLine();
			checkInputValidFormat(chosenDate);
		}
		inputDateScanner.close();
	}

	public void checkInputValidFormat(String chosenDate) throws FileNotFoundException {
		boolean inputIsNumeric = isNumeric(chosenDate);
		if (chosenDate.length() == 8 && inputIsNumeric) {
			checkInputInValidDateRange(chosenDate);
		} else {
			System.out.println("Please enter a valid date");
		}
	}
	
	public boolean isNumeric (String strToCheck) {
		boolean numeric = false;
		try {  
		    Integer.parseInt(strToCheck);  
		    numeric = true;
		  } catch(NumberFormatException e){  
		    numeric = false;
		  }  
		return numeric;
	}
	
	public boolean checkInputInValidDateRange(String chosenDate) throws FileNotFoundException {
		inputInRange = checkInputInCSV(chosenDate);
		if (inputInRange) {
			validInputDate = true;
			dateWeatherData.setDateString(chosenDate);
			
		}
		else {
			System.out.println("Please enter a valid date");
		}
		return inputInRange;
	}

	public boolean checkInputInCSV(String chosenDate) throws FileNotFoundException {
		Scanner tempFileScannerForValidation = new Scanner(new File("data/H_Temp.csv"));
		while (tempFileScannerForValidation.hasNextLine()) {
			String line = tempFileScannerForValidation.nextLine();
			if (line.contains(chosenDate)) {
				this.inputInRange = true;
			}
		}
		return inputInRange;
	}
}
