package com.org.bookApp.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.org.bookApp.entity.Publisher;

@Repository
public interface PublisherRepository extends JpaRepository<Publisher,Long>{

}
