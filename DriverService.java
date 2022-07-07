package com.cg.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cg.dto.DriverDto;
import com.cg.entity.Driver;
import com.cg.repository.DriverRepository;
@Service
public class DriverService {

	@Autowired
	public DriverRepository driverRepository;
	
	public DriverDto addDriver(DriverDto driverDto) {
		Driver driver  = new Driver();
		BeanUtils.copyProperties(driverDto, driver);
		driverRepository.save(driver);
		return driverDto;
	}
	
	public List<DriverDto> removeDriver(int id){
		driverRepository.deleteById(id);
		List<Driver> driverList = driverRepository.findAll();
		List<DriverDto> driverDtoList = new ArrayList<>();
		DriverDto driverDto = new DriverDto();
		for(Driver driver : driverList) {
			BeanUtils.copyProperties(driver, driverDto);
			driverDtoList.add(driverDto);
		}
		return driverDtoList;
		
	}
	
	public DriverDto updateDriver(int id, String mobNum) {
		Driver driver = new Driver();
		DriverDto driverDto = new DriverDto();
		BeanUtils.copyProperties(driverRepository.findById(id).get(), driverDto);
		driverDto.setDriverMobileNumber(mobNum);
		BeanUtils.copyProperties(driverDto, driver);
		driverRepository.flush();
		return driverDto;
	}
	
	public String AcceptOrRejectBooking(String message) {
		if(message.equals("Accept")) {
			return "Booking Accepted";
		}
		else {
			return "Booking Rejected";
		}
	}
	
}
