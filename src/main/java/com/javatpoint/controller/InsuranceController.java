package com.javatpoint.controller;

import java.util.ArrayList;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
//import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.javatpoint.model.Customers;
import com.javatpoint.model.Policy;
import com.javatpoint.model.User;
import com.javatpoint.model.Claim;

import com.javatpoint.service.ClaimService;
import com.javatpoint.service.CustomerService;
import com.javatpoint.service.PolicyService;

//mark class as Controller
@RestController
public class InsuranceController {
//autowire the BooksService class
	
	
	@Autowired
	CustomerService customerService;
	
	@Autowired
	ClaimService claimService;
	
	@Autowired
	PolicyService policyService;
	
	

	
	@RequestMapping(value = "/api/customers",method = RequestMethod.GET)
    public List<Customers> getAllCustomers(){
    	 List<Customers> customers = customerService.getAllCustomers();
    	 return customers;
    }
    
    @RequestMapping(value = "/api/customers/{id}",method = RequestMethod.GET)
    public List<Customers> getAllCustomersById(@PathVariable("id")int id){
    	 List<Customers> customersById = customerService.getAllCustomersById(id);
    	 return customersById;
    }
    
    @RequestMapping(value = "/api/customers/{id}/policies",method = RequestMethod.GET)
    public List<String> getAllCustomersPolicesById(@PathVariable("id")int id){
    	 List<Object[]> customersPolicesById = customerService.getAllCustomersPolicesById(id);
    	 List<String> ans= new ArrayList<String>();
    	 for (Object[] result :customersPolicesById ) {
             Integer customerId = (Integer) result[0];   
             String policy = (String) result[1];
             String formatans = "Customer ID: " + customerId + ", Policy: " + policy;
             ans.add(formatans);
    	 }
    	 return ans;
    }
    
    @RequestMapping(value = "/api/customers/{id}/claims",method = RequestMethod.GET)
    public List<String> getAllCustomersClaimsById(@PathVariable("id")int id){
    	 List<Object[]> customersClaimsById = customerService.getAllCustomersClaimsById(id);
    	 List<String> ans= new ArrayList<String>();
    	 for (Object[] result :customersClaimsById ) {
             Integer customerId = (Integer) result[0];   
             String claim = (String) result[1];
             String formatans = "Customer ID: " + customerId + ", Claim: " + claim;
             ans.add(formatans);
    	 }
    	 return ans;
    }
    
    @RequestMapping(value = "/api/policies",method = RequestMethod.GET)
    public List<Policy> getAllPolicies(){
    	 List<Policy> policies = policyService.getAllPolices();
    	 return policies;
    }
    @RequestMapping(value = "/api/policies/{id}",method = RequestMethod.GET)
    public List<Policy> getAllPoliciesById(@PathVariable("id")int id){
    	 List<Policy> policiesById = policyService.getAllPoliciesById(id);
    	 return policiesById;
    }
    @RequestMapping(value="/api/create/policies",method = RequestMethod.POST)
	private void savePolicies(@RequestBody Policy policy) {
    	policyService.saveOrUpdatePolicy(policy);
		
	}
    
    @RequestMapping(value = "/api/claims",method = RequestMethod.GET)
    public List<Claim> getAllClaims(){
    	 List<Claim> claims = claimService.getAllClaims();
    	 return claims;
    }
    @RequestMapping(value = "/api/claims/{id}",method = RequestMethod.GET)
    public List<Claim> getAllClaimsById(@PathVariable("id")int id){
    	 List<Claim> claimsById = claimService.getAllClaimsById(id);
    	 return claimsById;
    }
    @RequestMapping(value="/api/create/claims",method = RequestMethod.POST)
	private void saveClaim(@RequestBody Claim claims) {
    	claimService.saveOrUpdateClaim(claims);
		
	}
    
    // Spring Security
    
//    @PostMapping("/register")
//    public ResponseEntity<String> register(@RequestBody User user) {
//        if (userRepository.findByUserName(user.getUsername()) != null) {
//            return ResponseEntity.badRequest().body("User already exists");
//        }
//        user.setPassword(passwordEncoder.encode(user.getPassword()));
//        user.setRole("USER");
//        userRepository.save(user);
//        return ResponseEntity.ok("User registered successfully");
//    }
//
//    @PostMapping("/login")
//    public ResponseEntity<String> login(@RequestBody LoginRequest loginRequest) {
//        // Authentication handled by Spring Security
//        return ResponseEntity.ok("Login successful");
//    }
    
	
}
