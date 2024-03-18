package com.org.bookApp.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.org.bookApp.entity.BookEntry;
@Repository
public interface BookRepository extends JpaRepository<BookEntry, Long> {

}
