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
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import org.springframework.format.annotation.DateTimeFormat;

@Entity
@Table(name = "affiliate_type_affiliate")
public class AffiliateTypeAffiliate {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@DateTimeFormat(pattern = "yyyy-mm-dd")
	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "start_date")
	private Date startDate;

	@DateTimeFormat(pattern = "yyyy-mm-dd")
	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "finish_date")
	private Date finishDate;

	@ManyToOne
	@JoinColumn(name = "affiliate_id")
	private Affiliate affiliate;

	@ManyToOne
	@JoinColumn(name = "typeAffiliate_id")
	private TypeAffiliate typeAffiliate;

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
