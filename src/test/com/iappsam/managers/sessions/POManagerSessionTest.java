package com.iappsam.managers.sessions;

import static org.junit.Assert.*;

import java.sql.Date;

import org.junit.Before;
import org.junit.Test;

import com.iappsam.entities.DivisionOffice;
import com.iappsam.entities.Employee;
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
	private PersonManager pm;
	private SupplierManager sm;
	private POManager pom;
	private DivisionOfficeManager dom;

	@Override
	@Before
	public void init() throws Exception {
		super.init();
		pm = new PersonManagerSession();
		sm = new SupplierManagerSession();
		pom = new POManagerSession();
		dom = new DivisionOfficeManagerSession();

		contactPerson = Employee.create("Des", "Title", "Name");
		supplier = new Supplier("Name", "address", contactPerson);
		modeOfProcurement = new ModeOfProcurement("Mode");
		divisionOffice = new DivisionOffice("div", "office");
		supplierName = supplier.getContactPerson();
		accountant = Employee.create("Accountant", "Mr.", "John");
		dean = Employee.create("Dean", "Mrs", "Dean");
		po = new PurchaseOrder("num", supplier, Date.valueOf("2011-01-01"), modeOfProcurement, divisionOffice, Date.valueOf("2011-01-01"),
				supplierName, accountant, dean);
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
	public void addPOWithLine() {
		// po.addLine();
	}
}
