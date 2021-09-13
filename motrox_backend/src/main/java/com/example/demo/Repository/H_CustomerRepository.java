package com.example.demo.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.demo.Model.H_Customer;

@Repository
public interface H_CustomerRepository extends JpaRepository<H_Customer ,Long>{

}
