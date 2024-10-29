package com.example.horseracing.repository;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.example.horseracing.form.RaceResultForm;

import lombok.RequiredArgsConstructor;

@Repository
@RequiredArgsConstructor
public class RaceResultRepositoryImpl implements RaceResultRepository {
	
	private final JdbcTemplate jdbcTemplate;

	@Override
	public int addRaceResult(RaceResultForm form) {
		
		String sql = "INSERT	INTO		"+
				"RACE_RESULT						"+
				" (race_id,				"+
				"	horse_id,					"+
				"	jockey_id,				 "+
				"	position	)"+
				"VALUES					"+
				"	(?, ?, ?, ?)			";

		return jdbcTemplate.update(sql, form.getRaceId(),
													form.getHorseId(),
													form.getJockeyId(),
													form.getPosition()	);
	}

	@Override
	public List<RaceResultForm> getAllRaceResults() {
		
		
		String sql = "SELECT * FROM RACE_RESULT";
		List<Map<String, Object>> rows = jdbcTemplate.queryForList(sql);
		List<RaceResultForm> raceResults = new ArrayList<>();
		
		for(Map<String, Object> row : rows) {
			RaceResultForm raceResult = new RaceResultForm();
			raceResult.setId((int)row.get("id"));
			raceResult.setRaceId((int)row.get("race_id"));
			raceResult.setHorseId((int)row.get("horse_id"));
			raceResult.setJockeyId((int)row.get("jockey_id"));
			raceResult.setPosition((int)row.get("position"));
			raceResults.add(raceResult);
		}
		
		return raceResults;
	}

}
