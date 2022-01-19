package org.photoproductsshoppe.pps.controller;

import java.util.List;

import javax.persistence.criteria.Order;

import org.photoproductsshoppe.pps.dto.SuccessMessageDto;
import org.photoproductsshoppe.pps.exception.CustomerNotFoundException;
import org.photoproductsshoppe.pps.exception.OrderIdException;
import org.photoproductsshoppe.pps.exception.ValidateOrderException;
import org.photoproductsshoppe.pps.service.OrderServiceImp;
import org.photoproductsshoppe.pps.util.ShoppingConstants;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.jaxb.SpringDataJaxb.OrderDto;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;



@RestController
@RequestMapping("/order")
public class OrderController
{
	@Autowired
	OrderServiceImp orderService;
	
	@PostMapping("/addorder")
	public SuccessMessageDto addOrder(@RequestBody OrderDto orderDto) throws ValidateOrderException, CustomerNotFoundException
	{
		Order order= orderService.addOrder(orderDto);
		return new SuccessMessageDto(ShoppingConstants.ORDER_ADDED);
	}
}
	
	
	
	
		
	
	
	
	
	

