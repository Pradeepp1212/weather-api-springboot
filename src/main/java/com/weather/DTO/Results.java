package com.weather.DTO;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.Data;

/**
 * DTO class for individual geocoding result from Open-Meteo Geocoding API
 * Represents a single location with its coordinates and administrative info
 */
@Data
@JsonIgnoreProperties("unknown = true")
public class Results {
   
	// Location name (e.g., "Chennai", "Bengaluru")
	@JsonProperty("name")
	private String name;
	
	// Geographical coordinates
	@JsonProperty("latitude")
	private double latitude;
	
	@JsonProperty("longitude")
	private double longitude;
	
	// Administrative area (state/province/region)
	@JsonProperty("admin1")
	private String admin1;

	/**
	 * @return the name
	 */
	public String getName() {
		return name;
	}

	/**
	 * @param name the name to set
	 */
	public void setName(String name) {
		this.name = name;
	}

	/**
	 * @return the latitude
	 */
	public double getLatitude() {
		return latitude;
	}

	/**
	 * @param latitude the latitude to set
	 */
	public void setLatitude(double latitude) {
		this.latitude = latitude;
	}

	/**
	 * @return the longitude
	 */
	public double getLongitude() {
		return longitude;
	}

	/**
	 * @param longitude the longitude to set
	 */
	public void setLongitude(double longitude) {
		this.longitude = longitude;
	}

	/**
	 * @return the admin1
	 */
	public String getAdmin1() {
		return admin1;
	}

	/**
	 * @param admin1 the admin1 to set
	 */
	public void setAdmin1(String admin1) {
		this.admin1 = admin1;
	}
}