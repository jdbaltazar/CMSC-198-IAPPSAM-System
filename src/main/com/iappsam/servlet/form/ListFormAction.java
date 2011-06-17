package com.iappsam.servlet.form;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.iappsam.managers.exceptions.TransactionException;
import com.iappsam.servlet.item.Action;

public class ListFormAction implements Action {

	private String formName;
	private FormUtility utility;

	public ListFormAction(FormUtility utility) {
		this.formName = utility.getFormName();
		this.utility = utility;
	}

	@Override
	public void process(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		try {
			request.setAttribute("forms", utility.getAllForms());
			request.getRequestDispatcher(getListFormJsp()).forward(request, response);
		} catch (TransactionException e) {
			e.printStackTrace();
		}
	}

	protected String getListFormJsp() {
		return String.format("/%s/%s", formName, "list-pr.jsp");
	}
}