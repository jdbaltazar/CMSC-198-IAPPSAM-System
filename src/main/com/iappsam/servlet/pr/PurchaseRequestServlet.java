package com.iappsam.servlet.pr;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.iappsam.servlet.item.Action;

@WebServlet("/pr")
public class PurchaseRequestServlet extends HttpServlet {

	private static final long serialVersionUID = 1617728781320146937L;
	public static final String NEW_PR_JSP = "/pr/new-pr.jsp";
	public static final String ADD_ITEM_JSP = "/pr/add-item.jsp";

	private Action newPr = new NewPurchaseRequestAction();
	private Action addItem = new AddItemToPrAction();

	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		parseAction(request).process(request, response);
	}

	private Action parseAction(HttpServletRequest request) {
		String newParam = request.getParameter(PurchaseRequestParam.NEW);
		String addItemParam = request.getParameter(PurchaseRequestParam.ADD);

		if (newParam != null && newParam.equals("pr"))
			return newPr;
		else if (addItemParam != null && addItemParam.equals("item"))
			return addItem ;
		else
			return EmptyAction.INSTANCE;
	}
}
