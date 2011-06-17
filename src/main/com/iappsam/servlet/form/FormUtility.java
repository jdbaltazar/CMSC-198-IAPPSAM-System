package com.iappsam.servlet.form;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import com.iappsam.forms.Form;
import com.iappsam.managers.exceptions.TransactionException;
import com.iappsam.util.ApplicationContext;

public interface FormUtility {

	FormParser getParser();

	String getFormName();

	void beforeNewForm(HttpServletRequest request) throws TransactionException;

	ApplicationContext getApplicationContext();

	void add(Form form) throws TransactionException;

	List<? extends Form> getAllForms() throws TransactionException;

	Form getForm(int id) throws TransactionException;

}
