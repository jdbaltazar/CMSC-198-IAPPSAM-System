package com.iappsam.servlet.pr;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.iappsam.forms.PR;
import com.iappsam.managers.DivisionOfficeManager;
import com.iappsam.managers.ItemManager;
import com.iappsam.managers.PersonManager;
import com.iappsam.managers.exceptions.TransactionException;
import com.iappsam.servlet.item.Action;
import com.iappsam.util.ApplicationContext;

public class AddingItemToPRAction implements Action {

	private ItemManager im;
	private DivisionOfficeManager dom;
	private PersonManager pm;
	private PRFactory factory;

	public AddingItemToPRAction(ApplicationContext m, PRFactory factory) {
		super();
		this.im = m.getItemManager();
		this.dom = m.getDivisionOfficeManager();
		this.pm = m.getPersonManager();
		this.factory = factory;
	}

	@Override
	public void process(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		try {
			PR pr = factory.createPR(request, im, dom, pm);
			request.getSession().setAttribute("form", pr);
			response.sendRedirect("/pr/line");
		} catch (TransactionException e) {
			e.printStackTrace();
		}
	}
}
