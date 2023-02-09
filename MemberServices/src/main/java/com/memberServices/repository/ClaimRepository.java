package com.memberServices.repository;

import java.util.List;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.memberServices.model.ClaimDetails;


public interface ClaimRepository extends MongoRepository<ClaimDetails ,Integer> {
	
public List<ClaimDetails> findByUserId(String userId);
}
