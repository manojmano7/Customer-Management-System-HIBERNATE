package com.main;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import com.module.*;

public class update {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		SessionFactory sf=null;
		Session opensession=null;
		Transaction trans=null;
		
		try {
			sf=new Configuration().configure().addAnnotatedClass(customer.class)
					.addAnnotatedClass(customer_details.class).buildSessionFactory();
			
			opensession=sf.openSession();
			trans=opensession.beginTransaction();
			
			customer cust=opensession.get(customer.class,401);
			
			cust.getCust_details().setAddress("bengalore");
			
			trans.commit();
			
			
					
		}
		catch(Exception e) {
			e.printStackTrace();
		}
	}

}
