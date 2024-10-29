package com.example.horseracing.repository;

import java.util.List;

import com.example.horseracing.form.HorseForm;

public interface HorseRepository {

	public int addHourse(HorseForm form);
	
	public List<HorseForm> getAllHorse();
}
