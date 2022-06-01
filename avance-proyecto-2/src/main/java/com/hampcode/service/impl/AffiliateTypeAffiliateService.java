package com.hampcode.service.impl;

import java.util.Date;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hampcode.entity.AffiliateTypeAffiliate;
import com.hampcode.repository.AffiliateTypeAffiliateRepository;


@Service
public class AffiliateTypeAffiliateService {

	@Autowired
	private AffiliateTypeAffiliateRepository affiliatetypeAffiliateRepository;

	public List<AffiliateTypeAffiliate> getAll() {
		return affiliatetypeAffiliateRepository.findAll();
	}
	
	public AffiliateTypeAffiliate getOneById(Long id) {
		return affiliatetypeAffiliateRepository.findById(id).orElseThrow(() -> new RuntimeException("Affiliate Not Found!"));
	}
	
	public void update(Long id, AffiliateTypeAffiliate entity) {
		AffiliateTypeAffiliate current = getOneById(id);
		current.setStartDate(entity.getStartDate());
		current.setFinishDate(entity.getFinishDate());
		current.setAffiliate(entity.getAffiliate());
		current.setTypeAffiliate(entity.getTypeAffiliate());

		affiliatetypeAffiliateRepository.save(current);
		
	}

	public void delete(Long id) {
		affiliatetypeAffiliateRepository.deleteById(id);
	}
	public Long create(AffiliateTypeAffiliate entity) {
		affiliatetypeAffiliateRepository.save(entity);
		return entity.getId();
	}
	

	public List<AffiliateTypeAffiliate> findByDate(Date startDate, Date finishDate){
		List<AffiliateTypeAffiliate> affiliateTypeAffiliates = affiliatetypeAffiliateRepository.findByDate(startDate, finishDate);
		return affiliateTypeAffiliates;
	}
}
