package com.iappsam.reporting;

import java.io.File;
import java.util.HashMap;
import java.util.Map;

import net.sf.jasperreports.engine.JRException;
import net.sf.jasperreports.engine.JRExporterParameter;
import net.sf.jasperreports.engine.JasperExportManager;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.engine.export.JExcelApiExporter;
import net.sf.jasperreports.engine.export.JRXlsAbstractExporter;
import net.sf.jasperreports.engine.util.JRLoader;

import com.iappsam.entities.forms.AnnualProcurementPlan;

public class APPReport {

	private Map<String, String> propertyMap;

	public APPReport(AnnualProcurementPlan app) throws ReportException {
		setAPP(app);
		tryToFillReport();
	}

	private void setAPP(AnnualProcurementPlan app) {
		if (app == null)
			throw new NullPointerException();

		propertyMap = createPropertyMap(app);
	}

	private void tryToFillReport() throws ReportException {
		try {
			JasperFillManager.fillReportToFile("jasper/app.jasper", propertyMap);
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

	static Map<String, String> createPropertyMap(AnnualProcurementPlan app) {
		Map<String, String> map = new HashMap<String, String>();
		map.put("YEAR", app.getYear() + "");
		map.put("PLAN_CONTROL_NUMBER", app.getPlanControlNumber());
		map.put("DATE_SCHEDULED", app.getDateScheduled() + "");
		map.put("OFFICE", app.getDivisionOffice() + "");
		return map;
	}
}
