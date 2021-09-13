package com.example.demo.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.Exception.ResourceNotFoundException;
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
	
	//create employee rest api
	@PostMapping("/employees")
	public D_Employee createEmployee(@RequestBody D_Employee d_Employee) {
		return employeeRepository.save(d_Employee);
	}
	
	//get employee by id
	@GetMapping("/employees/{id}")
	public ResponseEntity<D_Employee> getEmployeeById(@PathVariable Long id) {
		D_Employee d_Employee = employeeRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("Employee not found" + id));
		return ResponseEntity.ok(d_Employee);
	}
	
	

}
