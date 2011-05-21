package com.iappsam.managers.sessions;

import static org.junit.Assert.*;

import org.hibernate.Session;
import org.hibernate.Transaction;
import org.junit.After;
import org.junit.Before;
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
import com.iappsam.util.HibernateUtil;

public class APPManagerSessionTest {

	private PersonManager pm;
	private DivisionOfficeManager dom;

	private Person person;
	private Employee employee;
	private Signatory signatory;
	private DivisionOffice office;

	@Before
	public void addAPPDepedencies() throws TransactionException, DuplicateEntryException {
		person = new Person("John");
		pm = new PersonManagerSession();
		pm.addPerson(person);

		employee = new Employee("Mayor", person);
		pm.addEmployee(employee);

		signatory = new Signatory("Signatory", employee);
		pm.addSignatory(signatory);

		office = new DivisionOffice("Division", "Office");

		dom = new DivisionOfficeManagerSession();
		dom.addDivisionOffice(office);
	}

	@Test
	public void addAPP() throws TransactionException, DuplicateEntryException {

		AnnualProcurementPlan app = new AnnualProcurementPlan(2011, office, signatory, signatory);

		APPManager appm = new APPManagerSession();
		appm.addAPP(app);

		AnnualProcurementPlan appFromDb = appm.getAPP(app.getId());
		assertEquals(app, appFromDb);

		removeAPP(app);
		appm.close();
	}

	private static void removeAPP(AnnualProcurementPlan app) {
		Session session = HibernateUtil.startSession();
		Transaction tx = session.beginTransaction();
		session.delete(app);
		tx.commit();
		assertFalse(session.contains(app));
		session.close();
	}

	@Test
	public void addAPPLine() throws TransactionException, DuplicateEntryException {

		AnnualProcurementPlan app = new AnnualProcurementPlan(2011, office, signatory, signatory);

		APPManager appManager = new APPManagerSession();
		appManager.addAPP(app);

		AnnualProcurementPlan appFromDb = appManager.getAPP(app.getId());
		assertEquals(app, appFromDb);

		appManager.removeAPP(app);
		appManager.close();
	}

	@After
	public void removeAPPDependencies() throws TransactionException {
		dom.removeDivisionOffice(office);
		pm.removeSignatory(signatory);
		pm.removeEmployee(employee);
		pm.removePerson(person);
	}
}
