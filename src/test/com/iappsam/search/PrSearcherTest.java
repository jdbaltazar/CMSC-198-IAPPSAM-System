package com.iappsam.search;

import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.List;

import org.junit.Before;
import org.junit.Test;

import com.iappsam.DivisionOffice;
import com.iappsam.Employee;
import com.iappsam.Item;
import com.iappsam.entities.EntityRemover;
import com.iappsam.forms.PR;
import com.iappsam.managers.PersonManager;
import com.iappsam.managers.exceptions.DuplicateEntryException;
import com.iappsam.managers.exceptions.TransactionException;
import com.iappsam.managers.sessions.DivisionOfficeManagerSession;
import com.iappsam.managers.sessions.ItemManagerSession;
import com.iappsam.managers.sessions.PRManagerSession;
import com.iappsam.managers.sessions.PersonManagerSession;

public class PrSearcherTest {

	private PrSearcher searcher;
	private PR pr;

	@Before
	public void init() throws TransactionException, DuplicateEntryException {

		EntityRemover.removeAll();

		DivisionOffice dof = new DivisionOffice("dnsm", "lecture room");
		new DivisionOfficeManagerSession().addDivisionOffice(dof);

		Employee requestedBy = Employee.create("mayor", "john");
		Employee approvedBy = Employee.create("vicemayor", "peter");
		PersonManager pm = new PersonManagerSession();
		pm.addEmployee(requestedBy);
		pm.addEmployee(approvedBy);

		pr = new PR(dof, "purp", requestedBy, approvedBy);

		Item item = Item.create("des", "cat", "unit", "stat", "cond");
		new ItemManagerSession().addItem(item);

		pr.addLine(10, item);
		new PRManagerSession().addPR(pr);

		searcher = new PrSearcher();
	}

	@Test
	public void shouldSearchRequestedByName() {
		List<PR> result = searcher.search("john");

		ArrayList<PR> exp = new ArrayList<PR>();
		exp.add(pr);

		assertEquals(exp, result);
	}

	@Test
	public void shouldSearchApprovedByName() {
		List<PR> result = searcher.search("peter");

		ArrayList<PR> exp = new ArrayList<PR>();
		exp.add(pr);

		assertEquals(exp, result);
	}
}
