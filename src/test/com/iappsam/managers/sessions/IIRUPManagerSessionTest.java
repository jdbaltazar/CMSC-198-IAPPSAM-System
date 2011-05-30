package com.iappsam.managers.sessions;

import static org.junit.Assert.*;

import java.sql.Date;

import org.junit.Before;
import org.junit.Test;

import com.iappsam.entities.Employee;
import com.iappsam.entities.ItemBuilder;
import com.iappsam.entities.forms.Disposal;
import com.iappsam.entities.forms.IIRUP;
import com.iappsam.managers.IIRUPManager;
import com.iappsam.managers.PersonManager;
import com.iappsam.managers.exceptions.DuplicateEntryException;
import com.iappsam.managers.exceptions.TransactionException;

public class IIRUPManagerSessionTest {

	private PersonManager pm;
	private Employee employee;
	private IIRUPManager iirupm;
	private IIRUP iirup;

	@Before
	public void init() {
		iirupm = new IIRUPManagerSession();
	}

	@Test
	public void addIIRUP() throws TransactionException, DuplicateEntryException {
		persistEmployee();

		iirup = new IIRUP(new Date(0), employee, employee, employee, employee, employee);
		iirupm.addIIRUP(iirup);

		assertIIRUPExistInDatabase();
	}

	@Test
	public void addIIRUPwithLine() throws TransactionException, DuplicateEntryException {
		persistEmployee();

		ItemBuilder builder = new ItemBuilder();
		builder.addUnit("Unit");
		builder.addCategory("Cat");
		builder.addCondition("Condition");
		builder.addStatus("Status");
		builder.addItem("Desc");
		builder.addToDatabase();

		iirup = new IIRUP(new Date(0), employee, employee, employee, employee, employee);
		iirup.addLine(builder.getItem(), 1, 1, 1, new Disposal("Disposal"), "111");
		iirupm.addIIRUP(iirup);

		assertIIRUPExistInDatabase();

		iirupm.removeIIRUP(iirup);
		builder.removeFromDatabase();
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
