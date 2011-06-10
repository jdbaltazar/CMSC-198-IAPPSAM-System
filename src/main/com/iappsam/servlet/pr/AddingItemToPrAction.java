package com.iappsam.servlet.pr;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.iappsam.entities.forms.PurchaseRequest;
import com.iappsam.managers.PersonManager;
import com.iappsam.managers.sessions.PersonManagerSession;
import com.iappsam.servlet.item.Action;

public class AddingItemToPrAction implements Action {

	private PersonManager pm;

	public AddingItemToPrAction(PersonManager personManagerSession) {
		this.pm = personManagerSession;
	}

	@Override
	public void process(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.getRequestDispatcher(PurchaseRequestServlet.ADD_ITEM_JSP).forward(request, response);
	}
}
