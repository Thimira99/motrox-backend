package com.example.demo.Controller;


import java.util.List;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.Model.H_Customer;
import com.example.demo.Repository.H_CustomerRepository;

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
		
}
