package org.photoproductsshoppe.pps.service;

import java.util.List;

import org.photoproductsshoppe.pps.dto.CustomerDto;
import org.photoproductsshoppe.pps.entity.Customer;
import org.photoproductsshoppe.pps.exception.CustomerIdException;
import org.photoproductsshoppe.pps.exception.ValidateCustomerException;



public interface CustomerService {
	public Customer addCustomer(CustomerDto customerdto)throws ValidateCustomerException;
	public Customer updateCustomer(CustomerDto customerdto)throws CustomerIdException,ValidateCustomerException;
	public boolean removeCustomer(Integer customerId)throws CustomerIdException;
	public Customer viewCustomerById(Integer customerId)throws CustomerIdException;
	public List<Customer> viewAllCustomers()throws CustomerIdException;
	public Customer getCustomerData(Integer userId);
	
}