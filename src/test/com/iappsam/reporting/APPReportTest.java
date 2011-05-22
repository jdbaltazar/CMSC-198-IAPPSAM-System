package com.iappsam.reporting;

import static org.junit.Assert.*;

import java.io.File;
import java.sql.Date;

import org.junit.Before;
import org.junit.Ignore;
import org.junit.Test;

import com.iappsam.entities.DivisionOffice;
import com.iappsam.entities.Employee;
import com.iappsam.entities.Person;
import com.iappsam.entities.Signatory;
import com.iappsam.entities.forms.AnnualProcurementPlan;

public class APPReportTest {

	private APPReport report;

	@Before
	public void iniAPP() throws ReportException {
		DivisionOffice office = new DivisionOffice("DNSM", "Office of the Division Chair");
		Person p = new Person("Mr.", "John dela Cruz");
		Employee e = new Employee("Mayor", p);
		Signatory s = new Signatory("Recieved by:", e);

		AnnualProcurementPlan app = new AnnualProcurementPlan(2011, office, s, s);
		app.setPlanControlNumber("CTR-001-002");
		app.setDateScheduled(Date.valueOf("2011-01-01"));
		report = new APPReport(app);
	}

	@Test
	public void exportAPPtoPDF() throws ReportException {
		File pdf = report.toPDF();
		assertTrue(pdf.exists());
	}

	@Test
	public void exportAPPtoXls() throws ReportException {
		File xls = report.toXLS();
		assertTrue(xls.exists());
	}

}
