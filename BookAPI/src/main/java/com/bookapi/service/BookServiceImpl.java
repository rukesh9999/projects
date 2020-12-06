package com.bookapi.service;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bookapi.dao.BookDAO;
import com.bookapi.model.Book;

@Service
public class BookServiceImpl implements BookService {

	@Autowired
	private BookDAO bookDAO;

	@Transactional
	public long saveBook(Book book) {
		// TODO Auto-generated method stub
	     long bookid = bookDAO.saveBook(book);
	     return bookid;
	}

	@Transactional
	public Book getBook(long id) {
		// TODO Auto-generated method stub
		Book book = bookDAO.getBook(id);
		return book;
	}

	@Transactional
	public List<Book> getBooks() {
		// TODO Auto-generated method stub
		List<Book> listOfBooks = bookDAO.getBooks();
		return listOfBooks;
	}

	@Transactional
	public void update(Book book) {
		// TODO Auto-generated method stub
		bookDAO.update(book);
	}

	@Transactional
	public void deleteBook(long id) {
		// TODO Auto-generated method stub
		bookDAO.deleteBook(id);
	}

}
