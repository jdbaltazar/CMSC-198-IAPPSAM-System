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
import com.iappsam.entities.ItemCategory;
import com.iappsam.entities.ItemCondition;
import com.iappsam.entities.ItemStatus;
import com.iappsam.entities.Person;
import com.iappsam.entities.Signatory;
import com.iappsam.entities.Supplier;
import com.iappsam.entities.Unit;
import com.iappsam.entities.forms.AnnualProcurementPlan;
import com.iappsam.entities.forms.AnnualProcurementPlanLine;
import com.iappsam.entities.forms.Disposal;
import com.iappsam.entities.forms.IIRUP;
import com.iappsam.entities.forms.IIRUPLine;
import com.iappsam.entities.forms.PurchaseOrder;
import com.iappsam.entities.forms.PurchaseOrderLine;
import com.iappsam.entities.forms.PurchaseRequest;
import com.iappsam.entities.forms.PurchaseRequestLine;
import com.iappsam.entities.forms.RequisitionAndIssueSlip;
import com.iappsam.entities.forms.RequisitionAndIssueSlipLine;
import com.iappsam.entities.forms.WasteMaterialsReport;
import com.iappsam.entities.forms.WasteMaterialsReportLine;
import com.iappsam.managers.APPManager;
import com.iappsam.managers.AccountManager;
import com.iappsam.managers.ContactManager;
import com.iappsam.managers.DivisionOfficeManager;
import com.iappsam.managers.IIRUPManager;
import com.iappsam.managers.ItemManager;
import com.iappsam.managers.POManager;
import com.iappsam.managers.PRManager;
import com.iappsam.managers.PersonManager;
import com.iappsam.managers.RISManager;
import com.iappsam.managers.SupplierManager;
import com.iappsam.managers.WMRManager;
import com.iappsam.managers.exceptions.DuplicateEntryException;
import com.iappsam.managers.exceptions.TransactionException;
import com.iappsam.managers.sessions.APPManagerSession;
import com.iappsam.managers.sessions.AccountManagerSession;
import com.iappsam.managers.sessions.ContactManagerSession;
import com.iappsam.managers.sessions.DivisionOfficeManagerSession;
import com.iappsam.managers.sessions.IIRUPManagerSession;
import com.iappsam.managers.sessions.ItemManagerSession;
import com.iappsam.managers.sessions.POManagerSession;
import com.iappsam.managers.sessions.PRManagerSession;
import com.iappsam.managers.sessions.PersonManagerSession;
import com.iappsam.managers.sessions.RISManagerSession;
import com.iappsam.managers.sessions.SupplierManagerSession;
import com.iappsam.managers.sessions.WMRManagerSession;

public class Tester {

