package com.iappsam.servlet.form;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.iappsam.managers.exceptions.TransactionException;
import com.iappsam.servlet.item.Action;

public abstract class NewFormPageAction implements Action {

	public NewFormPageAction() {
		super();
	}

	@Override
	public void process(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		try {
			beforeForward(request);
			request.getRequestDispatcher(getNewFormJsp()).forward(request, response);
		} catch (TransactionException e) {
			e.printStackTrace();
		}
	}

	protected abstract String getNewFormJsp();

	protected abstract void beforeForward(HttpServletRequest request) throws TransactionException;
}