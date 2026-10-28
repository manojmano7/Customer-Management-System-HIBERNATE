package com.main;

import java.util.List;
import java.util.Scanner;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import com.module.Orders;
import com.module.Reviews;
import com.module.customer;
import com.module.customer_details;

public class ReviewsMain {
	
	
	public static void add() {
		SessionFactory sf=null;
		Session opensession=null;
		Transaction trans=null;
		
		try {
			sf=new Configuration().configure()
					.addAnnotatedClass(customer.class)
					.addAnnotatedClass(customer_details.class)
					.addAnnotatedClass(Orders.class)
					.addAnnotatedClass(Reviews.class)
					.buildSessionFactory();
			
			opensession=sf.openSession();
			trans=opensession.beginTransaction();
			
			Reviews r=new Reviews(701,"good");
			Reviews r2=new Reviews(702,"bad");
			Reviews r3=new Reviews(703,"average");
			
			
			
			
			Orders o1=opensession.get(Orders.class, 601);

			Orders o2=opensession.get(Orders.class, 602);
			r.setOrder(o1);
			
			r2.setOrder(o1);
			
			r3.setOrder(o2);
			
			opensession.save(r);
			opensession.save(r2);
			opensession.save(r3);
			
			trans.commit();
			
			
			
			
			
		}
		catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	//<---------order details using review id-------------->
	
	public static void orderdet() {
	
			SessionFactory sf=null;
			Session opensession=null;
			Transaction trans=null;
			
			try {
				sf=new Configuration().configure()
						.addAnnotatedClass(customer.class)
						.addAnnotatedClass(customer_details.class)
						.addAnnotatedClass(Orders.class)
						.addAnnotatedClass(Reviews.class)
						.buildSessionFactory();
				
				opensession=sf.openSession();
				trans=opensession.beginTransaction();
				
				Reviews r=opensession.get(Reviews.class, 701);
				System.out.println(r.getOrder());
				System.out.println(r.getOrder().getCustomer());
			}
			catch(Exception e) {
				e.printStackTrace();
				}
			}
	
	
	public static void allReviews() {
		
		SessionFactory sf=null;
		Session opensession=null;
		Transaction trans=null;
		
		try {
			sf=new Configuration().configure()
					.addAnnotatedClass(customer.class)
					.addAnnotatedClass(customer_details.class)
					.addAnnotatedClass(Orders.class)
					.addAnnotatedClass(Reviews.class)
					.buildSessionFactory();
			
			opensession=sf.openSession();
			trans=opensession.beginTransaction();
			
			Orders o=opensession.get(Orders.class, 601);
			
			List<Reviews> l=o.getReviews();
			
			for (Reviews r:l) {
				System.out.println(r +" | "+r.getOrder().getOrder_id());
				
			}
		}
		catch(Exception e) {
			e.printStackTrace();
			}
		}

	

	
	public static void main(String [] args) {
		System.out.println("enter 1 to add reviews");
		System.out.println("enter 2 to see order details using review id");
		System.out.println("enter 3 to see all the reviews belong to one order");
		
		
		System.out.println("enter your choice");
		Scanner sc=new Scanner(System.in);
		
		int choice=sc.nextInt();
		
		switch(choice) {
		case 1:{
			add();
			break;
		}
		case 2:{
			orderdet();
			break;
		}
		
		case 3:{
			allReviews();
			break;
		}
		}
	}

}
