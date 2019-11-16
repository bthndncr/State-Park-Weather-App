package com.techelevator.npgeek.model;

import java.util.HashMap;
import java.util.Map;

public class Weather {

	private String parkCode;
	private int fiveDayForecastValue;
	private int low;
	private int high;
	private String defaultUnit = "F";
	private String forecast;
	
	
	
	public String getDefaultUnit() {
		return defaultUnit;
	}

	public void convertTemp(String unit) {
		if(unit != null) {
			if(unit.equalsIgnoreCase("C")) {
				if(defaultUnit != "C") {
					setLow((getLow() - 32) * 5/9);
					setHigh((getHigh() - 32) * 5/9);
					defaultUnit = "C";
				}
			} else if(unit.equalsIgnoreCase("F")){
				if(defaultUnit != "F") {
					setLow((getLow() * 9/5 )  );
					setHigh((getHigh() - 32) * 5/9);
					defaultUnit = "F";
				}
			}	
		}
	}
	
	public String getAdvisory() {
		Map<String, String> advisory = new HashMap<>();
		
		advisory.put("snow", "Pack snowshoes");
		advisory.put("rain", "Pack rain gear and wear waterproof shoes");
		advisory.put("thunderstorm", "Seek shelter and avoid hiking on exposed ridges");
		advisory.put("sunny", "Pack sunblock");
		advisory.put("partlyCloudy", "");
		advisory.put("cloudy", "");
		
		String advisory2 = "";
		if(this.defaultUnit.equals("F") || this.defaultUnit.equals(null)) {
			if(high > 75) {
				advisory2 = " Bring extra gallon of water";
			} 
			if(high - low >= 20 ) {
				advisory2 = " Please wear breathable layers";
			}
			if(low < 20) {
				advisory2 = " Danger of exposure to frigid temperatures";
			}
		} else {
			if(high > 24) {
				advisory2 = " Bring extra gallon of water";
			} 
			if(high - low >= 11 ) {
				advisory2 = " Please wear breathable layers";
			}
			if(low < -7) {
				advisory2 = " Danger of exposure to frigid temperatures";
			}
		}
		
		return advisory.get(this.forecast) + "\n" + advisory2;
	}
	
	public String getParkCode() {
		return parkCode;
	}
	public void setParkCode(String parkCode) {
		this.parkCode = parkCode;
	}
	public int getFiveDayForecastValue() {
		return fiveDayForecastValue;
	}
	public void setFiveDayForecastValue(int fiveDayForecastValue) {
		this.fiveDayForecastValue = fiveDayForecastValue;
	}
	public int getLow() {
		return low;
	}
	public void setLow(int low) {
		this.low = low;
	}
	public int getHigh() {
		return high;
	}
	public void setHigh(int high) {
		this.high = high;
	}
	public String getForecast() {
		return forecast;
	}
	public void setForecast(String forecast) {
		String[] str = forecast.split(" ");
		if(str.length == 2) {
			String upperCase = str[1].toUpperCase();
			char firstLetter = upperCase.charAt(0);
			String lowerCase = str[1].substring(1).toLowerCase();
			String finalStr = firstLetter + lowerCase;
			this.forecast =  str[0] + finalStr;			
		} else {
			this.forecast = forecast;
		}
	}
	@Override
	public String toString() {
		return "Weather [parkCode=" + parkCode + ", fiveDayForecastValue=" + fiveDayForecastValue + ", low=" + low
				+ ", high=" + high + ", forecast=" + forecast + "]";
	}
	
	
}
