package com.hampcode.service.impl;

import java.util.List;

import com.hampcode.entity.Affiliate;
import com.hampcode.repository.AffiliateRepository;
import com.hampcode.service.AffiliateService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AffiliateServiceImpl implements AffiliateService {

	@Autowired
	private AffiliateRepository affiliateRepository;

	@Override
	public List<Affiliate> getAll() {
		return affiliateRepository.findAll();
	}

	@Override
	public Affiliate getOneById(Long id) {
		return affiliateRepository.findById(id).orElseThrow(() -> new RuntimeException("Affiliate Not Found!"));
	}

	@Override
	public Long create(Affiliate entity) {
		affiliateRepository.save(entity);
		return entity.getId();
	}

	@Override
	public void update(Long id, Affiliate entity) {
		Affiliate currentAffiliate = getOneById(id);
		currentAffiliate.setFirstName(entity.getFirstName());
		currentAffiliate.setLastName(entity.getLastName());
		currentAffiliate.setCompanyName(entity.getCompanyName());
		currentAffiliate.setRuc(entity.getRuc());
		currentAffiliate.setPhone(entity.getPhone());
		currentAffiliate.setEmail(entity.getEmail());
		currentAffiliate.setPassword(entity.getPassword());
		currentAffiliate.setTypeAffiliates(entity.getTypeAffiliates());

		affiliateRepository.save(currentAffiliate);
	}

	@Override
	public void delete(Long id) {
		affiliateRepository.deleteById(id);
	}

}
