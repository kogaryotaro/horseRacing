package com.example.horseracing.repository;

import java.util.List;

import com.example.horseracing.form.JockeyForm;

public interface JockeyRepository {

	public int addJockey(JockeyForm form);
	
	public List<JockeyForm> getAllJockeys();
}
