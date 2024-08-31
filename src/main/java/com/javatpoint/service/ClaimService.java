package com.javatpoint.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.javatpoint.model.Claim;
import com.javatpoint.model.Policy;
import com.javatpoint.repository.ClaimRepository;
@Service
public class ClaimService {
	@Autowired
	ClaimRepository claimRepository;
	
	public List<Claim> getAllClaims() {
		return claimRepository.getAllClaims();
	}
	public List<Claim> getAllClaimsById(int id) {
		return claimRepository.getAllClaimsById(id);
	}
	public void saveOrUpdateClaim(Claim claims) {
		claimRepository.save(claims);
	}
	
	public Claim getClaimaById( int id) {
		return claimRepository.getClaimsById(id);
	}
	
	

}
