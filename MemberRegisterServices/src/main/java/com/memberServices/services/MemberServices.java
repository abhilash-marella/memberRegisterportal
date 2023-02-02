package com.memberServices.services;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import com.memberServices.model.UserInfo;

import com.memberServices.repository.MemberRepository;

@Service
public class MemberServices {
	@Autowired
	MemberRepository memberRepository;
	
	
	
	public UserInfo register(UserInfo userInfo)
	{
		UserInfo memDetails=memberRepository.save(userInfo);
			
		if(memDetails.getId()<9)
		{
			memDetails.setMemberId("P00"+memDetails.getId());
			
		}
		else if(memDetails.getId()<100 && memDetails.getId()>9)
				{
			memDetails.setMemberId("P0"+memDetails.getId());
			}
		else 
			{
			memDetails.setMemberId("P"+memDetails.getId());
			}
		
		return memberRepository.save(memDetails);
	}
		public Optional<UserInfo> getUserData(String userId)
		{
			return memberRepository.findByMemberId(userId);

		}
}
