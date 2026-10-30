package com.module;

import java.util.List;

import javax.persistence.*;

@Entity
@Table(name="offer")
public class Offer {
	
	@Id
	@Column
	private int offer_id;
	@Column
	private String offer_name;
	@Column
	private int discount_percentage;
	public Offer(int offer_id, String offer_name, int discount_percentage) {
		super();
		this.offer_id = offer_id;
		this.offer_name = offer_name;
		this.discount_percentage = discount_percentage;
	}
	public Offer() {
		super();
	}
	public int getOffer_id() {
		return offer_id;
	}
	public void setOffer_id(int offer_id) {
		this.offer_id = offer_id;
	}
	public String getOffer_name() {
		return offer_name;
	}
	public void setOffer_name(String offer_name) {
		this.offer_name = offer_name;
	}
	public int getDiscount_percentage() {
		return discount_percentage;
	}
	public void setDiscount_percentage(int discount_percentage) {
		this.discount_percentage = discount_percentage;
	}
	@Override
	public String toString() {
		return "Offer [offer_id=" + offer_id + "| offer_name=" + offer_name + "| discount_percentage="
				+ discount_percentage + "]";
	}
	
	@JoinTable(name="order_offer",
			joinColumns=@JoinColumn(name="offer_id"),
			inverseJoinColumns=@JoinColumn(name="order_id")
	)
	
	
	@ManyToMany(cascade= {CascadeType.DETACH,CascadeType.MERGE,CascadeType.PERSIST,CascadeType.REFRESH})
	private List<Orders> orders;
	public List<Orders> getOrders() {
		return orders;
	}
	public void setOrders(List<Orders> orders) {
		this.orders = orders;
	} 
	
	

}
