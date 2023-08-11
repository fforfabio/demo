package com.example.demo.model;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;


@Entity
@Table(name = "vehicleTable")
public class Vehicle {
	
	@Id
	@NotNull
	private String vin;
	
	private String plateNumber;
	
	private String modelDescription;


	public Vehicle() {
	}


	public Vehicle(@NotNull String vin, String plateNumber, String modelDescription) {
		super();
		this.vin = vin;
		this.plateNumber = plateNumber;
		this.modelDescription = modelDescription;
	}


	public String getVin() {
		return vin;
	}


	public void setVin(String vin) {
		this.vin = vin;
	}


	public String getPlateNumber() {
		return plateNumber;
	}


	public void setPlateNumber(String plateNumber) {
		this.plateNumber = plateNumber;
	}


	public String getModelDescription() {
		return modelDescription;
	}


	public void setModelDescription(String modelDescription) {
		this.modelDescription = modelDescription;
	}


	@Override
	public String toString() {
		return "Vehicle [vin=" + vin + ", plateNumber=" + plateNumber + ", modelDescription=" + modelDescription + "]";
	}

}
