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

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.Exception.ResourceNotFoundException;

import com.example.demo.Model.T_StockItem;
import com.example.demo.Repository.T_StockItemRepository;



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
	
	//create stock
	@PostMapping("/stockItems")
	public T_StockItem createStockItem( @RequestBody T_StockItem stockitem) {
		return stockRepository.save(stockitem);
	}
	

	@GetMapping("/stockItems/{id}")
	public ResponseEntity<T_StockItem> getitemById(@PathVariable String id) {
		T_StockItem S_InvoiceObj = stockRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("invoice not fount"));
		return ResponseEntity.ok(S_InvoiceObj);
	}
	
	
	//sukitha did this .....
	
	//@GetMapping("/stockItems/{Item_Name}")
	//public List< T_StockItem> getitemByString(@PathVariable String Item_Name) {
	//return  stockRepository.findT_StockItems(Item_Name);}
		

	//get stockItem by item code
	@GetMapping("/stockItems/{itemcode}")
	public ResponseEntity<T_StockItem> getTStockItemByItemcode(@PathVariable String itemcode) {
		
		T_StockItem t_stockitem = stockRepository.findById(itemcode)
				.orElseThrow(()-> new ResourceNotFoundException("Item not exist with item code :" + itemcode ));
		return ResponseEntity.ok(t_stockitem);
	}
	

	//update stock item

	
	@PutMapping("/stockItems/{itemcode}")
	public ResponseEntity<T_StockItem> updateStockItem(@PathVariable String itemcode,@RequestBody T_StockItem t_stockitemDetails){
		T_StockItem t_stockitem = stockRepository.findById(itemcode)
				.orElseThrow(()-> new ResourceNotFoundException("Item not exist with item code :" + itemcode ));
		
		t_stockitem.setItemcode(t_stockitemDetails.getItemcode());
		t_stockitem.setItemname(t_stockitemDetails.getItemname());
		t_stockitem.setQty(t_stockitemDetails.getQty());
		t_stockitem.setReceivedqty(t_stockitemDetails.getReceivedqty());
		t_stockitem.setSoldqty(t_stockitemDetails.getSoldqty());
		t_stockitem.setDamageqty(t_stockitemDetails.getDamageqty());
		t_stockitem.setReturnqty(t_stockitemDetails.getReturnqty());
		t_stockitem.setPrice(t_stockitemDetails.getPrice());
		
		T_StockItem updatedStockItem = stockRepository.save(t_stockitem);
		return ResponseEntity.ok(updatedStockItem);
		
	}
	

	

}

	//delete stock item
	@DeleteMapping("/stockItems/{itemcode}")
	public ResponseEntity<Map<String, Boolean>> deleteStockItem(@PathVariable String itemcode){
		
		T_StockItem t_stockitem = stockRepository.findById(itemcode)
				.orElseThrow(()-> new ResourceNotFoundException("Item not exist with item code :" + itemcode ));
		
		stockRepository.delete(t_stockitem);
		Map<String, Boolean> response = new HashMap<>();
		response.put("delete", Boolean.TRUE);
		return ResponseEntity.ok(response);
		
	}
}
	
	
	
}

