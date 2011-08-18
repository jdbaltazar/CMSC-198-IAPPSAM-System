package com.iappsam.managers.sessions;

import static org.junit.Assert.*;

import java.sql.Date;

import org.junit.Before;
import org.junit.BeforeClass;
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
	private static PersonManager pm;
	private static SupplierManager sm;
	private static POManager pom;
	private static DivisionOfficeManager dom;
	private static ItemManagerSession im;

	@BeforeClass
	public static void initManagers() {

		pm = new PersonManagerSession();
		sm = new SupplierManagerSession();
		pom = new POManagerSession();
		dom = new DivisionOfficeManagerSession();
		im = new ItemManagerSession();
	}

	@Override
	@Before
	public void init() throws Exception {
		super.init();

		contactPerson = Employee.create("Des", "Title", "Name");
		pm.addEmployee(contactPerson);

		supplier = new Supplier("Name", "address", contactPerson);
		sm.addSupplier(supplier);

		modeOfProcurement = new ModeOfProcurement("Mode");
		pom.addModeOfProcurement(modeOfProcurement);

		divisionOffice = new DivisionOffice("div", "office");
		dom.addDivisionOffice(divisionOffice);

		supplierName = supplier.getContactPerson();

		accountant = Employee.create("Accountant", "Mr.", "John");
		pm.addEmployee(accountant);

		dean = Employee.create("Dean", "Mrs", "Dean");
		pm.addEmployee(dean);

		pm.addEmployee(contactPerson);
		pm.addEmployee(accountant);
		pm.addEmployee(dean);
		sm.addSupplier(supplier);

		po = new PO("num", supplier, Date.valueOf("2011-01-01"), modeOfProcurement, divisionOffice, Date.valueOf("2011-01-01"), supplierName,
				Date.valueOf("2011-01-01"), accountant, Date.valueOf("2011-01-01"), dean, Date.valueOf("2011-01-01"));
	}

	@Test
	public void shouldAddPOwithRequiredFields() throws TransactionException, DuplicateEntryException {
		Item item = Item.create("des", "Cat", "u", "status", "condition");
		im.addItem(item);
		po.addLine(item, "1");
		pom.addPO(po);

		assertTrue(pom.containsPO(po));
	}

	@Test
	public void shouldAddWithTwoLines() throws TransactionException {
		Item item = Item.create("Des", "asd", "ad", "Asd", "Asd");
		im.addItem(item);

		Item item2 = Item.create("Des2", "asd2", "ad2", "Asd2", "Asd2");
		im.addItem(item2);

		po.addLine(item, "1");
		po.addLine(item2, "1");
		pom.addPO(po);

		assertTrue(pom.containsPO(po));
	}
}
