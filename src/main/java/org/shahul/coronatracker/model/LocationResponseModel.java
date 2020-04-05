package org.shahul.coronatracker.model;

import java.util.List;

public class LocationResponseModel {

	private List<LocationStats> locStats;
	private int totalReportedCases;
	private int totalIncreaseFromPreviousDay;
	
	public List<LocationStats> getLocStats() {
		return locStats;
	}
	public void setLocStats(List<LocationStats> locStats) {
		this.locStats = locStats;
	}
	public int getTotalReportedCases() {
		return totalReportedCases;
	}
	public void setTotalReportedCases(int totalReportedCases) {
		this.totalReportedCases = totalReportedCases;
	}
	public int getTotalIncreaseFromPreviousDay() {
		return totalIncreaseFromPreviousDay;
	}
	public void setTotalIncreaseFromPreviousDay(int totalIncreaseFromPreviousDay) {
		this.totalIncreaseFromPreviousDay = totalIncreaseFromPreviousDay;
	}

	
	
}
