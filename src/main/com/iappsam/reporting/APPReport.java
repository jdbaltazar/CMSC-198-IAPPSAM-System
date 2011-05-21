package com.iappsam.reporting;

import java.io.File;
import java.util.HashMap;
import java.util.Map;

import net.sf.jasperreports.engine.JRException;
import net.sf.jasperreports.engine.JasperExportManager;
import net.sf.jasperreports.engine.JasperFillManager;

import com.iappsam.entities.forms.AnnualProcurementPlan;

public class APPReport {

	private AnnualProcurementPlan app;

	public APPReport(AnnualProcurementPlan app) throws JRException {
		this.app = app;
	}

	public File toPDF() throws JRException {

		Map<String, String> m = getPropertyMap();

		JasperFillManager.fillReportToFile("jasper/app.jasper", m);
		JasperExportManager.exportReportToPdfFile("jasper/app.jrprint");
		return new File("jasper/app.pdf");
	}

	private Map<String, String> getPropertyMap() {
		Map<String, String> m = new HashMap<String, String>();
		m.put("YEAR", app.getId().getYear() + "");
		m.put("PLAN_CONTROL_NUMBER", app.getPlanControlNumber());
		m.put("DATE_SCHEDULED", app.getDateScheduled() + "");
		m.put("OFFICE", app.getId().getId() + "");
		return m;
	}
}
