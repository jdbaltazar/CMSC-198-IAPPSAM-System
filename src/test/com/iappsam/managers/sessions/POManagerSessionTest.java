package com.iappsam.managers.sessions;

import static org.junit.Assert.*;

import java.sql.Date;

import org.junit.Before;
import org.junit.Test;

import com.iappsam.entities.DivisionOffice;
import com.iappsam.entities.Employee;
import com.iappsam.entities.EntityRemover;
import com.iappsam.entities.Supplier;
import com.iappsam.entities.forms.ModeOfProcurement;
import com.iappsam.entities.forms.PurchaseOrder;
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
	private PurchaseOrder po;
	private Employee contactPerson;

	@Before
	public void init() throws TransactionException {
		super.init();
		contactPerson = Employee.create("Des", "Title", "Name");
		supplier = new Supplier("Name", "address", contactPerson);
		modeOfProcurement = new ModeOfProcurement("Mode");
		divisionOffice = new DivisionOffice("div", "office");
		supplierName = supplier.getContactPerson();
		accountant = Employee.create("Accountant", "Mr.", "John");
		dean = Employee.create("Dean", "Mrs", "Dean");
		po = new PurchaseOrder("num", supplier, Date.valueOf("2011-01-01"), modeOfProcurement, divisionOffice, Date.valueOf("2011-01-01"),
				supplierName, accountant, dean);
	}

	@Test
	public void addPO() throws TransactionException, DuplicateEntryException {
		PersonManager pm = new PersonManagerSession();
		pm.addEmployee(contactPerson);
		pm.addEmployee(accountant);
		pm.addEmployee(dean);

		SupplierManager sm = new SupplierManagerSession();
		sm.addSupplier(supplier);

		POManager pom = new POManagerSession();
		pom.addModeOfProcurement(modeOfProcurement);

		DivisionOfficeManager dom = new DivisionOfficeManagerSession();
		dom.addDivisionOffice(divisionOffice);

		pom.addPO(po);

		assertTrue(pom.containsPO(po));
	}
}
