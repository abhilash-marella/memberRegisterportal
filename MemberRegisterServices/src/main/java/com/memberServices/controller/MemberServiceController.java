package com.memberServices.controller;


import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;


import com.memberServices.model.UserInfo;
import com.memberServices.services.MemberServices;

@RestController
@CrossOrigin
public class MemberServiceController {
	@Autowired
	MemberServices memberServices;
	@GetMapping("/hi")
	public String greet()
	{
		return "abhilash here";
	}
	@PostMapping("/register")
	public UserInfo register(@RequestBody UserInfo userInfo)
	{
		
		return memberServices.register(userInfo);
	}
	@GetMapping("/getMemeber/{userId}")
	public Optional<UserInfo> findByMemberId(@PathVariable String userId) {
		return memberServices.getUserData(userId);
	}
	
	}
