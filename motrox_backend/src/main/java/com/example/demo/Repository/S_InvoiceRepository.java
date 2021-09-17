package com.example.demo.Repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.demo.Model.S_Invoice;

public interface S_InvoiceRepository extends JpaRepository<S_Invoice,Integer> {

	//@Query("SELECT new com.example.demo.Response.S_BillIdResponse(s.invoic_id) FROM S_Invoice s ORDER BY s.invoic_id DESC LIMIT 1?1" )
    //public S_BillIdResponse getLastIdnUMBER();
	
	
	
	
	//public S_Invoice findTopByOrderByIdDesc(int id);
	
	//TypedQuery<S_Invoice> query = entityManager.createQuery("SELECT s FROM Students s ORDER BY s.id DESC", Student.class);    
	//query.setMaxResults(1);
    
   
}
