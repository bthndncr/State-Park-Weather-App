package com.techelevator.npgeek.model;

import java.util.ArrayList;
import java.util.List;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.support.rowset.SqlRowSet;
import org.springframework.stereotype.Component;

@Component
public class JDBCWeatherDao implements WeatherDao {
	
	private JdbcTemplate jdbcTemplate;
	
	@Autowired
	public JDBCWeatherDao(DataSource dataSource) {
		this.jdbcTemplate = new JdbcTemplate(dataSource);
	}

	@Override
	public List<Weather> getFiveDayForecastByParkCode(String parkCode, String unit) {
		
		List<Weather> theWeathers = new ArrayList<>();
		
		String sql = "select * from weather where parkcode = ?";
		
		SqlRowSet results = jdbcTemplate.queryForRowSet(sql, parkCode);
		
		while(results.next()) {
			Weather aWeather = mapToRowWeather(results);
			aWeather.convertTemp(unit);
			theWeathers.add(aWeather);
		}
		return theWeathers;
	}
	
	
	////HELPER METHOD
	private Weather mapToRowWeather(SqlRowSet results) {
		Weather theWeather = new Weather();
		
		theWeather.setParkCode(results.getString("parkcode"));
		theWeather.setFiveDayForecastValue(results.getInt("fivedayforecastvalue"));
		theWeather.setLow(results.getInt("low"));
		theWeather.setHigh(results.getInt("high"));
		theWeather.setForecast(results.getString("forecast"));
		
		return theWeather;
	}

}
