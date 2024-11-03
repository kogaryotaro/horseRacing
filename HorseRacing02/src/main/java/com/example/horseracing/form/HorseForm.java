package com.example.horseracing.form;

import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.Data;

@Data
public class HorseForm {

	private Integer id;
	
	@Size(min=3, message="3文字以上で入力してください")
	@NotNull(message="入力してください")
	private String name;
	
	@NotNull(message="入力してください")
	private String breed;
	
	@Min(value=2, message="2歳以上")
	@Max(value=11, message="12歳未満")
	@NotNull(message="入力してください")
	private Integer age;
}
