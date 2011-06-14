package com.iappsam.servlet.pr;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.iappsam.entities.forms.PurchaseRequest;
import com.iappsam.managers.DivisionOfficeManager;
import com.iappsam.managers.ItemManager;
import com.iappsam.managers.PRManager;
import com.iappsam.managers.PersonManager;
import com.iappsam.managers.exceptions.TransactionException;
import com.iappsam.servlet.item.Action;

public class AddPRAction implements Action {

	private PRManager prm;
	private ItemManager im;
	private DivisionOfficeManager dom;
	private PersonManager pm;
	private PRFactory factory;

	public AddPRAction(PRManager prm, ItemManager im, DivisionOfficeManager dom, PersonManager pm, PRFactory factory) {
		super();
		this.prm = prm;
		this.im = im;
		this.dom = dom;
		this.pm = pm;
		this.factory = factory;
	}

	@Override
	public void process(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		try {
			PurchaseRequest pr = factory.createPR(request, im, dom, pm);
			if (pr.isValid()) {
				prm.addPR(pr);
				response.sendRedirect("/pr?id=" + pr.getId());
			} else
				response.sendRedirect("/pr?new=pr");
		} catch (TransactionException e) {
			e.printStackTrace();
		}
	}
}
