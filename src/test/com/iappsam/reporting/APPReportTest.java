package com.iappsam.reporting;

import static org.junit.Assert.*;

import java.io.File;
import java.util.Date;

import net.sf.jasperreports.engine.JRException;

import org.junit.Test;

import com.iappsam.entities.DivisionOffice;
import com.iappsam.entities.Employee;
import com.iappsam.entities.Person;
import com.iappsam.entities.Signatory;
import com.iappsam.entities.forms.AnnualProcurementPlan;

public class APPReportTest {

	@Test
	public void exportAPPtoPDF() throws JRException {

		DivisionOffice office = new DivisionOffice("DNSM", "Office of the Division Chair");
		Person p = new Person("Mr.", "John dela Cruz");
		Employee e = new Employee("Mayor", p);
		Signatory s = new Signatory("Recieved by:", e);

		AnnualProcurementPlan app = new AnnualProcurementPlan(2011, office, s, s);
		app.setPlanControlNumber("CTR-001-002");
		app.setDateScheduled(new Date());

		APPReport report = new APPReport(app);
		File pdf = report.toPDF();

		assertTrue(pdf.exists());
	}
}
