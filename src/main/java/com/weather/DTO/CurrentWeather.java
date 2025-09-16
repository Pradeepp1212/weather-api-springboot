package com.weather.DTO;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.Data;

/**
 * DTO for current weather data from Open-Meteo Weather API
 * Contains real-time weather conditions and measurements
 */
@Data
@JsonIgnoreProperties("unknown=true")
public class CurrentWeather {

	// Current temperature in Celsius
	@JsonProperty("temperature")
	private double temprature;
	
	// Wind speed in km/h
	@JsonProperty("windspeed")
	private double windspeed;
	
	// Wind direction in degrees (0-360)
	@JsonProperty("winddirection")
	private int winddirection;
	
	// Day/night indicator (1 = day, 0 = night)
	@JsonProperty("is_day")
	private int is_day;
	
	// Weather condition code (WMO standard codes)
	@JsonProperty("weathercode")
	private int weathercode;

	/**
	 * @return the temprature
	 */
	public double getTemprature() {
		return temprature;
	}

	/**
	 * @param temprature the temprature to set
	 */
	public void setTemprature(double temprature) {
		this.temprature = temprature;
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
	 * @return the winddirection
	 */
	public int getWinddirection() {
		return winddirection;
	}

	/**
	 * @param winddirection the winddirection to set
	 */
	public void setWinddirection(int winddirection) {
		this.winddirection = winddirection;
	}

	/**
	 * @return the is_day
	 */
	public int getIs_day() {
		return is_day;
	}

	/**
	 * @param is_day the is_day to set
	 */
	public void setIs_day(int is_day) {
		this.is_day = is_day;
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