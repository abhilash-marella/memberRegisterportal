package com.memberServices.test;

import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertSame;
import static org.junit.Assert.assertTrue;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

import org.junit.jupiter.api.Test;
import org.junit.runners.Suite.SuiteClasses;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.memberServices.exceptions.MemberException;
import com.memberServices.model.ClaimDetails;
import com.memberServices.model.Dependants;

import com.memberServices.services.MemberServices;


@SpringBootTest
@SuiteClasses(MemberServicesTest.class)
public class MemberServicesTest {
	
	@Autowired
	MemberServices memberServices;
	
	String UserId = "P021";
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
		claimDetails.setUserId(UserId);
		assertSame(claimDetails, memberServices.placeClaim(claimDetails));
	}
	@Test
	public void getMemberDetailsTest()
	{
		assertTrue(memberServices.getUserData(UserId).isPresent());
	}
	@Test
	public void getDependatsTest()
	{
		Optional<List<Dependants>> dependants= memberServices.getAllDependats(UserId);
		System.out.println(dependants.isPresent());
		assertTrue(dependants.get().size()>0);

		
	}
	@Test
	public void getAllClaimsTest()
	{
		List<ClaimDetails> allClaims=memberServices.getClaimDetails(UserId);
		assertTrue(!allClaims.isEmpty() && allClaims!=null);
		System.out.println(allClaims);
	}
}
