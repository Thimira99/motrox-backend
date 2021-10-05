package com.example.demo.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.Exception.ResourceNotFoundException;
import com.example.demo.Model.S_Invoice;
import com.example.demo.Model.S_Login;
import com.example.demo.Repository.S_loginRepository;

@CrossOrigin(origins = "http://localhost:3000")//changed nethmi ...................
@RestController
@RequestMapping("/api")
public class S_loginController {
	
	@Autowired
	private S_loginRepository S_loginRepositoryObjj;
	
	
	

	//get invoice by id
	@GetMapping("/logins/{username},{password}")
	public S_Login getpassword(@PathVariable String username,@PathVariable String password) {
		
		return S_loginRepositoryObjj.findByUsernameAndPassword(username,password);
	}
	

}
