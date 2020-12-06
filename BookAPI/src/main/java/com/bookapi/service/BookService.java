package com.bookapi.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.bookapi.model.Book;

public interface BookService {

	// save book
	long saveBook(Book book);

	// get the book
	Book getBook(long id);

	// get all books
	List<Book> getBooks();

	// update a book
	void update(Book book);

	// delete a book
	void deleteBook(long id);
	

}
