package com.example.demo.Repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.example.demo.Model.ND_Order;


@Repository
public interface ND_OrderRepository extends JpaRepository<ND_Order, Long>{
	
	@Query(value = "SELECT * FROM orders WHERE supplier = :supplier", nativeQuery = true)
	List <ND_Order> findbusuppliername(@Param("supplier")String supplier);

	

}
