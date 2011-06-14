package com.iappsam.servlet.pr;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;

import org.junit.Before;
import org.junit.Test;
import org.mockito.Mock;

import com.iappsam.entities.DivisionOffice;
import com.iappsam.entities.Employee;
import com.iappsam.entities.Item;
import com.iappsam.entities.forms.PurchaseRequest;
import com.iappsam.managers.DivisionOfficeManager;
import com.iappsam.managers.ItemManager;
import com.iappsam.managers.PRManager;
import com.iappsam.managers.PersonManager;
import com.iappsam.managers.exceptions.TransactionException;
import com.iappsam.servlet.ServletTestCase;

import static org.mockito.BDDMockito.*;

public class PRServletTest extends ServletTestCase {

	private PRServlet servlet;

	@Mock
	private AddingItemToPRAction addItem;
	@Mock
	private NewPRAction newPurchase;
	@Mock
	private ListPRAction listPR;
	@Mock
	private PersonManager pm;
	@Mock
	private PRManager prm;
	@Mock
	private DivisionOfficeManager dom;
	@Mock
	private ItemManager im;
	@Mock
	private RemoveItemFromPRAction removeItems;
	@Mock
	private AddPRAction addPr;
	@Mock
	private ViewPRAction viewPr;
	@Mock
	private PRFactory factory;

	private PurchaseRequest pr;

	@Override
	@Before
	public void init() {
		super.init();
		servlet = new PRServlet(listPR, addPr, newPurchase, addItem, removeItems, viewPr);
	}

	@Test
	public void listPurchaseRequest() throws ServletException, IOException {
		servlet.doGet(request, response);
		verify(listPR).process(request, response);
	}

	@Test
	public void processListPurchaseRequest() throws ServletException, IOException, TransactionException {
		givenRequestDispatcher(PRServlet.LIST_PR_JSP);
		ArrayList<PurchaseRequest> prs = new ArrayList<PurchaseRequest>();
		given(prm.getAllPR()).willReturn(prs);

		new ListPRAction(prm).process(request, response);

		verify(request).setAttribute("PRs", prs);
		verifyForwardedTo(PRServlet.LIST_PR_JSP);
	}

	@Test
	public void newPurchaseRequest() throws ServletException, IOException, TransactionException {
		givenParam("new", "pr");
		servlet.doGet(request, response);
		verify(newPurchase).process(request, response);
	}

	@Test
	public void processNewPurchaseRequest() throws ServletException, IOException, TransactionException {
		givenRequestDispatcher(PRServlet.NEW_PR_JSP);
		ArrayList<Employee> emps = new ArrayList<Employee>();
		given(pm.getAllEmployee()).willReturn(emps);
		ArrayList<DivisionOffice> offices = new ArrayList<DivisionOffice>();
		given(dom.getAllDivisionOffice()).willReturn(offices);

		new NewPRAction(pm, dom, im).process(request, response);

		verify(request).setAttribute("employees", emps);
		verify(request).setAttribute("offices", offices);
		verifyForwardedTo(PRServlet.NEW_PR_JSP);
	}

	@Test
	public void addPurchaseRequest() throws ServletException, IOException {
		givenParam("savePr", "");
		servlet.doPost(request, response);
		verify(addPr).process(request, response);
	}

	@Test
	public void processAddPurchaseRequest() throws ServletException, IOException, TransactionException {
		givenParam("deptAndSection", "1");
		givenParam("purpose", "purpose");
		givenParam("requestedBy", "1");
		givenParam("approvedby", "2");
		givenParams("quantity", new String[] { "1" });
		givenParams("items", new String[] { "1" });
		// given valid PR from factory
		PurchaseRequest pr = mock(PurchaseRequest.class);
		given(pr.isValid()).willReturn(true);
		given(factory.createPR(request, im, dom, pm)).willReturn(pr);

		new AddPRAction(prm, im, dom, pm, factory).process(request, response);

		verify(prm).addPR(any(PurchaseRequest.class));
		verify(response).sendRedirect(startsWith("/pr?id="));
	}

	@Test
	public void removeItems() throws ServletException, IOException {
		givenParam("removeItems", "");
		servlet.doPost(request, response);
		verify(removeItems).process(request, response);
	}

	@Test
	public void processRemoveItems() throws ServletException, IOException, TransactionException {
		givenParams("checkedItems", new String[] { "0" });
		// given valid PR from factory
		PurchaseRequest pr = mock(PurchaseRequest.class);
		given(factory.createPR(request, im, dom, pm)).willReturn(pr);

		new RemoveItemFromPRAction(im, dom, pm, factory).process(request, response);

		verify(session).setAttribute(eq("form"), any(PurchaseRequest.class));
		verify(response).sendRedirect("/pr?new=pr");
	}

	@Test
	public void processNewPurchaseRequestFromNewItem() throws ServletException, IOException, TransactionException {
		ArrayList<Employee> emps = new ArrayList<Employee>();
		given(pm.getAllEmployee()).willReturn(emps);

		ArrayList<DivisionOffice> offices = new ArrayList<DivisionOffice>();
		given(dom.getAllDivisionOffice()).willReturn(offices);

		givenRequestDispatcher(PRServlet.NEW_PR_JSP);

		new NewPRAction(pm, dom, im).process(request, response);

		verify(request).setAttribute("offices", offices);
		verify(request).setAttribute("employees", emps);
		verifyForwardedTo(PRServlet.NEW_PR_JSP);
	}

	@Test
	public void viewPr() throws ServletException, IOException {
		givenParam("id", "1");
		servlet.doGet(request, response);
		verify(viewPr).process(request, response);
	}

	@Test
	public void processViewPR() throws TransactionException, ServletException, IOException {
		givenParam("id", "1");
		PurchaseRequest pr = new PurchaseRequest();
		given(prm.getPR(1)).willReturn(pr);
		givenRequestDispatcher(PRServlet.VIEW_PR_JSP);
		new ViewPRAction(prm).process(request, response);
		verify(request).setAttribute(eq("form"), eq(pr));
		verifyForwardedTo(PRServlet.VIEW_PR_JSP);
	}

	@Test
	public void addingItem() throws ServletException, IOException {
		givenParam("addItems", "");
		servlet.doPost(request, response);
		verify(addItem).process(request, response);
	}

	@Test
	public void processAddingItem() throws ServletException, IOException, TransactionException {
		givenParam("deptAndSection", "1");
		givenParam("prNumber", "prNumber");
		givenParam("prDate", "2011-01-01");
		givenParam("saiNumber", "saiNumber");
		givenParam("saiDate", "2011-01-02");
		givenParam("alobsNumber", "alobsNumber");
		givenParam("alobsDate", "2011-01-03");
		givenParam("purpose", "purpose");
		givenParam("requestedBy", "1");
		givenParam("approvedby", "2");
		givenParams("quantity", new String[] { "1" });
		givenParams("items", new String[] { "1" });

		given(dom.getDivisionOffice(1)).willReturn(new DivisionOffice());
		given(pm.getEmployee(1)).willReturn(new Employee());
		given(pm.getEmployee(2)).willReturn(new Employee());
		given(im.getItem(1)).willReturn(new Item());

		new AddingItemToPRAction(im, dom, pm, factory).process(request, response);

		verify(session).setAttribute(eq("form"), any(PurchaseRequest.class));
		verify(response).sendRedirect("/pr/line");
	}

}