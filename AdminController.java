package com.cg.controller;

import java.time.LocalDate;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.cg.dto.AdminDto;
import com.cg.dto.BookingDto;
import com.cg.dto.CustomerDto;
import com.cg.dto.PaymentDto;
import com.cg.dto.VehicleDto;
import com.cg.service.AdminService;
import com.cg.service.BookingService;
import com.cg.service.CustomerService;
import com.cg.service.PaymentService;
import com.cg.service.VehicleService;

@RestController
public class AdminController {

	@Autowired
	private AdminService adminService;
	
	@Autowired
	private VehicleService vehicleService;
	
	
	@Autowired
    public CustomerService customerService;
	
	@Autowired
	public PaymentService paymentService;
	
	@Autowired
	private BookingService bookingService;
	
	
	@PostMapping("/addAdmin")
	public String addAdmin(@RequestBody AdminDto adminDto) {
		return adminService.addAdmin(adminDto);
	}
	
	@PutMapping("/updateAdminPassword/{id}/{pwd}")
	public AdminDto updateAdminPassword(@PathVariable("id") int adminId, @PathVariable("pwd") String newPwd) {
		return adminService.updateAdminPassword(adminId, newPwd);
	}
	
	@PutMapping("/updateAdminName/{id}/{firstName}")
	public AdminDto updateAdminName(@PathVariable("id") int adminId, @PathVariable("firstName") String firstName) {
		return adminService.updateAdminName(adminId, firstName);
	}
	
	@DeleteMapping("/deleteAdmin/{id}")
	public List<AdminDto> deleteAdmin(@PathVariable("id") int adminId){
		return adminService.deleteAdmin(adminId);
	}
	
	@PostMapping("/addVehicle")
	public String addVehicle(@RequestBody VehicleDto vehicleDto) {
		return vehicleService.addVehicle(vehicleDto);
	}
	
	@PutMapping("/updateVehicle/{id}/{type}")
	public VehicleDto updateVehicle(@PathVariable("id") int vId, @PathVariable("type") String newType) {
		return vehicleService.updateVehicle(vId, newType);
	}
	
	@DeleteMapping("/deleteVehicle/{id}")
	public List<VehicleDto> deleteVehicle(@PathVariable("id") int vId){
		return vehicleService.deleteVehicle(vId);
	}
    
    @PostMapping("/addCustomer/{customer}")
	public String addCustomer(@RequestBody CustomerDto customerDto) {
		return customerService.addCustomer(customerDto);
		
	}
	@PutMapping("/update/{customerId}/{customerMobileNumber}")
	public CustomerDto updateCustomer(@PathVariable("customerId") int customerId,@PathVariable("customerMobileNumber") String customerMobileNumber){
		return customerService.updateCustomer(customerId, customerMobileNumber);
	}
	
	@DeleteMapping("/deleteCustomer/{customerId}")
	public List<CustomerDto> deleteCustomer(@PathVariable ("customerId") int customerId) {
		return customerService.removeCustomer(customerId);
	}
	
	
	@GetMapping("/ViewAllCustomers")
	public List<CustomerDto> ViewAllCustomers() {
		return customerService.viewAllCustomer();
	}
	
	@GetMapping("/getAllCustomersAddress")
	public List<CustomerDto> getAllCustomers(String location){
		return customerService.viewAllCustomersByLocation(location);
	}
	

	@PutMapping("/update/{paymentId}/{mode}")
	public PaymentDto updatePaymentMode(@PathVariable("paymentId")int paymentId, @PathVariable("mode") String mode){
		return paymentService.updatePaymentMode(paymentId, mode);
	}
	
	@PutMapping("/update/{paymentId}/{date}")
	public PaymentDto updatePaymentDate(@PathVariable("paymentId")int paymentId, @PathVariable("date") LocalDate date){
		return paymentService.updatePaymentDate(paymentId, date);
	}
	
	@PutMapping("/update/{paymentId}/{status}")
	public PaymentDto updatePaymentStatus(@PathVariable("paymentId")int paymentId, @PathVariable("status") String status){
		return paymentService.updatePaymentStatus(paymentId, status);
	}
	
	@GetMapping("/viewAllPayments")
	public List<PaymentDto> ViewAllCustomer(){
		return paymentService.viewAllPayments();
   }

	@GetMapping("/calculateTotalPayment/{type}/{date1}/{date2}")
	public double calculateTotalPay(@PathVariable("type") String type , @PathVariable("date1") LocalDate date1, @PathVariable("date2") LocalDate date2) {
		return paymentService.CalculateTotalPayment(type, date1, date2);
	}
	
	
	@PutMapping("/updateByDate/{id}/{date}")
	public BookingDto updateBookingFromDate(@PathVariable ("id") int bookingId,@PathVariable("date") LocalDate bookingDate) {
		return bookingService.updateBookingFromDate(bookingId, bookingDate);
		
	}


	@PutMapping("/updateByTillDate/{id}/{date}")
	public BookingDto updateBookingTillDate(@PathVariable ("id") int bookingId,@PathVariable("date") LocalDate bookedTillDate) {
		return bookingService.updateBookingTillDate(bookingId, bookedTillDate);
		
	}

	@PutMapping("/updateDistance/{id}/{distance}")
	public BookingDto updatedistance(@PathVariable ("id") int bookingId,@PathVariable("distance") double distance) {
		return bookingService.updatedistance(bookingId, distance);
		
	}

	@PutMapping("/updateCost/{id}/{cost}")
	public BookingDto updatecost(@PathVariable ("id") int bookingId,@PathVariable("cost") double totalcost) {
		return bookingService.updatecost(bookingId, totalcost);
		
	}
	
    @GetMapping("/viewAllBooking")
    public List<BookingDto> viewAllBooking() {
    	return bookingService.viewAllBookings();
    }
    
    
    @GetMapping("/viewAllBookingByDate/{date}")
    public List<BookingDto> viewAllBookingByDate(@PathVariable ("date")LocalDate bookingDate) {
    	return bookingService.viewAllBookingByDate(bookingDate);
    }
    
}
