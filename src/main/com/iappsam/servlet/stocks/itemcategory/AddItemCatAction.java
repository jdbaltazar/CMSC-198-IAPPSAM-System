package com.iappsam.servlet.stocks.itemcategory;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.iappsam.managers.exceptions.TransactionException;
import com.iappsam.servlet.Action;
import com.iappsam.servlet.stocks.itemstatus.ItemStatusServlet;

public class AddItemCatAction implements Action {

	@Override
	public void process(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException, TransactionException {
		RequestDispatcher add = request.getRequestDispatcher(ItemCategoryServlet.ADD_ITEM_CAT);
		add.forward(request, response);
	}

}
