package com.example.demo.Controller;


import java.util.List;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
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
}
