package com.org.bookApp.dto;

import com.org.bookApp.entity.BookCategory;

public class BookDto {

    private String bookName;
    private String authorName;
    private long available;
    private long price;
    private long publisherId; // Use publisherId instead of the entire Publisher object
    private BookCategory bookCategory;
	public String getBookName() {
		return bookName;
	}
	public void setBookName(String bookName) {
		this.bookName = bookName;
	}
	public String getAuthorName() {
		return authorName;
	}
	public void setAuthorName(String authorName) {
		this.authorName = authorName;
	}
	
	public long getPrice() {
		return price;
	}
	public void setPrice(long price) {
		this.price = price;
	}
	public long getPublisherId() {
		return publisherId;
	}
	public void setPublisherId(long publisherId) {
		this.publisherId = publisherId;
	}
	public BookCategory getBookCategory() {
		return bookCategory;
	}
	public void setBookCategory(BookCategory bookCategory) {
		this.bookCategory = bookCategory;
	}
	public long getAvailable() {
		return available;
	}
	public void setAvailable(long available) {
		this.available = available;
	}

	
    // Constructors, getters, and setters
}









//public class BookDto {
//	
//	private String bookName;
//    private String authorName;
//    private String available;
//    private String price;
//    private BookCategory bookCategory;
//    private Publisher publisher;  
//	
//	
//	public String getBookName() {
//		return bookName;
//	}
//	public void setBookName(String bookName) {
//		this.bookName = bookName;
//	}
//	public String getAuthorName() {
//		return authorName;
//	}
//	public void setAuthorName(String authorName) {
//		this.authorName = authorName;
//	}
//	
//	public BookCategory getBookCategory() {
//		return bookCategory;
//	}
//	public void setBookCategory(BookCategory bookCategory) {
//		this.bookCategory = bookCategory;
//	}
//	public String getAvailable() {
//		return available;
//	}
//	public void setAvailable(String available) {
//		this.available = available;
//	}
//	public String getPrice() {
//		return price;
//	}
//	public void setPrice(String price) {
//		this.price = price;
//	}
//	public Publisher getPublisher() {
//		return publisher;
//	}
//	public void setPublisher(Publisher publisher) {
//		this.publisher = publisher;
//	}
//	
//	
//	
//}
