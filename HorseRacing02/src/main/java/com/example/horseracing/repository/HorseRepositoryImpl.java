package com.example.horseracing.repository;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.example.horseracing.form.HorseForm;

import lombok.RequiredArgsConstructor;

@Repository
@RequiredArgsConstructor
public class HorseRepositoryImpl implements HorseRepository {
	
	private final JdbcTemplate jdbcTemplate;

	@Override
	public int addHourse(HorseForm form) {
		
		String sql = "INSERT	INTO		"+
				"HORSE						"+
				" (name,				"+
				"	breed,					"+
				"	age						)"+
				"VALUES					"+
				"	(?, ?, ?)				";

return jdbcTemplate.update(sql, form.getName(),
													form.getBreed(),
													form.getAge()	);
				
	}

	@Override
	public List<HorseForm> getAllHorse() {
		// TODO 自動生成されたメソッド・スタブ
		String sql = "SELECT * FROM HORSE";
		List<Map<String, Object>> rows = jdbcTemplate.queryForList(sql);
		List<HorseForm> horses = new ArrayList<>();
		
		for(Map<String, Object> row : rows) {
			HorseForm horse = new HorseForm();
			horse.setId((int)row.get("id"));
			horse.setName((String)row.get("name"));
			horse.setBreed((String)row.get("breed"));
			horse.setAge((int)row.get("age"));
			horses.add(horse);
		}
		
		return horses;
	}

}
