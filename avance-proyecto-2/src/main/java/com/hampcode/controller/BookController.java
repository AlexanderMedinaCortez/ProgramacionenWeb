package com.hampcode.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.hampcode.model.entity.Book;
import com.hampcode.model.entity.Category;
import com.hampcode.service.BookService;
import com.hampcode.service.CategoryService;

@Controller
@RequestMapping("/books")
public class BookController {

	@Autowired
	private BookService bookService;

	@Autowired
	private CategoryService categoryService;

	@GetMapping
	public String showAllBooks(Model model) {
		model.addAttribute("books", bookService.getAll());
		model.addAttribute("categories", categoryService.getAll());
		return "books/list";
	}

	@GetMapping("/new")
	public String newBookForm(Model model) {
		model.addAttribute("book", new Book());
		List<Category> categories = categoryService.getAll();
		model.addAttribute("categories", categories);
		return "books/new";
	}

	@PostMapping("/save")
	public String saveNewBook(Book book) {
		long id = bookService.create(book);
		return "redirect:/books";
	}

	@GetMapping("/edit/{id}")
	public String editBookForm(@PathVariable("id") long id, Model model) {
		Book book = bookService.getOneById(id);
		List<Category> categories = categoryService.getAll();
		model.addAttribute("categories", categories);
		model.addAttribute("book", book);
		return "books/edit";
	}

	@PostMapping("/update/{id}")
	public String updateBook(@PathVariable("id") long id, Book book) {
		bookService.update(id, book);
		return "redirect:/books";
	}

}
