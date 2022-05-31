package com.hampcode.model.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.hampcode.model.entity.Book;

@Repository
public interface BookRepository extends JpaRepository<Book, Long> {

}
