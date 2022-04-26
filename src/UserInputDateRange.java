package src;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class UserInputDateRange {
	private DateRange datesInRange;
	private Date day1;
	private Date day2;
	private Date day3;
	private Date day4;
	private Date day5;
	private Date day6;
	private Date day7;
	private Scanner tempFileScanner;
	private Scanner precipFileScanner;
	private InputValidation dateValidation;

	public UserInputDateRange() throws FileNotFoundException {
		this.datesInRange = new DateRange();
		this.day1 = new Date();
		this.day2 = new Date();
		this.day3 = new Date();
		this.day4 = new Date();
		this.day5 = new Date();
		this.day6 = new Date();
		this.day7 = new Date();
		this.tempFileScanner = new Scanner(new File("data/H_Temp.csv"));
		this.precipFileScanner = new Scanner(new File("data/H_Precip.csv"));
		this.dateValidation = new InputValidation();
	}

	public DateRange getDatesInRange() {
		return datesInRange;
	}

	public void addDatesToDateRange() {
		datesInRange.addDateToDates(day1);
		datesInRange.addDateToDates(day2);
		datesInRange.addDateToDates(day3);
		datesInRange.addDateToDates(day4);
		datesInRange.addDateToDates(day5);
		datesInRange.addDateToDates(day6);
		datesInRange.addDateToDates(day7);
	}

	public void gatherUserInput() throws FileNotFoundException {
		addDatesToDateRange();
		tempFileScanner.useDelimiter(",");
		precipFileScanner.useDelimiter(",");
		dateValidation.promptUserForDateRange();
		this.day1 = dateValidation.getDateWeatherData();
		searchForDateInTempCSV();
	}

	public void searchForDateInTempCSV() {
		while (tempFileScanner.hasNextLine()) {
			String line = tempFileScanner.nextLine();
			if (line.contains(day1.getDateString())) {
				findTempDataForRange(line);
			}
		}
		tempFileScanner.close();
	}

	public void findTempDataForRange(String line) {
		String nextLine = line;
		for (Date d : datesInRange.getDates()) {
			nextLine = moveToNextDayTemp(nextLine, d);
		}
		searchForDateInPrecipCSV();
	}

	public String moveToNextDayTemp(String nextLine, Date d) {
		if (tempFileScanner.hasNextLine()) {
			setTempData(nextLine, d);
			nextLine = tempFileScanner.nextLine();
		}
		return nextLine;
	}

	public void setTempData(String line, Date day) {
		String[] contents = line.split(",");
		day.setDateString(contents[0]);
		day.setRealTemperatures(contents[1], contents[2]);
		day.setPredictedTemperatures(contents[3], contents[4]);
	}

	public void searchForDateInPrecipCSV() {
		while (precipFileScanner.hasNextLine()) {
			String line = precipFileScanner.nextLine();
			if (line.contains(day1.getDateString())) {
				findPrecipDataForRange(line);
			}
		}
		precipFileScanner.close();
	}

	public void findPrecipDataForRange(String line) {
		String nextLine = line;
		for (Date d : datesInRange.getDates()) {
			nextLine = moveToNextDayPrecip(nextLine, d);
		}
		printDateRangeDailyData();
		printDateRangeAverages();
	}

	public String moveToNextDayPrecip(String nextLine, Date d) {
		if (precipFileScanner.hasNextLine()) {
			setPrecipData(nextLine, d);
			nextLine = precipFileScanner.nextLine();
		}
		return nextLine;
	}

	public void setPrecipData(String line, Date d) {
		String[] contents = line.split(",");
		d.setRealPrecipitation(contents[1]);
		d.setPredictedPrecipitation(contents[2]);
	}

	public String checkEmptyData(String data) {
		if (data.equals(" ") || data.equals("") || data.equals("NaN") || data.equals("null")) {
			return "N/A";
		} else {
			return data;
		}
	}

	public void printDateRangeDailyData() {
		for (Date d : datesInRange.getDates()) {
			System.out.println("Date: " + checkEmptyData(d.getDateString()));
			System.out.println("Predicted Temperature Low: " + checkEmptyData(d.getPredLow()));
			System.out.println("Predicted Temperature High: " + checkEmptyData(d.getPredHigh()));
			System.out.println("Real Temperature Low: " + checkEmptyData(d.getRealLow()));
			System.out.println("Real Temperature High: " + checkEmptyData(d.getRealHigh()));
			System.out.println("Predicted Year-to-Date Precipitation: " + checkEmptyData(d.getPredPrecip()));
			System.out.println("Real Year-to-Date Precipitation: " + checkEmptyData(d.getRealPrecip()));
			System.out.println("-----------------------------------");
		}
	}

	public void printDateRangeAverages() {
		datesInRange.computeAverageTemps();
		datesInRange.computeTotalPrecips();
		System.out.println("Date Range: " + checkEmptyData(datesInRange.getRangeAsString()));
		System.out.println("Average Predicted Low: " + checkEmptyData(String.valueOf(datesInRange.getAvgLowPredTemp())));
		System.out.println("Average Predicted High: " + checkEmptyData(String.valueOf(datesInRange.getAvgHighPredTemp())));
		System.out.println("Average Real Low: " + checkEmptyData(String.valueOf(datesInRange.getAvgLowRealTemp())));
		System.out.println("Average Real High: " + checkEmptyData(String.valueOf(datesInRange.getAvgHighRealTemp())));
		System.out.println("Total Predicted Precipitation During Week: " + checkEmptyData(String.valueOf(datesInRange.getTotalPredPrecip())));
		System.out.println("Total Real Precipitation During Week: " + checkEmptyData(String.valueOf(datesInRange.getTotalRealPrecip())));
	}

}
