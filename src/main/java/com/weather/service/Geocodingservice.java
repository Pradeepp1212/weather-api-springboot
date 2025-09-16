package com.weather.service;

import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;
import org.springframework.web.util.UriBuilder;

import com.weather.DTO.GeoCodingDTO;

/**
 * Service for integrating with Open-Meteo Geocoding API
 * Converts location names to geographical coordinates
 * API Endpoint: https://geocoding-api.open-meteo.com/v1/search
 */
@Service
public class Geocodingservice {

	private final WebClient webclient;
	
	// WebClient is used to contact external API and work with it (reactive approach)
	// UriBuilder used to set or build the URI of the API dynamically
	
	/**
	 * Constructor to initialize WebClient for making HTTP requests
	 * @param builder - WebClient builder for configuration
	 */
	public Geocodingservice(WebClient.Builder builder) {
		webclient = builder.build();
	}
	
	/**
	 * Retrieves latitude and longitude for a given location name
	 * Makes HTTP GET request to Open-Meteo Geocoding API
	 * 
	 * @param location - City or location name to search for
	 * @param language - Language code for response (e.g., "en", "es")
	 * @return GeoCodingDTO containing location details and coordinates
	 */
	public GeoCodingDTO getLatandLon(String location, String language) {
		return webclient
			.get()
			.uri(  
				uriBuilder -> uriBuilder
					.scheme("https")
					.host("geocoding-api.open-meteo.com")
					.path("/v1/search")
					.queryParam("name", location)           // Location name to search
					.queryParam("count", 1)                 // Limit results to 1
					.queryParam("language", language)       // Response language
					.build()
			)
			.retrieve()
			.bodyToMono(GeoCodingDTO.class)    // Convert response to DTO
			.block();                          // Block and wait for response
	}
}