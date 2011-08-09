package com.iappsam.managers.sessions;

import static org.junit.Assert.*;

import java.sql.Date;

import org.junit.Before;
import org.junit.Test;

import com.iappsam.DivisionOffice;
import com.iappsam.Employee;
import com.iappsam.Item;
import com.iappsam.Supplier;
import com.iappsam.forms.ModeOfProcurement;
import com.iappsam.forms.PO;
import com.iappsam.managers.DivisionOfficeManager;
import com.iappsam.managers.POManager;
import com.iappsam.managers.PersonManager;
import com.iappsam.managers.SupplierManager;
import com.iappsam.managers.exceptions.DuplicateEntryException;
import com.iappsam.managers.exceptions.TransactionException;

public class POManagerSessionTest extends ManagerSessionTestCase {

	private Supplier supplier;
	private ModeOfProcurement modeOfProcurement;
	private DivisionOffice divisionOffice;
	private Employee supplierName;
	private Employee accountant;
	private Employee dean;
	private PO po;
	private Employee contactPerson;
	private PersonManager pm;
	private SupplierManager sm;
	private POManager pom;
	private DivisionOfficeManager dom;
	private ItemManagerSession im;

	@Override
	@Before
	public void init() throws Exception {
		super.init();
		pm = new PersonManagerSession();
		sm = new SupplierManagerSession();
		pom = new POManagerSession();
		dom = new DivisionOfficeManagerSession();
		im = new ItemManagerSession();

		contactPerson = Employee.create("Des", "Title", "Name");
		supplier = new Supplier("Name", "address", contactPerson);
		modeOfProcurement = new ModeOfProcurement("Mode");
		divisionOffice = new DivisionOffice("div", "office");
		supplierName = supplier.getContactPerson();
		accountant = Employee.create("Accountant", "Mr.", "John");
		dean = Employee.create("Dean", "Mrs", "Dean");
		po = new PO("num", supplier, Date.valueOf("2011-01-01"), modeOfProcurement, divisionOffice, Date.valueOf("2011-01-01"), supplierName, Date.valueOf("2011-01-01"), accountant,
				Date.valueOf("2011-01-01"), dean, Date.valueOf("2011-01-01"));
		pm.addEmployee(contactPerson);
		pm.addEmployee(accountant);
		pm.addEmployee(dean);
		sm.addSupplier(supplier);

		pom.addModeOfProcurement(modeOfProcurement);

		dom.addDivisionOffice(divisionOffice);
	}

	@Test
	public void addPO() throws TransactionException, DuplicateEntryException {
		pom.addPO(po);
		assertTrue(pom.containsPO(po));
	}

	@Test
	public void addPOWithLine() throws TransactionException {
		Item item = Item.create("des", "Cat", "u", "status", "condition");
		im.addItem(item);

		po.addLine(item);
		assertTrue(pom.containsPO(po));
	}
}
