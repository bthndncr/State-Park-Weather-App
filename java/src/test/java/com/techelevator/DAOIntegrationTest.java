package com.techelevator;

import static org.junit.Assert.assertEquals;

import java.sql.SQLException;

import javax.sql.DataSource;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Assert;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.datasource.SingleConnectionDataSource;

import com.techelevator.npgeek.model.JDBCParkDao;
import com.techelevator.npgeek.model.JDBCSurveyDao;
import com.techelevator.npgeek.model.Park;
import com.techelevator.npgeek.model.Survey;

public class DAOIntegrationTest {

	/* Using this particular implementation of DataSource so that
	 * every database interaction is part of the same database
	 * session and hence the same database transaction */
	private static SingleConnectionDataSource dataSource;
	private static final String PARKCODE = "TEST";
	private JDBCParkDao parkDao;
	private JDBCSurveyDao surveyDao;

	/* Before any tests are run, this method initializes the datasource for testing. */
	@BeforeClass
	public static void setupDataSource() {
		dataSource = new SingleConnectionDataSource();
		dataSource.setUrl("jdbc:postgresql://localhost:5432/npgeek");
		dataSource.setUsername("postgres");
		dataSource.setPassword("postgres1");
		/* The following line disables autocommit for connections
		 * returned by this DataSource. This allows us to rollback
		 * any changes after each test */
		dataSource.setAutoCommit(false);
	}

	/* After all tests have finished running, this method will close the DataSource */
	@AfterClass
	public static void closeDataSource() throws SQLException {
		dataSource.destroy();
	}

	/* After each test, we rollback any changes that were made to the database so that
	 * everything is clean for the next test */
	@After
	public void rollback() throws SQLException {
		dataSource.getConnection().rollback();
	}

	/* This method provides access to the DataSource for subclasses so that
	 * they can instantiate a DAO for testing */
	public DataSource getDataSource() {
		return dataSource;
	}
	
	@Before
	public void setup() {
		String sql = "insert into park (parkcode, parkname, state, acreage, elevationinfeet, milesoftrail, numberofcampsites, climate, yearfounded, annualvisitorcount, inspirationalquote, inspirationalquotesource, parkdescription, entryfee, numberofanimalspecies) " + 
				"values(?, 'testpark', 'OH', 10000, 1000, 10.0, 5, 'woodland', 1999, 1500, 'Do your best', 'M&L', 'this park rocks', 10, 65)";
		JdbcTemplate jdbcTemplate = new JdbcTemplate(dataSource);
		jdbcTemplate.update(sql, PARKCODE);
		parkDao = new JDBCParkDao(dataSource);
		surveyDao = new JDBCSurveyDao(dataSource);
	}
	
	@Test
	public void test_getParkByParkCode() {
		
		Park thePark = parkDao.getParkByParkCode(PARKCODE);
		
		Assert.assertNotNull(thePark);
		assertEquals(PARKCODE.toLowerCase(), thePark.getParkCode());
	}
	
	@Test
	public void test_saveSurvey() {
		int previousListSize = surveyDao.countSurveysByParkCode().size();
		
		Survey theSurvey = getSurvey(PARKCODE, "user@gmail.com", "OH", "Active");
		surveyDao.saveSurvey(theSurvey);
		
		int afterListSize = surveyDao.countSurveysByParkCode().size();
		
		Assert.assertEquals(1, afterListSize - previousListSize);
		
	}
	
	
	
	/// HELPER METHODS
	private Survey getSurvey(String parkCode, String emailAddress, String state, String activityLevel) {
		Survey theSurvey = new Survey();
		theSurvey.setParkCode(parkCode);
		theSurvey.setEmailAddress(emailAddress);
		theSurvey.setState(state);
		theSurvey.setActivityLevel(activityLevel);
		return theSurvey;
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}
