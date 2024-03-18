package com.org.bookApp.service;

import java.util.Date;
import java.util.List;
import java.util.Optional;

import javax.persistence.EntityNotFoundException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;
import com.org.bookApp.dto.BookDto;
import com.org.bookApp.entity.BookEntry;
import com.org.bookApp.entity.Publisher;
import com.org.bookApp.repository.BookRepository;
import com.org.bookApp.repository.PublisherRepository;

@Service
public class BookService {

	
	    @Autowired
	    private BookRepository bookRepository;

	    @Autowired
	    private PublisherRepository publisherRepository;

	    public BookEntry saveBookDetails(BookDto dto) {
	       
	        // Fetch the Publisher from the database using the provided publisherId
	        Optional<Publisher> optionalPublisher = publisherRepository.findById(dto.getPublisherId());
	        Publisher publisher = optionalPublisher.orElseThrow(() -> new EntityNotFoundException("Publisher not found"));

	        BookEntry bookEntry = new BookEntry();
	        bookEntry.setAuthorName(dto.getAuthorName());
	        bookEntry.setBookName(dto.getBookName());
	        bookEntry.setDate(new Date());
	        bookEntry.setPrice(dto.getPrice());
	        bookEntry.setAvailable(dto.getAvailable());
	        bookEntry.setBookCategory(dto.getBookCategory());
	        bookEntry.setPublisher(publisher);

	        BookEntry savedBookEntry = bookRepository.save(bookEntry);
	        return savedBookEntry;
	    }
	    
	    public List<BookEntry> getAllBooks(BookDto dto){
			return bookRepository.findAll();
		}
	    public BookEntry getBookById(@PathVariable Long bookId) {
			
			return bookRepository.findById(bookId).orElse(null);
		}
	    public boolean removeBookById(Long bookId) {
			
			 if (bookRepository.existsById(bookId)) {  
		            bookRepository.deleteById(bookId);
		            return true; 
		        } else {
		            return false; 
		        }
	}
	    public boolean updateBookById(Long bookId, BookEntry updatedBook) {
			
	        if (bookRepository.existsById(bookId)) {
	            updatedBook.setId(bookId);
	            bookRepository.save(updatedBook);
	            return true; 
	        } else {
	            return false; 
	        }
	     }	
	    public BookEntry getBookEntryById(long bookId) {
	        return bookRepository.findById(bookId)
	                .orElseThrow(() -> new EntityNotFoundException("BookEntry not found with id: " + bookId));
	    }

}	
	









