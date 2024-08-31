package com.javatpoint.repository;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import com.javatpoint.model.Claim;
import com.javatpoint.model.Policy;

public interface ClaimRepository extends CrudRepository<Claim, Integer> {
	
	
	@Query(nativeQuery = true, value = "select id,claims from claim")
	public List<Claim> getAllClaims();
	
	@Query(nativeQuery = true, value = "SELECT * FROM claim WHERE id = :id")
	public List<Claim> getAllClaimsById(@Param("id") int id);
	
	@Query(nativeQuery=true,value="SELECT * FROM claim WHERE id = :id")
	public Claim getClaimsById(@Param("id") int id);

}
