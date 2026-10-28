package com.module;

import javax.persistence.*;

@Entity
@Table
public class customer_details {
	@Column
	@Id
	private int cd_id;
	@Column
	private String email;
	@Column
	private String address;
	
	@Column
	private int phone;
	
	
	@OneToOne(mappedBy="cust_details",cascade=CascadeType.ALL)
	private customer cust;
	
	
	public customer_details() {
		super();
	}
	public customer_details(int cd_id, String email, String address, int phone) {
		super();
		this.cd_id = cd_id;
		this.email = email;
		this.address = address;
		this.phone = phone;
	}
	public int getCd_id() {
		return cd_id;
	}
	public void setCd_id(int cd_id) {
		this.cd_id = cd_id;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public int getPhone() {
		return phone;
	}
	public void setPhone(int phone) {
		this.phone = phone;
	}
	public customer getCust() {
		return cust;
	}
	public void setCust(customer cust) {
		this.cust = cust;
	}
	@Override
	public String toString() {
		return "customer_details [cd_id=" + cd_id + ", email=" + email + ", address=" + address + ", phone=" + phone
				+ "]";
	}
	
	
	
	
	
	

}
