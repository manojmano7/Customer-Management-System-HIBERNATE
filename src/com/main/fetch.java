package com.main;

import java.util.Scanner;

import org.hibernate.*;
import org.hibernate.cfg.Configuration;

import com.module.customer;
import com.module.customer_details;

public class fetch {

	
	 public static void fetchfromcustomer() {
	
		// TODO Auto-generated method 
		SessionFactory sf=null;
		Session opensession=null;
		Transaction transaction=null;
		
		try {
			sf=new Configuration().configure().addAnnotatedClass(customer.class).addAnnotatedClass(customer_details.class).buildSessionFactory();
			opensession=sf.openSession();
			transaction=opensession.beginTransaction();
			
			customer custo=opensession.get(customer.class, 401);
			System.out.println(custo);
			customer_details custdet=custo.getCust_details();
			System.out.println(custdet);
		}
		catch(Exception e) {
			e.printStackTrace();
		}
		
		

	}
	 public static void fetchfromcust_details() {
		 SessionFactory sf=null;
			Session opensession=null;
			Transaction transaction=null;
			
			try {
				sf=new Configuration().configure().addAnnotatedClass(customer.class).addAnnotatedClass(customer_details.class).buildSessionFactory();
				opensession=sf.openSession();
				transaction=opensession.beginTransaction();
				
				customer_details cust_details= opensession.get(customer_details.class, 1);
				
				customer custom=cust_details.getCust();
				System.out.println(cust_details);
				System.out.println(custom);
			}
			catch(Exception e) {
				e.printStackTrace();
			}
	 }



public static void main(String [] args) {
	System.out.println("enter 1 to fetch form customer");
	System.out.println("enter 2 to fetch form customer details");
	
	Scanner sc=new Scanner(System.in);
	
	System.out.println("enter your choice");
	int choice=sc.nextInt();
	switch(choice) {
	case 1:{
		fetchfromcustomer();
		break;
	}
	case 2:{
		fetchfromcust_details();
		break;
	}
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}
}