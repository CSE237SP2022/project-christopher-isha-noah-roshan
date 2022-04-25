package src;

import java.io.FileNotFoundException;
import java.util.Scanner;

public class WeatherData {
	public static void main(String[] args) throws FileNotFoundException {
		promptUserForDateOrRange();
	}

	public static void promptUserForDateOrRange() throws FileNotFoundException {
		System.out.println("Would you like data for a single date (1) or 7-day range (2)?");
		Scanner inputChoiceScanner = new Scanner(System.in);
		String userChoice = inputChoiceScanner.nextLine();
		if (userChoice.equals("1")) {
			setupDate(inputChoiceScanner);
		} else if (userChoice.equals("2")) {
			setupDateRange(inputChoiceScanner);
		} else {
			System.out.println("Invalid input. Please try again.");
			promptUserForDateOrRange();
		}
	}

	private static void setupDate(Scanner inputChoiceScanner) throws FileNotFoundException {
		UserInputDate inputDate = new UserInputDate();
		inputDate.gatherUserInput();
		inputChoiceScanner.close();
	}
	
	private static void setupDateRange(Scanner inputChoiceScanner) throws FileNotFoundException {
		UserInputDateRange inputRange = new UserInputDateRange();
		inputRange.gatherUserInput();
		inputChoiceScanner.close();
	}
}