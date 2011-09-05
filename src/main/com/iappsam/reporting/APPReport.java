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
		return new String[] { "Stock No.", "ARTICLES and SPECIFICATIONS", "Unit", "Qty.", "Price", "1stQ Qty.", "1stQ Amount", "2ndQ Qty.",
				"2ndQ Amount", "3rdQ Qty.", "3rdQ Amount", "4thQ Qty.", "4thQ Amount", "Total Amount" };
	}

	@Override
	protected void initPropertyMap() {
		propertyMap.put("YEAR", app.getYear() + "");
		propertyMap.put("PLAN_CONTROL_NUMBER", app.getPlanControlNumber() == null ? "" : app.getPlanControlNumber());
		propertyMap.put("DATE_SCHEDULED", app.getDateScheduled() == null ? "" : app.getDateScheduled().toString());
		propertyMap.put("DEPARTMENT/OFFICE", app.getDivisionOffice() + "");
		propertyMap.put("PREPARED_BY_NAME", app.getPreparedBy().getPerson() + "");
		propertyMap.put("PREPARED_BY_DESIGNATION", app.getPreparedBy().getDesignation());
		propertyMap.put("RECOMMENDED_BY_NAME", app.getRecommendedBy().getPerson() + "");
		propertyMap.put("RECOMMENDED_BY_DESIGNATION", app.getRecommendedBy().getDesignation());
		propertyMap.put("1stQ_TOTAL", app.get1stQuarterTotal() + "");
		propertyMap.put("2ndQ_TOTAL", app.get2ndQuarterTotal() + "");
		propertyMap.put("3rdQ_TOTAL", app.get3rdQuarterTotal() + "");
		propertyMap.put("4thQ TOTAL", app.get4thQuarterTotal() + "");
		propertyMap.put("GRAND_TOTAL_AMOUNT", app.getTotal() + "");
	}
}
