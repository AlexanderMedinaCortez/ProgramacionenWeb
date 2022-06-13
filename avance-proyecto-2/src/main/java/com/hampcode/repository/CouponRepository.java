package com.hampcode.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.hampcode.entity.Coupon;

public interface CouponRepository extends JpaRepository<Coupon, Long> {

}
