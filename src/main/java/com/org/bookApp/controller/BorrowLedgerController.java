package com.org.bookApp.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.org.bookApp.dto.BookDto;
import com.org.bookApp.dto.BorrowLedgerDto;
import com.org.bookApp.entity.BookEntry;
import com.org.bookApp.entity.BorrowLedger;
import com.org.bookApp.service.BorrowLedgerService;

@RestController
@RequestMapping("/borrowLedger")
public class BorrowLedgerController {

	@Autowired
	private BorrowLedgerService borrowLedgerService;
	
	@PostMapping(value = "/post")
	public BorrowLedger postBook(@RequestBody BorrowLedgerDto dto) {
		return borrowLedgerService.borrowLedgerDetails(dto);
	}
	
	@GetMapping("/{id}")
    public BorrowLedger getBorrowLedgerById(@PathVariable long id) {
        return borrowLedgerService.getBorrowLedgerById(id);
    }
	
	@GetMapping("/get")
	public List<BorrowLedger> getAll(BorrowLedgerDto dto){
		return borrowLedgerService.getAllBorrowLedger(dto);
	}
	@PutMapping("/update/{id}")
    public ResponseEntity<String> updateBorrowLedgerById(@RequestParam Long id, @RequestBody BorrowLedger updatedBorrowLedger) {
        boolean updated = borrowLedgerService.updateBorrowLedgerById(id, updatedBorrowLedger);

        if (updated) {
            return ResponseEntity.ok("Book updated successfully");
        } else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Book with the given ID not found");
        }
	}
}
