package com.memberServices.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.memberServices.model.UserInfo;

@Repository
public interface MemberRepository extends JpaRepository<UserInfo, String> {
	public Optional<UserInfo> findByMemberId(String memberId);

}
