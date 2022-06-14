package com.hampcode.repository;

import java.util.Date;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.hampcode.entity.AffiliateTypeAffiliate;

public interface AffiliateTypeAffiliateRepository extends JpaRepository<AffiliateTypeAffiliate, Long> {

	@Query("select a FROM AffiliateTypeAffiliate a where a.startDate>=?1 and a.finishDate<=?2")
	List<AffiliateTypeAffiliate> findByDate(Date startDate, Date finishDate);

	@Query("select a FROM AffiliateTypeAffiliate a JOIN a.coupon c where c.name=?1")
	List<AffiliateTypeAffiliate> findCoupon(String name);

}
