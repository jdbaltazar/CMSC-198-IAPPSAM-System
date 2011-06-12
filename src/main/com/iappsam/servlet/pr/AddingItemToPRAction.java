package com.iappsam.servlet.pr;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.iappsam.entities.forms.PurchaseRequest;
import com.iappsam.managers.DivisionOfficeManager;
import com.iappsam.managers.ItemManager;
import com.iappsam.managers.PersonManager;
import com.iappsam.managers.exceptions.TransactionException;
import com.iappsam.servlet.item.Action;

public class AddingItemToPRAction implements Action {

	private ItemManager im;
	private DivisionOfficeManager dom;
	private PersonManager pm;

	public AddingItemToPRAction(ItemManager im, DivisionOfficeManager dom, PersonManager pm) {
		super();
		this.im = im;
		this.dom = dom;
		this.pm = pm;
	}

	@Override
	public void process(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		try {
			PurchaseRequest pr = PurchaseRequest.create(request, im, dom, pm);
			request.getSession().setAttribute("form", pr);
			response.sendRedirect("/pr/line");
		} catch (TransactionException e) {
			e.printStackTrace();
		}
	}
}
