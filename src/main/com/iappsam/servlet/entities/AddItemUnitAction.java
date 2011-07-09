package com.iappsam.servlet.entities;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.iappsam.managers.exceptions.TransactionException;
import com.iappsam.servlet.Action;

public class AddItemUnitAction implements Action{

	@Override
	public void process(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException, TransactionException {
		RequestDispatcher add = request.getRequestDispatcher(StockPropertiesServlet.ADD_ITEM_UNIT);
		add.forward(request, response);
	}

}
