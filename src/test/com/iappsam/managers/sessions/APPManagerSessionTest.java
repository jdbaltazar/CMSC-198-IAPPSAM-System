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

	private Person p;
	private Employee e;
	private Signatory s;
	private DivisionOffice office;

	@Before
	public void addAPPDepedencies() throws TransactionException, DuplicateEntryException {
		p = new Person("John");
		pm = new PersonManagerSession();
		pm.addPerson(p);

		e = new Employee("Mayor", p);
		pm.addEmployee(e);

		s = new Signatory("Signatory", e.getId());
		pm.addSignatory(s);

		office = new DivisionOffice("Division", "Office");

		dom = new DivisionOfficeManagerSession();
		dom.addDivisionOffice(office);
	}

	@Test
	public void addAPP() throws TransactionException, DuplicateEntryException {

		addAPPDepedencies();

		AnnualProcurementPlan app = new AnnualProcurementPlan(2011, office, s, s);

		APPManager appManager = new APPManagerSession();
		appManager.addAPP(app);

		assertTrue(appManager.containsAPP(app));
		removeAPP(app);
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
		addAPPDepedencies();

		AnnualProcurementPlan app = new AnnualProcurementPlan(2011, office, s, s);

		APPManager appManager = new APPManagerSession();
		appManager.addAPP(app);

		assertTrue(appManager.containsAPP(app));
		removeAPP(app);
	}

	@After
	public void removeAPPDependencies() throws TransactionException {

		Session session = HibernateUtil.startSession();
		Transaction tx = session.beginTransaction();

		try {
			dom.removeDivisionOffice(office);
			session.delete(s);
			pm.removeEmployee(e);
			pm.removePerson(p);
			tx.commit();
		} catch (Exception e) {
			tx.rollback();
			throw new TransactionException(e.getMessage());
		} finally {
			session.close();
		}
	}
}
