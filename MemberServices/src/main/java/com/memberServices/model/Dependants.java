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

	public LocalDate getDateOfBirth() {
		return dateOfBirth;
	}
	
	public String getRegisteredUser() {
		return registeredUser;
	}

	public Dependants( String memberName, LocalDate dateOfBirth, String registeredUser) {
		super();
		
		this.memberName = memberName;
		this.dateOfBirth = dateOfBirth;
		this.registeredUser = registeredUser;
	}
	
	
	public Dependants() {
		
	}
}
