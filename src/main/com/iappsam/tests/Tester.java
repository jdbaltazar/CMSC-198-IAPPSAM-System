package com.iappsam.tests;

import java.sql.Date;
import java.util.Iterator;
import java.util.List;

import com.iappsam.entities.Account;
import com.iappsam.entities.AccountType;
import com.iappsam.entities.Building;
import com.iappsam.entities.Contact;
import com.iappsam.entities.ContactType;
import com.iappsam.entities.DivisionOffice;
import com.iappsam.entities.Employee;
import com.iappsam.entities.Item;
import com.iappsam.entities.ItemCondition;
import com.iappsam.entities.ItemStatus;
import com.iappsam.entities.Person;
import com.iappsam.entities.Supplier;
import com.iappsam.entities.Unit;
import com.iappsam.entities.forms.PurchaseRequest;
import com.iappsam.entities.forms.PurchaseRequestLine;
import com.iappsam.managers.AccountManager;
import com.iappsam.managers.ContactManager;
import com.iappsam.managers.DivisionOfficeManager;
import com.iappsam.managers.ItemManager;
import com.iappsam.managers.PRManager;
import com.iappsam.managers.PersonManager;
import com.iappsam.managers.SupplierManager;
import com.iappsam.managers.exceptions.TransactionException;
import com.iappsam.managers.sessions.AccountManagerSession;
import com.iappsam.managers.sessions.ContactManagerSession;
import com.iappsam.managers.sessions.DivisionOfficeManagerSession;
import com.iappsam.managers.sessions.ItemManagerSession;
import com.iappsam.managers.sessions.PRManagerSession;
import com.iappsam.managers.sessions.PersonManagerSession;
import com.iappsam.managers.sessions.SupplierManagerSession;

public class Tester {

	public static void main(String[] args) {
		try {

			PersonManager pManager = new PersonManagerSession();
			AccountManager aManager = new AccountManagerSession();
			ContactManager cManager = new ContactManagerSession();
			SupplierManager sManager = new SupplierManagerSession();
			DivisionOfficeManager doMananger = new DivisionOfficeManagerSession();
			ItemManager iManager = new ItemManagerSession();

			// Forms
			PRManager prManager = new PRManagerSession();

			 Person person = new Person("dcfvgbhn", "d fgbncdvfgbhnjm");
			 pManager.addPerson(person);
			 // person.setName("Warren");
			 // pManager.updatePerson(person);
			//
			// Person p = pManager.getPerson(1);
			//
			// if (pManager.containsPerson("Warren"))
			// System.out.println("Warren found!");
			// else
			// System.out.println("Warren NOT found!");
			// System.out.println("Name:" + person.getName());
			//
			// //save
			// Person p2 = new Person("AKO");
			// int id = pManager.savePerson(p2);
			// System.out.println("id: "+id);

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

			// Account

			// Account a = new Account("dfdfdfdfd", "sxdcfvgbhn",
			// AccountType.NON_SPSO_PERSONNEL_HEAD, person.getPersonID());
			// List<Account> accounts = aManager.getAllAccounts();
			//
			// for (Account ac: accounts) {
			// System.out.println(ac.getUsername());
			// }

			// Account a = aManager.getAccount("hellow");
			// a.setPassword("password");
			// aManager.updateAccount(a);

			// Contact

			// Contact c = new Contact("1222222222", ContactType.EMAIL, 0, 0,
			// 1);
			// System.out.println(c.getContactType());
			// System.out.println(c.getData());
			// System.out.println(c.getPersonID());
			// ContactManager cManager = new ContactManagerSession();
			// cManager.addContact(c);
			//
			// List<Contact>contacts = cManager.getAllContacts();
			// for(Contact c1: contacts){
			// System.out.println(c1.getData());
			// }

			// Supplier
			// problematic ><

			// Person contactPerson = new Person("De la Cruz");
			// pManager.addPerson(contactPerson);
			//
			// System.out.println("person id: "+contactPerson.getPersonID());
			// Employee employee = new Employee("sdsdsdssdsd", 1);
			// pManager.addEmployee(employee);
			// Supplier supplier = new Supplier("ABC Supplier", "Tacloban City",
			// employee.getPersonID());
			// sManager.addSupplier(supplier);

			// List<Supplier>suppliers = sManager.getAllSuppliers();
			// for(Supplier s: suppliers){
			// System.out.println(s.getSupplierName());
			// }

//			// Building
//
//			Building building = new Building("xdcfvgbhnjmk", "UPTAC Compund");
//			doMananger.addBuilding(building);

			// List<Building> buildings = doMananger.getAllBuildings();
			// for (Building b : buildings) {
			// System.out.println(b.getBuildingName());
			// }
			//
//			// DivisionOffice
//
//			DivisionOffice divisionOffice = new DivisionOffice("DM", null, building.getBuildingID());
//			doMananger.addDivisionOffice(divisionOffice);
			//
			// List<DivisionOffice> divisionOffices =
			// doMananger.getAllDivisionOffice();
			// for (DivisionOffice dO : divisionOffices) {
			// System.out.println(dO.getDivisionName());
			// }

			// //Unit
			// Unit unit = new Unit("PCS");
			// iManager.addUnit(unit);
			//
			// //ItemStatus
			// ItemStatus itemStatus = new ItemStatus("ON STOCK");
			// iManager.addItemStatus(itemStatus);

			// //ItemCondition
			// ItemCondition itemCondition = new
			// ItemCondition("GOOD CONDITION");
			// iManager.addItemCondition(itemCondition);
			// iManager.addItemCondition(itemCondition);

//			// Item
//			Item item = new Item("Table", "PCS", "Plastic", 100, new Date(2011, 5, 17), "ON STOCK", "GOOD CONDITION");
//			iManager.addItem(item);

//			// PR
//			PurchaseRequest pr = new PurchaseRequest(divisionOffice.getDivisionOfficeID(), "Office Purposes", 3, 3);
//			prManager.addPR(pr);
//
//			// PRLine
//			PurchaseRequestLine prLine = new PurchaseRequestLine(112, "PCS", "Description of Item", pr.getPrID());
//			prManager.addPRLine(prLine);

		} catch (TransactionException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
