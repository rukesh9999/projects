package com.bookapi.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Book {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;
	private String title;
	private String author;
	private String profile_image;
    private String book_type;
    
    
	public long getId() {
		return id;
	}


	public void setId(long id) {
		this.id = id;
	}

	public String getTitle() {
		return title;
	}


	public void setTitle(String title) {
		this.title = title;
	}

	public String getAuthor() {
		return author;
	}

	public void setAuthor(String author) {
		this.author = author;
	}


	public String getProfile_image() {
		return profile_image;
	}


	public void setProfile_image(String profile_image) {
		this.profile_image = profile_image;
	}

	public String getBook_type() {
		return book_type;
	}


	public void setBook_type(String book_type) {
		this.book_type = book_type;
	}


	@Override
	public String toString() {
		return "Book [id=" + id + ", title=" + title + ", author=" + author + ", profile_image=" + profile_image
				+ ", book_type=" + book_type + "]";
	}  
    
    

}
