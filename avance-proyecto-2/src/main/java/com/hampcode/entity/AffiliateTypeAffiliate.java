package com.hampcode.entity;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Transient;
import javax.transaction.TransactionScoped;

import org.springframework.format.annotation.DateTimeFormat;

@Entity
@Table(name = "affiliate_type_affiliate")
public class AffiliateTypeAffiliate {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@DateTimeFormat(pattern = "yyyy-MM-dd")
	@Column(name = "start_date")
	private Date startDate;

	@DateTimeFormat(pattern = "yyyy-MM-dd")
	@Column(name = "finish_date")
	private Date finishDate;

	@Transient
	private double totalPrice;

	@ManyToOne
	@JoinColumn(name = "affiliate_id")
	private Affiliate affiliate;

	@ManyToOne
	@JoinColumn(name = "typeAffiliate_id")
	private TypeAffiliate typeAffiliate;

	@ManyToOne
	@JoinColumn(name = "coupon_id")
	private Coupon coupon;

	public double getTotalPrice() {
		return totalPrice;
	}

	public void setTotalPrice(double totalPrice) {
		this.totalPrice = totalPrice;
	}

	public Coupon getCoupon() {
		return coupon;
	}

	public void setCoupon(Coupon coupon) {
		this.coupon = coupon;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Date getStartDate() {
		return startDate;
	}

	public void setStartDate(Date startDate) {
		this.startDate = startDate;
	}

	public Date getFinishDate() {
		return finishDate;
	}

	public void setFinishDate(Date finishDate) {
		this.finishDate = finishDate;
	}

	public Affiliate getAffiliate() {
		return affiliate;
	}

	public void setAffiliate(Affiliate affiliate) {
		this.affiliate = affiliate;
	}

	public TypeAffiliate getTypeAffiliate() {
		return typeAffiliate;
	}

	public void setTypeAffiliate(TypeAffiliate typeAffiliate) {
		this.typeAffiliate = typeAffiliate;
	}

}
