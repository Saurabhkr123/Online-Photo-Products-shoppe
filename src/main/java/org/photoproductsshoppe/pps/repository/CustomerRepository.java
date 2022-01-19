package org.photoproductsshoppe.pps.repository;

import org.photoproductsshoppe.pps.entity.Customer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;



public interface CustomerRepository extends JpaRepository<Customer,Integer>{
	@Query("FROM Customer c inner Join c.user u WHERE u.userId = :userid")
    public Customer getCustomerByUserId(@Param("userid") Integer userid);

}