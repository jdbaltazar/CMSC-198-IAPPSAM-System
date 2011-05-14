package com.trial;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;

public class Tester {
	
	public static void main(String[] args) {
		Person person = new Person("ATTY.", "Doe");
		
		Session session = HibernateUtil.startSession();
		Transaction tx = session.beginTransaction();
	
		try {
			session.persist(person);
			tx.commit();
			
		} catch (HibernateException ex) {
			tx.rollback();
		}
		
//		PersonManager pManager = new PersonManagerSession();
//		pManager.addPerson(person);
	}

}
