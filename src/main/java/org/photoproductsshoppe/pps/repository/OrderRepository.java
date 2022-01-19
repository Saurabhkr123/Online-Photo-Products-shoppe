package org.photoproductsshoppe.pps.repository;

import javax.persistence.criteria.Order;

import org.springframework.data.jpa.repository.JpaRepository;




public interface OrderRepository extends JpaRepository<Order,Integer>{

	
}