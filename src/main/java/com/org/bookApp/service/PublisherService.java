package com.org.bookApp.service;

import java.util.List;

import javax.persistence.EntityNotFoundException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;
import com.org.bookApp.dto.MemberDto;
import com.org.bookApp.dto.PublisherDto;
import com.org.bookApp.entity.Publisher;
import com.org.bookApp.repository.PublisherRepository;



@Service
public class PublisherService {

    @Autowired
    private PublisherRepository publisherRepository;

    public Publisher publisherdetails(PublisherDto publisherDto) {
        Publisher publisher = new Publisher();
        publisher.setName(publisherDto.getName());
        publisher.setAddress(publisherDto.getAddress());
        publisher.setAuthorName(publisherDto.getAuthorName());

        Publisher savedPublisher = publisherRepository.save(publisher);
        return savedPublisher;
    }
    
    public List<Publisher> getAllPublishers(PublisherDto dto){
		return publisherRepository.findAll();
	}
    
    public Publisher getPublisherById(@PathVariable Long publisherId) {
		
		return publisherRepository.findById(publisherId).orElse(null);
	}
    
    public boolean updatePublisherById(Long publisherId, Publisher updatedPublisher) {
		
        if (publisherRepository.existsById(publisherId)) {
            updatedPublisher.setPublisherId(publisherId);
            publisherRepository.save(updatedPublisher);
            return true; 
        } else {
            return false; 
        }
     }
    public Publisher getPublisherById(long publisherId) {
        return publisherRepository.findById(publisherId)
                .orElseThrow(() -> new EntityNotFoundException("Publisher not found with id: " + publisherId));
    }
}










//@Service
//public class PublisherService {
//	
//	@Autowired
//    private publisherRepository publisherRepository;
//	
//	public Publisher publisherDetails(PublisherDto publisherDto) {
//		Publisher publisher = new Publisher();
//		publisher.setName(publisherDto.getName());
//		publisher.setAddress(publisherDto.getAddress());
//		Publisher savePublisher=publisherRepository.save(publisher);
//		
//		return savePublisher;
//	}
//}
