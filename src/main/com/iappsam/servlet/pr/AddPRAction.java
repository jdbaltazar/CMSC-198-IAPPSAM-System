package com.iappsam.servlet.pr;

import com.iappsam.forms.Form;
import com.iappsam.forms.PR;
import com.iappsam.managers.PRManager;
import com.iappsam.managers.exceptions.TransactionException;
import com.iappsam.servlet.form.AddFormAction;
import com.iappsam.util.ApplicationContext;

public class AddPRAction extends AddFormAction {

	private PRManager prm;
	private PR pr;

	public AddPRAction(ApplicationContext m, PRParser parser) {
		super(parser, m);
		this.prm = m.getPRManager();
	}

	@Override
	protected void initForm(Form form) {
		pr = (PR) form;
	}

	@Override
	protected void add() throws TransactionException {
		prm.addPR(pr);
	}

	@Override
	protected String onSucessLink() {
		return "/pr?id=" + pr.getId();
	}

	@Override
	protected String onFailureLink() {
		return "/pr?new=pr";
	}
}
