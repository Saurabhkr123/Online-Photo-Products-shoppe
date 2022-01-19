package org.photoproductsshoppe.pps.service;

import java.util.List;
import java.util.Optional;

import org.photoproductsshoppe.pps.dto.CustomerDto;
import org.photoproductsshoppe.pps.entity.Customer;
import org.photoproductsshoppe.pps.exception.CustomerIdException;
import org.photoproductsshoppe.pps.exception.ValidateCustomerException;
import org.photoproductsshoppe.pps.repository.CustomerRepository;
import org.photoproductsshoppe.pps.util.ShoppingConstants;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.security.SecurityProperties.User;
import org.springframework.stereotype.Service;



@Service
public class CustomerServiceImp implements CustomerService
{
	@Autowired
	CustomerRepository customerDao;
	
	
	public Customer addCustomer(CustomerDto customerDto) throws ValidateCustomerException {
		validateCustomer(customerDto);
		Customer customer = new Customer();
		customer.setFirstName(customerDto.getFirstName());
		customer.setLastName(customerDto.getLastName());
		customer.setMobileNumber(customerDto.getMobileNumber());
		customer.setEmail(customerDto.getEmail());
		
		return customerDao.save(customer);
	}

	private boolean validateCustomer(CustomerDto customerDto) throws ValidateCustomerException {
	
		if (!customerDto.getFirstName().matches(ShoppingConstants.CUSTOMER_PATTERN))
			throw new ValidateCustomerException(ShoppingConstants.CUSTOMER_CANNOT_BE_EMPTY);
		
		if (!customerDto.getLastName().matches(ShoppingConstants.CUSTOMER_PATTERN))
			throw new ValidateCustomerException(ShoppingConstants.CUSTOMER_CANNOT_BE_EMPTY);
		
		if (!customerDto.getMobileNumber().matches("[1-9][0-9]{9}"))
			throw new ValidateCustomerException(ShoppingConstants.PHONENUMBER_CANNOT_BE_EMPTY);
		
		if (!customerDto.getEmail().matches("^[a-zA-Z0-9+_.-]+@[a-zA-Z0-9.-]+$"))
			throw new ValidateCustomerException(ShoppingConstants.EMAIL_CANNOT_BE_EMPTY);
		return true;
	}

	

	public Customer updateCustomer(CustomerDto customerDto) throws CustomerIdException, ValidateCustomerException {
		validateCustomer(customerDto);
		Optional<Customer> optCustomer = customerDao.findById(customerDto.getCustomerId());
		if (!optCustomer.isPresent())
			throw new CustomerIdException(ShoppingConstants.CUSTOMER_NOT_FOUND);
		
		
		Customer customer = optCustomer.get();
		
		customer.setFirstName(customerDto.getFirstName());
		customer.setLastName(customerDto.getLastName());
		customer.setMobileNumber(customerDto.getMobileNumber());
		customer.setEmail(customerDto.getEmail());
        return customerDao.save(customer);

	}
	
	

	

	@Override
	public boolean removeCustomer(Integer customerId) throws CustomerIdException {
		
			Optional<Customer> optcustomer = customerDao.findById(customerId);

			if (!optcustomer.isPresent()) {
				throw new CustomerIdException(ShoppingConstants.CUSTOMER_NOT_FOUND);

			}
			customerDao.delete(optcustomer.get());
			return true;
		}



	@Override
	public List<Customer> viewAllCustomers() throws CustomerIdException {
	
			List<Customer> customerlist = customerDao.findAll();
			if (customerlist.isEmpty())
				throw new CustomerIdException(ShoppingConstants.CUSTOMER_NOT_FOUND);
			customerlist.sort((a1, a2) -> a1.getFirstName().compareTo(a2.getFirstName()));
			return customerlist;
		
	}

	@Override
    public Customer getCustomerData(Integer userId) {
        Customer customer = customerDao.getCustomerByUserId(userId);
        return customer;
    }

	@Override
	public Customer viewCustomerById(Integer customerId) throws CustomerIdException {
		Optional<Customer> optcustomer = customerDao.findById(customerId);
		if (!optcustomer.isPresent()) {
			throw new CustomerIdException(ShoppingConstants.CUSTOMER_NOT_FOUND);

		}
		return optcustomer.get();
	}	

}
