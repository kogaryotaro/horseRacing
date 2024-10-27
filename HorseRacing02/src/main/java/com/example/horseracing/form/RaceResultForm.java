package com.example.horseracing.form;

import lombok.Data;

@Data
public class RaceResultForm {

	private Integer id;
	private Integer raceId;
	private Integer horseId;
	private Integer jockeyId;
	private Integer position;
}
