package com.iappsam.servlet.entities;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.iappsam.Unit;
import com.iappsam.managers.exceptions.TransactionException;
import com.iappsam.servlet.Action;
import com.iappsam.util.ApplicationContext;

public class ViewItemUnitsAction implements Action{

	@Override
	public void process(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException, TransactionException {
		RequestDispatcher view = request.getRequestDispatcher(StockPropertiesServlet.VIEW_ITEM_UNITS);

		List<Unit> units = new ArrayList<Unit>();

		try {
			units = ApplicationContext.INSTANCE.getItemManager().getAllUnits();
		} catch (TransactionException e) {
			e.printStackTrace();
		}
		request.setAttribute("itemUnits", units);
		view.forward(request, response);
	}
}
