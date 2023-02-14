package com.memberServices.model;

import java.time.LocalDate;

public class UserInfo {


	String memberId;
	String name;
	String address;
	String city;
	String country;
	String gmail;
	String pan;
	String contactNo;
	LocalDate dateOfBirth;
	String password;
	

	public String getMemberId() {
		return memberId;
	}
	public void setMemberId(String memberId) {
		this.memberId = memberId;
	}
	public String getName() {
		return name;
	}
	
	
public String getPan() {
		return pan;
	}
	

	public LocalDate getDateOfBirth() {
		return dateOfBirth;
	}
	public void setDateOfBirth(LocalDate dateOfBirth) {
		this.dateOfBirth = dateOfBirth;
	}

	public UserInfo( String name, String address, String city, String country, String gmail,
			String pan, String contactNo, LocalDate dateOfBirth, String password) {
		super();
	
		this.name = name;
		this.address = address;
		this.city = city;
		this.country = country;
		this.gmail = gmail;
		this.pan = pan;
		this.contactNo = contactNo;
		this.dateOfBirth = dateOfBirth;
		this.password = password;
	}

	public UserInfo() {
		
	}

	
	
	
}
