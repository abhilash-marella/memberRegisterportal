package com.memberServices.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.memberServices.model.ClaimDetails;

@Repository
public interface ClaimRepository extends JpaRepository<ClaimDetails ,Integer> {
	
public List<ClaimDetails> findByUserId(String userId);
}
