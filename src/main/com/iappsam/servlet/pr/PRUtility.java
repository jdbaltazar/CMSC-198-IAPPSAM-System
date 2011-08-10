package com.iappsam.servlet.pr;

import java.io.File;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import com.iappsam.forms.APP;
import com.iappsam.forms.Form;
import com.iappsam.forms.PR;
import com.iappsam.managers.DivisionOfficeManager;
import com.iappsam.managers.ItemManager;
import com.iappsam.managers.PRManager;
import com.iappsam.managers.PersonManager;
import com.iappsam.managers.exceptions.TransactionException;
import com.iappsam.reporting.PRReport;
import com.iappsam.reporting.ReportException;
import com.iappsam.servlet.form.AbstractFormUtility;
import com.iappsam.servlet.form.FormParser;
import com.iappsam.util.ApplicationContext;

public class PRUtility extends AbstractFormUtility {

	private ItemManager im;
	private PersonManager pm;
	private DivisionOfficeManager dom;
	private PRManager prm;

	public PRUtility() {
		this("pr", ApplicationContext.INSTANCE, new PRParser());
	}

	public PRUtility(String name, ApplicationContext appContext, FormParser parser) {
		super(name, appContext, parser);
		im = appContext.getItemManager();
		pm = appContext.getPersonManager();
		dom = appContext.getDivisionOfficeManager();
		prm = appContext.getPRManager();
	}

	@Override
	public void beforeNewForm(HttpServletRequest request) throws TransactionException {
		Object ob = request.getAttribute("form");
		if (!(ob instanceof PR))
			request.setAttribute("form", new PR());
		request.setAttribute("itemsDb", im.getAllItems());
		request.setAttribute("employees", pm.getAllEmployee());
		request.setAttribute("offices", dom.getAllDivisionOffice());
	}

	@Override
	public void add(Form form) throws TransactionException {
		prm.addPR((PR) form);
	}

	@Override
	public List<? extends Form> getAllForms() throws TransactionException {
		return prm.getAllPR();
	}

	@Override
	public Form getForm(int id) throws TransactionException {
		return prm.getPR(id);
	}

	@Override
	public File getPdf(Form form) throws ReportException {
		return new PRReport((PR) form).toPDF();
	}

	@Override
	public File getXls(Form form) throws ReportException {
		return new PRReport((PR) form).toXLS();
	}
}
