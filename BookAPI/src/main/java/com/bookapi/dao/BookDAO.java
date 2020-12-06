package com.bookapi.dao;

import java.util.List;

import com.bookapi.model.Book;

public interface BookDAO {
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
	
    public void updateProfileImage(String profileImage , int userID);  

}
