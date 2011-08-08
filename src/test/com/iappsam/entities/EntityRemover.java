package com.iappsam.entities;

import java.util.ArrayList;
import java.util.List;

import com.iappsam.Account;
import com.iappsam.Building;
import com.iappsam.Contact;
import com.iappsam.DivisionOffice;
import com.iappsam.Employee;
import com.iappsam.Item;
import com.iappsam.ItemCategory;
import com.iappsam.ItemCondition;
import com.iappsam.ItemStatus;
import com.iappsam.Person;
import com.iappsam.Signatory;
import com.iappsam.Supplier;
import com.iappsam.Unit;
import com.iappsam.forms.APP;
import com.iappsam.forms.IE;
import com.iappsam.forms.IIRUP;
import com.iappsam.forms.ModeOfProcurement;
import com.iappsam.forms.PO;
import com.iappsam.forms.PR;
import com.iappsam.managers.APPManager;
import com.iappsam.managers.AccountManager;
import com.iappsam.managers.ContactManager;
import com.iappsam.managers.DivisionOfficeManager;
import com.iappsam.managers.IEManager;
import com.iappsam.managers.IIRUPManager;
import com.iappsam.managers.ItemManager;
import com.iappsam.managers.POManager;
import com.iappsam.managers.PRManager;
import com.iappsam.managers.PersonManager;
import com.iappsam.managers.SupplierManager;
import com.iappsam.managers.exceptions.DuplicateEntryException;
import com.iappsam.managers.exceptions.TransactionException;
import com.iappsam.managers.sessions.APPManagerSession;
import com.iappsam.managers.sessions.AccountManagerSession;
import com.iappsam.managers.sessions.ContactManagerSession;
import com.iappsam.managers.sessions.DivisionOfficeManagerSession;
import com.iappsam.managers.sessions.IEManagerSession;
import com.iappsam.managers.sessions.IIRUPManagerSession;
import com.iappsam.managers.sessions.ItemManagerSession;
import com.iappsam.managers.sessions.POManagerSession;
import com.iappsam.managers.sessions.PRManagerSession;
import com.iappsam.managers.sessions.PersonManagerSession;
import com.iappsam.managers.sessions.SupplierManagerSession;
import com.iappsam.util.HibernateUtil;

public class EntityRemover {

	private static IIRUPManager iirupm = new IIRUPManagerSession();
	private static PersonManager pm = new PersonManagerSession();
	private static ItemManager im = new ItemManagerSession();
	private static APPManager appm = new APPManagerSession();
	private static DivisionOfficeManager dom = new DivisionOfficeManagerSession();
	private static ContactManager cm = new ContactManagerSession();
	private static AccountManager am = new AccountManagerSession();
	private static SupplierManager sm = new SupplierManagerSession();
	private static POManager pom = new POManagerSession();
	private static PRManager prm = new PRManagerSession();
	private static IEManager iem = new IEManagerSession();

	public static void removeAll() throws TransactionException {
		removeIEs();
		removePOs();
		removePRs();
		removeAPPs();
		removeIIRUPs();
		removeItems();
		removeItemProperties();
		removeModeOfProcurements();
		removeSignatories();
		removeSuppliers();
		removeEmployees();
		removeAccounts();
		removePersons();
		removeContacts();
		removeDivisionOffices();
		removeBuilidings();
	}

	private static void removeBuilidings() throws TransactionException {
		List<Building> buildings = dom.getAllBuildings();
		for (Building building : buildings)
			dom.removeBuilding(building);

	}

	private static void removeIEs() throws TransactionException {
		List<IE> ies = iem.getAllIE();
		for (IE ie : ies)
			iem.removeIE(ie);
	}

	public static void removePRs() throws TransactionException {
		List<PR> prs = prm.getAllPR();
		for (PR pr : prs)
			prm.removePR(pr);
	}

	public static void removeModeOfProcurements() throws TransactionException {
		List<ModeOfProcurement> mops = pom.getAllModeOfProcurement();
		for (ModeOfProcurement mop : mops)
			pom.removeModeOfProcurement(mop);

	}

	public static void removePOs() throws TransactionException {
		List<PO> pos = pom.getAllPO();
		for (PO po : pos)
			pom.removePurchaseOrder(po);
	}

	public static void removeSuppliers() throws TransactionException {
		List<Supplier> suppliers = sm.getAllSuppliers();
		for (Supplier s : suppliers)
			sm.removeSupplier(s);
	}

	public static void removeAccounts() throws TransactionException {
		List<Account> accounts = am.getAllAccounts();
		for (Account i : accounts)
			am.removeAccount(i);
	}

	public static void removeContacts() throws TransactionException {
		List<Contact> contacts = cm.getAllContacts();
		for (Contact i : contacts)
			cm.removeContact(i);
	}

	public static void removeDivisionOffices() throws TransactionException {
		List<DivisionOffice> offices = dom.getAllDivisionOffice();
		for (DivisionOffice i : offices)
			dom.removeDivisionOffice(i);
	}

	public static void removeAPPs() throws TransactionException {
		List<APP> persons = appm.getAllAPP();
		for (APP i : persons)
			appm.removeAPP(i);
	}

	public static void removePersons() throws TransactionException {
		List<Person> persons = pm.getAllPersons();
		for (Person i : persons)
			pm.removePerson(i);
	}

	public static void removeSignatories() throws TransactionException {
		List<Signatory> signatories = pm.getAllSignatories();
		for (Signatory i : signatories)
			pm.removeSignatory(i);
	}

	public static void removeItemProperties() throws TransactionException {
		removeItemConditions();
		removeCategories();
		removeUnits();
		removeItemStatuses();
	}

	public static void removeItemStatuses() throws TransactionException {
		List<ItemStatus> statuses = im.getAllItemStatus();
		for (ItemStatus i : statuses)
			im.removeItemStatus(i);
	}

	public static void removeUnits() throws TransactionException {
		List<Unit> units = im.getAllUnits();
		for (Unit i : units)
			im.removeUnit(i);
	}

	public static void removeCategories() throws TransactionException {
		List<ItemCategory> conditions = im.getAllItemCategory();
		for (ItemCategory i : conditions)
			im.removeItemCategory(i);
	}

	public static void removeItemConditions() throws TransactionException {
		List<ItemCondition> conditions = im.getAllItemCondition();
		for (ItemCondition i : conditions)
			im.removeItemCondition(i);
	}

	public static void removeItems() throws TransactionException {
		List<Item> items = im.getAllItems();
		for (Item i : items)
			im.removeItem(i);
	}

	public static void removeIIRUPs() throws TransactionException {
		List<IIRUP> iirups = iirupm.getAllIIRUP();
		for (IIRUP iirup : iirups)
			iirupm.removeIIRUP(iirup);
	}

	public static void removeEmployees() throws TransactionException {
		List<Employee> employees = pm.getAllEmployee();
		for (Employee e : employees)
			pm.removeEmployee(e);
	}

	public static void reset() throws TransactionException, DuplicateEntryException {
		removeAll();
	}
}
