package com.example.horseracing.form;

import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotNull;
import lombok.Data;

@Data
public class RaceResultForm {

	private Integer id;
	private Integer raceId;
	private Integer horseId;
	private Integer jockeyId;
	
	@Min(value=1, message="1以上")
	@Max(value=20, message="20未満")
	@NotNull(message="入力してください")
	private Integer position;
}
