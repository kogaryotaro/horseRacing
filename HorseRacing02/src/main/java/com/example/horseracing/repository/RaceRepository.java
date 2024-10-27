package com.example.horseracing.repository;

import java.util.List;

import com.example.horseracing.form.RaceForm;

public interface RaceRepository {
	
	public int addRace(RaceForm form);
	
	public List<RaceForm> getAllRaces();

}
