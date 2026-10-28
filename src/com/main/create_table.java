package com.main;

import org.hibernate.Session;
import org.hibernate.cfg.Configuration;

import com.module.customer;
import com.module.customer_details;

import org.hibernate.*;

public class create_table {
	public static void main(String [] args) {
	SessionFactory sf=null;
	Session opensession=null;
	Transaction trans=null;
	
	
	try {
		sf=new Configuration().configure().addAnnotatedClass(customer.class).addAnnotatedClass(customer_details.class).buildSessionFactory();
		
		opensession=sf.openSession();
		trans=opensession.beginTransaction();
		
		customer c=new customer(401,"manoj");
		customer_details cd=new customer_details(1,"manoj@gmai","pollahi",12212111);
		
		c.setCust_details(cd);
	    
		opensession.save(c);
		trans.commit();
		
	}
	catch(Exception e) {
		e.printStackTrace();
	}
}
}

