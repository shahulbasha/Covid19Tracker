package org.shahul.coronatracker.model;

public class LocationStats {

	private String state;
	private String country;
	private int latestCases;
	private int increaseFromPreviousDay;
	
	
	public int getIncreaseFromPreviousDay() {
		return increaseFromPreviousDay;
	}


	public void setIncreaseFromPreviousDay(int increaseFromPreviousDay) {
		this.increaseFromPreviousDay = increaseFromPreviousDay;
	}


	@Override
	public String toString() {
		return "LocationResponseModel [state=" + state + ", country=" + country + ", latestCases=" + latestCases + "]";
	}


	public String getState() {
		return state;
	}
	public void setState(String state) {
		this.state = state;
	}
	public String getCountry() {
		return country;
	}
	public void setCountry(String country) {
		this.country = country;
	}
	public int getLatestCases() {
		return latestCases;
	}
	public void setLatestCases(int latestCases) {
		this.latestCases = latestCases;
	}
}
