package com.iappsam.servlet.pr;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;

import org.junit.Before;
import org.junit.Test;
import org.mockito.Mock;

import com.iappsam.DivisionOffice;
import com.iappsam.Employee;
import com.iappsam.Item;
import com.iappsam.forms.Form;
import com.iappsam.forms.PR;
import com.iappsam.managers.DivisionOfficeManager;
import com.iappsam.managers.ItemManager;
import com.iappsam.managers.PRManager;
import com.iappsam.managers.PersonManager;
import com.iappsam.managers.exceptions.TransactionException;
import com.iappsam.servlet.ServletTestCase;
import com.iappsam.servlet.form.AddFormAction;
import com.iappsam.servlet.form.ExportPdfAction;
import com.iappsam.servlet.form.ExportXlsAction;
import com.iappsam.servlet.form.FormLinePageAction;
import com.iappsam.servlet.form.FormServlet;
import com.iappsam.servlet.form.FormUtility;
import com.iappsam.servlet.form.ListFormAction;
import com.iappsam.servlet.form.NewFormPageAction;
import com.iappsam.servlet.form.RemoveFormLineAction;
import com.iappsam.servlet.form.ViewFormAction;

import static org.mockito.BDDMockito.*;

public class PRServletTest extends ServletTestCase {

	private FormServlet servlet;

	@Mock
	private FormLinePageAction addItem;
	@Mock
	private NewFormPageAction newPurchase;
	@Mock
	private ListFormAction listPR;
	@Mock
	private RemoveFormLineAction removeItems;
	@Mock
	private AddFormAction addPr;
	@Mock
	private ViewFormAction viewPr;
	@Mock
	private ExportPdfAction exportPdf;
	@Mock
	private ExportXlsAction exportXls;

	private FormUtility utility;

	@Mock
	private PRParser parser;

	@Override
	@Before
	public void init() {
		super.init();
		utility = new PRUtility("pr", appContext, parser);
		servlet = new FormServlet(newPurchase, addItem, listPR, removeItems, addPr, viewPr, exportPdf, exportXls);
	}

	@Test
	public void listPurchaseRequest() throws ServletException, IOException {
		servlet.doGet(request, response);
		verify(listPR).process(request, response);
	}

	@Test
	public void processListPurchaseRequest() throws ServletException, IOException, TransactionException {
		givenRequestDispatcher("/pr/list-pr.jsp");

		new ListFormAction(utility).process(request, response);

		verify(request).setAttribute(eq("forms"), any(List.class));
		verifyForwardedTo("/pr/list-pr.jsp");
	}

	@Test
	public void newPurchaseRequest() throws ServletException, IOException, TransactionException {
		givenParam("new", "pr");
		servlet.doGet(request, response);
		verify(newPurchase).process(request, response);
	}

	@Test
	public void processNewPurchaseRequest() throws ServletException, IOException, TransactionException {
		givenRequestDispatcher("/pr/new-pr.jsp");
		ArrayList<Employee> emps = new ArrayList<Employee>();
		given(pm.getAllEmployee()).willReturn(emps);
		ArrayList<DivisionOffice> offices = new ArrayList<DivisionOffice>();
		given(dom.getAllDivisionOffice()).willReturn(offices);

		new NewFormPageAction(utility).process(request, response);

		verify(request).setAttribute("employees", emps);
		verify(request).setAttribute("offices", offices);
		verifyForwardedTo("/pr/new-pr.jsp");
	}

	@Test
	public void addPurchaseRequest() throws ServletException, IOException {
		givenParam("saveForm", "");
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

		// given valid PR from PRParser
		Form pr = mock(PR.class);
		given(pr.validate()).willReturn(true);
		given(parser.createForm(request, appContext)).willReturn(pr);

		new AddFormAction(utility).process(request, response);

		verify(prm).addPR(any(PR.class));
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
		PR pr = mock(PR.class);
		given(parser.createForm(request, appContext)).willReturn(pr);

		new RemoveFormLineAction(utility).process(request, response);

		verify(session).setAttribute(eq("form"), any(PR.class));
		verify(response).sendRedirect("/pr?new=pr");
	}

	@Test
	public void processNewPurchaseRequestFromNewItem() throws ServletException, IOException, TransactionException {
		ArrayList<Employee> emps = new ArrayList<Employee>();
		given(pm.getAllEmployee()).willReturn(emps);

		ArrayList<DivisionOffice> offices = new ArrayList<DivisionOffice>();
		given(dom.getAllDivisionOffice()).willReturn(offices);

		givenRequestDispatcher("/pr/new-pr.jsp");

		new NewFormPageAction(utility).process(request, response);

		verify(request).setAttribute("offices", offices);
		verify(request).setAttribute("employees", emps);
		verifyForwardedTo("/pr/new-pr.jsp");
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
		// given pr with id=1
		PR pr = new PR();
		given(prm.getPR(1)).willReturn(pr);

		givenRequestDispatcher("/pr/view-pr.jsp");

		new ViewFormAction(utility).process(request, response);

		verify(request).setAttribute(eq("form"), eq(pr));
		verifyForwardedTo("/pr/view-pr.jsp");
	}

	@Test
	public void shouldRedirectToPRListWhenPRDoesNotExist() throws ServletException, IOException {
		givenParam("id", "1");
		givenRequestDispatcher("/pr/view-pr.jsp");

		new ViewFormAction(utility).process(request, response);

		verify(response).sendRedirect(eq("/pr"));
	}

	@Test
	public void shouldRedirectToPRListWhenIDParamNotInteger() throws ServletException, IOException {
		givenParam("id", ".");
		givenRequestDispatcher("/pr/view-pr.jsp");

		new ViewFormAction(utility).process(request, response);

		verify(response).sendRedirect(eq("/pr"));
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

		new FormLinePageAction(utility).process(request, response);

		verify(session).setAttribute(eq("form"), any(PR.class));
		verify(response).sendRedirect("/pr/line");
	}

	@Test
	public void exportToPdf() {

	}
}
