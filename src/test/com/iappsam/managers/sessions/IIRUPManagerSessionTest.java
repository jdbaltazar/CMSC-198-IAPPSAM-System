package com.iappsam.managers.sessions;

import static org.junit.Assert.*;

import java.sql.Date;

import org.junit.Before;
import org.junit.Test;

import com.iappsam.Employee;
import com.iappsam.Item;
import com.iappsam.forms.Disposal;
import com.iappsam.forms.IIRUP;
import com.iappsam.managers.IIRUPManager;
import com.iappsam.managers.ItemManager;
import com.iappsam.managers.PersonManager;
import com.iappsam.managers.exceptions.DuplicateEntryException;
import com.iappsam.managers.exceptions.TransactionException;

public class IIRUPManagerSessionTest extends ManagerSessionTestCase {

	private PersonManager pm;
	private Employee employee;
	private IIRUPManager iirupm;
	private IIRUP iirup;
	private ItemManager im;

	@Override
	@Before
	public void init() throws Exception {
		super.init();
		iirupm = new IIRUPManagerSession();
		persistEmployee();
		im = new ItemManagerSession();
	}

	@Test
	public void addIIRUP() throws TransactionException, DuplicateEntryException {

		iirup = new IIRUP(new Date(0), employee, employee, employee, employee, employee);
		iirupm.addIIRUP(iirup);

		assertIIRUPExistInDatabase();
	}

	@Test
	public void addIIRUPwithLine() throws TransactionException {

		Item item = Item.create("desc", "cat", "unit", "status", "condition");
		im.addItem(item);

		iirup = new IIRUP(new Date(0), employee, employee, employee, employee, employee);
		iirup.addLine(item, 1, 1, 1, new Disposal("Disposal"), "111");
		iirupm.addIIRUP(iirup);

		assertIIRUPExistInDatabase();
	}

	private void assertIIRUPExistInDatabase() throws TransactionException {
		assertTrue(iirupm.containsIIRUP(iirup));
	}

	private void persistEmployee() throws TransactionException, DuplicateEntryException {
		pm = new PersonManagerSession();
		employee = Employee.create("Dean", "Mr.", "John");
		pm.addEmployee(employee);
	}
}
