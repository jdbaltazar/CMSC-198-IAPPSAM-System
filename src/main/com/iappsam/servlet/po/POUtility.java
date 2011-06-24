package com.iappsam.servlet.po;

import java.io.File;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import com.iappsam.forms.Form;
import com.iappsam.forms.PO;
import com.iappsam.managers.DivisionOfficeManager;
import com.iappsam.managers.POManager;
import com.iappsam.managers.PersonManager;
import com.iappsam.managers.SupplierManager;
import com.iappsam.managers.exceptions.TransactionException;
import com.iappsam.reporting.ReportException;
import com.iappsam.servlet.form.AbstractFormUtility;
import com.iappsam.util.ApplicationContext;

public class POUtility extends AbstractFormUtility {

	private POManager pom;
	private SupplierManager sm;
	private DivisionOfficeManager dom;
	private PersonManager pm;

	public POUtility() {
		super("po", ApplicationContext.INSTANCE, new POParser());
		pom = appContext.getPOManager();
		sm = appContext.getSupplierManager();
		dom = appContext.getDivisionOfficeManager();
		pm = appContext.getPersonManager();
	}

	@Override
	public void beforeNewForm(HttpServletRequest req) throws TransactionException {
		req.setAttribute("suppliers", sm.getAllSuppliers());
		req.setAttribute("mops", pom.getAllModeOfProcurement());
		req.setAttribute("divisionoffices", dom.getAllBuildings());
		req.setAttribute("employees", pm.getAllEmployee());
	}

	@Override
	public void add(Form form) throws TransactionException {
		pom.addPO((PO) form);

	}

	@Override
	public List<? extends Form> getAllForms() throws TransactionException {
		return pom.getAllPO();
	}

	@Override
	public Form getForm(int id) throws TransactionException {
		return pom.getPO(id);
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
