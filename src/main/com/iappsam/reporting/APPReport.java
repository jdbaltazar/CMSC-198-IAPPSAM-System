package com.iappsam.reporting;

import java.io.File;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import net.sf.jasperreports.engine.JRException;
import net.sf.jasperreports.engine.JRExporterParameter;
import net.sf.jasperreports.engine.JasperExportManager;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.engine.data.ListOfArrayDataSource;
import net.sf.jasperreports.engine.export.JExcelApiExporter;
import net.sf.jasperreports.engine.export.JRXlsAbstractExporter;
import net.sf.jasperreports.engine.util.JRLoader;

import com.iappsam.Item;
import com.iappsam.forms.APP;
import com.iappsam.forms.APPLine;

public class APPReport {

	protected String[] columns = { "stock_number", "description", "unit", "quantity", "price", "quarter1_quantity", "quarter1_amount", "quarter2_quantity", "quarter2_amount", "quarter3_quantity",
			"quarter3_amount", "quarter4_quantity", "quarter4_amount", "total_amount" };

	private Map<String, String> propertyMap;

	private APP app;

	protected APPReport() {

	}

	public APPReport(APP app) throws ReportException {
		setAPP(app);
		tryToFillReport();
	}

	private void setAPP(APP app) {
		if (app == null)
			throw new NullPointerException();
		propertyMap = createPropertyMap(app);
		this.app = app;
	}

	private void tryToFillReport() throws ReportException {
		try {
			JasperFillManager.fillReportToFile("jasper/app.jasper", propertyMap, getListOfArrayDataSource());
		} catch (JRException e) {
			throw new ReportException(e.getMessage());
		}
	}

	public File toPDF() throws ReportException {
		try {
			JasperExportManager.exportReportToPdfFile("jasper/app.jrprint");
			return new File("jasper/app.pdf");
		} catch (JRException e) {
			throw new ReportException(e.getMessage());
		}
	}

	public File toXLS() throws ReportException {
		try {
			exportReportToXls("jasper/app.jrprint");
			return new File("jasper/app.xls");
		} catch (JRException e) {
			throw new ReportException(e.getMessage());
		}
	}

	private void exportReportToXls(String fileName) throws JRException {
		File src = new File(fileName);
		JasperPrint print = (JasperPrint) JRLoader.loadObject(src);

		JRXlsAbstractExporter exporter = new JExcelApiExporter();
		exporter.setParameter(JRExporterParameter.JASPER_PRINT, print);
		exporter.setParameter(JRExporterParameter.OUTPUT_FILE_NAME, "jasper/" + print.getName() + ".xls");
		exporter.exportReport();
	}

	static Map<String, String> createPropertyMap(APP app) {
		Map<String, String> map = new HashMap<String, String>();
		map.put("YEAR", app.getYear() + "");
		map.put("PLAN_CONTROL_NUMBER", app.getPlanControlNumber());
		map.put("DATE_SCHEDULED", app.getDateScheduled() + "");
		map.put("OFFICE", app.getDivisionOffice() + "");
		return map;
	}

	protected List<Object[]> getListOfObject() {
		List<Object[]> objArrays = new ArrayList<Object[]>();

		APPLine[] lines = app.getLines().toArray(new APPLine[0]);

		objArrays.add(toArrayObject(lines[0]));
		return objArrays;
	}

	protected static Object[] toArrayObject(APPLine line) {
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

	public ListOfArrayDataSource getListOfArrayDataSource() {
		return new ListOfArrayDataSource(getListOfObject(), columns);
	}
}
