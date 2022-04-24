package src;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

//class not yet implemented
public class UserInputDateRange {
//	private Date dateWeatherData;
//	private Scanner tempFileScanner;
//	private Scanner precipFileScanner;
//	private InputValidation dateValidation;
//	
//	public UserInputDateRange() throws FileNotFoundException {
//		this.dateWeatherData = new Date();
//		this.tempFileScanner = new Scanner(new File("data/H_Temp.csv"));
//		this.precipFileScanner = new Scanner(new File("data/H_Precip.csv"));
//		this.dateValidation = new InputValidation();
//	}
//	
//	public Date getDateWeatherData() {
//		return this.dateWeatherData;
//	}
//	
//	public void gatherUserInput() throws FileNotFoundException {
//		tempFileScanner.useDelimiter(",");
//		precipFileScanner.useDelimiter(",");
//		dateValidation.promptUserForDate();
//		this.dateWeatherData = dateValidation.getDateWeatherData();
//		searchForDateInTempCSV();
//	}
//
//
//	public void searchForDateInTempCSV() {
//		while (tempFileScanner.hasNextLine()) {
//			String line = tempFileScanner.nextLine();
//			checkDateInCSVForTemp(line);
//		}
//		tempFileScanner.close();
//	}
//
//
//	public void checkDateInCSVForTemp(String line) {
//		if (line.contains(dateWeatherData.getDateString())) {
//			setTempData(line);
//		}
//	}
//	
//
//	public void setTempData(String line) {
//		String[] contents = line.split(",");
//		dateWeatherData.setPredictedTemperatures(contents[1], contents[2]);
//		dateWeatherData.setRealTemperatures(contents[3], contents[4]);
//		searchForDateInPrecipCSV();
//	}
//	
//	public void searchForDateInPrecipCSV() {
//		while (precipFileScanner.hasNextLine()) {
//			String line = precipFileScanner.nextLine();
//			checkDateInCSVForPrecip(line);
//		}
//		precipFileScanner.close();
//	}
//	
//	public void checkDateInCSVForPrecip(String line) {
//		if (line.contains(dateWeatherData.getDateString())) {
//			setPrecipData(line);
//		}
//	}
//
//	public void setPrecipData(String line) {
//		String[] contents = line.split(",");
//		dateWeatherData.setPredictedPrecipitation(contents[1]);
//		dateWeatherData.setRealPrecipitation(contents[2]);
//		printDateWeatherData();
//	}
//
//	public String checkEmptyData(String data) {
//		if (data.equals(" ") || data.equals("")) {
//			return "N/A";
//		}
//		else {
//			return data;
//		}
//	}
//
//	public void printDateWeatherData() {
//		System.out.println("Date: " + checkEmptyData(dateWeatherData.getDateString()));
//		System.out.println("Predicted Temperature Low: " + checkEmptyData(dateWeatherData.getPredLow()));
//		System.out.println("Predicted Temperature High: " + checkEmptyData(dateWeatherData.getPredHigh()));
//		System.out.println("Real Temperature Low: " + checkEmptyData(dateWeatherData.getRealLow()));
//		System.out.println("Real Temperature High: " + checkEmptyData(dateWeatherData.getRealHigh()));
//		System.out.println("Predicted Year-to-Date Precipitation: " + checkEmptyData(dateWeatherData.getPredPrecip()));
//		System.out.println("Real Year-to-Date Precipitation: " + checkEmptyData(dateWeatherData.getRealPrecip()));
//	}

}
