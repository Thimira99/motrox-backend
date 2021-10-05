package com.example.demo.Controller;

import java.io.FileNotFoundException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.Exception.ResourceNotFoundException;
import com.example.demo.Model.S_BillItems;
import com.example.demo.Model.S_Invoice;
import com.example.demo.Repository.S_BillItemsRepository;
import com.example.demo.Service.ReportService;
import com.example.demo.Service.S_billItems;

import net.sf.jasperreports.engine.JRException;




@CrossOrigin(origins = "http://localhost:3000")
@RestController
@RequestMapping("/api/v1")
public class S_BillItemsController {

	@Autowired
	private S_BillItemsRepository S_BillItemsRepositoryObj;
	
	 @Autowired
	 private S_billItems service;
	
	
	
	//get all billItems
	@GetMapping("/billitems")
	public List<S_BillItems> getAllemail(){
		return S_BillItemsRepositoryObj.findAll();
	}

	//get billitems by id
	@GetMapping("/billitems/{id}")
	public ResponseEntity<S_BillItems> getEmailById(@PathVariable int id) {
		S_BillItems S_BillItemsobj2 = S_BillItemsRepositoryObj.findById(id).orElseThrow(() -> new ResourceNotFoundException("emp not fount"));
		return ResponseEntity.ok(S_BillItemsobj2);
	}
	
	
	 @GetMapping("/Billnumber/{Invoice_Number}")
	    public List<S_BillItems> findInvoiceNumber(@PathVariable int Invoice_Number) {
		return  S_BillItemsRepositoryObj.findbillbyid(Invoice_Number);
		}
		 
	    
	    

		 @GetMapping("/billreport/{Invoice_Number},{filename}")
		    public String generateReport(@PathVariable int Invoice_Number,@PathVariable String filename) throws FileNotFoundException, JRException {
		        return service.exportReportbill(Invoice_Number,filename);
		    }
	

	
}
