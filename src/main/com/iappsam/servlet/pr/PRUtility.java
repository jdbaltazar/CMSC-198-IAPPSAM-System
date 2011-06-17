package com.iappsam.servlet.pr;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import com.iappsam.forms.Form;
import com.iappsam.forms.PR;
import com.iappsam.managers.DivisionOfficeManager;
import com.iappsam.managers.ItemManager;
import com.iappsam.managers.PRManager;
import com.iappsam.managers.PersonManager;
import com.iappsam.managers.exceptions.TransactionException;
import com.iappsam.servlet.form.FormParser;
import com.iappsam.util.ApplicationContext;

public class PRUtility extends AbstractFormUtility {

	private ItemManager im;
	private PersonManager pm;
	private DivisionOfficeManager dom;
	private PRManager prm;

	public PRUtility() {
		this(ApplicationContext.INSTANCE, new PRParser());
	}

	public PRUtility(ApplicationContext appContext, FormParser parser) {
		super(appContext, parser);
		im = appContext.getItemManager();
		pm = appContext.getPersonManager();
		dom = appContext.getDivisionOfficeManager();
		prm = appContext.getPRManager();
	}

	@Override
	public String getFormName() {
		return "pr";
	}

	@Override
	public void beforeNewForm(HttpServletRequest request) throws TransactionException {
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
}
