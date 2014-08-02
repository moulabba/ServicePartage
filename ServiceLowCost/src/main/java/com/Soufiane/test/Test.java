package com.Soufiane.test;

import org.hibernate.Session;

import utiles.HibernateUtil;


public class Test {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		  System.out.println("Maven + Hibernate + MySQL");
	        Session session = HibernateUtil.getSessionFactory().openSession();
	        
	        session.beginTransaction();
	        
	        //session.save(stock);
	       
	        
	        
	        //session.delete(stock);
	        
	        session.getTransaction().commit();
	        
	}

}
