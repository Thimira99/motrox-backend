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
import com.example.demo.Model.D_Employee;
import com.example.demo.Repository.D_EmployeeRepository;

@CrossOrigin(origins = "http://localhost:3000")
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
	
	
	//update employee
	@PutMapping("/employees/{id}")
	public ResponseEntity<D_Employee> updateEmployee(@PathVariable Long id, @RequestBody D_Employee employeedetails){
		D_Employee d_Employee = employeeRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("Employee not found" + id));
			
		d_Employee.setEmployeeName(employeedetails.getEmployeeName());
		d_Employee.setEmployeeNIC(employeedetails.getEmployeeNIC());
		d_Employee.setEmployeeAddress(employeedetails.getEmployeeAddress());
		d_Employee.setEmployeePhone(employeedetails.getEmployeePhone());
		d_Employee.setEmployeeEmail(employeedetails.getEmployeeEmail());
		d_Employee.setEmployeeJoinDate(employeedetails.getEmployeeJoinDate());
		d_Employee.setBasicSalary(employeedetails.getBasicSalary());
		d_Employee.setEmployeeType(employeedetails.getEmployeeType());
		d_Employee.setEmployeeCategory(employeedetails.getEmployeeCategory());
			
		D_Employee updatedemployee = employeeRepository.save(d_Employee);
		return ResponseEntity.ok(updatedemployee);
			
	}
		
		
	//delete employee
	@DeleteMapping("/employees/{id}")
	public ResponseEntity<Map<String, Boolean>> deleteEmployee(@PathVariable Long id){
		D_Employee d_Employee = employeeRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("Employee not found" + id));			
		employeeRepository.delete(d_Employee);
		Map<String, Boolean> response = new HashMap<>();
		response.put("deleted", Boolean.TRUE);
		return ResponseEntity.ok(response);
	}
	

}
