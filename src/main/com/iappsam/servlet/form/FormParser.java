package com.iappsam.servlet.form;

import javax.servlet.http.HttpServletRequest;

import com.iappsam.forms.Form;
import com.iappsam.managers.exceptions.TransactionException;
import com.iappsam.util.ApplicationContext;

public abstract class FormParser {
	public abstract Form createForm(HttpServletRequest req, ApplicationContext appContext) throws TransactionException;
}
