package com.iappsam.tests;

import java.util.Iterator;
import java.util.List;

import com.iappsam.entities.Account;
import com.iappsam.entities.AccountType;
import com.iappsam.entities.Contact;
import com.iappsam.entities.ContactType;
import com.iappsam.entities.Employee;
import com.iappsam.entities.Person;
import com.iappsam.entities.Supplier;
import com.iappsam.managers.AccountManager;
import com.iappsam.managers.ContactManager;
import com.iappsam.managers.PersonManager;
import com.iappsam.managers.SupplierManager;
import com.iappsam.managers.exceptions.TransactionException;
import com.iappsam.managers.sessions.AccountManagerSession;
import com.iappsam.managers.sessions.ContactManagerSession;
import com.iappsam.managers.sessions.PersonManagerSession;
import com.iappsam.managers.sessions.SupplierManagerSession;

public class Tester {

	public static void main(String[] args) {
		try {
			PersonManager pManager = new PersonManagerSession();
			AccountManager aManager = new AccountManagerSession();
			ContactManager cManager = new ContactManagerSession();
			SupplierManager sManager = new SupplierManagerSession();
			
//			Person person = new Person("Atty.", "sdsdsdsdsd");
			// pManager.addPerson(person);
			// // // person.setName("Warren");
			// // // pManager.updatePerson(person);
			// //
			// // Person p = pManager.getPerson(1);
			// //
			// // if (pManager.containsPerson("Warren"))
			// // System.out.println("Warren found!");
			// // else
			// // System.out.println("Warren NOT found!");
			// // System.out.println("Name:" + person.getName());
			// //
			// // //save
			// // Person p2 = new Person("AKO");
			// // int id = pManager.savePerson(p2);
			// // System.out.println("id: "+id);

			// view all
			// List<Person> persons = pManager.getAllPersons();
			//
			// for (Iterator<Person> iter = persons.iterator(); iter.hasNext();)
			// {
			// Person p = (Person) (iter.next());
			// System.out.println(p.getName());
			// }
			//
			//

//			//Account
//
//			Account a = new Account("jdc vgbhnjm", "cfvgbhnjmk", AccountType.NON_SPSO_PERSONNEL_HEAD, 10);
//			AccountManager aM = new AccountManagerSession();
//
//			List<Account> accounts = aM.getAllAccounts();
//			for (Account ac: accounts) {
//				System.out.println(ac.getUsername());
//			}

			
			//Contact
			
//			Contact c = new Contact("1222222222", ContactType.EMAIL, 0, 0, 1);
//			System.out.println(c.getContactType());
//			System.out.println(c.getData());
//			System.out.println(c.getPersonID());
//			ContactManager cManager = new ContactManagerSession();
//			cManager.addContact(c);
//			
//			List<Contact>contacts = cManager.getAllContacts();
//			for(Contact c1: contacts){
//				System.out.println(c1.getData());
//			}
			
			//Supplier
			
			
			Person contactPerson = new Person("De la Cruz");
			pManager.addPerson(contactPerson);
			
			System.out.println("person id: "+contactPerson.getPersonID());
			Employee employee = new Employee("sdsdsdssdsd", contactPerson.getPersonID());
			pManager.addEmployee(employee);
//			Supplier supplier = new Supplier("ABC Supplier", "Tacloban City", employee.getPersonID());
//			sManager.addSupplier(supplier);
			
//			List<Supplier>suppliers = sManager.getAllSuppliers();
//			for(Supplier s: suppliers){
//				System.out.println(s.getSupplierName());
//			}
//			
			
		} catch (TransactionException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
