package com.memberServices.model;

import java.time.LocalDate;
import org.springframework.data.mongodb.core.mapping.Document;


@Document
public class ClaimDetails {

	long claimNumber;
	String memberName;
	LocalDate dateOfBirth;
	LocalDate dateOfAdmission;
	LocalDate dateOfDischarge;
	String providerName;
	Double totalBillAmount;
	String userId;
	
	public String getUserId() {
		return userId;
	}
		

	public void setMemberName(String memberName) {
		this.memberName = memberName;
	}


	public void setClaimNumber(long claimNumber) {
		this.claimNumber = claimNumber;
	}
	public String getMemberName() {
		return memberName;
	}

	public void setDateOfBirth(LocalDate dateOfBirth) {
		this.dateOfBirth = dateOfBirth;
	}
	public LocalDate getDateOfAdmission() {
		return dateOfAdmission;
	}
	
	public LocalDate getDateOfDischarge() {
		return dateOfDischarge;
	}

	
	public ClaimDetails( String memberName, LocalDate dateOfBirth, LocalDate dateOfAdmission,
			LocalDate dateOfDischarge, String providerName, Double totalBillAmount, String userId) {
		super();
		this.memberName = memberName;
		this.dateOfBirth = dateOfBirth;
		this.dateOfAdmission = dateOfAdmission;
		this.dateOfDischarge = dateOfDischarge;
		this.providerName = providerName;
		this.totalBillAmount = totalBillAmount;
		this.userId = userId;
	}
	public ClaimDetails() {
	}
	
	
	

}
