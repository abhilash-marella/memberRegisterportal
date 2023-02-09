package com.memberServices.model;

import java.time.LocalDate;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document 
public class Dependants {

	@Id
	String memberName;
	LocalDate dateOfBirth;
	String registeredUser;
	
	
	public String getMemberName() {
		return memberName;
	}
	public void setMemberName(String memberName) {
		this.memberName = memberName;
	}
	public LocalDate getDateOfBirth() {
		return dateOfBirth;
	}
	public void setDateOfBirth(LocalDate dateOfBirth) {
		this.dateOfBirth = dateOfBirth;
	}
	public String getRegisteredUser() {
		return registeredUser;
	}
	public void setRegisteredUser(String registeredUser) {
		this.registeredUser = registeredUser;
	}
	public Dependants( String memberName, LocalDate dateOfBirth, String registeredUser) {
		super();
		
		this.memberName = memberName;
		this.dateOfBirth = dateOfBirth;
		this.registeredUser = registeredUser;
	}
	@Override
	public String toString() {
		return "Dependants [ memberName=" + memberName + ", dateOfBirth=" + dateOfBirth
				+ ", RegisteredUser=" + registeredUser + "]";
	}
	
	public Dependants() {
		
	}
}
