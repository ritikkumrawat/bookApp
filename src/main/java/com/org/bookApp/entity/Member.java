package com.org.bookApp.entity;

import java.util.Date;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import org.springframework.format.annotation.DateTimeFormat;
@Entity
public class Member {
	 @Id
     @GeneratedValue(strategy = GenerationType.IDENTITY)
	 @Column(name="member_id")
	 private long member_id;
	 @Column(name="member_name")
     private String member_name;
	 @Column(name="member_address")
     private String member_address;
	 @Column(name="gender")
     private String gender;
	 @Column(name="registeration_date")
	 private Date registeration_date;
	 @Column(name="registeration_expiry")
	 private Date registeration_expiry;
	 
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
	public long getMember_id() {
		return member_id;
	}
	public void setMember_id(long member_id) {
		this.member_id = member_id;
	}
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

	
	public Member(long member_id, String member_name, String member_address, String gender, Date registeration_date,
			Date registeration_expiry) {
		super();
		this.member_id = member_id;
		this.member_name = member_name;
		this.member_address = member_address;
		this.gender = gender;
		this.registeration_date = registeration_date;
		this.registeration_expiry = registeration_expiry;
	}
	public Member() {
		super();
	}
	@Override
	public String toString() {
		return "Member [member_id=" + member_id + ", member_name=" + member_name + ", member_address=" + member_address
				+ ", member_type=" + gender + ", registeration_date=" + registeration_date
				+ ", registeration_expiry=" + registeration_expiry + "]";
	}
	public String getGender() {
		return gender;
	}
	public void setGender(String gender) {
		this.gender = gender;
	}
	
}
