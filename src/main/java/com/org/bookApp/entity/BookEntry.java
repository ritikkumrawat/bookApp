package com.org.bookApp.entity;


import java.util.Date;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
@Table(name = "book_entry")
public class BookEntry {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="book_id")
    private long bookId;

    @Column(name = "Book_Name")
    private String bookName;

    @Column(name = "Author_Name")
    private String authorName;
    
    @Temporal(TemporalType.DATE)
    @Column(name = "Date")
    private Date date;

    @Column(name = "available")
    private long available;

    @Column(name = "price")
    private long price;

    @ManyToOne
    @JoinColumn(name = "publisher_id", nullable = false)
    private Publisher publisher;
    
    @Enumerated(EnumType.STRING)
    private BookCategory bookCategory;

	public long getId() {
		return bookId;
	}

	public void setId(long id) {
		this.bookId = id;
	}

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

	public Date getDate() {
		return date;
	}

	public void setDate(Date date) {
		this.date = date;
	}

	public long getAvailable() {
		return available;
	}

	public void setAvailable(long available) {
		this.available = available;
	}

	public long getPrice() {
		return price;
	}

	public void setPrice(long price) {
		this.price = price;
	}

	public Publisher getPublisher() {
		return publisher;
	}

	public void setPublisher(Publisher publisher) {
		this.publisher = publisher;
	}

	public BookCategory getBookCategory() {
		return bookCategory;
	}

	public void setBookCategory(BookCategory bookCategory) {
		this.bookCategory = bookCategory;
	}

	public BookEntry(long bookId, String bookName, String authorName, Date date, long available, long price,
			Publisher publisher, BookCategory bookCategory) {
		super();
		this.bookId = bookId;
		this.bookName = bookName;
		this.authorName = authorName;
		this.date = date;
		this.available = available;
		this.price = price;
		this.publisher = publisher;
		this.bookCategory = bookCategory;
	}

	public BookEntry() {
		super();
	}

	@Override
	public String toString() {
		return "BookEntry [bookId=" + bookId + ", bookName=" + bookName + ", authorName=" + authorName + ", date="
				+ date + ", available=" + available + ", price=" + price + ", publisher=" + publisher
				+ ", bookCategory=" + bookCategory + "]";
	}

    // Constructors, getters, and setters
	
}
