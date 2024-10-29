package com.example.horseracing.repository;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.example.horseracing.form.RaceForm;

import lombok.RequiredArgsConstructor;

@Repository
@RequiredArgsConstructor
public class RaceRepositoryImpl implements RaceRepository {

	private final JdbcTemplate jdbcTemplate;
	
	@Override
	public int addRace(RaceForm form) {
		
		String sql = "INSERT	INTO		"+
							"Race						"+
							" (location,				"+
							"	date,					"+
							"	weather,				 "+
							"	track_condition	)"+
							"VALUES					"+
							"	(?, ?, ?, ?)			";
		
		return jdbcTemplate.update(sql, form.getLocation(),
																form.getDate(),
																form.getWeather(),
																form.getTrackCondition()	);
							
	}

	@Override
	public List<RaceForm> getAllRaces() {

		String sql = "SELECT * FROM RACE";
		List<Map<String, Object>> rows = jdbcTemplate.queryForList(sql);
		List<RaceForm> races = new ArrayList<>();
		
		for(Map<String, Object> row : rows) {
			RaceForm race = new RaceForm();
			race.setId((int)row.get("id"));
			race.setLocation((String)row.get("location"));
			race.setDate(((java.sql.Date)row.get("date")).toString());
			race.setWeather((String)row.get("weather"));
			race.setTrackCondition((String)row.get("track_condition"));
			races.add(race);
		}
		
		return races;
		
	}

}
