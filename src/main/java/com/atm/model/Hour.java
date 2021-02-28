/**
 * 
 */
package com.atm.model;

import java.io.Serializable;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

/**
 * This class is used to capture the Hour object values from ATM get API.
 * 
 * @author Ramanjaneya Reddy
 *
 */
@JsonIgnoreProperties(ignoreUnknown = true)
public class Hour implements Serializable {

	private static final long serialVersionUID = 315662699207560942L;
	private String hourFrom;
	private String hourTo;

	/**
	 * @return the hourFrom
	 */
	public String getHourFrom() {
		return hourFrom;
	}

	/**
	 * @param hourFrom the hourFrom to set
	 */
	public void setHourFrom(String hourFrom) {
		this.hourFrom = hourFrom;
	}

	/**
	 * @return the hourTo
	 */
	public String getHourTo() {
		return hourTo;
	}

	/**
	 * @param hourTo the hourTo to set
	 */
	public void setHourTo(String hourTo) {
		this.hourTo = hourTo;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "Hour [hourFrom=" + hourFrom + ", hourTo=" + hourTo + "]";
	}

}
