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
import com.iappsam.entities.Signatory;
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

			// Account a = new Account("hellow", "sxdcfvgbhn",
			// AccountType.NON_SPSO_PERSONNEL_HEAD, person.getPersonID());
			// aManager.addAccount(a);
			// List<Account> accounts = aManager.getAllAccounts();
			//
			// for (Account ac : accounts) {
			// System.out.println(ac.getUsername());
			// }
			//
			// Account a2 = aManager.getAccount("hellow");
			// a2.setPassword("password");
			// aManager.updateAccount(a);

			// Contact

			// Contact c = new Contact("1232-2323", ContactType.LANDLINE);
			// cManager.addContact(c);
			// Contact c2 = new Contact("asasasasas", ContactType.LANDLINE);
			// cManager.addContact(c2);
			//
			// cManager.addContactToPerson(c.getContactID(),1);
			//
			// List<Contact> contacts = cManager.getAllContactsByPerson(1);
			// for (Contact c1 : contacts) {
			// System.out.println(c1.getData());
			// }

			// Supplier

			// Person contactPerson = new Person("De la Cruz");
			// pManager.addPerson(contactPerson);
			//
			// Employee employee = new Employee("CEO",
			// contactPerson.getPersonID());
			// pManager.addEmployee(employee);
			//
			// Supplier supplier = new Supplier("ABC Supplier", "Tacloban City",
			// employee.getEmployeeID());
			// sManager.addSupplier(supplier);
			//
			// List<Supplier> suppliers = sManager.getAllSuppliers();
			// for (Supplier s : suppliers) {
			// System.out.println(s.getSupplierName());
			// }

			// Building

			// Building building = new Building("Building 1223",
			// "UPTAC Compund");
			// doMananger.addBuilding(building);
			//
			// List<Building> buildings = doMananger.getAllBuildings();
			// for (Building b : buildings) {
			// System.out.println(b.getBuildingName());
			// }

			// // DivisionOffice
			//
			// DivisionOffice divisionOffice = new DivisionOffice("DNSM", null,
			// building.getBuildingID());
			// doMananger.addDivisionOffice(divisionOffice);
			//
			// List<DivisionOffice> divisionOffices =
			// doMananger.getAllDivisionOffice();
			// for (DivisionOffice dO : divisionOffices) {
			// System.out.println(dO.getDivisionName());
			// }
			//
			// // Unit
			// Unit unit = new Unit("SET");
			// iManager.addUnit(unit);
			//
			// // ItemStatus
			// ItemStatus itemStatus = new ItemStatus("ON SHELF");
			// iManager.addItemStatus(itemStatus);
			//
			// // ItemCondition
			// ItemCondition itemCondition = new
			// ItemCondition("FAIR CONDITION");
			// iManager.addItemCondition(itemCondition);
			//
			// // Item
			// Item item = new Item("Chair", "SET", "Wood", 100, new Date(2011,
			// 5, 17), "ON SHELF", "FAIR CONDITION");
			// iManager.addItem(item);

			// PR

			Person p = new Person("MARGARITA DE LA CRUZ");
			pManager.addPerson(p);

			Person p2 = new Person("TELESFORO SALES");
			pManager.addPerson(p2);

			Employee emp1 = new Employee("Dean", p.getPersonID());
			pManager.addEmployee(emp1);

			Employee emp2 = new Employee("SAO Head", p2.getPersonID());
			pManager.addEmployee(emp2);

			Signatory s1 = new Signatory("Noted by", emp1.getEmployeeID());
			pManager.addSignatory(s1);

			Signatory s2 = new Signatory("Noted by", emp2.getEmployeeID());
			pManager.addSignatory(s2);

			Building building = new Building("AS Building", "UPVTC Compund");
			doMananger.addBuilding(building);

			DivisionOffice divisionOffice = new DivisionOffice("DH", null, building.getBuildingID());
			doMananger.addDivisionOffice(divisionOffice);

			PurchaseRequest pr = new PurchaseRequest(divisionOffice.getDivisionOfficeID(), "Office Use", s1.getSignatoryID(), s2.getSignatoryID());
			prManager.addPR(pr);

			// PRLine
			PurchaseRequestLine prLine = new PurchaseRequestLine(1121, "PCS", "Item Description", "12323", 100, pr.getPrID());
			prManager.addPRLine(prLine);

		} catch (TransactionException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
