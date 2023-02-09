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
	public void setUserId(String userId) {
		this.userId = userId;
	}

	public long getClaimNumber() {
		return claimNumber;
	}
	public void setClaimNumber(long claimNumber) {
		this.claimNumber = claimNumber;
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
	public LocalDate getDateOfAdmission() {
		return dateOfAdmission;
	}
	public void setDateOfAdmission(LocalDate dateOfAdmission) {
		this.dateOfAdmission = dateOfAdmission;
	}
	public LocalDate getDateOfDischarge() {
		return dateOfDischarge;
	}
	public void setDateOfDischarge(LocalDate dateOfDischarge) {
		this.dateOfDischarge = dateOfDischarge;
	}
	public String getProviderName() {
		return providerName;
	}
	public void setProviderName(String providerName) {
		this.providerName = providerName;
	}
	public Double getTotalBillAmount() {
		return totalBillAmount;
	}
	public void setTotalBillAmount(Double totalBillAmount) {
		this.totalBillAmount = totalBillAmount;
	}

	

	@Override
	public String toString() {
		return "ClaimDetails [ claimNumber=" + claimNumber + ", memberName=" + memberName
				+ ", dateOfBirth=" + dateOfBirth + ", dateOfAdmission=" + dateOfAdmission + ", dateOfDischarge="
				+ dateOfDischarge + ", providerName=" + providerName + ", totalBillAmount=" + totalBillAmount
				+ ", userId=" + userId + "]";
	}
	
	public ClaimDetails( long claimNumber, String memberName, LocalDate dateOfBirth, LocalDate dateOfAdmission,
			LocalDate dateOfDischarge, String providerName, Double totalBillAmount, String userId) {
		super();
		this.claimNumber = claimNumber;
		this.memberName = memberName;
		this.dateOfBirth = dateOfBirth;
		this.dateOfAdmission = dateOfAdmission;
		this.dateOfDischarge = dateOfDischarge;
		this.providerName = providerName;
		this.totalBillAmount = totalBillAmount;
		this.userId = userId;
	}
	public ClaimDetails() {
		// TODO Auto-generated constructor stub
	}
	
	
	

}
