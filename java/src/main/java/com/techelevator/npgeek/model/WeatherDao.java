package com.techelevator.npgeek.model;

import java.util.List;

public interface WeatherDao {
	
	// return 5 day forecats by parkcode
	List<Weather> getFiveDayForecastByParkCode(String parkCode, String unit);
}
