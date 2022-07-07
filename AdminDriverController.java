package com.cg.controller;

import java.time.LocalDate;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import com.cg.service.PaymentService;

@RestController
public class AdminDriverController {

	@Autowired
	public PaymentService paymentService;
	
	@GetMapping("/calcPayByRole/{type}/{role}/{date1}/{date2}")
	public double calculatePayByRole(@PathVariable("type") String type, @PathVariable("role") String role, @PathVariable("date1") LocalDate date1, @PathVariable("date2") LocalDate date2) {
		return paymentService.calculateMonthlyPayment(type, role, date1, date2);
	}
	
	
}
