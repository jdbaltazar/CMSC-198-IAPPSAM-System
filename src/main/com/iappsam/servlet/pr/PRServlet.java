package com.iappsam.servlet.pr;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.iappsam.entities.forms.PurchaseRequest;
import com.iappsam.managers.DivisionOfficeManager;
import com.iappsam.managers.ItemManager;
import com.iappsam.managers.PersonManager;
import com.iappsam.managers.exceptions.TransactionException;
import com.iappsam.managers.sessions.DivisionOfficeManagerSession;
import com.iappsam.managers.sessions.PRManagerSession;
import com.iappsam.managers.sessions.PersonManagerSession;
import com.iappsam.servlet.item.Action;
import com.iappsam.util.Managers;

@WebServlet("/pr")
public class PRServlet extends HttpServlet {

	private static final long serialVersionUID = 1617728781320146937L;
	public static final String NEW_PR_JSP = "/pr/new-pr.jsp";
	public static final String ADD_ITEM_JSP = "/pr/line/add-item.jsp";
	public static final String LIST_PR_JSP = null;

	private Action newPr;
	private Action addItem;
	private Action list;
	private Action removeItem;
	private Action savePr;

	public PRServlet() {
		this(new ListPRAction(Managers.PR_MANAGER), new AddPRAction(Managers.PR_MANAGER, Managers.ITEM_MANAGER, Managers.DIVISION_OFFICE_MANAGER,
				Managers.PERSON_MANAGER), new NewPRAction(Managers.PERSON_MANAGER, Managers.DIVISION_OFFICE_MANAGER, Managers.ITEM_MANAGER), //
				new AddingItemToPRAction(Managers.ITEM_MANAGER, Managers.DIVISION_OFFICE_MANAGER, Managers.PERSON_MANAGER), new RemoveItemFromPRAction(
						Managers.ITEM_MANAGER, Managers.DIVISION_OFFICE_MANAGER, Managers.PERSON_MANAGER));
	}

	public PRServlet(ListPRAction list, AddPRAction addPr, NewPRAction newPr, AddingItemToPRAction addItem, RemoveItemFromPRAction removeItem) {
		this.list = list;
		this.newPr = newPr;
		this.addItem = addItem;
		this.removeItem = removeItem;
		this.savePr = addPr;
	}

	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		parseAction(request).process(request, response);
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		parseAction(req).process(req, resp);
	}

	private Action parseAction(HttpServletRequest request) {
		String newParam = request.getParameter("new");
		String addItemParam = request.getParameter("addItems");
		String removeItemParam = request.getParameter("removeItems");
		String savePrParam = request.getParameter("savePr");

		if (newParam != null)
			return newPr;
		else if (addItemParam != null)
			return addItem;
		else if (removeItemParam != null)
			return removeItem;
		else if (savePrParam != null)
			return savePr;
		return list;
	}

	public static PurchaseRequest createPR(HttpServletRequest request, ItemManager im, DivisionOfficeManager dom, PersonManager pm)
			throws TransactionException {

		PurchaseRequest pr = new PurchaseRequest();

		String divisionOfficeId = request.getParameter("deptAndSection");
		if (divisionOfficeId != null)
			pr.setDivisionOffice(dom.getDivisionOffice(Integer.parseInt(divisionOfficeId)));

		pr.setPrNumber(request.getParameter("prNumber"));
		pr.setPrDate(request.getParameter("prDate"));
		pr.setSaiNumber(request.getParameter("saiNumber"));
		pr.setSaiDate(request.getParameter("saiDate"));
		pr.setAlobsNumber(request.getParameter("alobsNumber"));
		pr.setAlobsDate(request.getParameter("alobsDate"));
		pr.setPurpose(request.getParameter("purpose"));

		String reqId = request.getParameter("requestedBy");
		if (reqId != null)
			pr.setRequestedBy(pm.getEmployee(Integer.parseInt(reqId)));

		String aprid = request.getParameter("approvedby");
		if (aprid != null)
			pr.setApprovedBy(pm.getEmployee(Integer.parseInt(aprid)));

		String[] quantities = request.getParameterValues("quantity");
		String[] items = request.getParameterValues("items");

		if (items != null)
			for (int i = 0; i < items.length; i++) {
				String q = null;
				if (quantities != null)
					q = quantities[i];
				if (q == null)
					q = "0";
				pr.addLine(Integer.parseInt(q), im.getItem(Integer.parseInt(items[i])));
			}

		return pr;
	}
}
