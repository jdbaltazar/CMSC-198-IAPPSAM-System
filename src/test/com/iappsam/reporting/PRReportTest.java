package com.iappsam.reporting;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import com.iappsam.DivisionOffice;
import com.iappsam.Employee;
import com.iappsam.Item;
import com.iappsam.forms.PR;

public class PRReportTest {

	private PRReport report;

	@Before
	public void init() throws ReportException {
		Employee emp = Employee.create("mayor", "john");
		PR form = new PR(new DivisionOffice("Division", "Office"), "Purpose", emp, emp);
		form.addLine(1, Item.create("des", "cat", "unit", "Stat", "cond"));

		report = new PRReport(form);
	}

	@Test
	public void canExportPDF() throws ReportException {
		assertTrue(report.toPDF().exists());
	}
}
