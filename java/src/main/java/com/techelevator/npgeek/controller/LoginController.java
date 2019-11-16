package com.techelevator.npgeek.controller;

import javax.servlet.http.HttpSession;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.techelevator.npgeek.model.ParkDao;
import com.techelevator.npgeek.model.SessionAuth;
import com.techelevator.npgeek.model.Survey;
import com.techelevator.npgeek.model.SurveyDao;
import com.techelevator.npgeek.model.User;


@Controller
public class LoginController {
	
	@Autowired
	SessionAuth auth;
	
	@Autowired
	ParkDao parkDao;
	
	@Autowired
	SurveyDao surveyDao;
	
	@RequestMapping(path="/login", method=RequestMethod.GET)
	public String displayLoginPage(ModelMap modelHolder) {
		if (!modelHolder.containsAttribute("user")) {
            modelHolder.put("user", new User());
        }
        
		return "loginPage";
		
	}
	
	@RequestMapping(path="/login", method=RequestMethod.POST)
	public String processLogin(@Valid @ModelAttribute("user") User user, BindingResult result, RedirectAttributes flash) {
		
		if (result.hasErrors()) {
            flash.addFlashAttribute("user", user);
            flash.addFlashAttribute(BindingResult.MODEL_KEY_PREFIX + "user", result);
            flash.addFlashAttribute("message", "Please fix the following errors:");
            return "redirect:/login";
        }
		auth.signIn(user.getUsername(), user.getPassword());
		
		return "redirect:/";
		
	}
	
	 @RequestMapping(path = "/logoff", method = RequestMethod.POST)
	    public String logOff() {
	        auth.logOff();
	        return "redirect:/";
	    }
	 
	 
	 @RequestMapping(path="/survey", method=RequestMethod.GET)
	 public String surveyPage(ModelMap map) {
		 
		 map.addAttribute("parks", parkDao.getAllParks());
		 
		 if(auth.isLoggedIn()) {
			 if (!map.containsAttribute("survey")) {
				 map.put("survey", new Survey());
			 }
			 return "survey";
		 } else {
			 return "redirect:/login";
		 } 
	 }
	 
	 @RequestMapping(path="/survey", method=RequestMethod.POST)
	 public String processSurvey(@Valid @ModelAttribute("survey") Survey survey, BindingResult result, RedirectAttributes flash) {
		 if(result.hasErrors()) {
			 flash.addFlashAttribute("survey", survey);
			 flash.addFlashAttribute(BindingResult.MODEL_KEY_PREFIX + "survey", result);
			 flash.addAttribute("message", "Invalid inputs");
			 return "redirect:/survey";
		 } else {
			 surveyDao.saveSurvey(survey);
			 
			 return "redirect:/surveyResults";
		 }
	 }
	 
	 @RequestMapping(path="/surveyResults", method=RequestMethod.GET)
	 public String displaySurveyResults(HttpSession session) {
		 session.setAttribute("surveys", surveyDao.countSurveysByParkCode());
		 if(auth.isLoggedIn()) {
			 return "surveyResults";
		 } else {
			 return "redirect:/login";
		 }
	 }
	 
	 

}
