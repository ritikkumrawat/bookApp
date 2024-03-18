package com.org.bookApp.service;

import java.util.List;
import java.util.Optional;
import javax.persistence.EntityNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.org.bookApp.dto.BookDto;
import com.org.bookApp.dto.BorrowLedgerDto;
import com.org.bookApp.entity.BookEntry;
import com.org.bookApp.entity.BorrowLedger;
import com.org.bookApp.entity.Member;
import com.org.bookApp.repository.BookRepository;
import com.org.bookApp.repository.BorrowLedgerRepository;
import com.org.bookApp.repository.MemberRepository;

@Service
public class BorrowLedgerService {


	 @Autowired
	    private BorrowLedgerRepository borrowLedgerRepository;
	 
	 @Autowired
	  private BookRepository bookRepository;
	 
	 @Autowired
	 private MemberRepository memberRepository;
	 
	 
	    public BorrowLedger borrowLedgerDetails(BorrowLedgerDto borrowLedgerDto) {
	        BorrowLedger borrowLedger = new BorrowLedger();
	        borrowLedger.setExpiry_date(borrowLedgerDto.getExpiry_date());
	        borrowLedger.setIssue_date(borrowLedgerDto.getIssue_date());

	        // Fetch the BookEntry by ID
	       Optional<BookEntry> optionalBookEntry = bookRepository.findById(borrowLedgerDto.getBookId());
	       BookEntry bookEntry = optionalBookEntry.orElseThrow(() -> new EntityNotFoundException("BookEntry not found"));
	        borrowLedger.setBook(bookEntry);

	        // Fetch the Member by ID
	        Optional<Member> optionalMember = memberRepository.findById(borrowLedgerDto.getMemberId());
	        Member member=optionalMember.orElseThrow(() -> new EntityNotFoundException("Member not found"));
	        borrowLedger.setMember(member);

	        // Save the BorrowLedger
	        BorrowLedger savedBorrowLedger = borrowLedgerRepository.save(borrowLedger);
	        return savedBorrowLedger;
	    }
	    
	    public List<BorrowLedger> getAllBorrowLedger(BorrowLedgerDto dto){
			return borrowLedgerRepository.findAll();
		}
	    
	    @Transactional
	    public BorrowLedger getBorrowLedgerById(long borrowLedgerId) {
	        return borrowLedgerRepository.findById(borrowLedgerId).orElse(null);
	    }
	    
 public boolean updateBorrowLedgerById(Long borrowLedgerId, BorrowLedger updatedBorrowLedger) {
			
	        if (bookRepository.existsById(borrowLedgerId)) {
	        	updatedBorrowLedger.setBorrowLedgerId(0);
	            borrowLedgerRepository.save(updatedBorrowLedger);
	            return true; 
	        } else {
	            return false; 
	        }
	     }	
	    
	    
	    
	}
	



