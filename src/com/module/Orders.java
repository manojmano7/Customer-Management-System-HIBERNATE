package com.module;

import java.util.List;

import javax.persistence.*;

@Entity
@Table(name="orders")
public class Orders {
	
	@Id
	@Column
	private int order_id;
	@Column
	private String item;
	@Column
	private int price ;
	public Orders(int order_id, String item, int price) {
		super();
		this.order_id = order_id;
		this.item = item;
		this.price = price;
	}
	public Orders() {
		super();
	}
	public int getOrder_id() {
		return order_id;
	}
	public void setOrder_id(int order_id) {
		this.order_id = order_id;
	}
	public String getItem() {
		return item;
	}
	public void setItem(String item) {
		this.item = item;
	}
	public int getPrice() {
		return price;
	}
	public void setPrice(int price) {
		this.price = price;
	}
	
	
	
	
	@Override
	public String toString() {
		return "Orders [order_id=" + order_id + ", item=" + item + ", price=" + price + "]";
	}




	@JoinColumn(name="customer_id")
	@ManyToOne(cascade=CascadeType.ALL)
	private customer customer;
	public customer getCustomer() {
		return customer;
	}
	public void setCustomer(customer customer) {
		this.customer = customer;
	}
	
	@JoinTable(name="order_offer",
			joinColumns=@JoinColumn(name="order_id"),
			inverseJoinColumns=@JoinColumn(name="offer_id"))
	
	@ManyToMany(cascade= {CascadeType.DETACH,CascadeType.MERGE,CascadeType.PERSIST,CascadeType.REFRESH})
	private List<Offer> offer;
	public List<Offer> getOffer() {
		return offer;
	}
	public void setOffer(List<Offer> offer) {
		this.offer = offer;
	}
	
	
	
	
	
	
	
	

}
