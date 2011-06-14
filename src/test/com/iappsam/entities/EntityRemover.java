package com.iappsam.entities;

import java.util.List;

import com.iappsam.entities.DivisionOffice;
import com.iappsam.entities.Employee;
import com.iappsam.entities.Item;
import com.iappsam.entities.ItemCategory;
import com.iappsam.entities.ItemCondition;
import com.iappsam.entities.ItemStatus;
import com.iappsam.entities.Person;
import com.iappsam.entities.Signatory;
import com.iappsam.entities.Unit;
import com.iappsam.entities.forms.AnnualProcurementPlan;
import com.iappsam.entities.forms.IIRUP;
import com.iappsam.entities.forms.ModeOfProcurement;
import com.iappsam.entities.forms.PurchaseOrder;
import com.iappsam.entities.forms.PurchaseRequest;
import com.iappsam.managers.APPManager;
import com.iappsam.managers.AccountManager;
import com.iappsam.managers.ContactManager;
import com.iappsam.managers.DivisionOfficeManager;
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

	public static void removeAll() throws TransactionException {
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
	}

	public static void removePRs() throws TransactionException {
		List<PurchaseRequest> prs = prm.getAllPR();
		for (PurchaseRequest pr : prs)
			prm.removePR(pr);
	}

	public static void removeModeOfProcurements() throws TransactionException {
		List<ModeOfProcurement> mops = pom.getAllModeOfProcurement();
		for (ModeOfProcurement mop : mops)
			pom.removeModeOfProcurement(mop);

	}

	public static void removePOs() throws TransactionException {
		List<PurchaseOrder> pos = pom.getAllPO();
		for (PurchaseOrder po : pos)
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
		List<AnnualProcurementPlan> persons = appm.getAllAPP();
		for (AnnualProcurementPlan i : persons)
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
		HibernateUtil.addAdminAccount();
		HibernateUtil.addItemDependencies();
		HibernateUtil.addDisposals();
	}
}
