package com.iappsam.servlet.pr;

import com.iappsam.servlet.form.FormParser;
import com.iappsam.servlet.form.RemoveFormLineAction;
import com.iappsam.util.ApplicationContext;

public class RemovePRLineAction extends RemoveFormLineAction {

	public RemovePRLineAction(ApplicationContext appContext, FormParser factory) {
		super(appContext, factory);
	}

	@Override
	protected String getNewFormLink() {
		return "/pr?new=pr";
	}
}
