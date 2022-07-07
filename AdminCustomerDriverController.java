package com.cg.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import com.cg.dto.BookingDto;
import com.cg.dto.CustomerDto;
import com.cg.dto.PaymentDto;
import com.cg.service.BookingService;
import com.cg.service.CustomerService;
import com.cg.service.PaymentService;

@RestController
public class AdminCustomerDriverController {

	@Autowired
	public BookingService bookingService;
	
	@Autowired
	public PaymentService paymentService;
	
	@Autowired
	public CustomerService customerService;
	
	@GetMapping("/viewBooking/{id}")
    public BookingDto viewBooking(@PathVariable ("id") int bookingId) {
    	return bookingService.viewBooking(bookingId);
    }
	
	@GetMapping("/View/{paymentId/{Status}")
	public PaymentDto viewPaymentStatus(@PathVariable("paymentId") int paymentId, @PathVariable("status") String status) {
		return paymentService.updatePaymentStatus(paymentId, status);
	}
	
	@GetMapping("/ViewCustomer/{customerId}")
	public CustomerDto viewCustomer(@PathVariable("customerId") int customerId) {
		return customerService.viewCustomer(customerId);
	}
}
