package com.memberServices.Test;

import static org.junit.Assert.assertSame;
import static org.junit.Assert.assertTrue;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.runners.Suite.SuiteClasses;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.memberServices.controller.MemberServiceController;
import com.memberServices.exceptions.MemberException;
import com.memberServices.model.ClaimDetails;
import com.memberServices.model.Dependants;
import com.memberServices.model.UserInfo;
import com.memberServices.services.MemberServices;


@SpringBootTest
@SuiteClasses(MemberServicesTest.class)
public class MemberServicesTest {
	
	@Autowired
	MemberServices memberServices;
	@Autowired
	MemberServiceController memberServiceController;
	
	String userId = "P001";
	Dependants dependant = new Dependants("Anush", LocalDate.now(), "P002");
	ClaimDetails claimDetails =new ClaimDetails( "mrudula", LocalDate.now(), LocalDate.now(), LocalDate.now(), "apollo", 3533.55, userId);

	
	@Test
	void placeClaimTest() throws MemberException
	{	
		claimDetails.setMemberName("Mrudula");
		assertSame(claimDetails, memberServiceController.placeClain(claimDetails));
	}
	@Test
	void placeClaim2Test() throws MemberException
	{
		claimDetails.setMemberName("Abhilash");

		assertSame(claimDetails, memberServices.placeClaim(claimDetails));
	}
	
	@Test
	void getMemberDetailsTest()
	{

		assertTrue(memberServices.getUserData(userId).isPresent());
	}
	@Test
	void getMemberDetailsRestTest()
	{

		assertTrue(memberServiceController.findUser(userId).isPresent());
	}
	@Test
	void getDependatsTest()
	{
		Optional<List<Dependants>> dependants= memberServices.getAllDependats(userId);

		assertTrue(dependants.get().size()>0);

		
	}
	@Test
	void addDependatTest() throws MemberException
	{
		assertSame(dependant, memberServices.addDependat(dependant));

	}
	@Test
	 void getClaimDetailsTest()
	{
		List<ClaimDetails> claimDetails = new ArrayList<ClaimDetails>();
		claimDetails=memberServices.getClaimDetails(userId);
		assertTrue(claimDetails.size()>0);

	}
	
	@Test
	void addDependatExceptionTest() throws MemberException
	{
		Dependants dependantq = new Dependants("Anush", LocalDate.now(), "P001");

		Assertions.assertThrows(MemberException.class,()->{ memberServiceController.addDependant(dependantq);});

	}
	@Test
	void addDependatRestTest() throws MemberException
	{

		assertSame(dependant, memberServices.addDependat(dependant));

	}
	@Test
	 void getClaimDetailsRestTest()
	{
		List<ClaimDetails> claimDetails = new ArrayList<ClaimDetails>();
		claimDetails =memberServiceController.getYourClaims(userId);
		assertTrue(claimDetails.size()>0);

	}
	
	@Test
	void getDependatsRestTest()
	{
		Optional<List<Dependants>> dependants= memberServiceController.getYourDependants(userId);

		assertTrue(dependants.get().size()>0);

		
	}@Test
	void register()
	{
		UserInfo  userInfo = new UserInfo("Rishi", "Nellore", "Hyderabad", "India", "abh@gmail", "abhilasj", "12345689", LocalDate.now(), "pwd");
	
		memberServiceController.register(userInfo);
	}
	
void testException () {
	ClaimDetails claimDetails1 =new ClaimDetails( "mrudula", LocalDate.now(), LocalDate.of(2023, 02, 03), LocalDate.of(2023, 01, 01), "apollo", 3533.55, userId);

	Assertions.assertThrows(MemberException.class, ()->{memberServices.placeClaim(claimDetails1);
});
}
}