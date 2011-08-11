package com.iappsam.servlet.form;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.iappsam.forms.Form;
import com.iappsam.forms.PR;
import com.iappsam.managers.exceptions.TransactionException;
import com.iappsam.servlet.Action;
import com.iappsam.util.ApplicationContext;

public class AddFormAction implements Action {

	private FormParser parser;
	private ApplicationContext appContext;
	private String formName;
	private Form form;
	private FormUtility utility;

	public AddFormAction(FormUtility utility) {
		this.utility = utility;
		this.formName = utility.getFormName();
		this.parser = utility.getParser();
		this.appContext = utility.getApplicationContext();
	}

	@Override
	public void process(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		try {
			form = parser.createForm(request, appContext);
			if (form.validate()) {
				utility.add(form);

				response.sendRedirect(onSucessLink());
			} else
				response.sendRedirect(onFailureLink());
		} catch (TransactionException e) {
			e.printStackTrace();
			response.sendRedirect(onFailureLink());
		}
	}

	private String onSucessLink() {
		return String.format("/%s?id=%d", formName, form.getId());
	}

	private String onFailureLink() {
		return String.format("/%s?new=%s&edit=1", formName, formName);
	}
}