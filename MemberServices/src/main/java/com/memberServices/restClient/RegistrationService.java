package com.memberServices.restClient;

import java.util.Optional;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import com.memberServices.model.UserInfo;

@FeignClient(name ="UserInfo" ,url ="http://localhost:8088")
public interface RegistrationService {
	@PostMapping("/register")
	public UserInfo register(@RequestBody UserInfo userInfo);
	
	@GetMapping("/getMemeber/{userId}")
	public Optional<UserInfo> findByMemberId(@PathVariable String userId);
}
