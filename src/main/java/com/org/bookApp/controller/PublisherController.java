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

import com.org.bookApp.dto.MemberDto;
import com.org.bookApp.dto.PublisherDto;
import com.org.bookApp.entity.Member;
import com.org.bookApp.entity.Publisher;
import com.org.bookApp.service.PublisherService;

@RestController
@RequestMapping("/publisher")
public class PublisherController {

    @Autowired
    private PublisherService publisherService;

    @PostMapping(value = "/post")
    public Publisher postBook(@RequestBody PublisherDto dto) {
        return publisherService.publisherdetails(dto);
    }
    
    @GetMapping("/get")
	public List<Publisher> getAll(PublisherDto dto){
		return publisherService.getAllPublishers(dto);
	}
    
    @GetMapping("/getPublisher/{byId}")
	public ResponseEntity<Publisher> getPublisherById(@PathVariable Long byId) {
		Publisher publisher=publisherService.getPublisherById(byId);
		
		if ( publisher != null) {
            return new ResponseEntity<>(publisher, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }	
	}
    
    @PutMapping("/update/{id}")
    public ResponseEntity<String> updatePublisherById(@RequestParam Long id, @RequestBody Publisher updatedPublisher) {
        boolean updated = publisherService.updatePublisherById(id, updatedPublisher);

        if (updated) {
            return ResponseEntity.ok("Publisher updated successfully");
        } else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Book with the given ID not found");
        }
	}
    
}











//@RestController
//@RequestMapping("/publisher")
//public class PublisherController {
//
//	@Autowired
//	private PublisherService publisherService;
//
//	@PostMapping(value = "/post")
//	public Publisher postBook(@RequestBody PublisherDto dto) {
//		return publisherService.publisherDetails(dto);
//	}
//
//}
