package org.photoproductsshoppe.pps.service;

import java.util.List;

import javax.persistence.criteria.Order;

import org.photoproductsshoppe.pps.dto.OrderDto;
import org.photoproductsshoppe.pps.exception.CustomerNotFoundException;
import org.photoproductsshoppe.pps.exception.OrderIdException;
import org.photoproductsshoppe.pps.exception.ValidateOrderException;



public interface OrderService {
	public Order addOrder(OrderDto orderDto) throws ValidateOrderException, CustomerNotFoundException;
	public Order updateOrder(OrderDto orderDto)throws OrderIdException, ValidateOrderException, CustomerNotFoundException;
	public boolean removeOrder(Integer ordId)throws OrderIdException;
	public Order viewOrder(Integer ordId)throws OrderIdException;
	
    public List<Order> viewAllOrderByCustomerId(Integer customerId) throws CustomerNotFoundException;

}
