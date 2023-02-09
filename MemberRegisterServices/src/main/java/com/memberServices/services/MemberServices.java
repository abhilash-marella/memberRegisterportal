package com.memberServices.services;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import com.memberServices.model.UserInfo;

import com.memberServices.repository.MemberRepository;
import com.mongodb.client.MongoClient;


@Service
public class MemberServices {
	@Autowired
	MemberRepository memberRepository;
	@Autowired
	MongoClient mongoClient;
	
	public UserInfo register(UserInfo userInfo)
	{	
		long count=memberRepository.count()+1;
		
		System.out.println(memberRepository.count());
			
		if(count<9)
		{
			userInfo.setMemberId("P00"+count);
			
		}
		else if(count<100 &&count>9)
				{
			userInfo.setMemberId("P0"+count);
			}
		else 
			{
			userInfo.setMemberId("P"+count);
			}
		
		return memberRepository.save(userInfo);
	}
		public Optional<UserInfo> getUserData(String userId)
		{
			return memberRepository.findByMemberId(userId);

		}
}
