package com.iappsam.servlet.ris;

import java.io.File;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import com.iappsam.forms.Form;
import com.iappsam.managers.exceptions.TransactionException;
import com.iappsam.reporting.ReportException;
import com.iappsam.servlet.form.AbstractFormUtility;
import com.iappsam.servlet.form.FormParser;
import com.iappsam.servlet.form.FormUtility;
import com.iappsam.util.ApplicationContext;

public class RISUtility extends AbstractFormUtility {

	public RISUtility() {
		super("ris", ApplicationContext.INSTANCE, new RISParser());
	}

	@Override
	public void beforeNewForm(HttpServletRequest request) throws TransactionException {

	}

	@Override
	public void add(Form form) throws TransactionException {
		// TODO Auto-generated method stub

	}

	@Override
	public List<? extends Form> getAllForms() throws TransactionException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Form getForm(int id) throws TransactionException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public File getPdf(Form form) throws ReportException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public File getXls(Form form) throws ReportException {
		// TODO Auto-generated method stub
		return null;
	}

}
