package com.example.demo.Repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.example.demo.Model.S_BillItems;


public interface S_BillItemsRepository extends JpaRepository<S_BillItems,Integer>{

	
	@Query(value = "SELECT * FROM bill_items WHERE invoice_number = :invoice_number", nativeQuery = true)
	List<S_BillItems> findbillbyid(@Param("invoice_number")int invoice_number);

	
	
}
