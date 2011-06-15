package com.iappsam.servlet.form;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.iappsam.forms.Form;
import com.iappsam.managers.exceptions.TransactionException;
import com.iappsam.servlet.item.Action;

public abstract class ListFormAction implements Action {

	public ListFormAction() {
		super();
	}

	@Override
	public void process(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		try {
			request.setAttribute("forms", getForms());
			request.getRequestDispatcher(getListFormJsp()).forward(request, response);
		} catch (TransactionException e) {
			e.printStackTrace();
		}
	}

	protected abstract String getListFormJsp();

	protected abstract List<? extends Form> getForms() throws TransactionException;

}