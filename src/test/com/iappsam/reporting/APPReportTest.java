package com.iappsam.reporting;

import static org.junit.Assert.*;

import java.io.File;
import java.sql.Date;
import java.util.ArrayList;
import java.util.List;

import org.junit.Before;
import org.junit.Test;

import com.iappsam.DivisionOffice;
import com.iappsam.Employee;
import com.iappsam.Item;
import com.iappsam.ItemCategory;
import com.iappsam.ItemCondition;
import com.iappsam.ItemStatus;
import com.iappsam.Person;
import com.iappsam.Signatory;
import com.iappsam.Unit;
import com.iappsam.forms.APP;
import com.iappsam.forms.APPLine;

public class APPReportTest extends APPReport {

	private APPReport report;
	private APPLine line;
	private Object[] lineObjs;
	private List<Object[]> objArrays;

	@Before
	public void iniAPP() throws ReportException {
		DivisionOffice office = new DivisionOffice("DNSM", "Office of the Division Chair");
		Person p = new Person("Mr.", "John dela Cruz");
		Employee e = new Employee("Mayor", p);

		APP app = new APP(2011, office, e, e);
		app.setPlanControlNumber("CTR-001-002");
		app.setDateScheduled(Date.valueOf("2011-01-01"));

		addLines(app);

		report = new APPReport(app);

		lineObjs = new Object[] { "ST-01-213", "Description", "unit", "10", "2.0", "1", "2.0", "2", "4.0", "3", "6.0", "4", "8.0", "20.0" };
		objArrays = new ArrayList<Object[]>();
		objArrays.add(lineObjs);
	}

	private void addLines(APP app) {
		ItemCategory cat = new ItemCategory("Category");
		Unit unit = new Unit("unit");
		ItemStatus status = new ItemStatus("Single");
		ItemCondition cond = new ItemCondition("Working");
		Item item = new Item("Description", cat, unit, status, cond);
		item.setPrice(2);
		item.setStockNumber("ST-01-213");

		line = new APPLine(app, item, 1, 2, 3, 4);
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
