package com.iappsam.servlet.ie;

import java.io.File;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import com.iappsam.forms.APP;
import com.iappsam.forms.Form;
import com.iappsam.forms.IE;
import com.iappsam.forms.PR;
import com.iappsam.logging.Logger;
import com.iappsam.managers.DivisionOfficeManager;
import com.iappsam.managers.IEManager;
import com.iappsam.managers.POManager;
import com.iappsam.managers.PersonManager;
import com.iappsam.managers.exceptions.TransactionException;
import com.iappsam.reporting.IEReport;
import com.iappsam.reporting.ReportException;
import com.iappsam.servlet.form.AbstractFormUtility;
import com.iappsam.util.ApplicationContext;

public class IEUtility extends AbstractFormUtility {

	private HttpServletRequest req;
	private DivisionOfficeManager dom;
	private IEManager iem;
	private PersonManager pm;
	private POManager pom;

	public IEUtility() {
		super("ie", ApplicationContext.INSTANCE, new IEParser());
		dom = appContext.getDivisionOfficeManager();
		iem = appContext.getIEManager();
		pm = appContext.getPersonManager();
		pom = appContext.getPOManager();
	}

	@Override
	public void beforeNewForm(HttpServletRequest req) throws TransactionException {
		this.req = req;
		Object ob = req.getSession().getAttribute("form");
		Object ob2 = req.getAttribute("form");
		if (!(ob instanceof IE || ob2 instanceof IE)) {
			req.getSession().removeAttribute("form");
			req.removeAttribute("form");
		}
		req.setAttribute("employees", pm.getAllEmployee());
		req.setAttribute("offices", dom.getAllDivisionOffice());
		req.setAttribute("buildings", dom.getAllBuildings());
		req.setAttribute("mods", pom.getAllModeOfProcurement());
	}

	@Override
	public void add(Form form) throws TransactionException {
		iem.addIE((IE) form);
		String division = ""+((IE) form).getDivisionOffice().getDivisionName();
		if(((IE) form).getDivisionOffice().getOfficeName()!=null)
			division =division+"/"+((IE) form).getDivisionOffice().getOfficeName();
		Logger.log(req, "Inventory of Equipment for "+division+ " was added");
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
		return new IEReport((IE) form).toPDF();
	}

	@Override
	public File getXls(Form form) throws ReportException {
		return new IEReport((IE) form).toXLS();
	}
}
