package com.techelevator.npgeek.model;

import java.util.ArrayList;
import java.util.List;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.support.rowset.SqlRowSet;
import org.springframework.stereotype.Component;

@Component
public class JDBCParkDao implements ParkDao {
	
	private JdbcTemplate jdbcTemplate;
	
	@Autowired
	public JDBCParkDao(DataSource dataSource) {
		this.jdbcTemplate = new JdbcTemplate(dataSource);
	}

	@Override
	public List<Park> getAllParks() {
		
		List<Park> allParks = new ArrayList<>();
		
		String sql = "select * from park";
		
		SqlRowSet results = jdbcTemplate.queryForRowSet(sql);
		
		while(results.next()) {
			Park thePark = mapToRowPark(results);
			allParks.add(thePark);
		}
		
		return allParks;
	}

	@Override
	public Park getParkByParkCode(String parkCode) {
		
		Park thePark = new Park();
		
		String sql = "select * from park where parkcode = ?";
		
		SqlRowSet result = jdbcTemplate.queryForRowSet(sql, parkCode);
		
		while(result.next()) {
			thePark = mapToRowPark(result);
		}
		
		return thePark;
	}

	
	//// HELPER METHOD
	private Park mapToRowPark(SqlRowSet results) {
		Park thePark = new Park();
		
		thePark.setParkCode(results.getString("parkcode"));
		thePark.setParkName(results.getString("parkname"));
		thePark.setState(results.getString("state"));
		thePark.setAcreage(results.getInt("acreage"));
		thePark.setElevationinFeet(results.getInt("elevationinfeet"));
		thePark.setMilesOfTrail(results.getFloat("milesoftrail"));
		thePark.setNumberOfCampSites(results.getInt("numberofcampsites"));
		thePark.setClimate(results.getString("climate"));
		thePark.setYearOfFounded(results.getInt("yearfounded"));
		thePark.setAnnualVisitorCount(results.getInt("annualvisitorcount"));
		thePark.setInspirationalQuote(results.getString("inspirationalquote"));
		thePark.setInspirationalQuoteSource(results.getString("inspirationalquotesource"));
		thePark.setParkDescription(results.getString("parkdescription"));
		thePark.setEntryFee(results.getInt("entryfee"));
		thePark.setNumberOfAnimalSpecies(results.getInt("numberofanimalspecies"));
		return thePark;
	}
	
}
















