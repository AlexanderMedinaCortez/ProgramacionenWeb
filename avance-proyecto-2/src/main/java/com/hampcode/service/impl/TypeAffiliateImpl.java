package com.hampcode.service.impl;

import java.util.List;


import com.hampcode.entity.TypeAffiliate;
import com.hampcode.repository.TypeAffiliateRepository;
import com.hampcode.service.TypeAffiliateService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class TypeAffiliateImpl implements TypeAffiliateService {

	@Autowired
	private TypeAffiliateRepository typeAffiliateRepository;

	@Override
	public List<TypeAffiliate> getAll() {
		return typeAffiliateRepository.findAll();
	}

	@Override
	public TypeAffiliate getOneById(Long id) {
		return typeAffiliateRepository.findById(id).orElseThrow(() -> new RuntimeException("TypeAffiliate Not Found!"));
	}

	@Override
	public Long create(TypeAffiliate entity) {
		typeAffiliateRepository.save(entity);
		return entity.getId();
	}

	@Override
	public void update(Long id, TypeAffiliate entity) {
		TypeAffiliate currentTypeAffiliate = getOneById(id);
		currentTypeAffiliate.setType(entity.getType());
		currentTypeAffiliate.setPrice(entity.getPrice());

		typeAffiliateRepository.save(currentTypeAffiliate);
	}

	@Override
	public void delete(Long id) {
		typeAffiliateRepository.deleteById(id);
	}

}

