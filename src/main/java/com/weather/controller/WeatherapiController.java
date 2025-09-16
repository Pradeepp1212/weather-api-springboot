package com.weather.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.weather.DTO.GeoCodingDTO;
import com.weather.DTO.OpenmeteoResponseDTO;
import com.weather.DTO.RESPONSE;
import com.weather.service.ApiResponseManager;
import com.weather.service.Geocodingservice;
import com.weather.service.Openmeteoservice;

/**
 * Weather API Controller
 * Handles REST endpoints for weather data retrieval
 * Base URL: http://localhost:8080/api/weather?name=chennai&language=en
 */
@RestController
@RequestMapping("/api/weather")
public class WeatherapiController {

    // Service for fetching weather data from Open-Meteo API
    @Autowired
    Openmeteoservice openmeteoservice;
    
    // Service for geocoding (converting location name to coordinates)
    @Autowired
    @Qualifier("geocodingservice")
    Geocodingservice geocodingservices;
    
    // Service for merging geocoding and weather API responses
    @Autowired
    @Qualifier("apiresponsemanager")
    ApiResponseManager resultmerger;
    
    /**
     * Main endpoint to get weather data by location name
     * Uses geocoding API: https://geocoding-api.open-meteo.com/v1/search?name=bengaluru&count=1&language=en
     * 
     * @param location - City name (e.g., "chennai", "bengaluru")
     * @param language - Response language (e.g., "en", "es", "fr")
     * @return Combined response with location info and weather data
     */
    @GetMapping()
    public RESPONSE getLatLon(@RequestParam("name") String location, @RequestParam("language") String language) {
        // Step 1: Convert location name to coordinates using geocoding service
        GeoCodingDTO response1 = geocodingservices.getLatandLon(location, language);
        
        // Step 2: Extract latitude and longitude from geocoding response
        double lat = response1.getResults().get(0).getLatitude();
        double lon = response1.getResults().get(0).getLongitude();
        
        // Step 3: Get weather data using the coordinates
        OpenmeteoResponseDTO response2 = getweather(lat, lon);
        
        // Step 4: Merge both responses into final result
        return resultmerger.merger(response1, response2);
    }
    
    /**
     * Direct endpoint to get weather data using coordinates
     * Bypasses geocoding and directly fetches weather from Open-Meteo API
     * 
     * @param lat - Latitude coordinate
     * @param lon - Longitude coordinate  
     * @return Raw weather data response
     */
    @GetMapping("/data")
    public OpenmeteoResponseDTO getweather(@RequestParam double lat, @RequestParam double lon) {
        // Fetch weather data directly using coordinates
        OpenmeteoResponseDTO response = openmeteoservice.getweather(lat, lon);
        
        return response;
    }
}