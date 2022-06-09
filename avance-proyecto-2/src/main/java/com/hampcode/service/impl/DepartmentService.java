package com.hampcode.service.impl;

import java.util.List;

import org.springframework.stereotype.Service;

import com.hampcode.entity.Department;
import com.hampcode.repository.DepartmentRepository;


@Service
public class DepartmentService {
	private DepartmentRepository departmentRepository;
	
	public DepartmentService(DepartmentRepository departmentRepository) {
		this.departmentRepository = departmentRepository;
	}
	
	public List<Department> getAllDeparment() {
		return departmentRepository.findAll();
	}
	
	public List<Department> getAllDeparmentByCountry(Long id) {
		return departmentRepository.findAllByCountry(id);
	}
}