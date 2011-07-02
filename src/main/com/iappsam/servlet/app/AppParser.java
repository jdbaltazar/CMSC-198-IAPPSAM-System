package com.iappsam.servlet.app;

import javax.servlet.http.HttpServletRequest;

import com.iappsam.forms.APP;
import com.iappsam.forms.Form;
import com.iappsam.managers.DivisionOfficeManager;
import com.iappsam.managers.ItemManager;
import com.iappsam.managers.PersonManager;
import com.iappsam.managers.exceptions.TransactionException;
import com.iappsam.servlet.form.FormParser;
import com.iappsam.util.ApplicationContext;

public class AppParser extends FormParser {

	@Override
	public Form createForm(HttpServletRequest req, ApplicationContext appContext) throws TransactionException {

		DivisionOfficeManager dom = appContext.getDivisionOfficeManager();
		PersonManager pm = appContext.getPersonManager();
		ItemManager im = appContext.getItemManager();

		APP app = new APP();
		app.setYear(req.getParameter("year"));
		app.setPlanControlNumber(req.getParameter("plan-control-number"));
		app.setDateScheduled(req.getParameter("date-scheduled"));

		app.setDivisionOffice(dom.getDivisionOffice(req.getParameter("division-office")));
		app.setPreparedBy(pm.getEmployee(req.getParameter("prepared-by")));
		app.setRecommendedBy(pm.getEmployee(req.getParameter("recommended-by")));

		String[] q1 = req.getParameterValues("q1");
		String[] q2 = req.getParameterValues("q2");
		String[] q3 = req.getParameterValues("q3");
		String[] q4 = req.getParameterValues("q4");
		String[] items = req.getParameterValues("items");

		if (items != null)
			for (int i = 0; i < items.length; i++)
				app.addLine(im.getItem(Integer.parseInt(items[i])), q1[i], q2[i], q3[i], q4[i]);

		return app;
	}
}
