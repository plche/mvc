package com.codingdojo.peru.full_time_2022.mvc.services;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.codingdojo.peru.full_time_2022.mvc.models.Book;
import com.codingdojo.peru.full_time_2022.mvc.repositories.BookRepository;

@Service
public class BookService {
	// agregar el repositorio de libros como una dependencia
	private final BookRepository bookRepository;

	public BookService(BookRepository bookRepository) {
		this.bookRepository = bookRepository;
	}
	
	// returns all the books
	public List<Book> allBooks() {
		return bookRepository.findAll();
	}
	
	// creates a book
	public Book createBook(Book book) {
		return bookRepository.save(book);
	}
	
	// retrieves a book
	public Book findBook(Long id) {
		Optional<Book> optionalBook = bookRepository.findById(id);
		if (optionalBook.isPresent()) {
			return optionalBook.get();
		} else return null;
	}
	
	// updates a book
	public Book updateBook(Long id, String title, String description, String language, Integer numOfPages) {
		Book book = new Book(title, description, language, numOfPages);
		book.setId(id);
		return bookRepository.save(book);
	}
	
	// removes a book
	public void deleteBook(Long id) {
		bookRepository.deleteById(id);
	}
}
