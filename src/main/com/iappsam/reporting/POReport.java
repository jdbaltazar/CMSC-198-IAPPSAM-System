package com.iappsam.reporting;

import java.util.ArrayList;
import java.util.List;

import com.iappsam.forms.PO;
import com.iappsam.forms.POLine;

public class POReport extends AbstractReport {

	private PO form;

	public POReport(PO form) throws ReportException {
		super("po");
		setForm(form);
	}

	private void setForm(PO form) throws ReportException {
		this.form = form;
		initPropertyMap();
		fillReport();
	}

	@Override
	protected List<Object[]> getRows() {
		List<Object[]> rows = new ArrayList<Object[]>();

		for (POLine line : form.getLines())
			rows.add(line.toArrayObjects());

		return rows;
	}

	@Override
	protected String[] getColumnTitles() {
		return new String[] { "Stock No.", "Unit", "Description", "Quantity", "Unit Cost", "Amount" };
	}

	@Override
	protected void initPropertyMap() {
		propertyMap.put("Supplier", form.getSupplier().getSupplierName());
		propertyMap.put("Address", form.getSupplier().getAddress());
		propertyMap.put("TIN", form.getSupplier().getTin());
		propertyMap.put("P.O. NO.", form.getPoNumber());
		propertyMap.put("Date", form.getDate() + "");
		propertyMap.put("Mode of Procurement", form.getModeOfProcurement().getName());
		propertyMap.put("Date of Delivery", form.getDateOfDelivery() + "");
		propertyMap.put("Delivery Term", form.getDeliveryTerm());
		propertyMap.put("Payment Term", form.getPaymentTerm());
		propertyMap.put("Total Amount in Words", form.getTotalAmountInWords());
		propertyMap.put("Total Amount", form.getTotalAmount() + "");
		propertyMap.put("Very truly yours NAME", form.getDean().getPerson().toString());
		propertyMap.put("Very truly yours DESIGNATION", form.getDean().getDesignation());
		propertyMap.put("Funds Available NAME", form.getAccountant().getPerson().toString());
		propertyMap.put("Funds Available DESIGNATION", form.getAccountant().getDesignation());
		propertyMap.put("SUPPLIER_NAME", form.getSupplier().getContactPerson().getPerson().toString());
		propertyMap.put("SUPPLIER_DATE", form.getSupplierDate() + "");
		propertyMap.put("OR No.", form.getOrNumber());
		propertyMap.put("Amount", form.getAmount() + "");
	}
}
