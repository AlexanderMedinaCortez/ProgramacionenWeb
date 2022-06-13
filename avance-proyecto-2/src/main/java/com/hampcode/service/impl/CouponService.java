package com.hampcode.service.impl;

import java.util.List;

import com.hampcode.entity.Coupon;
import com.hampcode.repository.CouponRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CouponService {

	@Autowired
	private CouponRepository couponRepository;

	public List<Coupon> getAll() {
		return couponRepository.findAll();
	}

	public Coupon getOneById(Long id) {
		return couponRepository.findById(id).orElseThrow(() -> new RuntimeException("Coupon Not Found!"));
	}

	
	public Long create(Coupon entity) {
		couponRepository.save(entity);
		return entity.getId();
	}

	
	public void update(Long id, Coupon entity) {
		Coupon currentCoupon = getOneById(id);
		currentCoupon.setName(entity.getName());
		currentCoupon.setDiscount(entity.getDiscount());

		couponRepository.save(currentCoupon);
	}

	
	public void delete(Long id) {
		couponRepository.deleteById(id);
	}

}
