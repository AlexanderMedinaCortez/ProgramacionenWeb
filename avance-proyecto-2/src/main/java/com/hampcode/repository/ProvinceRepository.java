package com.hampcode.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.hampcode.entity.Province;


public interface ProvinceRepository extends JpaRepository<Province,Long> {
	
	@Query("FROM Province WHERE department_id = ?1")
	List<Province> findAllByDepartment(Long id);
}
