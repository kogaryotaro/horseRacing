package com.example.horseracing.repository;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.example.horseracing.form.JockeyForm;

import lombok.RequiredArgsConstructor;


@Repository
@RequiredArgsConstructor
public class JockeyRepositoryImpl implements JockeyRepository {
	
	private final JdbcTemplate jdbcTemplate;

	@Override
	public int addJockey(JockeyForm form) {
		
		String sql = "INSERT	INTO		"+
				"JOCKEY					"+
				" (name,				"+
				"	experience	)"+
				"VALUES					"+
				"	(?, ?)			";

		return jdbcTemplate.update(sql, form.getName(),
													form.getExperience()	);
	}

	@Override
	public List<JockeyForm> getAllJockeys() {
		
		String sql = "SELECT * FROM JOCKEY";
		List<Map<String, Object>> rows = jdbcTemplate.queryForList(sql);
		List<JockeyForm> jockeys = new ArrayList<>();
		
		for(Map<String, Object> row : rows) {
			JockeyForm jockey = new JockeyForm();
			jockey.setId((int)row.get("id"));
			jockey.setName((String)row.get("name"));
			jockey.setExperience((int)row.get("Experience"));
			jockeys.add(jockey);
		}
		
		return jockeys;
	}

}
