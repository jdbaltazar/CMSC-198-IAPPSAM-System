package com.iappsam.servlet.ie;

import java.io.File;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import com.iappsam.forms.Form;
import com.iappsam.forms.IE;
import com.iappsam.managers.DivisionOfficeManager;
import com.iappsam.managers.IEManager;
import com.iappsam.managers.exceptions.TransactionException;
import com.iappsam.reporting.ReportException;
import com.iappsam.servlet.form.AbstractFormUtility;
import com.iappsam.util.ApplicationContext;

public class IEUtility extends AbstractFormUtility {

	private DivisionOfficeManager dom;
	private IEManager iem;

	public IEUtility() {
		super("ie", ApplicationContext.INSTANCE, new IEParser());
		dom = appContext.getDivisionOfficeManager();
		iem = appContext.getIEManager();
	}

	@Override
	public void beforeNewForm(HttpServletRequest req) throws TransactionException {
		req.setAttribute("offices", dom.getAllDivisionOffice());
		req.setAttribute("buildings", dom.getAllBuildings());
	}

	@Override
	public void add(Form form) throws TransactionException {
		iem.addIE((IE) form);
	}

	@Override
	public List<? extends Form> getAllForms() throws TransactionException {
		return iem.getAllIE();
	}

	@Override
	public Form getForm(int id) throws TransactionException {
		return iem.getIE(id);
	}

	@Override
	public File getPdf(Form form) throws ReportException {
		throw new UnsupportedOperationException();
	}

	@Override
	public File getXls(Form form) throws ReportException {
		throw new UnsupportedOperationException();
	}
}
