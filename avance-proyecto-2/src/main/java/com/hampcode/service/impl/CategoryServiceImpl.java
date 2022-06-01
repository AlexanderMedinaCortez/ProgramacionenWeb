package com.hampcode.service.impl;

import java.util.List;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hampcode.model.entity.Category;
import com.hampcode.model.repository.CategoryRepository;

@Service
public class CategoryServiceImpl {

	@Autowired
	private CategoryRepository categoryRepository;

	
	public List<Category> getAll() {
		return categoryRepository.findAll();
	}

	
	public Category getOneById(Long id) {
		return categoryRepository.findById(id).orElseThrow(() -> new RuntimeException("Category Not Found!"));
	}

	
	public Long create(Category entity) {
		categoryRepository.save(entity);
		return entity.getId();
	}

	
	public void update(Long id, Category entity) {
		Category currentCategory = getOneById(id);
		currentCategory.setName(entity.getName());
		categoryRepository.save(currentCategory);
	}

	
	public void delete(Long id) {
		categoryRepository.deleteById(id);
	}

}
