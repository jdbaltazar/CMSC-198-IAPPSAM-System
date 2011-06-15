package com.iappsam.servlet.pr;

import com.iappsam.servlet.form.AddLineAction;
import com.iappsam.util.ApplicationContext;

public class AddPRLineAction extends AddLineAction {

	public AddPRLineAction(ApplicationContext appContext) {
		super(appContext);
	}

	@Override
	protected String addLinePage() {
		return "/pr/line";
	}

	@Override
	protected String newFormPage() {
		return "/pr?new=pr";
	}
}
