package com.iappsam.servlet.pr;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;

import org.junit.Before;
import org.junit.Test;
import org.mockito.Mock;

import com.iappsam.entities.DivisionOffice;
import com.iappsam.entities.Employee;
import com.iappsam.entities.forms.PurchaseRequest;
import com.iappsam.managers.DivisionOfficeManager;
import com.iappsam.managers.PRManager;
import com.iappsam.managers.PersonManager;
import com.iappsam.managers.exceptions.TransactionException;
import com.iappsam.servlet.item.ServletTestCase;

import static org.mockito.BDDMockito.*;

public class PurchaseRequestServletTest extends ServletTestCase {

	private PurchaseRequestServlet prServlet;

	@Mock
	private AddingItemToPrAction addItem;
	@Mock
	private NewPurchaseRequestAction newPurchase;
	@Mock
	private ListPurchaseRequestAction listPR;
	@Mock
	private PersonManager pm;
	@Mock
	private PRManager prm;
	@Mock
	private DivisionOfficeManager dom;

	@Before
	public void init() {
		prServlet = new PurchaseRequestServlet(listPR, newPurchase, addItem);
	}

	@Test
	public void listPurchaseRequest() throws ServletException, IOException {
		prServlet.doGet(request, response);
		verify(listPR).process(request, response);
	}

	@Test
	public void newPurchaseRequest() throws ServletException, IOException, TransactionException {
		givenParam("new", "pr");
		prServlet.doGet(request, response);
		verify(newPurchase).process(request, response);
	}

	@Test
	public void addItem() throws ServletException, IOException {
		givenParam("add", "item");
		prServlet.doGet(request, response);
		verify(addItem).process(request, response);
	}

	@Test
	public void processNewPurchaseRequest() throws ServletException, IOException, TransactionException {
		givenRequestDispatcher(PurchaseRequestServlet.NEW_PR_JSP, dispatcher);
		ArrayList<Employee> emps = new ArrayList<Employee>();
		given(pm.getAllEmployee()).willReturn(emps);
		ArrayList<DivisionOffice> offices = new ArrayList<DivisionOffice>();
		given(dom.getAllDivisionOffice()).willReturn(offices);

		new NewPurchaseRequestAction(pm, dom).process(request, response);

		verify(request).setAttribute("employees", emps);
		verify(request).setAttribute("offices", offices);
		verifyForwardedTo(PurchaseRequestServlet.NEW_PR_JSP);
	}

	@Test
	public void processAddingItem() throws ServletException, IOException {
		givenRequestDispatcher(PurchaseRequestServlet.ADD_ITEM_JSP, dispatcher);
		new AddingItemToPrAction(pm).process(request, response);
		verifyForwardedTo(PurchaseRequestServlet.ADD_ITEM_JSP);
	}

	@Test
	public void processListPurchaseRequest() throws ServletException, IOException, TransactionException {
		givenRequestDispatcher(PurchaseRequestServlet.LIST_PR_JSP, dispatcher);
		ArrayList<PurchaseRequest> prs = new ArrayList<PurchaseRequest>();
		given(prm.getAllPR()).willReturn(prs);

		new ListPurchaseRequestAction(prm).process(request, response);

		verify(request).setAttribute("PRs", prs);
		verifyForwardedTo(PurchaseRequestServlet.LIST_PR_JSP);
	}
}
