package com.example.demo.Controller;

import java.io.FileNotFoundException;
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
import com.example.demo.Model.ND_Order;

import com.example.demo.Repository.ND_OrderRepository;
import com.example.demo.Service.NikilReport;


import net.sf.jasperreports.engine.JRException;

@CrossOrigin(origins = "http://localhost:3000")
@RestController
@RequestMapping("/api/v1/")


public class ND_OrderController {
	
	
	
	@Autowired
	private ND_OrderRepository ND_OrderRepository;
	
	@Autowired
	   private NikilReport service1;
	
	
	 
	 
	 
	 
	 @GetMapping("/Nikilreport/{format}")
	    public String generateReport(@PathVariable String format) throws FileNotFoundException, JRException {
	        return service1.exportReport(format);
	    }
	
	
	// get all orders
	
	@GetMapping("/orders")
	public List<ND_Order> getAllOrders(){
		return ND_OrderRepository.findAll();
	}
	
	//create order rest API
	
	@PostMapping("/orders")
    public ND_Order createOrder(@RequestBody ND_Order nd_Order) {
	    return ND_OrderRepository.save(nd_Order);
	}
	
	//get order by id
	
	@GetMapping("/orders/{id}")
	public ResponseEntity<ND_Order> getOrderById(@PathVariable Long id) {
	    ND_Order nd_Order = ND_OrderRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("Order not found" + id));
	    return ResponseEntity.ok(nd_Order);
	}
	

	//update order
	
	@PutMapping("/orders/{id}")
	public ResponseEntity<ND_Order> updateOrder(@PathVariable Long id, @RequestBody ND_Order nd_Order){
		ND_Order nd_Order2 = ND_OrderRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("Order not found" + id));
			
		nd_Order2.setDate(nd_Order.getDate());
		nd_Order2.setSupplier(nd_Order.getSupplier());
		nd_Order2.setItemCode(nd_Order.getItemCode());
		nd_Order2.setItemName(nd_Order.getItemName());
		nd_Order2.setQuantity(nd_Order.getQuantity());
		nd_Order2.setPrice(nd_Order.getPrice());
		nd_Order2.setTotalPrice(nd_Order.getTotalPrice());
			
		ND_Order nd_Order3 = ND_OrderRepository.save(nd_Order2);
		
		
		return ResponseEntity.ok(nd_Order3);
	}
	
	//delete order
	
	@DeleteMapping("/orders/{id}")
	public ResponseEntity<Map<String, Boolean>> deleteOrder(@PathVariable Long id){
		ND_Order nd_Order = ND_OrderRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("Order not found" + id));			
		ND_OrderRepository.delete(nd_Order);
		Map<String, Boolean> response = new HashMap<>();
		response.put("deleted", Boolean.TRUE);
		return ResponseEntity.ok(response);
	}
	
	
	
	 
    @GetMapping("/ordersbysup/{supplier}")
    public List<ND_Order> getsupplierbyName(@PathVariable String supplier) {
	return  ND_OrderRepository.findbusuppliername(supplier);
	}
	 
	
	
	
	
	

}
