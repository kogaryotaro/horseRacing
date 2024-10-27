package com.example.horseracing.form;

import jakarta.validation.constraints.NotNull;
import lombok.Data;

@Data
public class HorseForm {

	@NotNull(message="入力してください")
	private Integer id;
	
	@NotNull(message="入力してください")
	private String name;
	
	@NotNull(message="入力してください")
	private String breed;
	
	@NotNull(message="入力してください")
	private String age;
}
