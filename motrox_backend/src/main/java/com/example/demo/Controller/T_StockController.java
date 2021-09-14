package com.example.demo.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.Exception.ResourceNotFoundException;
import com.example.demo.Model.S_Invoice;
import com.example.demo.Model.T_StockItem;
import com.example.demo.Repository.T_StockItemRepository;

@CrossOrigin(origins = "http://localhost:3000")
@RestController
@RequestMapping("/api/v1")
public class T_StockController {

	@Autowired
	private T_StockItemRepository stockRepository;
	
	//get all stock 
	@GetMapping("/stockItems")
	public List<T_StockItem>getAllstockItems(){
		return stockRepository.findAll();
	}
	
	
	
	
}
