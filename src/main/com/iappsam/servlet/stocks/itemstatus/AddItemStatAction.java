package com.iappsam.servlet.stocks.itemstatus;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.iappsam.servlet.Action;

public class AddItemStatAction implements Action {

	@Override
	public void process(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		RequestDispatcher add = request.getRequestDispatcher(ItemStatusServlet.ADD_ITEM_STAT);
		add.forward(request, response);
	}

}
