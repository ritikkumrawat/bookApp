package com.org.bookApp.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "publisher_info")
public class Publisher {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long publisherId;

    @Column(name = "address")
    private String address;

    @Column(name = "name")
    private String name;
    
    @Column(name="author_name")
    private String authorName;

	public long getPublisherId() {
		return publisherId;
	}

	public void setPublisherId(long publisherId) {
		this.publisherId = publisherId;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
	

	public Publisher(long publisherId, String address, String name,String authorName) {
		super();
		this.publisherId = publisherId;
		this.address = address;
		this.name = name;
		this.authorName=authorName;
	}

	public Publisher() {
		super();
	}

	
	public String getAuthorName() {
		return authorName;
	}

	public void setAuthorName(String authorName) {
		this.authorName = authorName;
	}

	@Override
	public String toString() {
		return "Publisher [publisherId=" + publisherId + ", address=" + address + ", name=" + name + ", authorName=" + authorName
				+ "]";
	}
	
}

