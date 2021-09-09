package com.example.demo.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.Model.D_Employee;
import com.example.demo.Repository.D_EmployeeRepository;

@RestController
@RequestMapping("/api/v1/")
public class D_EmployeeController {
	
	@Autowired
	private D_EmployeeRepository employeeRepository;
	
	//get all employees
	@GetMapping("/employees")
	public List<D_Employee> getAllEmployees(){
		return employeeRepository.findAll();
	}

}
