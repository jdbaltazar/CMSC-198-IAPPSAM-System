package com.iappsam.servlet.pr;

import java.util.List;

import com.iappsam.forms.Form;
import com.iappsam.managers.PRManager;
import com.iappsam.managers.exceptions.TransactionException;
import com.iappsam.servlet.form.ListFormAction;
import com.iappsam.util.ApplicationContext;

public class ListPRAction extends ListFormAction {

	private PRManager prm;

	public ListPRAction(ApplicationContext m) {
		this.prm = m.getPRManager();
	}

	@Override
	protected List<? extends Form> getForms() throws TransactionException {
		return prm.getAllPR();
	}

	@Override
	protected String getListFormJsp() {
		return PRServlet.LIST_PR_JSP;
	}
}
