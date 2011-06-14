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
import com.iappsam.util.Managers;

public class RemoveItemFromPRAction implements Action {

	private ItemManager im;
	private DivisionOfficeManager dom;
	private PersonManager pm;
	private PRFactory factory;

	public RemoveItemFromPRAction(Managers m, PRFactory factory) {
		super();
		this.im = m.getItemManager();
		this.dom = m.getDivisionOfficeManager();
		this.pm = m.getPersonManager();
		this.factory = factory;
	}

	@Override
	public void process(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		try {
			String[] indexesToRemove = request.getParameterValues("checkedItems");

			if (indexesToRemove != null) {
				PurchaseRequest pr = factory.createPR(request, im, dom, pm);
				request.getSession().setAttribute("form", pr);
				for (String i : indexesToRemove)
					pr.removeLine(Integer.parseInt(i));
			}
			response.sendRedirect("/pr?new=pr");
		} catch (TransactionException e) {
			e.printStackTrace();
		}
	}
}
