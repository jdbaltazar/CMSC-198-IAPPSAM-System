package com.iappsam.reporting;

import static org.junit.Assert.assertTrue;

import java.sql.Date;

import org.junit.Before;
import org.junit.Test;

import com.iappsam.DivisionOffice;
import com.iappsam.Employee;
import com.iappsam.forms.RIS;

public class RISReportTest {

	private RISReport report;

	@Before
	public void init() throws ReportException {

		Date date = Date.valueOf("2011-01-01");
		DivisionOffice doffice = new DivisionOffice("name", "office");
		Employee emp = Employee.create("des", "name");

		RIS ris = new RIS("ris", doffice, date, "purpose", emp, date, emp, date, emp, date, emp, date);
		report = new RISReport(ris);
	}

	@Test
	public void canExportPDF() throws ReportException {
		assertTrue(report.toPDF().exists());
	}

}
