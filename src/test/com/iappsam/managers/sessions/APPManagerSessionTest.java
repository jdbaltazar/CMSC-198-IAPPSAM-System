package com.iappsam.managers.sessions;

import static org.junit.Assert.*;

import org.junit.Test;

import com.iappsam.entities.DivisionOffice;
import com.iappsam.entities.Employee;
import com.iappsam.entities.Person;
import com.iappsam.entities.Signatory;
import com.iappsam.entities.forms.AnnualProcurementPlan;
import com.iappsam.managers.APPManager;
import com.iappsam.managers.DivisionOfficeManager;
import com.iappsam.managers.PersonManager;
import com.iappsam.managers.exceptions.DuplicateEntryException;
import com.iappsam.managers.exceptions.TransactionException;

public class APPManagerSessionTest {

	private PersonManager pm;
	private DivisionOfficeManager dom;

	private Person p;
	private Employee e;
	private Signatory s;
	private DivisionOffice office;

	@Test
	public void addAPP() throws TransactionException, DuplicateEntryException {

		addAPPDepedencies();

		AnnualProcurementPlan app = new AnnualProcurementPlan(2011, office, s, s);

		APPManager appManager = new APPManagerSession();
		appManager.addAPP(app);

		assertTrue(appManager.containsAPP(app));
	}

	private void addAPPDepedencies() throws TransactionException, DuplicateEntryException {
		p = new Person("John");
		pm = new PersonManagerSession();
		pm.addPerson(p);

		e = new Employee("Mayor", p.getPersonID());
		pm.addEmployee(e);

		s = new Signatory("Signatory", e.getEmployeeID());
		pm.addSignatory(s);

		office = new DivisionOffice("Division", "Office");
		dom = new DivisionOfficeManagerSession();
		dom.addDivisionOffice(office);
	}
}
