package com.example.horseracing.form;

import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.Data;

@Data
public class JockeyForm {

	private Integer id;
	
	@NotNull(message="入力してください")
	@Size(min=3, message="3文字以上で入力してください")
	private String name;
	
	@Min(value=2, message="2年以上")
	@Max(value=100, message="100年未満")
	@NotNull(message="入力してください")
	private Integer experience;
}
