package com.weather.service;

import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;

import com.weather.DTO.OpenmeteoResponseDTO;

/**
 * Service for integrating with Open-Meteo Weather API
 * Fetches current weather data using geographical coordinates
 * API Endpoint: https://api.open-meteo.com/v1/forecast
 */
@Service
public class Openmeteoservice {
	
	// Two ways to call third-party API: WebClient (reactive) or RestTemplate (blocking)
	// Using WebClient for modern reactive approach
	
	private final WebClient webclient;
	
	/**
	 * Constructor to initialize WebClient for making HTTP requests
	 * @param builder - WebClient builder for configuration
	 */
	public Openmeteoservice(WebClient.Builder builder) {
		this.webclient = builder.build();
	}
	
	/**
	 * Retrieves current weather data for given coordinates
	 * Makes HTTP GET request to Open-Meteo Weather API
	 * 
	 * @param lat - Latitude coordinate
	 * @param lon - Longitude coordinate
	 * @return OpenmeteoResponseDTO containing current weather information
	 */
	public OpenmeteoResponseDTO getweather(double lat, double lon) {
		return webclient.get()
			.uri(
				uriBuilder -> uriBuilder
					.scheme("https")
					.host("api.open-meteo.com")
					.path("v1/forecast")
					.queryParam("latitude", lat)               // Latitude coordinate
					.queryParam("longitude", lon)              // Longitude coordinate
					.queryParam("current_weather", true)       // Include current weather data
					.build()
			)
			.retrieve()
			.bodyToMono(OpenmeteoResponseDTO.class)    // Convert response to DTO
			.block();                                  // Block and wait for response
	}
}