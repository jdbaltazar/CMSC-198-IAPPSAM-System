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

	@Test
	public void addAPP() throws TransactionException, DuplicateEntryException {

		Person p = new Person("John");
		PersonManager pm = new PersonManagerSession();
		pm.addPerson(p);

		Employee e = new Employee("Mayor", p.getPersonID());
		pm.addEmployee(e);

		Signatory s = new Signatory("Signatory", e.getEmployeeID());
		pm.addSignatory(s);

		DivisionOffice office = new DivisionOffice("Division", "Office");
		DivisionOfficeManager dom = new DivisionOfficeManagerSession();
		dom.addDivisionOffice(office);

		AnnualProcurementPlan.Id appId = new AnnualProcurementPlan.Id(2011, office.getDivisionOfficeID());
		AnnualProcurementPlan app = new AnnualProcurementPlan(appId, s.getSignatoryID(), s.getSignatoryID());

		APPManager appManager = new APPManagerSession();
		appManager.addAPP(app);

		assertTrue(appManager.containsAPP(app));
	}
}
