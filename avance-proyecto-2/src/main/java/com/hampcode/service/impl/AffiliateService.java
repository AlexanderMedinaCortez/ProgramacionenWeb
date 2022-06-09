package com.hampcode.service.impl;


import java.util.List;


import com.hampcode.entity.Affiliate;
import com.hampcode.repository.AffiliateRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AffiliateService{

	@Autowired
	private AffiliateRepository affiliateRepository;

	public List<Affiliate> getAll() {
		return affiliateRepository.findAll();
	}

	public Affiliate getOneById(Long id) {
		return affiliateRepository.findById(id).orElseThrow(() -> new RuntimeException("Affiliate Not Found!"));
	}


	public Long create(Affiliate entity) {
		affiliateRepository.save(entity);
		return entity.getId();
	}

	
	public void update(Long id, Affiliate entity) {
		Affiliate currentAffiliate = getOneById(id);
		currentAffiliate.setFirstName(entity.getFirstName());
		currentAffiliate.setLastName(entity.getLastName());
		currentAffiliate.setCompanyName(entity.getCompanyName());
		currentAffiliate.setRuc(entity.getRuc());
		currentAffiliate.setPhone(entity.getPhone());
		currentAffiliate.setEmail(entity.getEmail());
		currentAffiliate.setPassword(entity.getPassword());
		currentAffiliate.setCountry(entity.getCountry());
		currentAffiliate.setDepartment(entity.getDepartment());
		currentAffiliate.setProvince(entity.getProvince());

		affiliateRepository.save(currentAffiliate);
	}

	
	public void delete(Long id) {
		affiliateRepository.deleteById(id);
	}

}
