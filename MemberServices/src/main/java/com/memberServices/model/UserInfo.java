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
	public void setName(String name) {
		this.name = name;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	
	public String getCity() {
		return city;
	}
	public void setCity(String city) {
		this.city = city;
	}
	public String getCountry() {
		return country;
	}
	public void setCountry(String country) {
		this.country = country;
	}
	public String getGmail() {
		return gmail;
	}
	public void setGmail(String gmail) {
		this.gmail = gmail;
	}
	public String getPan() {
		return pan;
	}
	public void setPan(String pan) {
		this.pan = pan;
	}
	public String getContactNo() {
		return contactNo;
	}
	public void setContactNo(String contactNo) {
		this.contactNo = contactNo;
	}
	public LocalDate getDateOfBirth() {
		return dateOfBirth;
	}
	public void setDateOfBirth(LocalDate dateOfBirth) {
		this.dateOfBirth = dateOfBirth;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
	
		this.password = password;
	}
	public UserInfo(int id, String memberId, String name, String address, String city, String country, String gmail,
			String pan, String contactNo, LocalDate dateOfBirth, String password) {
		super();
	
		this.memberId = memberId;
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
	@Override
	public String toString() {
		return "UserInfo [ memberId=" + memberId + ", name=" + name + ", address=" + address + ", city="
				+ city + ", country=" + country + ", gmail=" + gmail + ", pan=" + pan + ", contactNo=" + contactNo
				+ ", dateOfBirth=" + dateOfBirth + ", password=" + password + "]";
	}
	public UserInfo() {
		
		// TODO Auto-generated constructor stub
	}

	
	
	
}
