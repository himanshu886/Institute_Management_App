package com.himanshu.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.himanshu.entity.Institute;
import com.himanshu.payload.InstituteDto;
import com.himanshu.service.InstituteService;

import jakarta.validation.Valid;

@RestController
@RequestMapping("/api")
public class InstituteController {
	
		@Autowired
		private InstituteService instituteService;
	
		@PostMapping("/register")
		public ResponseEntity<InstituteDto> registerInstitute(@Valid @RequestBody InstituteDto instituteDto){
					InstituteDto registerInstitute = instituteService.registerInstitute(instituteDto);
					return new ResponseEntity<>(registerInstitute,HttpStatus.CREATED);
		}
		
		@PutMapping("/update/{instituteId}")
		public ResponseEntity<InstituteDto> updateInstitute(@Valid @RequestBody InstituteDto instituteDto,@PathVariable Integer instituteId){
			InstituteDto updatedInstitute = instituteService.updateInstitute(instituteDto,instituteId);
			
			return ResponseEntity.ok(updatedInstitute);
		}
		
		@GetMapping("/getAll")
		public ResponseEntity<List<InstituteDto>> getAllInstitute(){
			
			return ResponseEntity.ok(instituteService.getAllInstitute());
		}
		
		@GetMapping("/get/{instituteId}")
		public ResponseEntity<InstituteDto> getInstituteById(@PathVariable Integer instituteId){
			InstituteDto instituteById = instituteService.getInstituteById(instituteId);
			return ResponseEntity.ok(instituteById);
		}
}
