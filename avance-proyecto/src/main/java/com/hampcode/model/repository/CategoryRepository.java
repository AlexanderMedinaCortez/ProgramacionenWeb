package com.hampcode.model.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.hampcode.model.entity.Category;

@Repository
public interface CategoryRepository extends JpaRepository<Category, Long> {

}
