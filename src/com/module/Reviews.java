package com.module;

import javax.persistence.*;

@Entity
@Table(name="reviews")
public class Reviews {
	
	@Column
	@Id
	private int review_id;
	
	@Column
	private String comment;

	public Reviews(int review_id, String comment) {
		super();
		this.review_id = review_id;
		this.comment = comment;
	}

	public Reviews() {
		super();
	}

	public int getReview_id() {
		return review_id;
	}

	public void setReview_id(int review_id) {
		this.review_id = review_id;
	}

	public String getComment() {
		return comment;
	}

	public void setComment(String comment) {
		this.comment = comment;
	}
	
	
	
	@Override
	public String toString() {
		return "Reviews [review_id=" + review_id + ", comment=" + comment + "]";
	}



	@JoinColumn(name="order_id")
	@ManyToOne
	private Orders order;

	public Orders getOrder() {
		return order;
	}

	public void setOrder(Orders order) {
		this.order = order;
	}
	
	
	
	 

}
