package com.org.bookApp.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.org.bookApp.entity.BorrowLedger;

@Repository
public interface BorrowLedgerRepository extends JpaRepository<BorrowLedger, Long>{

}
