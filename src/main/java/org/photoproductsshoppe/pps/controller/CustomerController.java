package org.photoproductsshoppe.pps.controller;

import java.util.List;

import org.photoproductsshoppe.pps.dto.CustomerDto;
import org.photoproductsshoppe.pps.entity.Customer;
import org.photoproductsshoppe.pps.exception.CustomerIdException;
import org.photoproductsshoppe.pps.exception.ValidateCustomerException;
import org.photoproductsshoppe.pps.service.CustomerServiceImp;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
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



@RestController
@RequestMapping("/customer")
@CrossOrigin
public class CustomerController 
{
    
        @Autowired
        CustomerServiceImp customerService;
        
        
//        @PostMapping("/add customer")
//        public SuccessMessageDto addCustomer(@RequestBody CustomerDto customerDto) throws ValidateCustomerException, UserNotFoundException
//        {
//            Customer customer= customerService.addCustomer(customerDto);
//            return new SuccessMessageDto(ShoppingConstants.CUSTOMER_ADDED+ customer.getCustomerId());
//        }
        
        @PostMapping("/addcustomer")
        public Customer addCustomer(@RequestBody CustomerDto customerDto) throws ValidateCustomerException
        {
            Customer customer= customerService.addCustomer(customerDto);
            return customer;
        }
        
      
        
        @GetMapping("/getcustomerbyid/{customerId}")
        public Customer viewCustomerById(@PathVariable("customerId")Integer customerId) throws CustomerIdException 
        {
        
            return customerService.viewCustomerById(customerId); 
        }
        
        @GetMapping("/getallcustomer")
        public List<Customer> viewCustomer() throws CustomerIdException 
        {
            return customerService.viewAllCustomers();    
        }
        
        @GetMapping("/getcustomerdata/{userId}")
        public Customer getCustomerData(@PathVariable("userId") Integer userId) {
            Customer customer = customerService.getCustomerData(userId);
            return customer;
        }

}