package com.iappsam.servlet.app;

import javax.servlet.http.HttpServletRequest;

import com.iappsam.forms.Form;
import com.iappsam.managers.exceptions.TransactionException;
import com.iappsam.servlet.form.FormParser;
import com.iappsam.util.ApplicationContext;

public class APPParser extends FormParser {

	@Override
	public Form createForm(HttpServletRequest request, ApplicationContext appContext) throws TransactionException {
		return null;
	}
}
