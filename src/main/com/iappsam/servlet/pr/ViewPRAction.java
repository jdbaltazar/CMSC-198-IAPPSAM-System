package com.iappsam.servlet.pr;

import com.iappsam.forms.Form;
import com.iappsam.managers.PRManager;
import com.iappsam.managers.exceptions.TransactionException;
import com.iappsam.servlet.form.ViewFormAction;
import com.iappsam.util.ApplicationContext;

public class ViewPRAction extends ViewFormAction {

	private PRManager prm;

	public ViewPRAction(ApplicationContext m) {
		this.prm = m.getPRManager();
	}

	@Override
	protected Form getForm(Object id) throws TransactionException {
		return prm.getPR((Integer) id);
	}

	@Override
	protected String getViewFormJsp() {
		return PRServlet.VIEW_PR_JSP;
	}

	@Override
	protected String getFormListLink() {
		return "/pr";
	}
}
