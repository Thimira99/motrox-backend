package com.example.demo.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.Exception.ResourceNotFoundException;
import com.example.demo.Model.N_Vehicle;
import com.example.demo.Repository.N_VehicleRepository;

@RestController
@RequestMapping("/api/v1/")
public class N_VehicleController {

	@Autowired
	private N_VehicleRepository n_VehicleRepository;
	
	//get all vehicles
		@GetMapping("/vehicle")
		public List<N_Vehicle> getAllVehicles(){
			return n_VehicleRepository.findAll();
		}
	
	//create vehicle rest api
		@PostMapping("/vehicle")
		public N_Vehicle  CreateVehicle(@RequestBody N_Vehicle n_Vehicle) {
			return n_VehicleRepository.save(n_Vehicle);
		}
		
	//get vehicle by id rest api
		@GetMapping("/vehicle/{vehicleId}")
		public ResponseEntity<N_Vehicle> getVehicleById(@PathVariable Long vehicleId) {
			N_Vehicle n_Vehicle = n_VehicleRepository.findById(vehicleId).orElseThrow(() -> new ResourceNotFoundException("Vehicle is not exist with id :" + vehicleId));
			return ResponseEntity.ok(n_Vehicle);
		}
		
}
