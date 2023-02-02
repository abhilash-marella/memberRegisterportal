package com.memberServices.services;

import java.time.Year;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.memberServices.exceptions.MemberException;
import com.memberServices.model.ClaimDetails;
import com.memberServices.model.Dependants;
import com.memberServices.model.UserInfo;
import com.memberServices.repository.ClaimRepository;
import com.memberServices.repository.DependantRepository;
import com.memberServices.repository.MemberRepository;

@Service
public class MemberServices {
	@Autowired
	MemberRepository memberRepository;
	
	@Autowired
	ClaimRepository claimRepository;
	
	@Autowired
	DependantRepository dependantRepository;
	
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
	public ClaimDetails placeClaim(ClaimDetails claimDetails) throws MemberException
	{
		
		Optional<UserInfo> userdata=memberRepository.findByMemberId(claimDetails.getUserId());
		ClaimDetails claimData= new ClaimDetails();
		if(userdata.isPresent())
		{
			if(claimDetails.getMemberName().equalsIgnoreCase(userdata.get().getName()))
			{
				claimData=claimRepository.save(claimDetails);
				claimData.setClaimNumber(Long.parseLong(Year.now().getValue()+"0000"+claimData.getId()));
				
			}
			else {
			Optional<List<Dependants>> dependants= dependantRepository.findByRegisteredUser(userdata.get().getMemberId());
			if(dependants.isPresent()) {
			boolean isDepandantValid=dependants.get().stream().anyMatch(s->s.getMemberName().equalsIgnoreCase(claimDetails.getMemberName()));
			System.out.println(isDepandantValid);
			if(isDepandantValid) {
			claimData=claimRepository.save(claimDetails);
			claimData.setClaimNumber(Long.parseLong(Year.now().getValue()+"0000"+claimData.getId()));
		}
			else 
				throw new MemberException("Not a valid member to claim");
		}
			else 
				throw new MemberException("No Dependant found");
			}
			
			}else 
				throw new MemberException("User not Registered");
		
		return claimData;
		}
	
		public List<ClaimDetails> getClaimDetails(String UserId)
		{
			return claimRepository.findByUserId(UserId);	
		}

		public Dependants addDependat(Dependants dependant) throws MemberException
			{
			Optional<List<Dependants>> dependants= dependantRepository.findByRegisteredUser(dependant.getRegisteredUser());
			if(dependants.isPresent())
			{
				if(dependants.get().size()>=2)
					throw new MemberException("You can't add more than 2 dependats");
			}
			return dependantRepository.save(dependant);
			}


		public Optional<List<Dependants>> getAllDependats(String userId)
		{
			return dependantRepository.findByRegisteredUser(userId);

		}
		public Optional<UserInfo> getUserData(String userId)
		{
			return memberRepository.findByMemberId(userId);

		}
}
