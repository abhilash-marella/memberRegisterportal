package com.memberServices.restclient;

import java.util.Optional;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import com.memberServices.model.UserInfo;

import io.swagger.v3.oas.annotations.parameters.RequestBody;

@FeignClient(name ="UserInfo" ,url="http://3.91.249.143:8088")
public interface RegistrationServices {

@PostMapping("/register")
public UserInfo register(@RequestBody UserInfo userInfo);

@GetMapping("/getMemeber/{userId}")
public Optional<UserInfo> findByMemberId(@PathVariable("userId") String userId);
}

	
