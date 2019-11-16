package com.techelevator.npgeek.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.techelevator.npgeek.model.ParkDao;

@Controller
public class HomeController {
	
	@Autowired
	ParkDao parkDao;
	
	@RequestMapping(path="/", method=RequestMethod.GET)
	public String displayHomePage(ModelMap model) {
		
		model.addAttribute("parks", parkDao.getAllParks());
				
		return "homePage";
	}
	
}
