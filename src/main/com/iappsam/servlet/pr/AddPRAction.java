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

	public AddPRAction(PRManager prm, ItemManager im, DivisionOfficeManager dom, PersonManager pm) {
		super();
		this.prm = prm;
		this.im = im;
		this.dom = dom;
		this.pm = pm;
	}

	@Override
	public void process(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		try {
			PurchaseRequest pr = PRServlet.createPR(request, im, dom, pm);
			prm.addPR(pr);
			response.sendRedirect("/pr?id=" + pr.getId());
		} catch (TransactionException e) {
			e.printStackTrace();
		}
	}
}
