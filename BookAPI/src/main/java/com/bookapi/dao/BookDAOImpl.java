package com.bookapi.dao;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.hibernate5.HibernateTemplate;
import org.springframework.stereotype.Repository;

import com.bookapi.model.Book;

@Repository
public class BookDAOImpl implements BookDAO {

	@Autowired
	private HibernateTemplate hibernateTemplate;

	public long saveBook(Book book) {

		long bookId =  (Long) hibernateTemplate.save(book);
        return bookId;
	}

	public Book getBook(long id) {
		// TODO Auto-generated method stub
		return hibernateTemplate.get(Book.class, id);
	}

	public List<Book> getBooks() {
		// TODO Auto-generated method stub
		List<Book> listOfBooks = hibernateTemplate.loadAll(Book.class);
		return listOfBooks;
	}

	public void update(Book book) {
		hibernateTemplate.update(book);;
		
	}

	public void deleteBook(long id) {
		// TODO Auto-generated method stub
		Book book = hibernateTemplate.get(Book.class, id);
		if(book==null)
		{
			throw new RuntimeException("Book is not founf with id...."+id);
		}	
		else{
		   hibernateTemplate.delete(book);;
		}
	}

	@Override
	public void updateProfileImage(String profileImage, int userID) {
		// TODO Auto-generated method stub
		  hibernateTemplate.find("update Book set profile_image = :profileImage where id=:id ", profileImage,userID);
		
	}

	
}
