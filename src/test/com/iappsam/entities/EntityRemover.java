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
import com.iappsam.managers.APPManager;
import com.iappsam.managers.ContactManager;
import com.iappsam.managers.DivisionOfficeManager;
import com.iappsam.managers.IIRUPManager;
import com.iappsam.managers.ItemManager;
import com.iappsam.managers.PersonManager;
import com.iappsam.managers.exceptions.TransactionException;
import com.iappsam.managers.sessions.APPManagerSession;
import com.iappsam.managers.sessions.ContactManagerSession;
import com.iappsam.managers.sessions.DivisionOfficeManagerSession;
import com.iappsam.managers.sessions.IIRUPManagerSession;
import com.iappsam.managers.sessions.ItemManagerSession;
import com.iappsam.managers.sessions.PersonManagerSession;
import com.sun.org.apache.bcel.internal.generic.NEW;

public class EntityRemover {

	private static IIRUPManager iirupm = new IIRUPManagerSession();
	private static PersonManager pm = new PersonManagerSession();
	private static ItemManager im = new ItemManagerSession();
	private static APPManager appm = new APPManagerSession();
	private static DivisionOfficeManager dom = new DivisionOfficeManagerSession();
	private static ContactManager cm = new ContactManagerSession();

	public static void removeAll() throws TransactionException {
		removeAPPs();
		removeIIRUPs();
		removeItems();
		removeItemDependencies();
		removeSignatories();
		removeEmployees();
		removePersons();
		removeContacts();
		removeDivisionOffices();
	}

	private static void removeContacts() throws TransactionException {
		List<Contact> contacts = cm.getAllContacts();
		for (Contact i : contacts)
			cm.removeContact(i);

	}

	private static void removeDivisionOffices() throws TransactionException {
		List<DivisionOffice> offices = dom.getAllDivisionOffice();
		for (DivisionOffice i : offices)
			dom.removeDivisionOffice(i);
	}

	private static void removeAPPs() throws TransactionException {
		List<AnnualProcurementPlan> persons = appm.getAllAPP();
		for (AnnualProcurementPlan i : persons)
			appm.removeAPP(i);
	}

	private static void removePersons() throws TransactionException {
		List<Person> persons = pm.getAllPersons();
		for (Person i : persons)
			pm.removePerson(i);
	}

	private static void removeSignatories() throws TransactionException {
		List<Signatory> signatories = pm.getAllSignatories();
		for (Signatory i : signatories)
			pm.removeSignatory(i);
	}

	public static void removeItemDependencies() throws TransactionException {
		removeItemConditions();
		removeCategories();
		removeUnits();
		removeItemStatuses();
	}

	private static void removeItemStatuses() throws TransactionException {
		List<ItemStatus> statuses = im.getAllItemStatus();
		for (ItemStatus i : statuses)
			im.removeItemStatus(i);
	}

	private static void removeUnits() throws TransactionException {
		List<Unit> units = im.getAllUnits();
		for (Unit i : units)
			im.removeUnit(i);
	}

	private static void removeCategories() throws TransactionException {
		List<ItemCategory> conditions = im.getAllItemCategory();
		for (ItemCategory i : conditions)
			im.removeItemCategory(i);
	}

	private static void removeItemConditions() throws TransactionException {
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

}
