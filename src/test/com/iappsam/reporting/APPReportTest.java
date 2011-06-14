package com.iappsam.reporting;

import static org.junit.Assert.*;

import java.io.File;
import java.sql.Date;
import java.util.ArrayList;
import java.util.List;

import org.junit.Before;
import org.junit.Test;

import com.iappsam.entities.DivisionOffice;
import com.iappsam.entities.Employee;
import com.iappsam.entities.Item;
import com.iappsam.entities.ItemCategory;
import com.iappsam.entities.ItemCondition;
import com.iappsam.entities.ItemStatus;
import com.iappsam.entities.Person;
import com.iappsam.entities.Signatory;
import com.iappsam.entities.Unit;
import com.iappsam.entities.forms.AnnualProcurementPlan;
import com.iappsam.entities.forms.AnnualProcurementPlanLine;

public class APPReportTest extends APPReport {

	private APPReport report;
	private AnnualProcurementPlanLine line;
	private Object[] lineObjs;
	private List<Object[]> objArrays;

	@Before
	public void iniAPP() throws ReportException {
		DivisionOffice office = new DivisionOffice("DNSM", "Office of the Division Chair");
		Person p = new Person("Mr.", "John dela Cruz");
		Employee e = new Employee("Mayor", p);
		Signatory s = new Signatory("Recieved by:", e);

		AnnualProcurementPlan app = new AnnualProcurementPlan(2011, office, s, s);
		app.setPlanControlNumber("CTR-001-002");
		app.setDateScheduled(Date.valueOf("2011-01-01"));

		addLines(app);

		report = new APPReport(app);

		lineObjs = new Object[] { "ST-01-213", "Description", "unit", "10", "2.0", "1", "2.0", "2", "4.0", "3", "6.0", "4", "8.0", "20.0" };
		objArrays = new ArrayList<Object[]>();
		objArrays.add(lineObjs);
	}

	private void addLines(AnnualProcurementPlan app) {
		ItemCategory cat = new ItemCategory("Category");
		Unit unit = new Unit("unit");
		ItemStatus status = new ItemStatus("Single");
		ItemCondition cond = new ItemCondition("Working");
		Item item = new Item("Description", cat, unit, status, cond);
		item.setPrice(2);
		item.setStockNumber("ST-01-213");

		line = new AnnualProcurementPlanLine(app, item, 1, 2, 3, 4);
		app.addLine(line);
		// app.addLine(new Item("Bond Paper Long", cat, unit, status, cond), 5, 7,
		// 10, 4);
	}

	@Test
	public void getListOfArrayObject() {
		List<Object[]> actualObjArrays = report.getListOfObject();
		assertEquals(1, actualObjArrays.size());
		assertArrayEquals(objArrays.get(0), actualObjArrays.get(0));
	}

	@Test
	public void toArrayObject() {
		Object[] obj2 = APPReport.toArrayObject(line);
		assertArrayEquals(lineObjs, obj2);
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
