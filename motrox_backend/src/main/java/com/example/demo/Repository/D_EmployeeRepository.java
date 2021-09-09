package com.example.demo.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.demo.Model.D_Employee;

@Repository
public interface D_EmployeeRepository extends JpaRepository<D_Employee, Long>{

}
