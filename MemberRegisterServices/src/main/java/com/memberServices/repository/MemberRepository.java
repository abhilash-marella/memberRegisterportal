package com.memberServices.repository;

import java.util.Optional;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.memberServices.model.UserInfo;


public interface MemberRepository extends MongoRepository<UserInfo, String> {
	public Optional<UserInfo> findByMemberId(String memberId);

}

