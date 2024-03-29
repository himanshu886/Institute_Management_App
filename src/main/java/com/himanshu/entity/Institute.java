package com.himanshu.entity;

import org.hibernate.validator.constraints.Length;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.validation.constraints.NotBlank;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Getter
@Setter
@NoArgsConstructor
public class Institute {
	
		@Id
		@GeneratedValue(strategy = GenerationType.IDENTITY)
		private Integer instituteId;
		
		private String name;
		
		private String location;
		
		private String contact;
		
		private String description;
}
