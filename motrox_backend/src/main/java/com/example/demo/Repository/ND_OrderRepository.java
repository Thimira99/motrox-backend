package com.example.demo.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.demo.Model.ND_Order;

@Repository
public interface ND_OrderRepository extends JpaRepository<ND_Order, Long>{

}
