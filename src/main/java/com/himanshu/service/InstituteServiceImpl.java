package com.himanshu.service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.himanshu.entity.Institute;
import com.himanshu.exception.ResourceNotFoundException;
import com.himanshu.payload.InstituteDto;
import com.himanshu.repository.InstituteRespository;

@Service
public class InstituteServiceImpl implements InstituteService {
	
		@Autowired
		private InstituteRespository instituteRepo;
		
		@Autowired
		private ModelMapper modelMapper;

	@Override
	public InstituteDto registerInstitute(InstituteDto instituteDto) {
			Institute institute = dtoToInstitute(instituteDto);
			Institute savedInstitute = instituteRepo.save(institute);
			
			return instituteToDto(savedInstitute);
	}

	@Override
	public InstituteDto updateInstitute(InstituteDto instituteDto, Integer instituteId) {
		 
		Institute institute = instituteRepo.findById(instituteId).orElseThrow(()-> new ResourceNotFoundException("Institute", "InstituteId", instituteId));

			institute.setName(instituteDto.getName());
			institute.setLocation(instituteDto.getLocation());
			institute.setContact(instituteDto.getContact());
			
			Institute updatedInstitute = instituteRepo.save(institute);
			
			return instituteToDto(updatedInstitute);
	}

	@Override
	public List<InstituteDto> getAllInstitute() {
			List<Institute> findAll = instituteRepo.findAll();
			List<InstituteDto> collect = findAll.stream().map(institute-> instituteToDto(institute)).collect(Collectors.toList());
			return collect;
			
	}
	
	private InstituteDto instituteToDto(Institute institute) {
		return modelMapper.map(institute, InstituteDto.class);
	}
	
	private Institute dtoToInstitute(InstituteDto instituteDto) {
		return modelMapper.map(instituteDto, Institute.class);
	}

	@Override
	public InstituteDto getInstituteById(Integer instituteId) {
		 Institute institute = instituteRepo.findById(instituteId).orElseThrow(()-> new ResourceNotFoundException("Institute","InstituteId", instituteId));
		 
		 return instituteToDto(institute);
	}
	
}
