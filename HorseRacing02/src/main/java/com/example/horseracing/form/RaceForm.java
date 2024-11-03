package com.example.horseracing.form;

import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.Data;

@Data
public class RaceForm {
	
	private Integer id;
	
	@Size(max=3, message="3文字以下で入力してください")	
	@NotNull(message="入力してください")
	private String location;

	@NotNull(message="入力してください")	
	private String date;
	
	@NotNull(message="入力してください")	
	private String weather;
	
	@Size(max=3, message="3文字以下で入力してください")
	@NotNull(message="入力してください")
	private String trackCondition;

}
