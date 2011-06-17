/**
 * 
 */
package com.iappsam.servlet.pr;

import com.iappsam.servlet.form.ListItemsAction;
import com.iappsam.util.ApplicationContext;

/**
 * @author JK
 * 
 */
public class PRListItemsAction extends ListItemsAction {

	public PRListItemsAction(ApplicationContext appContext) {
		super(appContext);
	}

	@Override
	protected String getListItemJsp() {
		return PRLineServlet.LIST_ITEMS_JSP;
	}
}
