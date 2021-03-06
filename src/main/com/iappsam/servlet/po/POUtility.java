package com.iappsam.servlet.po;

import java.io.File;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import com.iappsam.forms.APP;
import com.iappsam.forms.Form;
import com.iappsam.forms.PO;
import com.iappsam.logging.Logger;
import com.iappsam.managers.DivisionOfficeManager;
import com.iappsam.managers.POManager;
import com.iappsam.managers.PersonManager;
import com.iappsam.managers.SupplierManager;
import com.iappsam.managers.exceptions.TransactionException;
import com.iappsam.reporting.POReport;
import com.iappsam.reporting.ReportException;
import com.iappsam.servlet.form.AbstractFormUtility;
import com.iappsam.util.ApplicationContext;

public class POUtility extends AbstractFormUtility {

	private HttpServletRequest req;
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
		this.req = req;
		Object ob = req.getSession().getAttribute("form");
		Object formReq = req.getAttribute("form");

		if (!(ob instanceof PO)) {
			String retain = (String) req.getParameter("retain");
			if (retain == null) {
				req.getSession().removeAttribute("form");
			}
		}
		if (!(formReq instanceof PO)) {
			String retain = (String) req.getParameter("retain");
			if (retain == null) {
				req.removeAttribute("form");
			}
		}
		req.setAttribute("suppliers", sm.getAllSuppliers());
		req.setAttribute("mops", pom.getAllModeOfProcurement());
		req.setAttribute("divisionoffices", dom.getAllDivisionOffice());
		req.setAttribute("employees", pm.getAllNonSupplierEmployee());
		req.setAttribute("supplierEmployees", pm.getAllSupplierEmployee());
	}

	@Override
	public void add(Form form) throws TransactionException {
		pom.addPO((PO) form);
		Logger.log(req, "Purchase Order with PO No. " + ((PO) form).getPoNumber() + " was added");
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
		return new POReport((PO) form).toPDF();
	}

	@Override
	public File getXls(Form form) throws ReportException {
		return new POReport((PO) form).toXLS();
	}
}
