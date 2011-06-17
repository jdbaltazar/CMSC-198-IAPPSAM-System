package com.iappsam.servlet.pr;

import javax.servlet.http.HttpServletRequest;

import com.iappsam.managers.DivisionOfficeManager;
import com.iappsam.managers.ItemManager;
import com.iappsam.managers.PersonManager;
import com.iappsam.managers.exceptions.TransactionException;
import com.iappsam.servlet.form.NewFormPageAction;
import com.iappsam.util.ApplicationContext;

public class NewPRPageAction extends NewFormPageAction {

	private PersonManager pm;
	private DivisionOfficeManager dom;
	private ItemManager im;

	public NewPRPageAction(ApplicationContext m) {
		this.dom = m.getDivisionOfficeManager();
		this.pm = m.getPersonManager();
		this.im = m.getItemManager();
	}

	@Override
	protected String getNewFormJsp() {
		return PRServlet.NEW_PR_JSP;
	}

	@Override
	protected void beforeForward(HttpServletRequest request) throws TransactionException {
		request.setAttribute("itemsDb", im.getAllItems());
		request.setAttribute("employees", pm.getAllEmployee());
		request.setAttribute("offices", dom.getAllDivisionOffice());
	}
}
