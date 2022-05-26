package com.hampcode.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hampcode.model.entity.Book;
import com.hampcode.model.repository.BookRepository;
import com.hampcode.service.BookService;

@Service
public class BookServiceImpl implements BookService {

	@Autowired
	private BookRepository bookRepository;

	@Override
	public List<Book> getAll() {
		return bookRepository.findAll();
	}

	@Override
	public Book getOneById(Long id) {
		return bookRepository.findById(id).orElseThrow(() -> new RuntimeException("Book Not Found!"));
	}

	@Override
	public Long create(Book entity) {
		bookRepository.save(entity);
		return entity.getId();
	}

	@Override
	public void update(Long id, Book entity) {
		Book currentBook = getOneById(id);
		currentBook.setTitle(entity.getTitle());
		currentBook.setAuthor(entity.getAuthor());
		currentBook.setCategories(entity.getCategories());
		currentBook.setDescription(entity.getDescription());
		currentBook.setDateField(entity.getDateField());
		bookRepository.save(currentBook);
	}

	@Override
	public void delete(Long id) {
		bookRepository.deleteById(id);
	}

}
