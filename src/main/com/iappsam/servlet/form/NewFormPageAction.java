package com.iappsam.servlet.form;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.iappsam.forms.PR;
import com.iappsam.managers.exceptions.TransactionException;
import com.iappsam.servlet.Action;

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

			if (request.getParameter("edit") == null) {
				Object ob = request.getSession().getAttribute("form");
				Object ob2 = request.getAttribute("form");

				if (!(ob instanceof PR && ob2 instanceof PR)) {
					request.getSession().removeAttribute("form");
					request.removeAttribute("form");
				}
			}

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