package com.memberServices.model;

import java.time.LocalDate;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity 
public class Dependants {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	int id;
	String memberName;
	LocalDate dateOfBirth;
	String registeredUser;
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
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
	public Dependants(int id, String memberName, LocalDate dateOfBirth, String registeredUser) {
		super();
		this.id = id;
		this.memberName = memberName;
		this.dateOfBirth = dateOfBirth;
		this.registeredUser = registeredUser;
	}
	@Override
	public String toString() {
		return "Dependants [id=" + id + ", memberName=" + memberName + ", dateOfBirth=" + dateOfBirth
				+ ", RegisteredUser=" + registeredUser + "]";
	}
	
	public Dependants() {
		
	}
}
