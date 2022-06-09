package com.hampcode.service.impl;
import java.util.List;

import org.springframework.stereotype.Service;

import com.hampcode.entity.Country;
import com.hampcode.repository.CountryRepository;



@Service
public class CountryService {
	private CountryRepository countryRepository;
	
	public CountryService(CountryRepository countryRepository) {
		this.countryRepository = countryRepository;
	}
	
	public List<Country> getAllCountry() {
		return countryRepository.findAll();
	}
	
}
