package com.org.bookApp.dto;

import java.util.Date;

import org.springframework.format.annotation.DateTimeFormat;

public class MemberDto {
     private String member_name;
     private String member_address;
     private String gender;
     @DateTimeFormat(pattern = "yyyy-MM-dd'T'HH:mm:ss.SSSX")
	 private Date registeration_date;
     @DateTimeFormat(pattern = "yyyy-MM-dd'T'HH:mm:ss.SSSX")
	 private Date registeration_expiry;
	 
	public String getMember_name() {
		return member_name;
	}
	public void setMember_name(String member_name) {
		this.member_name = member_name;
	}
	public String getMember_address() {
		return member_address;
	}
	public void setMember_address(String member_address) {
		this.member_address = member_address;
	}

	
	public Date getRegisteration_date() {
		return registeration_date;
	}
	public void setRegisteration_date(Date registeration_date) {
		this.registeration_date = registeration_date;
	}
	public Date getRegisteration_expiry() {
		return registeration_expiry;
	}
	public void setRegisteration_expiry(Date registeration_expiry) {
		this.registeration_expiry = registeration_expiry;
	}
	public String getGender() {
		return gender;
	}
	public void setGender(String gender) {
		this.gender = gender;
	}
	 
	 
}
