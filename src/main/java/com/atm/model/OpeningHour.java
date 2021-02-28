package com.atm.model;

import java.io.Serializable;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

/**
 * This class is used to capture the OpeningHour object values from ATM get API.
 * 
 * @author Ramanjaneya Reddy S
 *
 */
@JsonIgnoreProperties(ignoreUnknown = true)
public class OpeningHour implements Serializable {

	private static final long serialVersionUID = -6926943406606151155L;
	private int dayOfWeek;
	private List<Hour> hours;

	/**
	 * @return the dayOfWeek
	 */
	public int getDayOfWeek() {
		return dayOfWeek;
	}

	/**
	 * @param dayOfWeek the dayOfWeek to set
	 */
	public void setDayOfWeek(int dayOfWeek) {
		this.dayOfWeek = dayOfWeek;
	}

	/**
	 * @return the hours
	 */
	public List<Hour> getHours() {
		return hours;
	}

	/**
	 * @param hours the hours to set
	 */
	public void setHours(List<Hour> hours) {
		this.hours = hours;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "OpeningHour [dayOfWeek=" + dayOfWeek + ", hours=" + hours + "]";
	}

}
