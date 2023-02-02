package com.memberServices.model;

import java.time.LocalDate;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

@Entity
public class UserInfo {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	int id;
	String memberId;
	String name;
	String address;
	String state;
	String country;
	String gmail;
	String pan;
	String contactNo;
	LocalDate dateOfBirth;
	String password;
	

	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
		
	}
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
	public String getState() {
		return state;
	}
	public void setState(String state) {
		this.state = state;
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
		 PasswordEncoder encoder = new BCryptPasswordEncoder();
		 password = encoder.encode(password);
		this.password = password;
	}
	public UserInfo(int id, String memberId, String name, String address, String state, String country, String gmail,
			String pan, String contactNo, LocalDate dateOfBirth, String password) {
		super();
		this.id = id;
		this.memberId = memberId;
		this.name = name;
		this.address = address;
		this.state = state;
		this.country = country;
		this.gmail = gmail;
		this.pan = pan;
		this.contactNo = contactNo;
		this.dateOfBirth = dateOfBirth;
		
		 PasswordEncoder encoder = new BCryptPasswordEncoder();
		 password = encoder.encode(password);
		 this.password = password;
	}
	@Override
	public String toString() {
		return "UserInfo [id=" + id + ", memberId=" + memberId + ", name=" + name + ", address=" + address + ", state="
				+ state + ", country=" + country + ", gmail=" + gmail + ", pan=" + pan + ", contactNo=" + contactNo
				+ ", dateOfBirth=" + dateOfBirth + ", password=" + password + "]";
	}
	public UserInfo() {
		
		// TODO Auto-generated constructor stub
	}

	
	
	
}
