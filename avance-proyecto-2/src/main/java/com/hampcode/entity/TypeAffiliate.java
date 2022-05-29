package com.hampcode.entity;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

@Entity
@Table(name = "type_affiliate")
public class TypeAffiliate {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@Column(name = "type", nullable = false)
	private String type;

	@Column(name = "price", nullable = false)
	private double price;

	@ManyToMany(mappedBy = "typeAffiliates")
	private List<Affiliate> affiliates;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public double getPrice() {
		return price;
	}

	public void setPrice(double price) {
		this.price = price;
	}

	public List<Affiliate> getAffiliates() {
		return affiliates;
	}

	public void setAffiliates(List<Affiliate> affiliates) {
		this.affiliates = affiliates;
	}

}
