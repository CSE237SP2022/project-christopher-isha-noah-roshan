package src;

import java.util.ArrayList;
import java.util.List;

public class DateRange {
	private List<Date> dates;
	private Double avgLowPredTemp;
	private Double avgHighPredTemp;
	private Double avgLowRealTemp;
	private Double avgHighRealTemp;
	private Double totalPredPrecip;
	private Double totalRealPrecip;

	public DateRange() {
		this.dates = new ArrayList<>();
		this.avgLowPredTemp = 0.0;
		this.avgHighPredTemp = 0.0;
		this.avgLowRealTemp = 0.0;
		this.avgHighRealTemp = 0.0;
		this.totalPredPrecip = 0.0;
		this.totalRealPrecip = 0.0;
	}

	public List<Date> getDates() {
		return dates;
	}

	public Double getAvgLowPredTemp() {
		return avgLowPredTemp;
	}

	public Double getAvgHighPredTemp() {
		return avgHighPredTemp;
	}

	public Double getAvgLowRealTemp() {
		return avgLowRealTemp;
	}

	public Double getAvgHighRealTemp() {
		return avgHighRealTemp;
	}

	public Double getTotalPredPrecip() {
		return totalPredPrecip;
	}

	public Double getTotalRealPrecip() {
		return totalRealPrecip;
	}

	public String getRangeAsString() {
		String range = dates.get(0).getDateString() + "-" + dates.get(6).getDateString();
		return range;
	}

	public void addDateToDates(Date day) {
		dates.add(day);
	}

	public void computeAverageTemps() {
		double predLowCount = 0;
		double predHighCount = 0;
		double realLowCount = 0;
		double realHighCount = 0;
		for (Date day : dates) {
			if (!day.getPredLow().equals("")) {
				this.avgLowPredTemp += Double.parseDouble(day.getPredLow());
				predLowCount += 1;
			}
			if (!day.getPredHigh().equals("")) {
				this.avgHighPredTemp += Double.parseDouble(day.getPredHigh());
				predHighCount += 1;
			}
			if (!day.getRealLow().equals("")) {
				this.avgLowRealTemp += Double.parseDouble(day.getRealLow());
				realLowCount += 1;
			}
			if (!day.getRealHigh().equals("")) {
				this.avgHighRealTemp += Double.parseDouble(day.getRealHigh());
				realHighCount += 1;
			}
		}
		this.avgLowPredTemp = Math.round((this.avgLowPredTemp / predLowCount) *100.0)/100.0;
		this.avgHighPredTemp = Math.round((this.avgHighPredTemp / predHighCount)*100.0)/100.0;
		this.avgLowRealTemp = Math.round((this.avgLowRealTemp / realLowCount) *100.0)/100.0;
		this.avgHighRealTemp = Math.round((this.avgHighRealTemp / realHighCount)*100.0)/100.0;
	}
	
	public void computeTotalPrecips() {
		if (!(dates.get(6).getPredPrecip().equals("")) && !(dates.get(0).getPredPrecip().equals(""))) {
			this.totalPredPrecip = Double.parseDouble(dates.get(6).getPredPrecip()) - Double.parseDouble(dates.get(0).getPredPrecip());
			this.totalPredPrecip = Math.round(this.totalPredPrecip * 100.0)/100.0;
		}
		else {
			this.totalPredPrecip = null;
		}
		if (!(dates.get(6).getRealPrecip().equals("")) && !(dates.get(0).getRealPrecip().equals(""))) {
			this.totalRealPrecip = Double.parseDouble(dates.get(6).getRealPrecip()) - Double.parseDouble(dates.get(0).getRealPrecip());
			this.totalRealPrecip = Math.round(this.totalRealPrecip * 100.0)/100.0;
		}
		else {
			this.totalRealPrecip = null;
		}
	}

}
