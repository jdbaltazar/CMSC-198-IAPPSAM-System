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
public class PRServlet extends HttpServlet {

	private static final long serialVersionUID = 1617728781320146937L;
	public static final String NEW_PR_JSP = "/pr/new-pr.jsp";
	public static final String ADD_ITEM_JSP = "/pr/line/add-item.jsp";
	public static final String LIST_PR_JSP = null;

	private Action newPr;
	private Action addItem;
	private Action list;
	private Action removeItem;

	public PRServlet() {
		this(new ListPRAction(Managers.PR_MANAGER), //
				new NewPRAction(Managers.PERSON_MANAGER, Managers.DIVISION_OFFICE_MANAGER, Managers.ITEM_MANAGER), //
				new AddingItemToPRAction(Managers.ITEM_MANAGER, Managers.DIVISION_OFFICE_MANAGER, Managers.PERSON_MANAGER), new RemoveItemFromPRAction(Managers.ITEM_MANAGER,
						Managers.DIVISION_OFFICE_MANAGER, Managers.PERSON_MANAGER));
	}

	public PRServlet(ListPRAction list, NewPRAction newPr, AddingItemToPRAction addItem, RemoveItemFromPRAction removeItem) {
		this.list = list;
		this.newPr = newPr;
		this.addItem = addItem;
		this.removeItem = removeItem;
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

		if (newParam != null)
			return newPr;
		else if (addItemParam != null)
			return addItem;
		else if (removeItemParam != null)
			return removeItem;
		else
			return list;
	}
}
