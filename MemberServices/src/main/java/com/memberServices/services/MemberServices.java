package com.memberServices.services;

import java.time.DateTimeException;
import java.time.LocalDate;
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
import com.memberServices.restclient.RegistrationServices;

@Service
public class MemberServices {

	
	@Autowired
	ClaimRepository claimRepository;
	
	@Autowired
	DependantRepository dependantRepository;
	
	@Autowired
	RegistrationServices registrationService;
	
	
	public ClaimDetails placeClaim(ClaimDetails claimDetails) throws MemberException
	{
		LocalDate dateOfAdmission = claimDetails.getDateOfAdmission();
		LocalDate dateOfDischarge = claimDetails.getDateOfDischarge();
		boolean validaDate=false;
		if(dateOfDischarge.isAfter(dateOfAdmission) || dateOfAdmission.isEqual(dateOfDischarge))
		{
			validaDate=true;
		}
		if(validaDate) {
		claimDetails.setClaimNumber((long) Math.floor(Math.random() * 1_000_000_0000L));
		
		Optional<UserInfo> userdata=registrationService.findByMemberId(claimDetails.getUserId());
		ClaimDetails claimData= new ClaimDetails();
		if(userdata.isPresent())
		{
			if(claimDetails.getMemberName().equalsIgnoreCase(userdata.get().getName()))
			{	claimDetails.setDateOfBirth(userdata.get().getDateOfBirth());
				claimData=claimRepository.save(claimDetails);
			}
			else {
			Optional<List<Dependants>> dependants= dependantRepository.findByRegisteredUser(userdata.get().getMemberId());
			if(dependants.isPresent()) {
				boolean validDependant=false;
				for(Dependants dependant :dependants.get())
				{
					if(claimDetails.getMemberName().equalsIgnoreCase(dependant.getMemberName())) {
						claimDetails.setDateOfBirth(dependant.getDateOfBirth());
					claimData=claimRepository.save(claimDetails);
					validDependant=true;

				}
				
			}
				if(!validDependant) 
					throw new MemberException("Not a valid member to claim");
				
		}
			else 
				throw new MemberException("No Dependant found With the "+claimDetails.getMemberName());
		}
			}else 
				throw new MemberException(claimDetails.getUserId()+"  not a Registered user");
		
		return claimData;
		
		}
		else 
			throw new MemberException("Date of Discharge must be After the Date Of Admision");}
	
		public List<ClaimDetails> getClaimDetails(String UserId)
		{
			System.out.println(claimRepository.findByUserId(UserId));
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
			System.out.println("========================"+userId);
			return registrationService.findByMemberId(userId);

		}
}
