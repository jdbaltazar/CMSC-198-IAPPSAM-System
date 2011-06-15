package com.iappsam.servlet.form;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.iappsam.forms.Form;
import com.iappsam.managers.exceptions.TransactionException;
import com.iappsam.servlet.item.Action;
import com.iappsam.util.ApplicationContext;

public abstract class AddFormAction implements Action {

	private FormParser parser;
	private ApplicationContext appContext;

	public AddFormAction(FormParser parser, ApplicationContext appContext) {
		super();
		this.parser = parser;
		this.appContext = appContext;
	}

	@Override
	public void process(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		try {
			Form form = parser.createForm(request, appContext);
			initForm(form);
			if (form.validate()) {
				add();
				response.sendRedirect(onSucess());
			} else
				response.sendRedirect(onFailure());
		} catch (TransactionException e) {
			e.printStackTrace();
			response.sendRedirect(onFailure());
		}
	}

	protected abstract void initForm(Form form);

	protected abstract void add() throws TransactionException;

	protected abstract String onSucess();

	protected abstract String onFailure();

}