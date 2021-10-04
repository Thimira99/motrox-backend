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
import com.example.demo.Model.S_Invoice;
import com.example.demo.Repository.S_InvoiceRepository;
//import com.example.demo.Response.S_BillIdResponse;
import com.example.demo.Service.ReportService;

import net.sf.jasperreports.engine.JRException;



@CrossOrigin(origins = "http://localhost:3000")//changed nethmi ...................
@RestController
@RequestMapping("/api/v1")
public class S_InvoiceController {

	@Autowired
	private S_InvoiceRepository S_InvoiceRepositoryObj;
	
	 @Autowired
	    private ReportService service;
	 
	@GetMapping("/vehical_num/{Vehical_Num}")
    public List<S_Invoice> getVehicalSearch(@PathVariable String Vehical_Num) {
	return  S_InvoiceRepositoryObj.findvehical(Vehical_Num);}
			
	 
    @GetMapping("/Invoice_Number/{Invoice_Number}")
    public List<S_Invoice> findInvoiceNumber(@PathVariable String Invoice_Number) {
	return  S_InvoiceRepositoryObj.findInvoiceNumber(Invoice_Number);
	}
	 
	 //...............try
	 
	//get invoice by between 1date
			//@GetMapping("/Invoicefies/{startDate}")
			//public List<S_Invoice> getInvoiceBetweebId(@PathVariable int startDate,@PathVariable int endDate) {
				//return S_InvoiceRepositoryObj.findbetweenvalue(startDate,endDate);
			///}
		
	 
	
	 
	
	 @GetMapping("/report/{format}")
	    public String generateReport(@PathVariable String format) throws FileNotFoundException, JRException {
	        return service.exportReport(format);
	    }
	
	
	

	//get invoice by between totoal amount
		@GetMapping("/Invoicesbet/{startDate},{endDate}")
		public List<S_Invoice> getInvoiceBetweebId(@PathVariable int startDate,@PathVariable int endDate) {
			return S_InvoiceRepositoryObj.findbetweenvalue(startDate,endDate);
		}
	
		
		
		
		//get invoice by between date ...
				@GetMapping("/Invoicesdate/{startDatee},{endDatee}")
				public List<S_Invoice> getInvoiceBetweebdate(@PathVariable String startDatee,@PathVariable String endDatee) {
					return S_InvoiceRepositoryObj.findbetweenDatevalue(startDatee,endDatee);
				}
				
				
				
			
	//get all Invoices
	@GetMapping("/Invoices")
	public List<S_Invoice> getAllInvoices(){
		return S_InvoiceRepositoryObj.findAll();
	}
	
	
	
	
	
	//create invoice rest API
	@PostMapping("/Invoices")
	public S_Invoice createInvoice(@RequestBody S_Invoice S_InvoiceObj) {
		return S_InvoiceRepositoryObj.save(S_InvoiceObj);
	}
	
	
	
	
	
	
	//get invoice by id
	@GetMapping("/Invoices/{id}")
	public ResponseEntity<S_Invoice> getInvoiceById(@PathVariable int id) {
		S_Invoice S_InvoiceObj = S_InvoiceRepositoryObj.findById(id).orElseThrow(() -> new ResourceNotFoundException("invoice not fount"));
		return ResponseEntity.ok(S_InvoiceObj);
	}
	
	
	
	
	
	//update invoice by id
	@PutMapping("/Invoices/{id}")
	public ResponseEntity<S_Invoice> updateInvoiceById(@PathVariable int id,@RequestBody S_Invoice S_Invoiceobj){
		S_Invoice S_Invoiceobj2 = S_InvoiceRepositoryObj.findById(id).orElseThrow(() -> new ResourceNotFoundException("invoice not fount"));
		
		S_Invoiceobj2.setInvoiceNumber(S_Invoiceobj.getInvoiceNumber());
		S_Invoiceobj2.setVehicalNumber(S_Invoiceobj.getVehicalNumber());
		S_Invoiceobj2.setDate(S_Invoiceobj.getDate());
		S_Invoiceobj2.setTotalAmount(S_Invoiceobj.getTotalAmount());
		
		
		S_Invoiceobj2.setBillItemObj(S_Invoiceobj.getBillItemObj());
		
		S_Invoice S_Invoiceobj3 = S_InvoiceRepositoryObj.save(S_Invoiceobj2);
		
		
		return ResponseEntity.ok(S_Invoiceobj3);
	}
	
	
	
	
	
	//delete invoice by id
	@DeleteMapping("/Invoices/{id}")
	public ResponseEntity<Map<String,Boolean>>deleteInvoice(@PathVariable int id){
		S_Invoice invoiceObj = S_InvoiceRepositoryObj.findById(id).orElseThrow(() -> new ResourceNotFoundException("invoicdelete"
				+ " not fount"));
		S_InvoiceRepositoryObj.delete(invoiceObj);
		Map<String,Boolean> response = new HashMap<>();
		response.put("Deleted", Boolean.TRUE);
		return ResponseEntity.ok(response);
		
	}
	
	
	
	
	
	
	
}
