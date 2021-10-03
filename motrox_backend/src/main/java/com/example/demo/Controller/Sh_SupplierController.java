package com.example.demo.Controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.Exception.ResourceNotFoundException;
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
	
	// get supplier by id rest api
	@GetMapping("/suppliers/{id}")
	public ResponseEntity<Sh_Supplier> getSupplierById(@PathVariable Long id) {
			
		Sh_Supplier sh_Supplier = supplierRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("Supplier not exist with id :" + id));
		return ResponseEntity.ok(sh_Supplier);
	}
	
	//update supplier rest api
	@PutMapping("/suppliers/{id}")
	public ResponseEntity<Sh_Supplier> updateSupplier(@PathVariable Long id, @RequestBody Sh_Supplier supplierDetails){
			
			Sh_Supplier sh_Supplier = supplierRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("Supplier not exist with id :" + id));
			sh_Supplier.setSupplierName(supplierDetails.getSupplierName());
			sh_Supplier.setSupplierPhone(supplierDetails.getSupplierPhone());
			sh_Supplier.setSupplierAddress(supplierDetails.getSupplierAddress());
			sh_Supplier.setSupplierEmail(supplierDetails.getSupplierEmail());
			sh_Supplier.setItemDescription(supplierDetails.getItemDescription());
			sh_Supplier.setSupplierJoinDate(supplierDetails.getSupplierJoinDate());
			sh_Supplier.setPaymentMethod(supplierDetails.getPaymentMethod());
			
			Sh_Supplier updatedSupplier = supplierRepository.save(sh_Supplier);
			return ResponseEntity.ok(updatedSupplier);
	}
	
	//delete supplier rest api
	@DeleteMapping("/suppliers/{id}")
	public ResponseEntity<Map<String, Boolean>> deleteSupplier(@PathVariable Long id){
			
		Sh_Supplier sh_Supplier = supplierRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("Supplier not exist with id :" + id));
			
		supplierRepository.delete(sh_Supplier);
		Map<String, Boolean> response = new HashMap<>();
		response.put("deleted", Boolean.TRUE);
		return ResponseEntity.ok(response);
			
	}


	

}
