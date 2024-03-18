package com.org.bookApp.entity;

import java.util.Date;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
@Table(name="borrowLedger")
 public class BorrowLedger {
	 
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private long  borrowLedgerId;
  
  
  
  @Temporal(TemporalType.TIMESTAMP)
  @Column(name="issue_date")
  private Date issue_date;
  @Temporal(TemporalType.TIMESTAMP)
  @Column(name="expiry_date")
  private Date expiry_date; 
  
  @ManyToOne(fetch = FetchType.LAZY)
  @JoinColumn(name = "book_id", nullable = false)
  private BookEntry book;
  
  @ManyToOne(fetch = FetchType.LAZY)
  @JoinColumn(name = "member_id",nullable = false)
  private Member member ;

public long getBorrowLedgerId() {
	return borrowLedgerId;
}

public void setBorrowLedgerId(long borrowLedgerId) {
	this.borrowLedgerId = borrowLedgerId;
}

public Date getIssue_date() {
	return issue_date;
}

public void setIssue_date(Date issue_date) {
	this.issue_date = issue_date;
}

public Date getExpiry_date() {
	return expiry_date;
}

public void setExpiry_date(Date expiry_date) {
	this.expiry_date = expiry_date;
}

public BookEntry getBook() {
	return book;
}

public void setBook(BookEntry book) {
	this.book = book;
}

public Member getMember() {
	return member;
}

public void setMember(Member member) {
	this.member = member;
}

}
