package com.bookapi.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.bookapi.model.Book;
import com.bookapi.service.BookService;
@CrossOrigin("*")
@RestController
@RequestMapping(value = "/api")
public class BookController {

	@Autowired
	private BookService bookService;

	@GetMapping("/books")
	public ResponseEntity<List<Book>> getBooks() {
		System.out.println(" controller..");
		List<Book> listOfBooks = bookService.getBooks();
		return ResponseEntity.ok().body(listOfBooks);
	}

	
	
	@PostMapping("/savebook")
	public ResponseEntity<?>  saveBook(@RequestBody Book book) {
		 
		 long bookid =  bookService.saveBook(book);
		 return ResponseEntity.ok().body("book created..."+bookid);
	}

	@GetMapping("/getbook/{id}")
	public ResponseEntity<Book> getBook(@PathVariable("id") long id) {
		Book book = bookService.getBook(id);

		return ResponseEntity.ok().body(book);
	}

	@PutMapping("/updatebook")
	public ResponseEntity<?> updateBook(@RequestBody Book book) {

		bookService.update(book);
		return ResponseEntity.ok().body("book updated..");
	}

	@DeleteMapping("/deletebook/{id}")
	public ResponseEntity<?> deleteBook(@PathVariable("id") long id) {
		bookService.deleteBook(id);
		return ResponseEntity.ok().body("Book deleted...");
	}

}
