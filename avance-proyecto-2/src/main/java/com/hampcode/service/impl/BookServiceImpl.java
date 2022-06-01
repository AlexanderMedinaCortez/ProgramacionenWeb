package com.hampcode.service.impl;

import java.util.List;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hampcode.model.entity.Book;
import com.hampcode.model.repository.BookRepository;

@Service
public class BookServiceImpl {

	@Autowired
	private BookRepository bookRepository;

	public List<Book> getAll() {
		return bookRepository.findAll();
	}

	public Book getOneById(Long id) {
		return bookRepository.findById(id).orElseThrow(() -> new RuntimeException("Book Not Found!"));
	}

	public Long create(Book entity) {
		bookRepository.save(entity);
		return entity.getId();
	}

	public void update(Long id, Book entity) {
		Book currentBook = getOneById(id);
		currentBook.setTitle(entity.getTitle());
		currentBook.setAuthor(entity.getAuthor());
		currentBook.setCategories(entity.getCategories());
		currentBook.setDescription(entity.getDescription());
		currentBook.setDateField(entity.getDateField());
		bookRepository.save(currentBook);
	}

	
	public void delete(Long id) {
		bookRepository.deleteById(id);
	}

}
