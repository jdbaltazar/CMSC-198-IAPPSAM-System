package com.iappsam.reporting;

import java.io.File;

import net.sf.jasperreports.engine.JRException;
import net.sf.jasperreports.engine.JRExporterParameter;
import net.sf.jasperreports.engine.JasperExportManager;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.engine.JasperReport;
import net.sf.jasperreports.engine.export.ooxml.JRDocxExporter;
import net.sf.jasperreports.engine.util.JRLoader;
import net.sf.jasperreports.engine.util.JRSaver;

import com.iappsam.entities.forms.AnnualProcurementPlan;

public class AAPReport {

	private AnnualProcurementPlan app;
	private JasperReport appReport;
	private File appJasper;

	public AAPReport(AnnualProcurementPlan app) throws JRException {
		this.app = app;
		appJasper = new File("jasper/app.jasper");
		appReport = (JasperReport) JRLoader.loadObject(appJasper);
	}

	public File toPDF() throws JRException {

		JasperPrint print = JasperFillManager.fillReport(appReport, null);
		File destFile = new File(appJasper.getParent(), "app.jrprint");
		JRSaver.saveObject(print, destFile);
		JasperExportManager.exportReportToPdfFile(appJasper.getParent() + "/app.jrprint");

		return new File(appJasper.getParent() + "/app.pdf");
	}
}
