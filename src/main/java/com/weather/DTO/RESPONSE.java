package com.weather.DTO;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import lombok.Data;

/**
 * Final merged response DTO combining geocoding and weather data
 * Contains simplified weather information with location details
 */
public class RESPONSE {

	// Location information
	private String city;           // City name from geocoding
	private String state;          // State/region from geocoding
	
	// Weather information  
	private double temperature;    // Current temperature in Celsius
	private double windspeed;      // Wind speed in km/h
	private int isday;            // Day indicator (1 = day, 0 = night)
	private int weathercode;      // Weather condition code
	
	/**
	 * @return the city
	 */
	public String getCity() {
		return city;
	}
	
	/**
	 * @param city the city to set
	 */
	public void setCity(String city) {
		this.city = city;
	}
	
	/**
	 * @return the state
	 */
	public String getState() {
		return state;
	}
	
	/**
	 * @param state the state to set
	 */
	public void setState(String state) {
		this.state = state;
	}
	
	/**
	 * @return the temperature
	 */
	public double getTemperature() {
		return temperature;
	}
	
	/**
	 * @param temperature the temperature to set
	 */
	public void setTemperature(double temperature) {
		this.temperature = temperature;
	}
	
	/**
	 * @return the windspeed
	 */
	public double getWindspeed() {
		return windspeed;
	}
	
	/**
	 * @param windspeed the windspeed to set
	 */
	public void setWindspeed(double windspeed) {
		this.windspeed = windspeed;
	}
	
	/**
	 * @return the isday
	 */
	public int getIsday() {
		return isday;
	}
	
	/**
	 * @param isday the isday to set
	 */
	public void setIsday(int isday) {
		this.isday = isday;
	}
	
	/**
	 * @return the weathercode
	 */
	public int getWeathercode() {
		return weathercode;
	}
	
	/**
	 * @param weathercode the weathercode to set
	 */
	public void setWeathercode(int weathercode) {
		this.weathercode = weathercode;
	}
}