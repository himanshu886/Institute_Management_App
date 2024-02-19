package com.himanshu.payload;

import org.hibernate.validator.constraints.Length;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class InstituteDto {
	
	@Length(min = 2, max = 40, message = "Invalid Name!!!!!!")
	private String name;
	
	@Length(min = 2, max = 20, message = "Invalid Location!!!!!!")
	private String location;
	
	@Length(min = 2, max = 20, message = "Invalid Contact!!!!!!")
	private String contact;
	
	@Length(min = 2, max = 100, message = "Invalid Description!!!!!!")
	private String description;
	
}
