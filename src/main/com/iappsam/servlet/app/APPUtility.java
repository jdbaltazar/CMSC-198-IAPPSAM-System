package com.iappsam.servlet.app;

import java.io.File;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import com.iappsam.forms.APP;
import com.iappsam.forms.Form;
import com.iappsam.managers.APPManager;
import com.iappsam.managers.DivisionOfficeManager;
import com.iappsam.managers.PersonManager;
import com.iappsam.managers.exceptions.TransactionException;
import com.iappsam.reporting.ReportException;
import com.iappsam.servlet.form.AbstractFormUtility;
import com.iappsam.servlet.form.FormUtility;
import com.iappsam.util.ApplicationContext;

public class APPUtility extends AbstractFormUtility implements FormUtility {

	private PersonManager pm;
	private DivisionOfficeManager dom;
	private APPManager appm;

	public APPUtility() {
		super("app", ApplicationContext.INSTANCE, new AppParser());
		dom = appContext.getDivisionOfficeManager();
		pm = appContext.getPersonManager();
		appm = appContext.getAPPManager();
	}

	@Override
	public void beforeNewForm(HttpServletRequest request) throws TransactionException {
		request.setAttribute("offices", dom.getAllDivisionOffice());
		request.setAttribute("employees", pm.getAllEmployee());
	}

	@Override
	public void add(Form form) throws TransactionException {
		appm.addAPP((APP) form);

	}

	@Override
	public List<? extends Form> getAllForms() throws TransactionException {
		return appm.getAllAPP();
	}

	@Override
	public Form getForm(int id) throws TransactionException {
		return appm.getAPP(id);
	}

	@Override
	public File getPdf(Form form) {
		throw new UnsupportedOperationException();
	}

	@Override
	public File getXls(Form form) throws ReportException {
		throw new UnsupportedOperationException();
	}
}
