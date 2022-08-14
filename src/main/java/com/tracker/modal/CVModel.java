package com.tracker.modal;

public class CVModel 
{
	private String State,Country ;
	private int totalCases,todayRecordedCases ;
	
	public String getState() {
		return State;
	}
	public void setState(String state) {
		State = state;
	}
	public String getCountry() {
		return Country;
	}
	public void setCountry(String country) {
		Country = country;
	}
	public int getTotalCases() {
		return totalCases;
	}
	public void setTotalCases(int totalCases) {
		this.totalCases = totalCases;
	}
	public int getTodayRecordedCases() {
		return todayRecordedCases;
	}
	public void setTodayRecordedCases(int todayRecordedCases) {
		this.todayRecordedCases = todayRecordedCases;
	}
	
	
}
