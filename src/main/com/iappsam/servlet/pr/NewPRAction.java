package com.iappsam.servlet.pr;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.iappsam.entities.Item;
import com.iappsam.managers.DivisionOfficeManager;
import com.iappsam.managers.ItemManager;
import com.iappsam.managers.PersonManager;
import com.iappsam.managers.exceptions.TransactionException;
import com.iappsam.servlet.item.Action;
import com.iappsam.util.Managers;

public class NewPRAction implements Action {

	private PersonManager pm;
	private DivisionOfficeManager dom;
	private ItemManager im;

	public NewPRAction(Managers m) {
		this.dom = m.getDivisionOfficeManager();
		this.pm = m.getPersonManager();
		this.im = m.getItemManager();
	}

	@Override
	public void process(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		try {
			List<Item> items = (List<Item>) request.getSession().getAttribute("items");

			if (items == null) {
				items = new ArrayList<Item>();
				request.setAttribute("items", items);
				request.getSession().setAttribute("quantity", new ArrayList<String>(items.size()));
			}

			request.setAttribute("itemsDb", im.getAllItems());
			request.setAttribute("employees", pm.getAllEmployee());
			request.setAttribute("offices", dom.getAllDivisionOffice());
			request.getRequestDispatcher(PRServlet.NEW_PR_JSP).forward(request, response);
		} catch (TransactionException e) {
			e.printStackTrace();
		}
	}
}
