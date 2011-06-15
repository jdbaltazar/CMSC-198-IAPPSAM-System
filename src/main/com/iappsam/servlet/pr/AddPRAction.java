package com.iappsam.servlet.pr;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.iappsam.forms.PR;
import com.iappsam.managers.DivisionOfficeManager;
import com.iappsam.managers.ItemManager;
import com.iappsam.managers.PRManager;
import com.iappsam.managers.PersonManager;
import com.iappsam.managers.exceptions.TransactionException;
import com.iappsam.servlet.item.Action;
import com.iappsam.util.ApplicationContext;

public class AddPRAction implements Action {

	private PRManager prm;
	private ItemManager im;
	private DivisionOfficeManager dom;
	private PersonManager pm;
	private PRFactory factory;

	public AddPRAction(ApplicationContext m, PRFactory factory) {
		super();
		this.prm = m.getPRManager();
		this.im = m.getItemManager();
		this.dom = m.getDivisionOfficeManager();
		this.pm = m.getPersonManager();
		this.factory = factory;
	}

	@Override
	public void process(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		try {
			PR pr = factory.createPR(request, im, dom, pm);
			if (pr.validate()) {
				prm.addPR(pr);
				response.sendRedirect("/pr?id=" + pr.getId());
			} else
				response.sendRedirect("/pr?new=pr");
		} catch (TransactionException e) {
			e.printStackTrace();
		}
	}
}
