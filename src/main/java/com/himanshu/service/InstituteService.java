package com.himanshu.service;

import java.util.List;

import com.himanshu.entity.Institute;
import com.himanshu.payload.InstituteDto;

public interface InstituteService {
	
		InstituteDto registerInstitute(InstituteDto instituteDto);
		
		InstituteDto updateInstitute(InstituteDto institute,Integer instituteId);
		
		List<InstituteDto> getAllInstitute();
		
		InstituteDto getInstituteById(Integer instituteId);

}
