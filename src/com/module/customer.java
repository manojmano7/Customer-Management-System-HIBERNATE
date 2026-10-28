package com.module;

import java.util.List;

import javax.persistence.*;

@Entity
@Table
public class customer {
	
	@Column
	@Id
	private int id;
	@Column
	private String name;
	
	@JoinColumn(name="customer_details")
	@OneToOne(cascade=CascadeType.ALL)
	private customer_details cust_details;
	
	public customer(int id, String name) {
		super();
		this.id = id;
		this.name = name;
	}
	

	public customer() {
		super();
	}


	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public customer_details getCust_details() {
		return cust_details;
	}

	public void setCust_details(customer_details cust_details) {
		this.cust_details = cust_details;
	}


	@Override
	public String toString() {
		return "customer [id=" + id + ", name=" + name + "]";
	}

	
	
	@OneToMany(mappedBy="customer")
	private List<Orders> orders;

	public List<Orders> getOrders() {
		return orders;
	}


	public void setOrders(List<Orders> orders) {
		this.orders = orders;
	}
	
	
	
	
	
	
	
	

	
	

}
