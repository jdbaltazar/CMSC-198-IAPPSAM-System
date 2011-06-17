package com.iappsam.servlet.pr;

import com.iappsam.servlet.form.FormLinePageAction;
import com.iappsam.servlet.form.FormParser;
import com.iappsam.util.ApplicationContext;

public class PRLinePageAction extends FormLinePageAction {

	public PRLinePageAction(ApplicationContext appContext, FormParser factory) {
		super(appContext, factory);

	}

	@Override
	public String getFormLineLink() {
		return "/pr/line";
	}
}
