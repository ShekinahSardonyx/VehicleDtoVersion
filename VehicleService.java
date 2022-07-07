package com.cg.service;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cg.dto.VehicleDto;
import com.cg.entity.Vehicle;
import com.cg.repository.VehicleRepository;

@Service
public class VehicleService {
	
	@Autowired
	private VehicleRepository vehicleRepository;
	

	Vehicle vehicle = new Vehicle();

	public String addVehicle(VehicleDto vehicleDto) {
		Vehicle vehicle = new Vehicle();
		BeanUtils.copyProperties(vehicleDto, vehicle);
		vehicleRepository.save(vehicle);
		return "Vehicle Added Successfully";
	}
	
	public VehicleDto updateVehicle(int vId, String type) {
		Vehicle vehicle = new Vehicle();
		VehicleDto vehicleDto = new VehicleDto();
		BeanUtils.copyProperties(vehicleRepository.findById(vId), vehicleDto);
		vehicleDto.setType(type);
		BeanUtils.copyProperties(vehicle, vehicleDto);
		vehicleRepository.flush();
		return vehicleDto;
	}
	
	public List<VehicleDto> deleteVehicle(int vId){
		
		vehicleRepository.deleteById(vId);
		VehicleDto vehicleDto = new VehicleDto();
		List<VehicleDto> vehicleDtoList = new ArrayList<>();
		List<Vehicle> vehicleList = vehicleRepository.findAll();
		for(Vehicle vehicle : vehicleList) {
			BeanUtils.copyProperties(vehicle, vehicleDto);
			vehicleDtoList.add(vehicleDto);
		}
		return vehicleDtoList;
	}
	
	public double fixedChargesForCar(LocalDate d1, LocalDate d2) {
		double perDayCost = 2000.0;
		int numOfDays = d2.compareTo(d1);
		return perDayCost*numOfDays;
	}
	
	public double fixedChargesForBike(LocalDate d1, LocalDate d2) {
		double perDayCost = 500.0;
		int numOfDays = d2.compareTo(d1);
		return perDayCost*numOfDays;
	}
	
	public double fixedChargesForBicycle(LocalDate d1, LocalDate d2) {
		double perDayCost = 200.0;
		int numOfDays = d2.compareTo(d1);
		return perDayCost*numOfDays;
	}
	
	public double chargesPerKm(String type) {
		double d1 =0.0;
		if(type.equals("Car")) {
			d1 = 40.0;
		}
		else if(type.equals("Bike")) {
			d1 = 20.0;
		}
		else if(type.equals("Bicycle")) {
			d1 = 10.0;
		}
		return d1;
	}
	
		
}