	public static void main(String[] args) {
//		try {
//
//			PersonManager pManager = new PersonManagerSession();
//			AccountManager aManager = new AccountManagerSession();
//			ContactManager cManager = new ContactManagerSession();
//			SupplierManager sManager = new SupplierManagerSession();
//			DivisionOfficeManager doManager = new DivisionOfficeManagerSession();
//			ItemManager iManager = new ItemManagerSession();
//
//			// Forms
//			APPManager appManager = new APPManagerSession();
//			PRManager prManager = new PRManagerSession();
//			POManager poManager = new POManagerSession();
//			RISManager risManager = new RISManagerSession();
//			IIRUPManager iirupManager = new IIRUPManagerSession();
//			WMRManager wmrManager = new WMRManagerSession();
//			// -----------------------Account Creation and Login
//			// Test-----------------------
//			Person person = new Person("Mang2", "Tating2");
////			pManager.addPerson(person);
////			Account a = new Account("pusit", "bulad", AccountType.NON_SPSO_PERSONNEL_HEAD, person.getId());
////			aManager.addAccount(a);
////			List<Account> accounts = aManager.getAllAccounts();
////
////			for (Account ac : accounts) {
////				System.out.println(ac.getUsername());
////			}
////
////			Account a2 = aManager.getAccount("hellow");
////			a2.setPassword("password");
////			aManager.updateAccount(a);
//
//			// Contact
//
//			 Contact c = new Contact("1232-2323", ContactType.LANDLINE);
//			 cManager.addContact(c);
//			 Contact c2 = new Contact("asasasasas", ContactType.LANDLINE);
//			 cManager.addContact(c2);
//			
//			 cManager.addContactToPerson(c.getContactID(), 1);
//			
//			 List<Contact> contacts = cManager.getAllContactsByPerson(1);
//			 for (Contact c1 : contacts) {
//			 System.out.println(c1.getData());
//			 }
//
//			// Supplier
//
//			// Person contactPerson = new Person("De la Cruz");
//			// pManager.addPerson(contactPerson);
//			//
//			// Employee employee = new Employee("CEO", 1);
//			// pManager.addEmployee(employee);
//			//
//			// Supplier supplier = new Supplier("ABC Supplier", "Tacloban City",
//			// employee.getId());
//			// sManager.addSupplier(supplier);
//			//
//			// List<Supplier> suppliers = sManager.getAllSuppliers();
//			// for (Supplier s : suppliers) {
//			// System.out.println(s.getSupplierName());
//			// }
//
//			// Building
//
//			// Building building = new Building("Building 1223",
//			// "UPTAC Compund");
//			// doMananger.addBuilding(building);
//			//
//			// List<Building> buildings = doMananger.getAllBuildings();
//			// for (Building b : buildings) {
//			// System.out.println(b.getBuildingName());
//			// }
//
//			// // DivisionOffice
//
//			//
//			// for (Account ac : accounts) {
//			// System.out.println(ac.getUsername());
//			// }
//			//
//			// Account a2 = aManager.getAccount("hellow");
//			// a2.setPassword("password");
//			// aManager.updateAccount(a);
//			//
//			// // Contact
//			//
//			// Contact c = new Contact("1232-2323", ContactType.LANDLINE);
//			// cManager.addContact(c);
//			// Contact c2 = new Contact("asasasasas", ContactType.LANDLINE);
//			// cManager.addContact(c2);
//			//
//			// cManager.addContactToPerson(c.getContactID(), 1);
//			//
//			// List<Contact> contacts = cManager.getAllContactsByPerson(1);
//			// for (Contact c1 : contacts) {
//			// System.out.println(c1.getData());
//			// }
//			//
//			// // Supplier
//			//
//			// Person contactPerson = new Person("De la Cruz");
//			// pManager.addPerson(contactPerson);
//			//
//			// Employee employee = new Employee("CEO", 1);
//			// pManager.addEmployee(employee);
//			//
//			// Supplier supplier = new Supplier("ABC Supplier", "Tacloban City",
//			// employee.getEmployeeID());
//			// sManager.addSupplier(supplier);
//			//
//			// List<Supplier> suppliers = sManager.getAllSuppliers();
//			// for (Supplier s : suppliers) {
//			// System.out.println(s.getSupplierName());
//			// }
//			//
//			// // Building
//			//
//			// Building building = new Building("Building 1223",
//			// "UPTAC Compund");
//			// doMananger.addBuilding(building);
//			//
//			// List<Building> buildings = doMananger.getAllBuildings();
//			// for (Building b : buildings) {
//			// System.out.println(b.getBuildingName());
//			// }
//			//
//			// // // DivisionOffice
//			// //
//			// DivisionOffice divisionOffice = new DivisionOffice("DNSM", null);
//			// doMananger.addDivisionOffice(divisionOffice);
//			//
//			// List<DivisionOffice> divisionOffices =
//			// doMananger.getAllDivisionOffice();
//			// for (DivisionOffice dO : divisionOffices) {
//			// System.out.println(dO.getDivisionName());
//			// }
//			//
//			// // // Unit
//			// Unit unit = new Unit("SET");
//			// iManager.addUnit(unit);
//			//
//			// // ItemStatus
//			// ItemStatus itemStatus = new ItemStatus("ON SHELF");
//			// iManager.addItemStatus(itemStatus);
//			//
//			// // ItemCondition
//			// ItemCondition itemCondition = new
//			// ItemCondition("FAIR CONDITION");
//			// iManager.addItemCondition(itemCondition);
//
//			// Item
//			// Item item = new Item("Chair", "SET", "Wood", 100, new Date(2011,
//			// 5, 17), 10,"hello", "ON SHELF", "FAIR CONDITION" );
//			// iManager.addItem(item);
//
//			// ---------------------------------------------------->
//
//			// Purchase Request
//
//			// Person p = new Person("John Michael");
//			// Person p2 = new Person("Jayson");
//			// pManager.addPerson(p);
//			// pManager.addPerson(p2);
//			//
//			// Employee emp1 = new Employee("Head", p.getPersonID());
//			// Employee emp2 = new Employee("Dean", p2.getPersonID());
//			// pManager.addEmployee(emp1);
//			// pManager.addEmployee(emp2);
//			//
//			// Signatory sig1 = new Signatory("Requested by",
//			// emp1.getEmployeeID());
//			// Signatory sig2 = new Signatory("Approved by",
//			// emp2.getEmployeeID());
//			// pManager.addSignatory(sig1);
//			// pManager.addSignatory(sig2);
//			//
//			// DivisionOffice dOffice = new DivisionOffice("DNSM", null);
//			// doMananger.addDivisionOffice(dOffice);
//			//
//			// PurchaseRequest pr = new
//			// PurchaseRequest(dOffice.getDivisionOfficeID(), "Office Use",
//			// sig1.getSignatoryID(), sig2.getSignatoryID());
//			// prManager.addPR(pr);
//			//
//			// // name should be unique
//			// Item item = new Item("Item " + Math.random(),
//			// ItemCategory.COMMON_COMPUTER_SUPPLIES, "PCS", "Available",
//			// "Good Condition");
//			// iManager.addItem(item);
//			//
//			// PurchaseRequestLine prLine = new PurchaseRequestLine(10,
//			// item.getDescription(), 100, pr.getPrID());
//			// prManager.addPRLine(prLine);
//			//
//			// // removing a line from pr
//			// PurchaseRequestLine prLine2 = new PurchaseRequestLine(10,
//			// "ABC Item", 1);
//			// prManager.removePRLine(prLine2);
//
//			// ---------------------------------------------------->
//
//			// ---------------------------------------------------->
//			// Purchase Order
//
//			// Person contactPerson = new Person("Mr. Bean");
//			// pManager.addPerson(contactPerson);
//			//
//			// Employee emp1 = new Employee("CEO", contactPerson.getPersonID());
//			// pManager.addEmployee(emp1);
//			//
//			// Person p1 = new Person("person " + Math.random());
//			// Person p2 = new Person("person " + Math.random());
//			// Person p3 = new Person("person " + Math.random());
//			//
//			// pManager.addPerson(p1);
//			// pManager.addPerson(p2);
//			// pManager.addPerson(p3);
//			//
//			// Employee e1 = new Employee("Requisitioner", p1.getPersonID());
//			// Employee e2 = new Employee("Head", p2.getPersonID());
//			// Employee e3 = new Employee("Dean", p3.getPersonID());
//			//
//			// pManager.addEmployee(e1);
//			// pManager.addEmployee(e2);
//			// pManager.addEmployee(e3);
//			//
//			// Signatory s1 = new Signatory("Approved by", e1.getEmployeeID());
//			// Signatory s2 = new Signatory("Approved by", e2.getEmployeeID());
//			// Signatory s3 = new Signatory("Approved by", e3.getEmployeeID());
//			//
//			// pManager.addSignatory(s1);
//			// pManager.addSignatory(s2);
//			// pManager.addSignatory(s3);
//			//
//			// DivisionOffice dOffice = new DivisionOffice("DNSM", null);
//			// doMananger.addDivisionOffice(dOffice);
//			//
//			// Supplier supplier = new Supplier("ANBBCV Supplier",
//			// "Tacloban City", emp1.getEmployeeID());
//			// sManager.addSupplier(supplier);
//			//
//			// PurchaseOrder po = new PurchaseOrder(supplier.getSupplierID(),
//			// "dsdfdfd" + Math.random(), new Date(0), "Shopping",
//			// dOffice.getDivisionOfficeID(), new Date(0), "sdsdsd",
//			// s1.getSignatoryID(), s2.getSignatoryID(), s3.getSignatoryID());
//			// poManager.addPO(po);
//			//
//			// Item item = new Item("xdcfgvbnkmZSXDCFVGBH",
//			// ItemCategory.COMMON_OFFICE_FORMS, "PCS", "Available",
//			// "Good Condition");
//			// iManager.addItem(item);
//			//
//			// PurchaseOrderLine poLine = new
//			// PurchaseOrderLine(item.getItemID(), po.getPoNumber());
//			// poManager.addPOLine(poLine);
//			//
//			// // remove pr_line
//			// PurchaseOrderLine poLine2 = new
//			// PurchaseOrderLine(item.getItemID(), po.getPoNumber());
//			// poManager.removePOLine(poLine);
//			// ---------------------------------------------------->
//
//			// ---------------------------------------------------->
//			// Requisition and Issue slip
//
//			// DivisionOffice dOffice = new DivisionOffice("DNSM ", null);
//			// doManager.addDivisionOffice(dOffice);
//			//
//			// Person p1 = new Person("person " + Math.random());
//			// Person p2 = new Person("person " + Math.random());
//			// Person p3 = new Person("person " + Math.random());
//			// Person p4 = new Person("person " + Math.random());
//			//
//			// pManager.addPerson(p1);
//			// pManager.addPerson(p2);
//			// pManager.addPerson(p3);
//			// pManager.addPerson(p4);
//			//
//			// Employee e1 = new Employee("Requisitioner", p1.getPersonID());
//			// Employee e2 = new Employee("Head", p2.getPersonID());
//			// Employee e3 = new Employee("Dean", p3.getPersonID());
//			// Employee e4 = new Employee("Dean", p4.getPersonID());
//			//
//			// pManager.addEmployee(e1);
//			// pManager.addEmployee(e2);
//			// pManager.addEmployee(e3);
//			// pManager.addEmployee(e4);
//			//
//			// Signatory s1 = new Signatory("Approved by", e1.getEmployeeID());
//			// Signatory s2 = new Signatory("Approved by", e2.getEmployeeID());
//			// Signatory s3 = new Signatory("Approved by", e3.getEmployeeID());
//			// Signatory s4 = new Signatory("Approved by", e4.getEmployeeID());
//			//
//			// pManager.addSignatory(s1);
//			// pManager.addSignatory(s2);
//			// pManager.addSignatory(s3);
//			// pManager.addSignatory(s4);
//			//
//			//
//			// RequisitionAndIssueSlip ris = new
//			// RequisitionAndIssueSlip(dOffice.getDivisionOfficeID(), "sdsd " +
//			// Math.random(), new Date(0), "dfdfdfdfdf", s1.getSignatoryID(),
//			// s2.getSignatoryID(), s3.getSignatoryID(), s4.getSignatoryID());
//			// risManager.addRIS(ris);
//			//
//			// Item item = new Item("dsds" + Math.random(), ItemCategory.OTHERS,
//			// "PCS", "Available", "Good Condition");
//			// iManager.addItem(item);
//			//
//			// RequisitionAndIssueSlipLine risLine = new
//			// RequisitionAndIssueSlipLine(item.getItemID(), 10,
//			// 10,ris.getRisNumber());
//			// risManager.addRISLine(risLine);
//
//			// ---------------------------------------------------->
//
//			// ---------------------------------------------------->
//
//			// IIRUP
//
//			 Person p1 = new Person("person " + Math.random());
//			 Person p2 = new Person("person " + Math.random());
//			 Person p3 = new Person("person " + Math.random());
//			 Person p4 = new Person("person " + Math.random());
//			
//			 pManager.addPerson(p1);
//			 pManager.addPerson(p2);
//			 pManager.addPerson(p3);
//			 pManager.addPerson(p4);
//			
//			 Employee e1 = new Employee("Requisitioner", p1);
//			 Employee e2 = new Employee("Head", p2);
//			 Employee e3 = new Employee("Dean", p3);
//			 Employee e4 = new Employee("Dean", p4);
//			
//			 pManager.addEmployee(e1);
//			 pManager.addEmployee(e2);
//			 pManager.addEmployee(e3);
//			 pManager.addEmployee(e4);
////			
////			 Signatory s1 = new Signatory("Approved by", e1);
////			 Signatory s2 = new Signatory("Approved by", e2);
////			 Signatory s3 = new Signatory("Approved by", e3);
////			 Signatory s4 = new Signatory("Approved by", e4);
////			
////			 pManager.addSignatory(s1);
////			 pManager.addSignatory(s2);
////			 pManager.addSignatory(s3);
////			 pManager.addSignatory(s4);
////			
////			 IIRUP iirup = new IIRUP(new Date(0), e1.getId(),
////			 s1.getId(), s2.getId(), s3.getId(),
////			 s4.getId());
////			 iirupManager.addIIRUP(iirup);
////			
////			 Item item = new Item("" + Math.random(), ItemCategory.OTHERS,
////			 "PCS", "Available", "Good Condition");
////			 iManager.addItem(item);
////			
////			 IIRUPLine iirupLine = new IIRUPLine(item.getId(), 10, 12,
////			 100, "Destroyed", "dfdf", iirup.getIirupID());
////			 iirupManager.addIIRUPLine(iirupLine);
//
//			// ---------------------------------------------------->
//
//			// ---------------------------------------------------->
//			// Waste Materials Report
//
////			DivisionOffice dOffice = new DivisionOffice("sddfdfdf", null);
////			doManager.addDivisionOffice(dOffice);
////
////			Person p1 = new Person("person " + Math.random());
////			Person p2 = new Person("person " + Math.random());
////			Person p3 = new Person("person " + Math.random());
////			Person p4 = new Person("person " + Math.random());
////
////			pManager.addPerson(p1);
////			pManager.addPerson(p2);
////			pManager.addPerson(p3);
////			pManager.addPerson(p4);
//
//			// Employee e1 = new Employee("Requisitioner", p1.getPersonID());
//			// Employee e2 = new Employee("Head", p2.getPersonID());
//			// Employee e3 = new Employee("Dean", p3.getPersonID());
//			// Employee e4 = new Employee("Dean", p4.getPersonID());
//
//			// pManager.addEmployee(e1);
//			// pManager.addEmployee(e2);
//			// pManager.addEmployee(e3);
//			// pManager.addEmployee(e4);
//
//			// Signatory s1 = new Signatory("Approved by", e1.getEmployeeID());
//			// Signatory s2 = new Signatory("Approved by", e2.getEmployeeID());
//			// Signatory s3 = new Signatory("Approved by", e3.getEmployeeID());
//			// Signatory s4 = new Signatory("Approved by", e4.getEmployeeID());
//
//			// pManager.addSignatory(s1);
//			// pManager.addSignatory(s2);
//			// pManager.addSignatory(s3);
//			// pManager.addSignatory(s4);
//			//
//			// WasteMaterialsReport wmr = new
//			// WasteMaterialsReport(dOffice.getDivisionOfficeID(), new Date(0),
//			// s1.getSignatoryID(), s2.getSignatoryID(), s3.getSignatoryID(),
//			// s4.getSignatoryID());
//			// wmrManager.addWMR(wmr);
//
////			Item item = Item.createManagedItem("sdsd" + Math.random(), ItemCategory.OTHERS, "PCS", "Available", "Good Condition");
////			iManager.addItem(item);
////
////			// WasteMaterialsReportLine wmrLine = new
////			// WasteMaterialsReportLine(item.getItemID(), 100, "dfdfdfdf",
////			// "Destroyed", wmr.getWmrID());
////			// wmrManager.addWMRLine(wmrLine);
//
//			System.out.println("Success!");
//
//		} catch (TransactionException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		} catch (DuplicateEntryException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
		
		Date date = Date.valueOf("2011-05-26");
		System.out.println("date: "+date.toString());
	}
}
