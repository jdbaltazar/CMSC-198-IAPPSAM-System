package com.iappsam.servlet.stocks.disposal;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.iappsam.managers.exceptions.TransactionException;
import com.iappsam.servlet.Action;

public class AddDisposalAction implements Action {

	@Override
	public void process(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		RequestDispatcher add = request.getRequestDispatcher(DisposalServlet.ADD_DISPOSAL);
		add.forward(request, response);
	}

}
