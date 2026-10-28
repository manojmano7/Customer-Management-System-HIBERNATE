package com.main;

import java.util.*;

import org.hibernate.*;
import org.hibernate.cfg.Configuration;

import com.module.Orders;
import com.module.Reviews;
import com.module.customer;
import com.module.customer_details;

public class OrdersMain {

	
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
			
			Orders o1=new Orders(601,"burger",100);
			Orders o2=new Orders(602,"pizza",100);
			Orders o3=new Orders(603,"biriyani",100);
			
			
			
			customer c=opensession.get(customer.class, 401);
		
			
			
			o1.setCustomer(c);
			o2.setCustomer(c);
			o3.setCustomer(c);
			
			
			opensession.save(o3);
			opensession.save(o2);
			opensession.save(o1);
			trans.commit();
			
		}
		catch(Exception e) {
			e.printStackTrace();
		}
	}
	//<---------------------GETTING CUSTOMER DETAILS----------------->
	public static void customerdet() {
		SessionFactory sf=null;
		Session opensession=null;
		Transaction trans=null;
		
		try {
			sf=new Configuration().configure()
					.addAnnotatedClass(customer.class)
					.addAnnotatedClass(customer_details.class)
					.addAnnotatedClass(Orders.class)
					.buildSessionFactory();
			
			opensession=sf.openSession();
			trans=opensession.beginTransaction();
			
			Orders o=opensession.get(Orders.class, 601);
			
			System.out.println(o.getCustomer());
			
		}
			
			catch(Exception e) {
				e.printStackTrace();
			}
		
	}
	
	//<-------all the order belong to one customer-------------------->
	
	public static void allOrder() {
		
		SessionFactory sf=null;
		Session opensession=null;
		Transaction trans=null;
		
		try {
			sf=new Configuration().configure()
					.addAnnotatedClass(customer.class)
					.addAnnotatedClass(customer_details.class)
					.addAnnotatedClass(Orders.class)
					.buildSessionFactory();
			
			opensession=sf.openSession();
			trans=opensession.beginTransaction();
			
			customer c=opensession.get(customer.class,401);
			
			List<Orders> l=c.getOrders();
			
			for (Orders o:l) {
				System.out.println(o+"customer_id"+" "+o.getCustomer().getId());
				
			}
			
		}
			
			catch(Exception e) {
				e.printStackTrace();
			}
	}
	
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		System.out.println("enter 1 to add orders");
		System.out.println("enter 2 to see customer details using order id");
		System.out.println("enter 3 to see all the order belong to one customer");
		
		
		System.out.println("enter your choice");
		Scanner sc=new Scanner(System.in);
		
		int choice=sc.nextInt();
		
		switch(choice) {
		case 1:{
			add();
			break;
		}
		case 2:{
			customerdet();
			break;
		}
		
		case 3:{
			allOrder();
			break;
		}
		}
	}

}
