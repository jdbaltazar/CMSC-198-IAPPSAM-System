package com.iappsam.servlet.app;

import java.io.File;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import com.iappsam.forms.APP;
import com.iappsam.forms.Form;
import com.iappsam.forms.RIS;
import com.iappsam.logging.Logger;
import com.iappsam.managers.APPManager;
import com.iappsam.managers.DivisionOfficeManager;
import com.iappsam.managers.PersonManager;
import com.iappsam.managers.exceptions.TransactionException;
import com.iappsam.reporting.APPReport;
import com.iappsam.reporting.ReportException;
import com.iappsam.servlet.form.AbstractFormUtility;
import com.iappsam.servlet.form.FormUtility;
import com.iappsam.util.ApplicationContext;

public class APPUtility extends AbstractFormUtility implements FormUtility {

	private HttpServletRequest request;
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
		this.request = request;
		Object ob = request.getSession().getAttribute("form");
		Object ob2 = request.getAttribute("form");

		if (!(ob instanceof APP || ob2 instanceof APP)) {
			String retain = (String) request.getParameter("retain");
			if (retain == null) {
				request.getSession().removeAttribute("form");
				request.removeAttribute("form");
			}
		}
		request.setAttribute("offices", dom.getAllDivisionOffice());
		request.setAttribute("employees", pm.getAllNonSupplierEmployee());
	}

	@Override
	public void add(Form form) throws TransactionException {
		appm.addAPP((APP) form);
		Logger.log(request, "Annual Procurement Plan for year " + ((APP) form).getYear() + " was added");
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
	public File getPdf(Form form) throws ReportException {
		return new APPReport((APP) form).toPDF();
	}

	@Override
	public File getXls(Form form) throws ReportException {
		return new APPReport((APP) form).toXLS();
	}
}
