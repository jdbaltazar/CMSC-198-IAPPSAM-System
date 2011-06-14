package com.iappsam.servlet.pr;

import javax.servlet.http.HttpServletRequest;

import com.iappsam.entities.forms.PurchaseRequest;
import com.iappsam.managers.DivisionOfficeManager;
import com.iappsam.managers.ItemManager;
import com.iappsam.managers.PersonManager;
import com.iappsam.managers.exceptions.TransactionException;

public class PRFactory {
	public PurchaseRequest createPR(HttpServletRequest request, ItemManager im, DivisionOfficeManager dom, PersonManager pm)
			throws TransactionException {

		PurchaseRequest pr = new PurchaseRequest();

		String divisionOfficeId = request.getParameter("deptAndSection");
		if (divisionOfficeId != null)
			pr.setDivisionOffice(dom.getDivisionOffice(Integer.parseInt(divisionOfficeId)));

		pr.setPrNumber(request.getParameter("prNumber"));
		pr.setPrDate(request.getParameter("prDate"));
		pr.setSaiNumber(request.getParameter("saiNumber"));
		pr.setSaiDate(request.getParameter("saiDate"));
		pr.setAlobsNumber(request.getParameter("alobsNumber"));
		pr.setAlobsDate(request.getParameter("alobsDate"));
		pr.setPurpose(request.getParameter("purpose"));

		String reqId = request.getParameter("requestedBy");
		if (reqId != null)
			pr.setRequestedBy(pm.getEmployee(Integer.parseInt(reqId)));

		String aprid = request.getParameter("approvedby");
		if (aprid != null)
			pr.setApprovedBy(pm.getEmployee(Integer.parseInt(aprid)));

		String[] quantities = request.getParameterValues("quantity");
		String[] items = request.getParameterValues("items");

		if (items != null)
			for (int i = 0; i < items.length; i++) {
				String q = null;
				if (quantities != null)
					q = quantities[i];
				if (q == null)
					q = "0";
				pr.addLine(Integer.parseInt(q), im.getItem(Integer.parseInt(items[i])));
			}

		return pr;
	}
}
