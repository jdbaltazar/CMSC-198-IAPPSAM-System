package com.iappsam.servlet.po;

import javax.servlet.http.HttpServletRequest;

import com.iappsam.forms.Form;
import com.iappsam.forms.PO;
import com.iappsam.managers.DivisionOfficeManager;
import com.iappsam.managers.ItemManager;
import com.iappsam.managers.POManager;
import com.iappsam.managers.PersonManager;
import com.iappsam.managers.SupplierManager;
import com.iappsam.managers.exceptions.TransactionException;
import com.iappsam.servlet.form.FormParser;
import com.iappsam.util.ApplicationContext;

public class POParser extends FormParser {

	@Override
	public Form createForm(HttpServletRequest req, ApplicationContext appContext) throws TransactionException {
		SupplierManager sm = appContext.getSupplierManager();
		POManager pom = appContext.getPOManager();
		DivisionOfficeManager dom = appContext.getDivisionOfficeManager();
		PersonManager pm = appContext.getPersonManager();
		ItemManager im = appContext.getItemManager();

		PO po = new PO();

		po.setDate(req.getParameter("date"));
		po.setPoNumber(req.getParameter("po-number"));

		String supplierParam = req.getParameter("supplier");
		if (supplierParam != null)
			po.setSupplier(sm.getSupplier(Integer.parseInt(supplierParam)));

		String supplierNameParam = req.getParameter("supplier-name");
		if (supplierNameParam != null)
			po.setSupplierName(pm.getEmployee(Integer.parseInt(supplierNameParam)));

		po.setSupplierDate(req.getParameter("supplier-date"));

		String mopParam = req.getParameter("mop");
		if (mopParam != null)
			po.setModeOfProcurement(pom.getModeOfProcurement(Integer.parseInt(mopParam)));

		String domParam = req.getParameter("dom");
		if (domParam != null)
			po.setDivisionOffice(dom.getDivisionOffice(Integer.parseInt(domParam)));

		po.setDateOfDelivery(req.getParameter("date-of-delivery"));
		po.setPaymentTerm(req.getParameter("payment-term"));
		po.setDeliveryTerm(req.getParameter("delivery-term"));
		po.setTotalAmountInWords(req.getParameter("total-amount-in-words"));
		po.setOrNumber(req.getParameter("or-number"));

		String amountParam = req.getParameter("amount");
		if (amountParam != null)
			po.setAmount(amountParam);

		String accountantParam = req.getParameter("accountant");
		if (accountantParam != null)
			po.setAccountant(pm.getEmployee(Integer.parseInt(accountantParam)));

		po.setAccountantDate(req.getParameter("accountant-date"));

		String deanParam = req.getParameter("dean");
		if (deanParam != null)
			po.setDean(pm.getEmployee(Integer.parseInt(deanParam)));
		po.setDeanDate(req.getParameter("dean-date"));

		String[] items = req.getParameterValues("items");

		if (items != null)
			for (String item : items)
				try {
					po.addLine(im.getItem(Integer.parseInt(item)));
				} catch (NumberFormatException e) {
				}

		return po;
	}
}
