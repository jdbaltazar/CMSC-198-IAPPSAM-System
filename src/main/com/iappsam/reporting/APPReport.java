package com.iappsam.reporting;

import java.util.ArrayList;
import java.util.List;

import com.iappsam.Item;
import com.iappsam.forms.APP;
import com.iappsam.forms.APPLine;

public class APPReport extends AbstractReport {

	private APP app;

	public APPReport(APP app) throws ReportException {
		super("app");
		setForm(app);
		fillReport();
	}

	private void setForm(APP app) {
		if (app == null)
			throw new NullPointerException();
		this.app = app;
		initPropertyMap();
	}

	@Override
	protected List<Object[]> getRows() {
		List<Object[]> objArrays = new ArrayList<Object[]>();

		for (APPLine line : app.getLines())
			objArrays.add(line.toArrayObject());

		return objArrays;
	}

	@Override
	protected String[] getColumnTitles() {
		return new String[] { "stock_number", "description", "unit", "quantity", "price", "quarter1_quantity", "quarter1_amount", "quarter2_quantity",
				"quarter2_amount", "quarter3_quantity", "quarter3_amount", "quarter4_quantity", "quarter4_amount", "total_amount" };
	}

	@Override
	protected void initPropertyMap() {
		propertyMap.put("YEAR", app.getYear() + "");
		propertyMap.put("PLAN_CONTROL_NUMBER", app.getPlanControlNumber() == null ? "" : app.getPlanControlNumber());
		propertyMap.put("DATE_SCHEDULED", app.getDateScheduled() == null ? "" : app.getDateScheduled().toString());
		propertyMap.put("OFFICE", app.getDivisionOffice() + "");
		propertyMap.put("PREPARED_BY", app.getPreparedBy().getPerson() + "");
		propertyMap.put("RECOMMENDED_BY", app.getRecommendedBy().getPerson() + "");
	}

	
}
