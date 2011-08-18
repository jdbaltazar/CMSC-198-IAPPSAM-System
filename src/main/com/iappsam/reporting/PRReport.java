package com.iappsam.reporting;

import java.util.ArrayList;
import java.util.List;

import com.iappsam.forms.PR;
import com.iappsam.forms.PRLine;

public class PRReport extends AbstractReport {

	private PR form;

	public PRReport(PR form) throws ReportException {
		super("pr");
		setForm(form);
	}

	private void setForm(PR form) throws ReportException {
		this.form = form;
		initPropertyMap();
		fillReport();
	}

	@Override
	protected List<Object[]> getRows() {
		List<Object[]> rows = new ArrayList<Object[]>();

		for (PRLine line : form.getLines())
			rows.add(line.toArrayObjects());

		return rows;
	}

	@Override
	protected String[] getColumnTitles() {
		return new String[] { "Quantity", "Unit of Issue", "Item Description", "Stock No.", "Estimated Unit Cost", "Estimated Cost" };
	}

	@Override
	protected void initPropertyMap() {
		propertyMap.put("PR_NUMBER", form.getPrNumber());
		propertyMap.put("PR Date", form.getPrDate() == null ? "" : form.getPrDate() + "");
		propertyMap.put("SAI No.", form.getSaiNumber());
		propertyMap.put("SAI Date", form.getSaiDate() == null ? "" : form.getSaiDate() + "");
		propertyMap.put("ALOBS No.", form.getAlobsNumber());
		propertyMap.put("ALOBS Date", form.getAlobsDate() == null ? "" : form.getAlobsDate() + "");
		propertyMap.put("Dean", form.getApprovedBy().getPerson().getName());
		propertyMap.put("APPROVED_BY_DESIGNATION", form.getApprovedBy().getDesignation());
		propertyMap.put("REQUESTED_BY_NAME", form.getRequestedBy().getPerson().getName());
		propertyMap.put("REQUESTED_BY_DESIGNATION", form.getRequestedBy().getDesignation());
		propertyMap.put("Purpose", form.getPurpose());
		propertyMap.put("Department", form.getDivisionOffice().getDivisionName());
		propertyMap.put("Section", form.getDivisionOffice().getOfficeName() == null? "" : form.getDivisionOffice().getOfficeName());
	}
}
