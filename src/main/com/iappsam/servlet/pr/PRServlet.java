package com.iappsam.servlet.pr;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.iappsam.servlet.item.Action;
import com.iappsam.util.Managers;

@WebServlet("/pr")
public class PRServlet extends HttpServlet {

	private static final long serialVersionUID = 1617728781320146937L;
	public static final String NEW_PR_JSP = "/pr/new-pr.jsp";
	public static final String ADD_ITEM_JSP = "/pr/line/add-item.jsp";
	public static final String LIST_PR_JSP = null;
	public static final String VIEW_PR_JSP = "/pr/view-pr.jsp";

	private NewPRAction newPr;
	private AddingItemToPRAction addItem;
	private ListPRAction list;
	private RemoveItemFromPRAction removeItem;
	private AddPRAction addPr;
	private ViewPRAction viewPr;

	public PRServlet() {
		this(new ListPRAction(Managers.INSTANCE), new AddPRAction(Managers.INSTANCE, new PRFactory()), new NewPRAction(Managers.INSTANCE), //
				new AddingItemToPRAction(Managers.INSTANCE, new PRFactory()), new RemoveItemFromPRAction(Managers.INSTANCE, new PRFactory()), new ViewPRAction(Managers.INSTANCE));
	}

	public PRServlet(ListPRAction list, AddPRAction addPr, NewPRAction newPr, AddingItemToPRAction addItem, RemoveItemFromPRAction removeItem, ViewPRAction viewPr) {
		this.list = list;
		this.newPr = newPr;
		this.addItem = addItem;
		this.removeItem = removeItem;
		this.addPr = addPr;
		this.viewPr = viewPr;
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
		String idParam = request.getParameter("id");

		if (newParam != null)
			return newPr;
		else if (addItemParam != null)
			return addItem;
		else if (removeItemParam != null)
			return removeItem;
		else if (savePrParam != null)
			return addPr;
		else if (idParam != null)
			return viewPr;
		return list;
	}

}
