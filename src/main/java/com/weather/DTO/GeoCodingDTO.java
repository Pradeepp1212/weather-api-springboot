package com.weather.DTO;

import java.util.ArrayList;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

import io.micrometer.core.ipc.http.HttpSender;
import lombok.Data;

/**
 * Root response DTO for Open-Meteo Geocoding API
 * Contains search results with location coordinates and metadata
 */
@Data
@JsonIgnoreProperties("unknown = true")
public class GeoCodingDTO {

	// API response generation time in milliseconds
	@JsonProperty("generationtime_ms")
	private Double generationtime_ms;
	
	// List of matching locations for the search query
	@JsonProperty("results")
	private ArrayList<Results> results;

	/**
	 * @return the generationtime_ms
	 */
	public Double getGenerationtime_ms() {
		return generationtime_ms;
	}

	/**
	 * @param generationtime_ms the generationtime_ms to set
	 */
	public void setGenerationtime_ms(Double generationtime_ms) {
		this.generationtime_ms = generationtime_ms;
	}

	/**
	 * @return the results
	 */
	public ArrayList<Results> getResults() {
		return results;
	}

	/**
	 * @param results the results to set
	 */
	public void setResults(ArrayList<Results> results) {
		this.results = results;
	}
}