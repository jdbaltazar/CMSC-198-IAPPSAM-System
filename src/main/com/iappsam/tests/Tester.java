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
import com.iappsam.managers.APPManager;
import com.iappsam.managers.AccountManager;
import com.iappsam.managers.ContactManager;
import com.iappsam.managers.DivisionOfficeManager;
import com.iappsam.managers.ItemManager;
import com.iappsam.managers.PRManager;
import com.iappsam.managers.PersonManager;
import com.iappsam.managers.SupplierManager;
import com.iappsam.managers.exceptions.DuplicateEntryException;
import com.iappsam.managers.exceptions.TransactionException;
import com.iappsam.managers.sessions.APPManagerSession;
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
			APPManager appManager = new APPManagerSession();
			PRManager prManager = new PRManagerSession();

			Person person = new Person("ASasasasas", "d fgbncdvfgbhnjm");
			pManager.addPerson(person);

			// person.setName("Warren");
			// pManager.updatePerson(person);
			//
			Person p = pManager.getPerson(1);

			if (pManager.containsPerson("Warren"))
				System.out.println("Warren found!");
			else
				System.out.println("Warren NOT found!");
			System.out.println("Name:" + person.getName());

			// save
			Person p2 = new Person("AKO");
			int id = pManager.savePerson(p2);
			System.out.println("id: " + id);

			// view all
			// List<Person> persons = pManager.getAllPersons();

			// for (Iterator<Person> iter = persons.iterator(); iter.hasNext();)
			// {
			// // Person p = (Person) (iter.next());
			// System.out.println(p.getName());
			// }
			//
			//

			// Account

			Account a = new Account("hellow", "sxdcfvgbhn", AccountType.NON_SPSO_PERSONNEL_HEAD, person.getId());
			aManager.addAccount(a);
			List<Account> accounts = aManager.getAllAccounts();

			for (Account ac : accounts) {
				System.out.println(ac.getUsername());
			}

			Account a2 = aManager.getAccount("hellow");
			a2.setPassword("password");
			aManager.updateAccount(a);

			// Contact

			Contact c = new Contact("1232-2323", ContactType.LANDLINE);
			cManager.addContact(c);
			Contact c2 = new Contact("asasasasas", ContactType.LANDLINE);
			cManager.addContact(c2);

			cManager.addContactToPerson(c.getContactID(), 1);

			List<Contact> contacts = cManager.getAllContactsByPerson(1);
			for (Contact c1 : contacts) {
				System.out.println(c1.getData());
			}

			// Supplier

			Person contactPerson = new Person("De la Cruz");
			pManager.addPerson(contactPerson);

			Employee employee = new Employee("CEO", 1);
			pManager.addEmployee(employee);

			Supplier supplier = new Supplier("ABC Supplier", "Tacloban City", employee.getId());
			sManager.addSupplier(supplier);

			List<Supplier> suppliers = sManager.getAllSuppliers();
			for (Supplier s : suppliers) {
				System.out.println(s.getSupplierName());
			}

			// Building

			Building building = new Building("Building 1223", "UPTAC Compund");
			doMananger.addBuilding(building);

			List<Building> buildings = doMananger.getAllBuildings();
			for (Building b : buildings) {
				System.out.println(b.getBuildingName());
			}

			// // DivisionOffice
			//
			DivisionOffice divisionOffice = new DivisionOffice("DNSM", null);
			doMananger.addDivisionOffice(divisionOffice);

			List<DivisionOffice> divisionOffices = doMananger.getAllDivisionOffice();
			for (DivisionOffice dO : divisionOffices) {
				System.out.println(dO.getDivisionName());
			}

			// // Unit
			Unit unit = new Unit("SET");
			iManager.addUnit(unit);

			// ItemStatus
			ItemStatus itemStatus = new ItemStatus("ON SHELF");
			iManager.addItemStatus(itemStatus);

			// ItemCondition
			ItemCondition itemCondition = new ItemCondition("FAIR CONDITION");
			iManager.addItemCondition(itemCondition);

			// Item
			// Item item = new Item("Chair", "SET", "Wood", 100, new Date(2011,
			// 5, 17), 10,"hello", "ON SHELF", "FAIR CONDITION" );
			// iManager.addItem(item);

			// PR

			// try {
			//
			// Person p = pManager.getPerson("MARGARITA DE LA CRUZ 2");
			// Person p2 = pManager.getPerson("TELESFORO SALES 2");
			//
			// pManager.addPerson(p);
			// pManager.addPerson(p2);
			//
			// Employee emp1 = new Employee("Dean", p.getPersonID());
			// Employee emp2 = new Employee("Head", p2.getPersonID());
			//
			// pManager.addEmployee(emp1);
			// pManager.addEmployee(emp2);
			//
			// Signatory sign1 = new Signatory("Approved by",
			// emp1.getEmployeeID());
			// Signatory sign2 = new Signatory("Requested by",
			// emp2.getEmployeeID());
			//
			// pManager.addSignatory(sign1);
			// pManager.addSignatory(sign2);
			//
			// Building b1 = new Building("AS Hall", "UPVTC Compound");
			// doMananger.addBuilding(b1);
			//
			// DivisionOffice divisionOffice = new DivisionOffice("DNSM", null,
			// b1.getBuildingID());
			// doMananger.addDivisionOffice(divisionOffice);
			//
			// // PR
			// PurchaseRequest pr = new
			// PurchaseRequest(divisionOffice.getDivisionOfficeID(),
			// "Office use", sign2.getSignatoryID(), sign1.getSignatoryID());
			// prManager.addPR(pr);
			//
			// // PRLine
			// PurchaseRequestLine prLine = new PurchaseRequestLine(1121, "PCS",
			// "Item Description", "12323", 100, pr.getPrID());
			// prManager.addPRLine(prLine);
			//
			// } catch (DuplicateEntryException de) {
			//
			// }

		} catch (TransactionException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (DuplicateEntryException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
