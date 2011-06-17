package com.iappsam.servlet.pr;

import com.iappsam.servlet.form.SearchItemAction;
import com.iappsam.util.ApplicationContext;

public class PRSearchItemAction extends SearchItemAction {

	public PRSearchItemAction(ApplicationContext appContext) {
		super(appContext);
	}

	@Override
	protected String getListItemJsp() {
		return PRLineServlet.LIST_ITEMS_JSP;
	}
}
