package com.memberServices.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.memberServices.exceptions.MemberException;
import com.memberServices.model.ClaimDetails;
import com.memberServices.model.Dependants;
import com.memberServices.model.UserInfo;
import com.memberServices.restclient.RegistrationServices;
import com.memberServices.services.MemberServices;

@RestController
@CrossOrigin

@ComponentScan(basePackages = {
		"com.memberServices.restclient"})
public class MemberServiceController {
	@Autowired
	MemberServices memberServices;
	
	@Autowired
	RegistrationServices registrationService;
	
	@GetMapping("/hi")
	public String greet()
	{
		return "abhilash here";
	}
	@PostMapping("/register")
	public UserInfo register(@RequestBody UserInfo userInfo)
	{
		return registrationService.register(userInfo);
	}
	@PostMapping("/placeClaim")
	public ClaimDetails placeClain(@RequestBody ClaimDetails claimDetails) throws MemberException
	{
		return memberServices.placeClaim(claimDetails);
	}
	@GetMapping("/yourClaims/{userId}")
	public List<ClaimDetails> getYourClaims(@PathVariable String userId)
	{
	 return memberServices.getClaimDetails(userId);
	}
	@PostMapping("/addDependant")
	public Dependants addDependant(@RequestBody Dependants dependant) throws MemberException
	{
		return memberServices.addDependat(dependant);
	}
	@GetMapping("/getDependants/{userId}")
	public Optional<List<Dependants>> getYourDependants(@PathVariable String userId)
	{
		return memberServices.getAllDependats(userId);
	}
	
	@GetMapping("/memeberDetails/{userId}")	
	public Optional<UserInfo> findUser(@PathVariable String userId) {
		System.out.println("==================================== rest "+userId);
		return memberServices.getUserData(userId);
	}
}
