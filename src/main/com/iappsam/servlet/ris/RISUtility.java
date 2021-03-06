package com.iappsam.servlet.ris;

import java.io.File;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import com.iappsam.forms.APP;
import com.iappsam.forms.Form;
import com.iappsam.forms.PR;
import com.iappsam.forms.RIS;
import com.iappsam.logging.Logger;
import com.iappsam.managers.DivisionOfficeManager;
import com.iappsam.managers.ItemManager;
import com.iappsam.managers.PersonManager;
import com.iappsam.managers.RISManager;
import com.iappsam.managers.exceptions.TransactionException;
import com.iappsam.reporting.RISReport;
import com.iappsam.reporting.ReportException;
import com.iappsam.servlet.form.AbstractFormUtility;
import com.iappsam.util.ApplicationContext;

public class RISUtility extends AbstractFormUtility {

	private HttpServletRequest req;
	private DivisionOfficeManager dom;
	private PersonManager pm;
	private ItemManager im;
	private RISManager rism;

	public RISUtility() {
		super("ris", ApplicationContext.INSTANCE, new RISParser());
		dom = appContext.getDivisionOfficeManager();
		pm = appContext.getPersonManager();
		im = appContext.getItemManager();
		rism = appContext.getRISManager();
	}

	@Override
	public void beforeNewForm(HttpServletRequest req) throws TransactionException {
		this.req = req;
		Object ob = req.getSession().getAttribute("form");
		Object ob2 = req.getAttribute("form");
		if (!(ob instanceof RIS || ob2 instanceof RIS)) {
			String retain = (String) req.getParameter("retain");
			if (retain == null) {
				req.getSession().removeAttribute("form");
				req.removeAttribute("form");
			}
		}
		req.setAttribute("items", im.getAllItems());
		req.setAttribute("offices", dom.getAllDivisionOffice());
		req.setAttribute("employees", pm.getAllNonSupplierEmployee());
	}

	@Override
	public void add(Form form) throws TransactionException {
		rism.addRIS((RIS) form);
		Logger.log(req, "Requisition and Issue Slip with RIS No. " + ((RIS) form).getRisNumber() + " was added");
	}

	@Override
	public List<? extends Form> getAllForms() throws TransactionException {
		return rism.getAllRIS();
	}

	@Override
	public Form getForm(int id) throws TransactionException {
		return rism.getRIS(id);
	}

	@Override
	public File getPdf(Form form) throws ReportException {
		return new RISReport((RIS) form).toPDF();
	}

	@Override
	public File getXls(Form form) throws ReportException {
		return new RISReport((RIS) form).toXLS();
	}
}
