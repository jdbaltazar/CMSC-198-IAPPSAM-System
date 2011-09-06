package com.iappsam.reporting;

import java.io.File;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.iappsam.forms.Form;
import com.iappsam.forms.RIS;

import net.sf.jasperreports.engine.JRException;
import net.sf.jasperreports.engine.JRExporterParameter;
import net.sf.jasperreports.engine.JasperExportManager;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.engine.data.ListOfArrayDataSource;
import net.sf.jasperreports.engine.export.JExcelApiExporter;
import net.sf.jasperreports.engine.export.JRXlsAbstractExporter;
import net.sf.jasperreports.engine.util.JRLoader;

public abstract class AbstractReport {

	protected Map<String, Object> propertyMap = new HashMap<String, Object>();
	private String fileName;

	public AbstractReport(String fileName) {
		super();
		this.fileName = fileName;
	}

	protected void fillReport() throws ReportException {
		try {
			JasperFillManager.fillReportToFile("jasper/" + fileName + ".jasper", propertyMap, getListOfArrayDataSource());
		} catch (JRException e) {
			throw new ReportException(e.getMessage());
		}
	}

	private ListOfArrayDataSource getListOfArrayDataSource() {
		return new ListOfArrayDataSource(getRows(), getColumnTitles());
	}

	public File toPDF() throws ReportException {
		try {
			JasperExportManager.exportReportToPdfFile("jasper/" + fileName + ".jrprint");
			return new File("jasper/" + fileName + ".pdf");
		} catch (JRException e) {
			throw new ReportException(e.getMessage());
		}
	}

	public File toXLS() throws ReportException {
		try {
			exportReportToXls("jasper/" + fileName + ".jrprint");
			return new File("jasper/" + fileName + ".xls");
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

	protected abstract List<Object[]> getRows();

	protected abstract String[] getColumnTitles();

	protected abstract void initPropertyMap();

}