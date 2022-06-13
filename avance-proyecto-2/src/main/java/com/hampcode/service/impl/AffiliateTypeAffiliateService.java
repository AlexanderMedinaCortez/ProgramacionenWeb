package com.hampcode.service.impl;

import java.util.Calendar;

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
		double totalPrice;
		List<AffiliateTypeAffiliate> affiliateTypeAffiliates=affiliatetypeAffiliateRepository.findAll();
		
		for (AffiliateTypeAffiliate affiliateTypeAffiliate : affiliateTypeAffiliates) {
			totalPrice= affiliateTypeAffiliate.getTypeAffiliate().getPrice()*((100-affiliateTypeAffiliate.getCoupon().getDiscount())/100);
			affiliateTypeAffiliate.setTotalPrice(totalPrice);
		
		}

		
		return affiliatetypeAffiliateRepository.findAll();
	}
	
	public double totalHistoryPrice(List<AffiliateTypeAffiliate> affiliateTypeAffiliates) {
		double historyPrice=0;
		
		for (AffiliateTypeAffiliate affiliateTypeAffiliate : affiliateTypeAffiliates) {
			historyPrice= historyPrice + affiliateTypeAffiliate.getTotalPrice();
		}
		return historyPrice;
	}

	public AffiliateTypeAffiliate getOneById(Long id) {
		return affiliatetypeAffiliateRepository.findById(id)
				.orElseThrow(() -> new RuntimeException("Affiliate Not Found!"));
	}

	public void update(Long id, AffiliateTypeAffiliate entity) {
		
		AffiliateTypeAffiliate current = getOneById(id);
		Calendar c = Calendar.getInstance();
		entity.setStartDate(c.getTime());
		
		if (entity.getTypeAffiliate().getId() == 1) {
			c.add(Calendar.MONTH, 1);
			current.setFinishDate(c.getTime());
		}

		else {
			c.add(Calendar.MONTH, 12);
			current.setFinishDate(c.getTime());
		}
		
		current.setAffiliate(entity.getAffiliate());
		current.setTypeAffiliate(entity.getTypeAffiliate());
		current.setCoupon(entity.getCoupon());

		affiliatetypeAffiliateRepository.save(current);

	}

	public void delete(Long id) {
		affiliatetypeAffiliateRepository.deleteById(id);
	}

	public Long create(AffiliateTypeAffiliate entity) {

		Calendar c = Calendar.getInstance();
		entity.setStartDate(c.getTime());
		
		if (entity.getTypeAffiliate().getId() == 1) {
			c.add(Calendar.MONTH, 1);
			entity.setFinishDate(c.getTime());
		}

		else {
			c.add(Calendar.MONTH, 12);
			entity.setFinishDate(c.getTime());
		}

		affiliatetypeAffiliateRepository.save(entity);
		return entity.getId();
	}

	public List<AffiliateTypeAffiliate> findByDate(Date startDate, Date finishDate) {
		List<AffiliateTypeAffiliate> affiliateTypeAffiliates = affiliatetypeAffiliateRepository.findByDate(startDate,
				finishDate);
		return affiliateTypeAffiliates;
	}

	public List<AffiliateTypeAffiliate> findCoupon(String name) {
		List<AffiliateTypeAffiliate> affiliateTypeAffiliates = affiliatetypeAffiliateRepository.findCoupon(name);
		return affiliateTypeAffiliates;
	}

}
