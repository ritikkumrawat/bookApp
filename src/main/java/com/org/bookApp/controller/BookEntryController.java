package com.org.bookApp.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController; 
import com.org.bookApp.dto.BookDto;
import com.org.bookApp.entity.BookEntry;
import com.org.bookApp.service.BookService;


@RestController
@RequestMapping("/book")
public class BookEntryController {

    @Autowired
    private BookService bookService;

    @PostMapping(value = "/post")
    public BookEntry postBook(@RequestBody BookDto dto) {
        return bookService.saveBookDetails(dto);
    }    
    @GetMapping("/get")
	public List<BookEntry> getAll(BookDto dto){
		return bookService.getAllBooks(dto);
	}
	
		@GetMapping("/getBook/{byId}")
	public ResponseEntity<BookEntry> getBookEntryById(@PathVariable Long byId) {
		BookEntry bookEntry=bookService.getBookById(byId);
		
		if ( bookEntry != null) {
            return new ResponseEntity<>(bookEntry, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }	
	}
	
	@DeleteMapping("/remove/{id}")
	public ResponseEntity<String> deleteBookEntryById(@PathVariable Long id) {
	
		boolean removed = bookService.removeBookById(id);

        if (removed) {
        	return new ResponseEntity<>("Book removed successfully", HttpStatus.OK);
          
        } else {
            return new ResponseEntity<>("Book with the given ID not found", HttpStatus.NOT_FOUND);
        }
	}
	
	@PutMapping("/update/{id}")
    public ResponseEntity<String> updateBookById(@RequestParam Long id, @RequestBody BookEntry updatedBook) {
        boolean updated = bookService.updateBookById(id, updatedBook);

        if (updated) {
            return ResponseEntity.ok("Book updated successfully");
        } else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Book with the given ID not found");
        }
	}
}










//@RestController
//@RequestMapping("/book")
//public class BookEntryController {
//	
//	@Autowired
//	private BookService bookService; 
//		
//	@PostMapping(value = "/post")
//	public BookEntry postBook(@RequestBody BookDto dto) {
//		return bookService.saveBookDetails(dto);
//	}
//
//	@GetMapping("/get")
//	public List<BookEntry> getAll(BookDto dto){
//		return bookService.getAllBooks(dto);
//	}
//	
//		@GetMapping("/getBook/{byId}")
//	public ResponseEntity<BookEntry> getBookEntryById(@PathVariable Long byId) {
//		BookEntry bookEntry=bookService.getBookById(byId);
//		
//		if ( bookEntry != null) {
//            return new ResponseEntity<>(bookEntry, HttpStatus.OK);
//        } else {
//            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
//        }	
//	}
//	
//	@DeleteMapping("/remove/{id}")
//	public ResponseEntity<String> deleteBookEntryById(@PathVariable Long id) {
//	
//		boolean removed = bookService.removeBookById(id);
//
//        if (removed) {
//        	return new ResponseEntity<>("Book removed successfully", HttpStatus.OK);
//          
//        } else {
//            return new ResponseEntity<>("Book with the given ID not found", HttpStatus.NOT_FOUND);
//        }
//	}
//	
//	@PutMapping("/update/{id}")
//    public ResponseEntity<String> updateBookById(@RequestParam Long id, @RequestBody BookEntry updatedBook) {
//        boolean updated = bookService.updateBookById(id, updatedBook);
//
//        if (updated) {
//            return ResponseEntity.ok("Book updated successfully");
//        } else {
//            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Book with the given ID not found");
//        }
//	}
//}
