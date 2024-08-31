package com.javatpoint.controller;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.persistence.EntityNotFoundException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;

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
import com.javatpoint.model.Employee;
import com.javatpoint.model.LoginMessage;
import com.javatpoint.model.Policy;

import com.javatpoint.repository.ClaimRepository;
import com.javatpoint.repository.PolicyRepository;
import com.javatpoint.repository.UserRepository;
import com.javatpoint.DTO.LoginDTO;
import com.javatpoint.DTO.UserDTO;
import com.javatpoint.model.Claim;

import com.javatpoint.service.ClaimService;
import com.javatpoint.service.CustomerService;
import com.javatpoint.service.EmployeeService;
import com.javatpoint.service.PolicyService;
import com.javatpoint.service.UserService;

//mark class as Controller
@RestController
@CrossOrigin(origins="*")
public class InsuranceController {
//autowire the BooksService class
	
	
	@Autowired
	CustomerService customerService;
	
	@Autowired
	ClaimService claimService;
	
	@Autowired
	PolicyService policyService;
	
	@Autowired
	PolicyRepository policyRepository;
	
	@Autowired
	ClaimRepository claimRepository;
	
	@Autowired
	UserService userService;
	
	@Autowired
	EmployeeService employeeService;
	
	
	
	
	
	

	
	@RequestMapping(value = "/api/customers",method = RequestMethod.GET)
    public List<Customers> getAllCustomers(){
    	 List<Customers> customers = customerService.getAllCustomers();
    	 return customers;
    }
	
	@RequestMapping(value="/api/employee", method=RequestMethod.GET)
	public List <Employee> getAllEmploye(){
		List<Employee> employee =employeeService.getAllEmployee();
		return employee;
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
    
    @PutMapping(value="/api/update/policy/{id}")
    public ResponseEntity<Policy> updatePolicy(@PathVariable int id,@RequestBody Policy policy){
    	Policy p = policyService.getPoliciesById(id);
    	if(p==null) {
    		return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
    	}
    	p.setPolicies(policy.getPolicies());
    	Policy updatePolicy = policyRepository.save(p);
    	return ResponseEntity.ok(updatePolicy);
    	
    }
    @RequestMapping(value = "/api/get/policy/{id}",method = RequestMethod.GET)
    public Policy getPolicyById(@PathVariable("id")int id){
    	 Policy policyById = policyService.getPoliciesById(id);
    	 return policyById;
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
    
    
    @RequestMapping(value="/api/update/claim/{id}")
    public ResponseEntity<Claim>updateClaim(@PathVariable int id,@RequestBody Claim claim ){
    	Claim c = claimService.getClaimaById(id);
    	c.setClaims(claim.getClaims());
    	Claim updateClaim=claimRepository.save(c);
    	return ResponseEntity.ok(updateClaim);
    }
    
   
    
    @RequestMapping(value = "/api/get/claim/{id}",method = RequestMethod.GET)
    public Claim getClaimById(@PathVariable("id")int id){
    	 Claim claimById = claimService.getClaimaById(id);
    	 return claimById;
    }
    
    @RequestMapping(value = "/api/delete/policy/{id}",method = RequestMethod.DELETE)
    public ResponseEntity<Map<String,Boolean>> deletePolicy(@PathVariable("id")int id){
    	Policy p=policyRepository.findById(id).orElseThrow(() -> 
    	new EntityNotFoundException("Policy Not Found " + id));
    	policyRepository.delete(p);
    	Map<String, Boolean> response = new HashMap<String, Boolean>();
    	response.put("Deleted", Boolean.TRUE);
    	return ResponseEntity.ok(response);

    }
    @RequestMapping(value = "/api/delete/claim/{id}",method = RequestMethod.DELETE)
    public ResponseEntity<Map<String,Boolean>> deleteClaim(@PathVariable("id")int id){
    	Claim c=claimRepository.findById(id).orElseThrow(() -> 
    	new EntityNotFoundException("Claim Not Found " + id));
    	claimRepository.delete(c);
    	Map<String, Boolean> response = new HashMap<String, Boolean>();
    	response.put("Deleted", Boolean.TRUE);
    	return ResponseEntity.ok(response);

    }
    @RequestMapping(value="/save",method = RequestMethod.POST)
	private ResponseEntity<?> saveUser(@RequestBody UserDTO userdto) {
    	LoginMessage message = userService.addUser(userdto);
    	return ResponseEntity.ok(message);
		
	}
    @RequestMapping(value="/login",method = RequestMethod.POST)
	private ResponseEntity<?> saveLogin(@RequestBody LoginDTO logindto) {
    	LoginMessage message = userService.loginUser(logindto);
    	return ResponseEntity.ok(message);
		
	}
    
    // DUMMY
    
    
    
    
    
    
	
}
