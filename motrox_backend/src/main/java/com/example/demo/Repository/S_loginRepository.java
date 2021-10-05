package com.example.demo.Repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.demo.Model.S_Login;

public interface S_loginRepository extends JpaRepository<S_Login,Integer>{
	
	
	S_Login findByUsernameAndPassword(String username,String password);

}
