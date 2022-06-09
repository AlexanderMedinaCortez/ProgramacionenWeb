package com.hampcode.service.impl;

import java.util.List;

import org.springframework.stereotype.Service;

import com.hampcode.entity.Province;
import com.hampcode.repository.ProvinceRepository;


@Service
public class ProvinceService {
	private ProvinceRepository provinceRepository;
	
	public ProvinceService(ProvinceRepository provinceRepository) {
		this.provinceRepository = provinceRepository;
	}
	
	public List<Province> getAllProvince() {
		return provinceRepository.findAll();
	}
	
	public List<Province> getAllProvinceByDeparment(Long id) {
		return provinceRepository.findAllByDepartment(id);
	}
}