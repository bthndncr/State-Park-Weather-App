package com.techelevator.npgeek.controller;



import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.techelevator.npgeek.model.ParkDao;
import com.techelevator.npgeek.model.WeatherDao;

@Controller
public class DetailsController {
	
	@Autowired
	ParkDao parkDao;
	
	HttpSession session;
	
	@Autowired
	WeatherDao weatherDao;
	
	@RequestMapping(path="/details", method=RequestMethod.GET)
	public String displayDetailsPage(ModelMap map, @RequestParam String parkCode, HttpSession session) {
		
		
		session.setAttribute("park", parkDao.getParkByParkCode(parkCode.toUpperCase()));
		
		if(session.getAttribute("unit") == null) {
			session.setAttribute("weather", weatherDao.getFiveDayForecastByParkCode(parkCode.toUpperCase(), "F"));
		}
		
		if((String)session.getAttribute("unit") != null) {
			session.setAttribute("weather", weatherDao.getFiveDayForecastByParkCode(parkCode.toUpperCase(), (String)session.getAttribute("unit") ));
		} 

		return "details";
	}
	
	@RequestMapping(path="/details", method=RequestMethod.POST)
	public String processCalcUnit(@RequestParam String temp, @RequestParam String parkCode, HttpSession session ) {
		
		session.setAttribute("unit", temp);
		
		
		
		return "redirect:/details?parkCode=" + parkCode;
	}

	
	
	
	
	
	
	
	
}
