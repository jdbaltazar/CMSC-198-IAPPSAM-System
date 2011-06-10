package com.iappsam.servlet.pr;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.iappsam.managers.DivisionOfficeManager;
import com.iappsam.managers.PersonManager;
import com.iappsam.managers.exceptions.TransactionException;
import com.iappsam.servlet.item.Action;

public class NewPurchaseRequestAction implements Action {

	private PersonManager pm;
	private DivisionOfficeManager dom;

	public NewPurchaseRequestAction(PersonManager pm, DivisionOfficeManager dom) {
		this.dom = dom;
		this.pm = pm;
	}

	@Override
	public void process(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		try {
			request.setAttribute("employees", pm.getAllEmployee());
			request.setAttribute("offices", dom.getAllDivisionOffice());
			request.getRequestDispatcher(PurchaseRequestServlet.NEW_PR_JSP).forward(request, response);
		} catch (TransactionException e) {
			e.printStackTrace();
		}
	}
}
