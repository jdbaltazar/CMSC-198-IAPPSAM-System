package com.iappsam.tests;

import java.util.Iterator;
import java.util.List;

import com.iappsam.entities.Person;
import com.iappsam.managers.PersonManager;
import com.iappsam.managers.exceptions.TransactionException;
import com.iappsam.managers.sessions.PersonManagerSession;

public class Tester {

	public static void main(String[] args) {
		try {
			PersonManager pManager = new PersonManagerSession();
//			Person person = new Person("Atty.", "aaaaaaaaaaaaaaaaaaaaa");
//			pManager.addPerson(person);
//			// person.setName("Warren");
//			// pManager.updatePerson(person);
//
//			Person p = pManager.getPerson(1);
//
//			if (pManager.containsPerson("Warren"))
//				System.out.println("Warren found!");
//			else
//				System.out.println("Warren NOT found!");
//			System.out.println("Name:" + person.getName());
			
			//save
			Person p2 = new Person("AKO");
			int id = pManager.savePerson(p2);
			System.out.println("id: "+id);
			
			//view all
			List persons = pManager.getAllPersons();
			
			for (Iterator iter = persons.iterator(); iter.hasNext();) {
				Person p = (Person) (iter.next());
				System.out.println(p.getPersonID());
			}
			
			
			//Account
			
			
		} catch (TransactionException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
