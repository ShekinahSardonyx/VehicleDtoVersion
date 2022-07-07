package com.cg.service;


import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cg.dto.CustomerDto;
import com.cg.entity.Customer;
import com.cg.repository.CustomerRepository;
@Service
public class CustomerService {

	@Autowired
	private CustomerRepository customerRepository;
	
	public String addCustomer(CustomerDto customerDto) {
		Customer customer = new Customer();
		BeanUtils.copyProperties(customerDto, customer);
		customerRepository.save(customer);
		return "Customer added successfully";
		
	}
	
	public List<CustomerDto> removeCustomer(int id) {
		customerRepository.deleteById(id);
		CustomerDto customerDto = new CustomerDto();
		List<Customer> customerList = customerRepository.findAll();
		List<CustomerDto> customerDtoList = new ArrayList<>();
		for(Customer customer : customerList) {
			BeanUtils.copyProperties(customer, customerDto);
			customerDtoList.add(customerDto);
		}
		return customerDtoList;
		
	}
	public CustomerDto viewCustomer(int id) {
		Customer customer = customerRepository.findById(id).get();
		CustomerDto customerDto = new CustomerDto();
		BeanUtils.copyProperties(customer, customerDto);
		return customerDto;
		
	}
	public CustomerDto updateCustomer(int id,String mobNum) {
		Customer customer= new Customer();
		CustomerDto customerDto = new CustomerDto();
		BeanUtils.copyProperties(customerRepository.findById(id).get(), customerDto);
		customerDto.setCustomerMobileNumber(mobNum);
		BeanUtils.copyProperties(customerDto, customer);
		customerRepository.flush();
		return customerDto;
	}
	public List<CustomerDto> viewAllCustomer(){
		List<Customer> customerList = customerRepository.findAll();
		List<CustomerDto> customerDtoList = new ArrayList<>();
		CustomerDto customerDto = new CustomerDto();
		for(Customer customer : customerList) {
			BeanUtils.copyProperties(customer, customerDto);
			customerDtoList.add(customerDto);
		}
		return customerDtoList;
		
		
	}
	public List<CustomerDto> viewAllCustomersByLocation(String location){
		List<Customer> customerList =  customerRepository.getByCustomerAddress(location) ;
		List<CustomerDto> customerDtoList = new ArrayList<>();
		CustomerDto customerDto = new CustomerDto();
		for(Customer customer : customerList) {
			BeanUtils.copyProperties(customer, customerDto);
			customerDtoList.add(customerDto);
		}
		return customerDtoList;
		
	}
	
	
}
