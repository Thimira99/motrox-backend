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
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.Exception.ResourceNotFoundException;
import com.example.demo.Model.N_Vehicle;
import com.example.demo.Repository.N_VehicleRepository;

@CrossOrigin(origins = "http://localhost:3000")
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
		
	//update vehicle rest api
		@PutMapping("/vehicle/{vehicleId}")
		public ResponseEntity<N_Vehicle> updateVehicle(@PathVariable Long vehicleId, @RequestBody N_Vehicle vehicleDetails){
			N_Vehicle n_Vehicle = n_VehicleRepository.findById(vehicleId).orElseThrow(() -> new ResourceNotFoundException("Vehicle is not exist with id :" + vehicleId));
			
			n_Vehicle.setNameOfTheOwner(vehicleDetails.getNameOfTheOwner());
			n_Vehicle.setRegistrationNo(vehicleDetails.getRegistrationNo());
			n_Vehicle.setYearOfManufacture(vehicleDetails.getYearOfManufacture());
			n_Vehicle.setChassisNo(vehicleDetails.getChassisNo());
			n_Vehicle.setEngineNo(vehicleDetails.getEngineNo());
			n_Vehicle.setSeatingCapacity(vehicleDetails.getSeatingCapacity());
			n_Vehicle.setMake(vehicleDetails.getMake());
			n_Vehicle.setModel(vehicleDetails.getModel());
			n_Vehicle.setTypeOfFuel(vehicleDetails.getTypeOfFuel());
			n_Vehicle.setTypeOfBody(vehicleDetails.getTypeOfBody());
			n_Vehicle.setCylinderCapacity(vehicleDetails.getCylinderCapacity());
			n_Vehicle.setDateOfRegistration(vehicleDetails.getDateOfRegistration());
			n_Vehicle.setClassOfVehicle(vehicleDetails.getClassOfVehicle());
			n_Vehicle.setColour(vehicleDetails.getColour());
			
			N_Vehicle updatedVehicle = n_VehicleRepository.save(n_Vehicle);
			return ResponseEntity.ok(updatedVehicle);
		}
		
	//delete vehicle rest api
		@DeleteMapping("/vehicle/{vehicleId}")
		public ResponseEntity <Map<String, Boolean>> deleteVehicle(@PathVariable Long vehicleId){
			N_Vehicle n_Vehicle = n_VehicleRepository.findById(vehicleId).orElseThrow(() -> new ResourceNotFoundException("Vehicle is not exist with id :" + vehicleId));
			
			n_VehicleRepository.delete(n_Vehicle);
			Map<String, Boolean> response = new HashMap<>();
			response.put("deleted", Boolean.TRUE);
			return ResponseEntity.ok(response);
		}
}
