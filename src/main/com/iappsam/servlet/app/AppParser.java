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

		ItemManager im = appContext.getItemManager();
		DivisionOfficeManager dom = appContext.getDivisionOfficeManager();
		PersonManager pm = appContext.getPersonManager();

		String doParam = req.getParameter("division-office");
		String recomParam = req.getParameter("recommended-by");
		String prepParam = req.getParameter("prepared-by");

		APP app = new APP();
		app.setYear(req.getParameter("year"));
		app.setPlanControlNumber(req.getParameter("plan-control-number"));
		app.setDateScheduled(req.getParameter("date"));

		if (doParam != null)
			app.setDivisionOffice(dom.getDivisionOffice(Integer.parseInt(doParam)));

		if (recomParam != null)
			app.setRecommendedBy(pm.getEmployee(Integer.parseInt(recomParam)));

		if (prepParam != null)
			app.setPreparedBy(pm.getEmployee(Integer.parseInt(prepParam)));

		String[] itemsParam = req.getParameterValues("items");
		String[] q1Param = req.getParameterValues("q1");
		String[] q2Param = req.getParameterValues("q2");
		String[] q3Param = req.getParameterValues("q3");
		String[] q4Param = req.getParameterValues("q4");

		for (int i = 0; i < itemsParam.length; i++) {
			try {
				int itemId = Integer.parseInt(itemsParam[i]);
				int q1 = Integer.parseInt(q1Param[i]);
				int q2 = Integer.parseInt(q2Param[i]);
				int q3 = Integer.parseInt(q3Param[i]);
				int q4 = Integer.parseInt(q4Param[i]);
				app.addLine(im.getItem(itemId), q1, q2, q3, q4);
			} catch (Exception e) {
			}
		}
		return app;
	}
}
