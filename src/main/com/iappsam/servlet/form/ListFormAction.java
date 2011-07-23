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
	private String listFormJsp;

	public ListFormAction(FormUtility utility) {
		this.formName = utility.getFormName();
		this.utility = utility;
		listFormJsp = String.format("/%s/list-%s.jsp", formName, formName);
	}

	@Override
	public void process(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		try {
			request.setAttribute("forms", utility.getAllForms());
			request.getRequestDispatcher(listFormJsp).forward(request, response);
		} catch (TransactionException e) {
			e.printStackTrace();
		}
	}
}