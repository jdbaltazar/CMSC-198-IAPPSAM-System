package com.iappsam.servlet.stocks.itemstatus;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.iappsam.ItemStatus;
import com.iappsam.managers.ItemManager;
import com.iappsam.managers.exceptions.TransactionException;
import com.iappsam.managers.sessions.ItemManagerSession;
import com.iappsam.servlet.Action;
import com.iappsam.servlet.stocks.itemunit.ItemUnitServlet;
import com.iappsam.util.Validator;

public class AddItemStatAction implements Action {

	@Override
	public void process(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException, TransactionException {
		RequestDispatcher add = request.getRequestDispatcher(ItemStatusServlet.ADD_ITEM_STAT);
		add.forward(request, response);
	}

}
