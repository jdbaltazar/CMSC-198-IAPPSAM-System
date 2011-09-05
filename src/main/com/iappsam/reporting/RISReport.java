package com.iappsam.reporting;

import java.util.ArrayList;
import java.util.List;

import com.iappsam.Item;
import com.iappsam.forms.RIS;
import com.iappsam.forms.RISLine;

public class RISReport extends AbstractReport {
	RIS form;

	public RISReport(RIS form) throws ReportException {
		super("ris");
		setForm(form);
	}

	private void setForm(RIS form) throws ReportException {
		this.form = form;
		initPropertyMap();
		fillReport();
	}

	@Override
	protected List<Object[]> getRows() {
		List<Object[]> objArrays = new ArrayList<Object[]>();

		for (RISLine line : form.getLines())
			objArrays.add(toArrayObject(line));

		return objArrays;
	}

	private Object[] toArrayObject(RISLine line) {
		List<Object> objs = new ArrayList<Object>();

		Item item = line.getItem();
		objs.add(item.getStockNumber());
		objs.add(item.getUnit().getName());
		objs.add(item.getDescription());

		objs.add(line.getQuantityRequested() + "");
		objs.add(line.getQuantityIssued() + "");
		objs.add(line.getRemarks());

		return objs.toArray();
	}

	@Override
	protected String[] getColumnTitles() {
		return new String[] { "Stock No.", "Unit", "Description", "Qty. Requested", "Qty. Issued", "Remarks" };
	}

	@Override
	protected void initPropertyMap() {
		propertyMap.put("Division", form.getDivisionOffice().getDivisionName());
		propertyMap.put("Responsibility Center Code", form.getRcCode() == null ? "" : form.getRcCode());
		propertyMap.put("RIS No.", form.getRisNumber());
		propertyMap.put("SAI No.", form.getSaiNumber());
		propertyMap.put("RIS Date", form.getRisDate().toString());
		propertyMap.put("SAI Date", form.getSaiDate() == null ? "" : form.getSaiDate().toString());
		propertyMap.put("Purpose", form.getPurpose());
		propertyMap.put("Requested by Printed Name", form.getRequestedBy().getPerson().getName());
		propertyMap.put("Requested by Designation", form.getRequestedBy().getDesignation());
		propertyMap.put("Approved by Printed Name", form.getApprovedBy().getPerson().getName());
		propertyMap.put("Approved by Designation", form.getApprovedBy().getDesignation());
		propertyMap.put("Issued by Printed Name", form.getIssuedBy().getPerson().getName());
		propertyMap.put("Issued by Designation", form.getIssuedBy().getDesignation());
		propertyMap.put("Received by Printed Name", form.getReceivedBy().getPerson().getName());
		propertyMap.put("Received by Designation", form.getReceivedBy().getDesignation());
		propertyMap.put("Requested by Date", form.getRequestedByDate().toString());
		propertyMap.put("Approved by Date", form.getApprovedByDate().toString());
		propertyMap.put("Issued by Date", form.getIssuedByDate().toString());
		propertyMap.put("Received by Date", form.getReceivedByDate().toString());
	}
}
