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
		setAPP(app);
		fillReport();
	}

	private void setAPP(APP app) {
		if (app == null)
			throw new NullPointerException();
		this.app = app;
		initPropertyMap();
	}

	@Override
	protected List<Object[]> getRows() {
		List<Object[]> objArrays = new ArrayList<Object[]>();

		for (APPLine line : app.getLines())
			objArrays.add(toArrayObject(line));

		return objArrays;
	}

	@Override
	protected String[] getColumnTitles() {
		return new String[] { "stock_number", "description", "unit", "quantity", "price", "quarter1_quantity", "quarter1_amount", "quarter2_quantity", "quarter2_amount", "quarter3_quantity",
				"quarter3_amount", "quarter4_quantity", "quarter4_amount", "total_amount" };
	}

	@Override
	protected void initPropertyMap() {
		propertyMap.put("YEAR", app.getYear() + "");
		propertyMap.put("PLAN_CONTROL_NUMBER", app.getPlanControlNumber());
		propertyMap.put("DATE_SCHEDULED", app.getDateScheduled() + "");
		propertyMap.put("OFFICE", app.getDivisionOffice() + "");
	}

	static Object[] toArrayObject(APPLine line) {
		Item item = line.getItem();
		String description = item.getDescription();
		String stockNumber = item.getStockNumber();
		double price = item.getPrice();

		int quantity1 = line.getQuantityQuarter1();
		int quantity2 = line.getQuantityQuarter2();
		int quantity3 = line.getQuantityQuarter3();
		int quantity4 = line.getQuantityQuarter4();
		int quantity = quantity1 + quantity2 + quantity3 + quantity4;

		double amount1 = quantity1 * item.getPrice();
		double amount2 = quantity2 * item.getPrice();
		double amount3 = quantity3 * item.getPrice();
		double amount4 = quantity4 * item.getPrice();
		double amountTotal = amount1 + amount2 + amount3 + amount4;

		return new Object[] { stockNumber, description, item.getUnit().getName(), quantity + "", price + "", quantity1 + "", amount1 + "", quantity2 + "", amount2 + "", quantity3 + "", amount3 + "",
				quantity4 + "", amount4 + "", amountTotal + "" };
	}
}
