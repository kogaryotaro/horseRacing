package com.example.horseracing.form;

import jakarta.validation.constraints.NotNull;
import lombok.Data;

@Data
public class RaceForm {
	
	@NotNull(message="入力してください")
	private Integer id;
	
	@NotNull(message="入力してください")
	private String location;

	@NotNull(message="入力してください")	
	private String date;
	
	@NotNull(message="入力してください")	
	private String weather;
	
	@NotNull(message="入力してください")
	private String trackCondition;

}
