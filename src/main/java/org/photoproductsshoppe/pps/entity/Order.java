package org.photoproductsshoppe.pps.entity;



import java.time.LocalDate;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;



import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
public class Order {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Integer ordId;
	private String ordStatus;
	private LocalDate ordDate;
	
	@OneToOne
	@JsonIgnore
	private Customer customer;
	
	
	

	


	public Integer getOrdId() {
		return ordId;
	}

	public void setOrdId(Integer ordId) {
		this.ordId = ordId;
	}

	public String getOrdStatus() {
		return ordStatus;
	}

	public void setOrdStatus(String ordStatus) {
		this.ordStatus = ordStatus;
	}

	public LocalDate getOrdDate() {
		return ordDate;
	}

	public void setOrdDate(LocalDate ordDate) {
		this.ordDate = ordDate;
	}

	public Customer getCustomer() {
		return customer;
	}

	public void setCustomer(Customer customer) {
		this.customer = customer;
	}


	





}