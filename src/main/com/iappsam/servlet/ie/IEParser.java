package com.iappsam.servlet.ie;

import javax.servlet.http.HttpServletRequest;

import com.iappsam.Employee;
import com.iappsam.Item;
import com.iappsam.forms.Form;
import com.iappsam.forms.IE;
import com.iappsam.forms.ModeOfProcurement;
import com.iappsam.managers.DivisionOfficeManager;
import com.iappsam.managers.ItemManager;
import com.iappsam.managers.POManager;
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
		POManager pom = appContext.getPOManager();

		IE ie = new IE();

		String doid = req.getParameter("division-office");
		if (doid != null)
			ie.setDivisionOffice(dom.getDivisionOffice(doid));

		String building = req.getParameter("building");
		if (building != null)
			ie.setBuilding(dom.getBuilding(building));

		String preparedBy = req.getParameter("prepared-by");
		if (preparedBy != null)
			ie.setPreparedBy(pm.getEmployee(preparedBy));

		String committee1 = req.getParameter("committee1");
		if (committee1 != null)
			ie.setCommitteeMember1(pm.getEmployee(committee1));

		String committee2 = req.getParameter("committee2");
		if (committee2 != null)
			ie.setCommitteeMember2(pm.getEmployee(committee2));

		String counterCheck = req.getParameter("countercheck");
		if (counterCheck != null)
			ie.setCounterCheckedBy(pm.getEmployee(counterCheck));

		String notedBy = req.getParameter("noted-by");
		if (notedBy != null)
			ie.setNotedBy(pm.getEmployee(notedBy));

		String coaRepresentative = req.getParameter("coa-representative");
		if (coaRepresentative != null)
			ie.setCoaRepresentative(pm.getEmployee(coaRepresentative));

		String datePrepared = req.getParameter("date-prepared");
		if (datePrepared != null)
			ie.setDatePrepared(datePrepared);

		String[] items = req.getParameterValues("items");
		String[] quantity = req.getParameterValues("quantity");
		String[] employee = req.getParameterValues("employee");
		String[] howAcquired = req.getParameterValues("how-acquired");
		String[] remarks = req.getParameterValues("remarks");

		if (items != null)
			for (int i = 0; i < items.length; i++) {
				Item item = im.getItem(items[i]);
				Employee emp = pm.getEmployee(employee[i]);
				ModeOfProcurement mop = pom.getModeOfProcurement(howAcquired[i]);
				ie.addLine(item, quantity[i], emp, mop, remarks[i]);
			}

		return ie;
	}
}
