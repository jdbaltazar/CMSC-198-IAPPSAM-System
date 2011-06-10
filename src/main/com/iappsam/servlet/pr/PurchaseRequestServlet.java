package com.iappsam.servlet.pr;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.iappsam.managers.sessions.DivisionOfficeManagerSession;
import com.iappsam.managers.sessions.PRManagerSession;
import com.iappsam.managers.sessions.PersonManagerSession;
import com.iappsam.servlet.item.Action;
import com.iappsam.util.Managers;

@WebServlet("/pr")
public class PurchaseRequestServlet extends HttpServlet {

	private static final long serialVersionUID = 1617728781320146937L;
	public static final String NEW_PR_JSP = "/pr/new-pr.jsp";
	public static final String ADD_ITEM_JSP = "/pr/add-item.jsp";
	public static final String LIST_PR_JSP = null;

	private Action newPr;
	private Action addItem;
	private Action list;

	public PurchaseRequestServlet() {
		this(new ListPurchaseRequestAction(Managers.PR_MANAGER), //
				new NewPurchaseRequestAction(Managers.PERSON_MANAGER, Managers.DIVISION_OFFICE_MANAGER), //
				new AddingItemToPrAction(Managers.PERSON_MANAGER));
	}

	public PurchaseRequestServlet(ListPurchaseRequestAction list, NewPurchaseRequestAction newPr, AddingItemToPrAction addItem) {
		this.list = list;
		this.newPr = newPr;
		this.addItem = addItem;
	}

	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		parseAction(request).process(request, response);
	}

	private Action parseAction(HttpServletRequest request) {
		String newParam = request.getParameter("new");
		String addItemParam = request.getParameter("add");

		if (newParam != null && newParam.equals("pr"))
			return newPr;
		else if (addItemParam != null && addItemParam.equals("item"))
			return addItem;
		else
			return list;
	}
}
