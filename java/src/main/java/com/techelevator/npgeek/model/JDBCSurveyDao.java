package com.techelevator.npgeek.model;

import java.util.ArrayList;
import java.util.List;

import javax.sql.DataSource;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.support.rowset.SqlRowSet;
import org.springframework.stereotype.Component;

@Component
public class JDBCSurveyDao implements SurveyDao {
	
	private JdbcTemplate jdbcTemplate;
	
	public JDBCSurveyDao(DataSource dataSource) {
		this.jdbcTemplate = new JdbcTemplate(dataSource);
	}
	
	@Override
	public void saveSurvey(Survey theSurvey) {
		
		String sql = "insert into survey_result(parkcode, emailaddress, state, activitylevel) values(?, ?, ?, ?)";
		jdbcTemplate.update(sql, theSurvey.getParkCode(), theSurvey.getEmailAddress(), theSurvey.getState(), theSurvey.getActivityLevel());
	}

	@Override
	public List<SurveyResults> countSurveysByParkCode() {
		
		List<SurveyResults> surveys = new ArrayList<>();
		String sql = "select sr.parkcode, p.parkname, count(sr.parkcode) as count " + 
				"from survey_result sr " + 
				"join park p " + 
				"on p.parkcode = upper(sr.parkcode) " + 
				"group by sr.parkcode, p.parkname order by count desc, p.parkname asc";
		SqlRowSet results = jdbcTemplate.queryForRowSet(sql);
		while(results.next()) {
			SurveyResults theSurvey = mapToRowSurveyResult(results);
			surveys.add(theSurvey);
		}
		return surveys;
	}
	
	////HELPER METHOD
	private SurveyResults mapToRowSurveyResult(SqlRowSet result) {
		SurveyResults theSurvey = new SurveyResults();
		theSurvey.setParkCode(result.getString("parkcode"));
		theSurvey.setParkName(result.getString("parkname"));
		theSurvey.setCount(result.getInt("count"));
		return theSurvey;
	}

}
