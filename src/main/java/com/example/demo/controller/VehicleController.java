package com.example.demo.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.repository.VehicleRepository;
import com.example.demo.model.Vehicle;


@RestController
@RequestMapping("/vehicle")
public class VehicleController {

	private VehicleRepository vehicleRepo;
	
	public VehicleController(VehicleRepository vehicleRepo) {
		this.vehicleRepo = vehicleRepo;
	}
	
	
	@PreAuthorize("hasAuthority('SCOPE_data.read') AND hasAuthority('SCOPE_openid')")
	@GetMapping("/all")
	public ResponseEntity<List<Vehicle>> getAllVehicles(){
		try {
			List<Vehicle> vehicles = new ArrayList<Vehicle>();
			vehicles = vehicleRepo.getAllVehicles();
			if (vehicles.isEmpty()) {
				return new ResponseEntity<>(HttpStatus.NO_CONTENT);
			}
		    return new ResponseEntity<>(vehicles, HttpStatus.OK);
		} catch (Exception e) {
			return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
	
}
