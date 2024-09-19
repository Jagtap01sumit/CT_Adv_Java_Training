package com.citiustech.objectidentity;

public class Interval {
	
	private int minutes;
	private int seconds;
	
	public Interval(int minutes, int seconds) {
		super();
		this.minutes = minutes;
		this.seconds = seconds;
	}

	public int getMinutes() {
		return minutes;
	}

	public int getSeconds() {
		return seconds;
	}
	
	public int time() {
		return 60* minutes* seconds;
	}
	
	public int hashCode() {
		return minutes;
	}
	public boolean equals(Object other) {
		if(other instanceof Interval) {
			Interval that = (Interval) other;
			return this.minutes == that.minutes && this.seconds==that.seconds;
		}
		return false;
	}

}
