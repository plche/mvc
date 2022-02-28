package com.codingdojo.peru.full_time_2022.mvc.controllers;

import java.util.List;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.codingdojo.peru.full_time_2022.mvc.models.Book;
import com.codingdojo.peru.full_time_2022.mvc.services.BookService;

@RestController
public class BooksApi {
	private final BookService bookService;

	public BooksApi(BookService bookService) {
		this.bookService = bookService;
	}
	
	@RequestMapping("/api/books")
	public List<Book> index() {
		return bookService.allBooks();
	}
	
	@RequestMapping(value = "/api/books", method = RequestMethod.POST)
	public Book create(@RequestParam(value = "title") String title, @RequestParam(value = "description") String description,
						@RequestParam(value = "language") String language, @RequestParam(value = "pages") Integer numOfPages) {
		Book book = new Book(title, description, language, numOfPages);
		return bookService.createBook(book);
	}
	
	@RequestMapping(value = "/api/books/{id}")
	public Book show(@PathVariable("id") Long id) {
		Book book = bookService.findBook(id);
		return book;
	}
	
	@RequestMapping(value = "/api/books/{id}", method = RequestMethod.PUT)
    public Book update(@PathVariable("id") Long id, @RequestParam(value="title") String title, @RequestParam(value="description") String description,
    					@RequestParam(value="language") String language, @RequestParam(value="pages") Integer numOfPages) {
        Book book = bookService.updateBook(id, title, description, language, numOfPages);
        return book;
    }
    
    @RequestMapping(value = "/api/books/{id}", method = RequestMethod.DELETE)
    public void destroy(@PathVariable("id") Long id) {
        bookService.deleteBook(id);
    }
}
