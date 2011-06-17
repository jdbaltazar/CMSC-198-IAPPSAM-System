package com.iappsam.servlet.form;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.iappsam.managers.exceptions.TransactionException;
import com.iappsam.servlet.item.Action;

public class NewFormPageAction implements Action {

	private String formName;
	private FormUtility utility;

	public NewFormPageAction(FormUtility utility) {
		this.formName = utility.getFormName();
		this.utility = utility;
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

	protected String getNewFormJsp() {
		return String.format("/%s/new-%s.jsp", formName, formName);
	}

	protected void beforeForward(HttpServletRequest request) throws TransactionException {
		utility.beforeNewForm(request);
	}
}