package src;

import java.io.FileNotFoundException;
import java.util.Scanner;

public class WeatherData {
	private UserInputDate inputDate;
	private UserInputDateRange inputRange;
	private Scanner inputChoiceScanner;
	
	public WeatherData() throws FileNotFoundException {
		this.inputDate = new UserInputDate();
		this.inputRange = new UserInputDateRange();
		this.inputChoiceScanner = new Scanner(System.in);
	}
	public UserInputDate getInputDate() {
		return this.inputDate;
	}
	public UserInputDateRange getInputRange() {
		return this.inputRange;
	}

	public void promptUserForDateOrRange() throws FileNotFoundException {
		System.out.println("Would you like data for a single date (1) or 7-day range (2)?");
		String userChoice = inputChoiceScanner.nextLine();
		if (userChoice.equals("1")) {
			setupDate();
		} else if (userChoice.equals("2")) {
			setupDateRange();
		} else {
			System.out.println("Invalid input. Please try again.");
			promptUserForDateOrRange();
		}
	}
	public void setupDate() throws FileNotFoundException {
		inputDate.gatherUserInput();
		inputChoiceScanner.close();
	}
	
	public void setupDateRange() throws FileNotFoundException {
		inputRange.gatherUserInput();
		inputChoiceScanner.close();
	}
	
	public static void main(String[] args) throws FileNotFoundException {
		WeatherData run = new WeatherData();
		run.promptUserForDateOrRange();
	}
}