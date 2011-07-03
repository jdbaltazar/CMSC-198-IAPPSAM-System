package com.iappsam.servlet.ris;

import javax.servlet.http.HttpServletRequest;

import com.iappsam.forms.Form;
import com.iappsam.forms.RIS;
import com.iappsam.managers.DivisionOfficeManager;
import com.iappsam.managers.ItemManager;
import com.iappsam.managers.PersonManager;
import com.iappsam.managers.exceptions.TransactionException;
import com.iappsam.servlet.form.FormParser;
import com.iappsam.util.ApplicationContext;

public class RISParser extends FormParser {

	@Override
	public Form createForm(HttpServletRequest req, ApplicationContext appContext) throws TransactionException {
		DivisionOfficeManager dom = appContext.getDivisionOfficeManager();
		PersonManager pm = appContext.getPersonManager();
		ItemManager im = appContext.getItemManager();

		RIS ris = new RIS();

		ris.setRisNumber(req.getParameter("ris-number"));
		ris.setDivisionOffice(dom.getDivisionOffice(req.getParameter("division-office")));
		ris.setRcCode(req.getParameter("rc-code"));
		ris.setRisDate(req.getParameter("ris-date"));
		ris.setSaiNumber(req.getParameter("sai-number"));
		ris.setSaiDate(req.getParameter("sai-date"));
		ris.setPurpose(req.getParameter("purpose"));
		ris.setRequestedBy(pm.getEmployee(req.getParameter("requested-by")));
		ris.setRequestedByDate(req.getParameter("requested-by-date"));
		ris.setApprovedBy(pm.getEmployee(req.getParameter("approved-by")));
		ris.setApprovedByDate(req.getParameter("approved-by-date"));
		ris.setIssuedBy(pm.getEmployee(req.getParameter("issued-by")));
		ris.setIssuedByDate(req.getParameter("issued-by-date"));
		ris.setReceivedBy(pm.getEmployee(req.getParameter("received-by")));
		ris.setReceivedByDate(req.getParameter("received-by-date"));

		String[] items = req.getParameterValues("items");
		String[] requested = req.getParameterValues("quantity-requested");
		String[] issued = req.getParameterValues("quatity-issued");
		String[] remarks = req.getParameterValues("remarks");

		for (int i = 0; i < items.length; i++)
			ris.addLine(im.getItem(items[0]), requested[0], issued[0], remarks[0]);

		return ris;
	}
}
