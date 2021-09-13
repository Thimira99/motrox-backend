package com.example.demo.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.Model.Sh_Supplier;
import com.example.demo.Repository.Sh_SupplierRepository;

@RestController
@RequestMapping("/api/v1")
public class Sh_SupplierController {
	
	@Autowired
	private Sh_SupplierRepository supplierRepository;
	
	//get all suppliers
	@GetMapping("/suppliers")
	public List<Sh_Supplier> getAllSuppliers(){
		return supplierRepository.findAll();
		
	}
	
	// create supplier rest api
	@PostMapping("/suppliers")
	public Sh_Supplier createSupplier(@RequestBody Sh_Supplier sh_Supplier) {
		return supplierRepository.save(sh_Supplier);
	}

	

}
