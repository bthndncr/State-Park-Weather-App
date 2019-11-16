package com.techelevator.npgeek.model;

import java.util.List;

public interface SurveyDao {

	void saveSurvey(Survey theSurvey);
	
	// return number of survey by parkcode
	List<SurveyResults> countSurveysByParkCode();
}
