package com.example.demo.Controller;


import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.Exception.ResourceNotFoundException;
import com.example.demo.Model.H_Customer;
import com.example.demo.Repository.H_CustomerRepository;

@CrossOrigin(origins="http://localhost:3000")
@RestController
@RequestMapping("/api/v1/")

public class H_CustomerController {
	
	@Autowired
	private H_CustomerRepository h_CustomerRepository;
	
	//get all customers
	@GetMapping("/customers")
	public List<H_Customer> getAllCustomers(){
		return h_CustomerRepository.findAll();
	}
	
	//create customer rest api
	@PostMapping("/customers")
	public H_Customer creatCustomers(@RequestBody H_Customer h_Customer) {
		return h_CustomerRepository.save(h_Customer);
			
			
	}
	//get customer by id rest api
	@GetMapping("/customers/{id}")
	public ResponseEntity <H_Customer>  getCustomerById(@PathVariable Long id) {
		
		H_Customer h_Customer = h_CustomerRepository.findById(id)
				.orElseThrow(() -> new ResourceNotFoundException("Customer not exit with id :" + id));
		return ResponseEntity.ok(h_Customer);
	}
	// update customer rest api
		@PutMapping("/customers/{id}")
		public ResponseEntity<H_Customer> updateCustomer (@PathVariable Long id,@RequestBody H_Customer customerDetails){
			
			H_Customer h_Customer = h_CustomerRepository.findById(id)
					.orElseThrow(() -> new ResourceNotFoundException("Customer not exit with id :" + id));
			
			h_Customer.setFirstName(customerDetails.getFirstName());
			h_Customer.setLastName(customerDetails.getLastName());
			h_Customer.setNic(customerDetails.getNic());
			h_Customer.setAddress(customerDetails.getAddress());
			h_Customer.setPhoneNo(customerDetails.getPhoneNo());
			h_Customer.setEmail(customerDetails.getEmail());
			h_Customer.setVehicleRegNo(customerDetails.getVehicleRegNo());
			
			H_Customer updateCustomer = h_CustomerRepository.save(h_Customer);
			return ResponseEntity.ok(updateCustomer);
		}
		// delete customer rest api
		@DeleteMapping("/customers/{id}")
		public ResponseEntity< Map<String, Boolean>> deleteCustomer(@PathVariable Long id){
			H_Customer h_Customer = h_CustomerRepository.findById(id)
					.orElseThrow(() -> new ResourceNotFoundException("Customer not exit with id :" + id));
			
			h_CustomerRepository.delete(h_Customer);
			Map<String, Boolean> response = new HashMap<>();
			response.put("deleted", Boolean.TRUE);
			return ResponseEntity.ok(response);
		}
		
}
