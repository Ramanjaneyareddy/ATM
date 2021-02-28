/**
 * 
 */
package com.atm.model;

import java.io.Serializable;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

/**
 * This class is used to capture the GeoLocation values from ATM get API
 * response.
 * 
 * @author Ramanjaneya Reddy S
 *
 */
@JsonIgnoreProperties(ignoreUnknown = true)
public class GeoLocation implements Serializable {

	private static final long serialVersionUID = 4518053122052047464L;
	private String lat;
	private String lng;

	/**
	 * @return the lat
	 */
	public String getLat() {
		return lat;
	}

	/**
	 * @param lat the lat to set
	 */
	public void setLat(String lat) {
		this.lat = lat;
	}

	/**
	 * @return the lng
	 */
	public String getLng() {
		return lng;
	}

	/**
	 * @param lng the lng to set
	 */
	public void setLng(String lng) {
		this.lng = lng;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "GeoLocation [lat=" + lat + ", lng=" + lng + "]";
	}

}
