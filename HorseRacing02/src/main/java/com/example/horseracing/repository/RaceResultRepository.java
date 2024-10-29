package com.example.horseracing.repository;

import java.util.List;

import com.example.horseracing.form.RaceResultForm;

public interface RaceResultRepository {

	public int addRaceResult(RaceResultForm form);
	
	public List<RaceResultForm> getAllRaceResults();
}
