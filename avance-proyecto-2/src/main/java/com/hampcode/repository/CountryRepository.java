package com.hampcode.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.hampcode.entity.Country;


public interface CountryRepository extends JpaRepository<Country,Long> {
	
}
