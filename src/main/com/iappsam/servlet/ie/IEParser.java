package com.iappsam.servlet.ie;

import javax.servlet.http.HttpServletRequest;

import com.iappsam.Employee;
import com.iappsam.Item;
import com.iappsam.forms.Form;
import com.iappsam.forms.IE;
import com.iappsam.managers.DivisionOfficeManager;
import com.iappsam.managers.ItemManager;
import com.iappsam.managers.PersonManager;
import com.iappsam.managers.exceptions.TransactionException;
import com.iappsam.servlet.form.FormParser;
import com.iappsam.util.ApplicationContext;

public class IEParser extends FormParser {

	@Override
	public Form createForm(HttpServletRequest req, ApplicationContext appContext) throws TransactionException {

		DivisionOfficeManager dom = appContext.getDivisionOfficeManager();
		ItemManager im = appContext.getItemManager();
		PersonManager pm = appContext.getPersonManager();

		IE ie = new IE();

		String doid = req.getParameter("division-office");
		if (doid != null)
			ie.setDivisionOffice(dom.getDivisionOffice(doid));

		String building = req.getParameter("building");
		if (building != null)
			ie.setBuilding(dom.getBuilding(building));

		String[] items = req.getParameterValues("items");
		String[] quantity = req.getParameterValues("quantity");
		String[] employee = req.getParameterValues("employee");
		String[] howAcquired = req.getParameterValues("how-acquired");
		String[] remarks = req.getParameterValues("remarks");

		if (items != null)
			for (int i = 0; i < items.length; i++) {
				Item item = im.getItem(items[i]);
				Employee emp = pm.getEmployee(employee[i]);
				ie.addLine(item, quantity[i], emp, howAcquired[i], remarks[i]);
			}

		return ie;
	}
}
