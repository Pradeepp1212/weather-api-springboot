package com.weather.DTO;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.Data;

/**
 * Root response DTO for Open-Meteo Weather API
 * Maps the main response structure containing current weather data
 */
@Data
@JsonIgnoreProperties("unknown = true")
public class OpenmeteoResponseDTO {
	
	// Nested current weather object from API response
	@JsonProperty("current_weather")
	CurrentWeather currentweather;

	/**
	 * @param currentweather the currentweather to set
	 */
	public void setCurrentweather(CurrentWeather currentweather) {
		this.currentweather = currentweather;
	}

	/**
	 * @return the current weather data
	 */
	public CurrentWeather getCurrentweather() {
		return currentweather;
	}
}