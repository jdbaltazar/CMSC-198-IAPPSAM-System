package com.iappsam.reporting;

import static org.junit.Assert.*;

import java.sql.Date;

import org.junit.Before;
import org.junit.Test;

import com.iappsam.DivisionOffice;
import com.iappsam.Employee;
import com.iappsam.Supplier;
import com.iappsam.forms.ModeOfProcurement;
import com.iappsam.forms.PO;

public class POReportTest {

	POReport report;

	@Before
	public void init() throws ReportException {

		Employee emp = Employee.create("des", "name");
		Supplier supplier = new Supplier("suppName", "Add", emp);
		ModeOfProcurement mop = new ModeOfProcurement("mop");
		DivisionOffice divisionOffice = new DivisionOffice("name", "officeName");

		Date date = Date.valueOf("2011-01-01");
		PO po = new PO("po", supplier, date, mop, divisionOffice, date, emp, date, emp, date, emp, date);

		report = new POReport(po);
	}

	@Test
	public void canExportPDF() throws ReportException {
		assertTrue(report.toPDF().exists());
	}
}
