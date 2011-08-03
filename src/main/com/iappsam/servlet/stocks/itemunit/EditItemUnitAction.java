package com.iappsam.servlet.stocks.itemunit;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.iappsam.Unit;
import com.iappsam.managers.exceptions.TransactionException;
import com.iappsam.servlet.Action;
import com.iappsam.util.ApplicationContext;

public class EditItemUnitAction implements Action {

	@Override
	public void process(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("inside edititemunit.java");

		int itemUnitID = Integer.parseInt(request.getParameter("itemUnitID"));
		Unit unit = new Unit();
		RequestDispatcher edit = request.getRequestDispatcher(ItemUnitServlet.EDIT_ITEM_UNIT);
		try {
			unit = ApplicationContext.INSTANCE.getItemManager().getUnit(itemUnitID);
		} catch (TransactionException e) {
			e.printStackTrace();
		}

		request.setAttribute("itemUnit", unit);
		edit.forward(request, response);
	}

}
