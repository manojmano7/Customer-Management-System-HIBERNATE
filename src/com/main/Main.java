package com.main;

import java.util.*;

import org.hibernate.*;
import org.hibernate.cfg.Configuration;

import com.module.Offer;
import com.module.Orders;

import com.module.customer;
import com.module.customer_details;

public class Main {

	
	public static void add() {
		
		SessionFactory sf=null;
		Session opensession=null;
		Transaction trans=null;
		
		try {
			sf=new Configuration().configure()
					.addAnnotatedClass(customer.class)
					.addAnnotatedClass(customer_details.class)
					.addAnnotatedClass(Orders.class)
					.addAnnotatedClass(Offer.class)
					
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
					.addAnnotatedClass(Offer.class)
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
					.addAnnotatedClass(Offer.class)
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
	
	
//<-----------------	add customer and customer details------------------------->
	
	public static void addCustomer(Scanner sc) {
		
		SessionFactory sf=null;
		Session opensession=null;
		Transaction trans=null;
		
		try {
			sf=new Configuration().configure()
					.addAnnotatedClass(customer.class)
					.addAnnotatedClass(customer_details.class)
					.addAnnotatedClass(Orders.class)
					.addAnnotatedClass(Offer.class)
					.buildSessionFactory();
			
			opensession=sf.openSession();
			trans=opensession.beginTransaction();
			
			
			System.out.println("enter customer id");
			int id=sc.nextInt();
			System.out.println("enter customer name");
			String name=sc.next();
			
		
			customer customer=new customer(id,name);
			
			System.out.println("enter customer details id");
			int cdid=sc.nextInt();
			
			System.out.println("enter customer address");
			String address=sc.next();
			
			System.out.println("enter customer email");
			String email=sc.next();
			
			System.out.println("enter customer phone number");
			int num=sc.nextInt();
			
			
			customer_details cd=new customer_details(cdid,email,address,num);
			
			customer.setCust_details(cd);
			
			opensession.save(cd);
			opensession.save(customer);
			trans.commit();
			
			System.out.println("customer details added successfully");
			
			
		
		}
		catch(Exception e) {
			e.printStackTrace();
		}
		
	}
	
	
	//<------------------------FETCH CUSTOMER-------------------------->
	
	public static void fetchCustomer(Scanner sc) {
		SessionFactory sf=null;
		Session opensession=null;
		Transaction trans=null;
		
		try {
			sf=new Configuration().configure()
					.addAnnotatedClass(customer.class)
					.addAnnotatedClass(customer_details.class)
					.addAnnotatedClass(Orders.class)
					.addAnnotatedClass(Offer.class)
					.buildSessionFactory();
			
			opensession=sf.openSession();
			trans=opensession.beginTransaction();
			
			System.out.println("enter customer id to fetch");
			
			int cid=sc.nextInt();
			
			
			customer cust=opensession.get(customer.class,cid);
			
			System.out.println(cust);
			
			
		}
		catch(Exception e) {
			e.printStackTrace();
		}
	} 
	
//<-----------------------FETCH CUSTOMER AND CUSTOMER DETAILS--------------------------->
	
	public static void fetchCustomer2(Scanner sc) {
		SessionFactory sf=null;
		Session opensession=null;
		Transaction trans=null;
		
		try {
			sf=new Configuration().configure()
					.addAnnotatedClass(customer.class)
					.addAnnotatedClass(customer_details.class)
					.addAnnotatedClass(Orders.class)
					.addAnnotatedClass(Offer.class)
					.buildSessionFactory();
			
			opensession=sf.openSession();
			trans=opensession.beginTransaction();
			
			System.out.println("enter customer id to fetch");
			
			int cid=sc.nextInt();
			
			
			customer cust=opensession.get(customer.class,cid);
			
			System.out.println(cust);
			
			System.out.println(cust.getCust_details());
			
			
		}
		catch(Exception e) {
			e.printStackTrace();
		}
	} 
	
//<----------------------------UPDATE CUSTOMER--------------------------------->
	
	public static void updateCustomer(Scanner sc) {
		SessionFactory sf = null;
		Session opensession = null;
		Transaction trans = null;

		try {
			
			sf=new Configuration().configure()
					.addAnnotatedClass(customer.class)
					.addAnnotatedClass(customer_details.class)
					.addAnnotatedClass(Orders.class)
					.addAnnotatedClass(Offer.class)
					.buildSessionFactory();
			
			

			opensession = sf.openSession();
			trans = opensession.beginTransaction();
			
			System.out.println("enter customer details id");
			int cdid=sc.nextInt();
			
			System.out.println("enter new customer address");
			String address=sc.next();
			
			System.out.println("enter new customer email");
			String email=sc.next();
			
			System.out.println("enter new customer phone number");
			int num=sc.nextInt();
			
			customer_details cust=new customer_details(cdid,email,address,num);
			opensession.saveOrUpdate(cust);
			System.out.println("updated successfully");
			trans.commit();

		} catch (Exception e) {
			e.printStackTrace();
		}
		
	}
	
//<-------------------------------DELETE CUSTOMER------------------------------------->
	public static void deleteCustomer(Scanner sc) {
		SessionFactory sf = null;
		Session opensession = null;
		Transaction trans = null;

		try {
			sf=new Configuration().configure()
					.addAnnotatedClass(customer.class)
					.addAnnotatedClass(customer_details.class)
					.addAnnotatedClass(Orders.class)
					.addAnnotatedClass(Offer.class)
					.buildSessionFactory();
			
			opensession = sf.openSession();
			trans = opensession.beginTransaction();
			
			System.out.println("enter customer id to delete");
			int id=sc.nextInt();
			
			customer c=opensession.get(customer.class, id);
			
			opensession.delete(c);
			trans.commit();
			System.out.println("customer deleted successfully");

		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
//<-------------------------ADD OFFER-------------------------------------->
	public static void addOffer(Scanner sc) {
		SessionFactory sf = null;
		Session opensession = null;
		Transaction trans = null;

		try {
			sf=new Configuration().configure()
					.addAnnotatedClass(customer.class)
					.addAnnotatedClass(customer_details.class)
					.addAnnotatedClass(Orders.class)
					.addAnnotatedClass(Offer.class)
					.buildSessionFactory();
			
			opensession = sf.openSession();
			trans = opensession.beginTransaction();
			
			System.out.println("enter offer id");
			int id=sc.nextInt();
			
			System.out.println("enter offer name");
			String name=sc.next();
			
			System.out.println("enter discount percentage");
			int dis=sc.nextInt();
			
			Offer of=new Offer(id,name,dis);
			
			opensession.save(of);
			trans.commit();
			
			

		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
//<-----------------------------FETCH ALL OFFERS-------------------->
	public static void fetchAllOffer() {
		SessionFactory sf = null;
		Session opensession = null;
		Transaction trans = null;

		try {
			sf=new Configuration().configure()
					.addAnnotatedClass(customer.class)
					.addAnnotatedClass(customer_details.class)
					.addAnnotatedClass(Orders.class)
					.addAnnotatedClass(Offer.class)
					.buildSessionFactory();

			opensession = sf.openSession();
			trans = opensession.beginTransaction();
			
			String hql="from Offer";
			Query q=opensession.createQuery(hql);
			List<Offer> l=q.list();
			
			for (Offer o:l) {
				System.out.println(o);
			}
			

		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	//<--------------------------------SET OFFEERS----------------------------->
	public static void setOffer() {
		SessionFactory sf = null;
		Session opensession = null;
		Transaction trans = null;

		try {
		sf=new Configuration().configure()
				.addAnnotatedClass(customer.class)
				.addAnnotatedClass(customer_details.class)
				.addAnnotatedClass(Orders.class)
				.addAnnotatedClass(Offer.class)
				.buildSessionFactory();
		

		opensession = sf.openSession();
		trans = opensession.beginTransaction();
		
		Orders o1=opensession.get(Orders.class, 601);
		Orders o2=opensession.get(Orders.class, 602);
		Orders o3=opensession.get(Orders.class, 603);
		Orders o4=opensession.get(Orders.class, 604);
		
		
		Offer off1=opensession.get(Offer.class, 701);
		Offer off2=opensession.get(Offer.class, 702);
		
		
		ArrayList<Orders> al1=new ArrayList<>();
		al1.add(o1);
		al1.add(o2);
		al1.add(o4);
		
		
		ArrayList<Orders> al2=new ArrayList<>();
		al2.add(o4);
		al2.add(o3);
		al2.add(o2);
		
		
		
		off1.setOrders(al2);
		off2.setOrders(al1);
		
		
		trans.commit();
		
		
		}
		catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		
		System.out.println("<----------------ORDERS----------------------------->");
		System.out.println("enter 1 to add orders");
		System.out.println("enter 2 to see customer details using order id");
		System.out.println("enter 3 to see all the order belong to one customer");
		
		System.out.println();
		
		System.out.println("<-----------------------CUSTOMERS---------------------->");
		System.out.println("enter 4 to add customer and customer details");
		System.out.println("enter 5 to fetch customer");
		System.out.println("enter 6 to fetch customer name with customer details");
		System.out.println("enter 7 to update customer");
		System.out.println("enter 8 to delete customer");
		
		System.out.println();
		
		System.out.println("<--------------------------OFFERS----------------------->");
		System.out.println("enter 9 to add offers");
		System.out.println("enter 10 to fetch all offers");
		System.out.println("enter 11 to set offers to orders");
		
		
		
		System.out.println("enter your choice");
		Scanner sc=new Scanner(System.in);
		
		
		
		
		while(true)
		{
			System.out.println("enter your choice");
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
		case 4:{
			addCustomer(sc);
			break;
		}
		case 5:{
			fetchCustomer(sc);
			break;
		}
		case 6:{
			fetchCustomer2(sc);
			break;
		}
		case 7 :{
			updateCustomer(sc);
			break;
		}
		case 8 :{
			deleteCustomer(sc);
			break;
		}
		case 9:{
			addOffer(sc);
			break;
		}
		case 10 :{
			fetchAllOffer();
			break;
		}
		case 11:{
			setOffer();
			break;
		}
		case 12:{
			System.out.println("exited");
			return;
		}
		default :{
			System.out.println("invalid choice");
		}
	}
		}

}
}
