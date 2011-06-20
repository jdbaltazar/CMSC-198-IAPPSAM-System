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
import com.iappsam.forms.APP;
import com.iappsam.forms.APPLine;

public class APPReportTest {

	private AbstractReport report;
	private APPLine line;
	private Object[] lineObjs;
	private List<Object[]> objArrays;
	private APP app;

	@Before
	public void initAPP() throws ReportException {
		createReport();
		createObjectArrays();
	}

	@Test
	public void getListOfArrayObject() {
		List<Object[]> actualObjArrays = report.getRows();
		assertEquals(1, actualObjArrays.size());
		assertArrayEquals(objArrays.get(0), actualObjArrays.get(0));
	}

	@Test
	public void toArrayObject() {
		Object[] objs = APPReport.toArrayObject(line);
		assertArrayEquals(lineObjs, objs);
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

	private void createObjectArrays() {
		lineObjs = new Object[] { "ST-01-213", "Description", "unit", "10", "2.0", "1", "2.0", "2", "4.0", "3", "6.0", "4", "8.0", "20.0" };
		objArrays = new ArrayList<Object[]>();
		objArrays.add(lineObjs);
	}

	private void createReport() throws ReportException {

		DivisionOffice office = new DivisionOffice("DNSM", "Office of the Division Chair");
		Employee e = Employee.create("Mayor", "John");

		app = new APP(2011, office, e, e);
		app.setPlanControlNumber("CTR-001-002");
		app.setDateScheduled(Date.valueOf("2011-01-01"));

		addAPPLine();

		report = new APPReport(app);

		line = getFirstLine();
	}

	private APPLine getFirstLine() {
		return (APPLine) app.getLines().toArray()[0];
	}

	private void addAPPLine() {
		Item item = Item.create("Description", "Category", "unit", "Single", "Working");
		item.setPrice(2);
		item.setStockNumber("ST-01-213");

		app.addLine(item, 1, 2, 3, 4);
	}
}
