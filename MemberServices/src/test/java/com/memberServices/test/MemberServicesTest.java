package com.memberServices.test;

import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertSame;
import static org.junit.Assert.assertTrue;

import java.time.LocalDate;


import org.junit.jupiter.api.Test;
import org.junit.runners.Suite.SuiteClasses;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.memberServices.exceptions.MemberException;
import com.memberServices.model.ClaimDetails;
import com.memberServices.services.MemberServices;


@SpringBootTest
@SuiteClasses(MemberServicesTest.class)
public class MemberServicesTest {
	
	@Autowired
	MemberServices memberServices;
	
	@Test
	public void placeClaimTest() throws MemberException
	{
		ClaimDetails claimDetails =new ClaimDetails();
		claimDetails.setDateOfAdmission(LocalDate.now());
		claimDetails.setDateOfBirth(LocalDate.now());
		claimDetails.setDateOfDischarge(LocalDate.now());
		claimDetails.setMemberName("Abhilash");
		claimDetails.setProviderName("unknown");
		claimDetails.setTotalBillAmount(1234.44);
		claimDetails.setUserId("P001");
		assertSame(claimDetails, memberServices.placeClaim(claimDetails));
	}
	@Test
	public void getMemberDetailsTest()
	{
		assertTrue(memberServices.getUserData("P001").isPresent());
	}

}
