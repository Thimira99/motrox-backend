package com.example.demo.Repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.example.demo.Model.S_Invoice;
import com.example.demo.Model.T_StockItem;

public interface S_InvoiceRepository extends JpaRepository<S_Invoice,Integer> {

	//@Query("SELECT new com.example.demo.Response.S_BillIdResponse(s.invoic_id) FROM S_Invoice s ORDER BY s.invoic_id DESC LIMIT 1?1" )
    //public S_BillIdResponse getLastIdnUMBER();
	
	
	
	
	//public S_Invoice findTopByOrderByIdDesc(int id);
	
	//TypedQuery<S_Invoice> query = entityManager.createQuery("SELECT s FROM Students s ORDER BY s.id DESC", Student.class);    
	//query.setMaxResults(1);
	
	
	@Query(value = "SELECT * FROM invoice WHERE total_amount  >= :startDate AND total_amount <= :endDate", nativeQuery = true)
	List<S_Invoice> findbetweenvalue(@Param("startDate") int startDate, @Param("endDate") int endDate);
	
	
	

	@Query(value = "SELECT * FROM invoice WHERE invoice_date  >= :startDatee AND invoice_date <= :endDatee", nativeQuery = true)
	List<S_Invoice> findbetweenDatevalue(@Param("startDatee") String startDatee, @Param("endDatee") String endDatee);

	
	@Query(value = "SELECT * FROM invoice WHERE vehical_number = :vehical_number", nativeQuery = true)
	List<S_Invoice> findvehical(@Param("vehical_number")String Vehical_Number);


	@Query(value = "SELECT * FROM invoice WHERE invoice_number = :invoice_number", nativeQuery = true)
	List<S_Invoice> findInvoiceNumber(@Param("invoice_number")String Invoice_number);



	

	

   
}
