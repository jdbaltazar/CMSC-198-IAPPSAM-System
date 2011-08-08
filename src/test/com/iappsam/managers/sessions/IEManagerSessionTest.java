package com.iappsam.managers.sessions;

import org.junit.Before;
import org.junit.Test;

import com.iappsam.Building;
import com.iappsam.DivisionOffice;
import com.iappsam.Employee;
import com.iappsam.entities.EntityRemover;
import com.iappsam.forms.IE;
import com.iappsam.managers.DivisionOfficeManager;
import com.iappsam.managers.IEManager;
import com.iappsam.managers.PersonManager;
import com.iappsam.managers.exceptions.DuplicateEntryException;
import com.iappsam.managers.exceptions.TransactionException;

public class IEManagerSessionTest {

	private IEManager iem;
	private IE ie;

	@Before
	public void init() throws TransactionException, DuplicateEntryException {
		EntityRemover.removeAll();

		iem = new IEManagerSession();
		DivisionOfficeManager dom = new DivisionOfficeManagerSession();
		DivisionOffice office = new DivisionOffice("div", "office");
		dom.addDivisionOffice(office);

		Building building = new Building("name");
		dom.addBuilding(building);

		PersonManager pm = new PersonManagerSession();
		Employee prep = Employee.create("des", "prep");
		pm.addEmployee(prep);

		Employee comm = Employee.create("des", "comm");
		pm.addEmployee(comm);

		Employee comm2 = Employee.create("des", "comm2");
		pm.addEmployee(comm2);

		Employee checked = Employee.create("des", "checked");
		pm.addEmployee(checked);

		Employee noted = Employee.create("des", "noted");
		pm.addEmployee(noted);

		Employee coa = Employee.create("des", "coa");
		pm.addEmployee(coa);

		ie = new IE(office, building, prep, comm, comm2, checked, noted, coa);
	}

	@Test
	public void shouldAddIE() throws TransactionException {
		iem.addIE(ie);
		iem.containsIE(ie);
	}
}
