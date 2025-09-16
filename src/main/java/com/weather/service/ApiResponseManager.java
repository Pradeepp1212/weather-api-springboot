package com.weather.service;

import org.springframework.stereotype.Service;

import com.weather.DTO.CurrentWeather;
import com.weather.DTO.GeoCodingDTO;
import com.weather.DTO.OpenmeteoResponseDTO;
import com.weather.DTO.RESPONSE;
import com.weather.DTO.Results;

/**
 * Service responsible for merging responses from different APIs
 * Combines geocoding data with weather data into a unified response
 */
@Service("apiresponsemanager")  
public class ApiResponseManager {

	/**
	 * Merges geocoding and weather API responses into a single unified response
	 * Extracts location info from geocoding and weather data from Open-Meteo API
	 * 
	 * @param response1 - Geocoding response containing location details
	 * @param weatherapi2 - Weather API response containing current weather data
	 * @return Merged response with location and weather information
	 */
	public RESPONSE merger(GeoCodingDTO response1, OpenmeteoResponseDTO weatherapi2) {
		RESPONSE response = new RESPONSE();
		 
		// Extract location information from geocoding response
		response.setCity(response1.getResults().get(0).getName());
		response.setState(response1.getResults().get(0).getAdmin1());
		
		// Extract weather information from Open-Meteo response
		response.setTemperature(weatherapi2.getCurrentweather().getTemprature());
		response.setWindspeed(weatherapi2.getCurrentweather().getWindspeed());
		response.setIsday(weatherapi2.getCurrentweather().getIs_day());
		response.setWeathercode(weatherapi2.getCurrentweather().getWeathercode());
		
		return response;
	}
}