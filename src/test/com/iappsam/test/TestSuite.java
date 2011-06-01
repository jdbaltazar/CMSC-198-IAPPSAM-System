package com.iappsam.test;

import org.junit.runner.RunWith;
import org.junit.runners.Suite;
import org.junit.runners.Suite.SuiteClasses;

import com.iappsam.entities.ContactTest;
import com.iappsam.entities.DivisionOfficeTest;
import com.iappsam.entities.EmployeeTest;
import com.iappsam.entities.ItemTest;
import com.iappsam.entities.PersonTest;
import com.iappsam.entities.forms.AnnualProcurementPlanTest;
import com.iappsam.managers.sessions.APPManagerSessionTest;
import com.iappsam.managers.sessions.ItemManagerSessionTest;
import com.iappsam.managers.sessions.PersonManagerSessionTest;
import com.iappsam.reporting.APPReportTest;
import com.iappsam.search.IIRUPSearcherTest;
import com.iappsam.search.ItemSearcherTest;
import com.iappsam.util.HibernateUtilTest;

@RunWith(Suite.class)
@SuiteClasses({ HibernateUtilTest.class, //
		PersonTest.class, //
		EmployeeTest.class,//
		ItemTest.class,//
		ContactTest.class, //
		DivisionOfficeTest.class, //
		AnnualProcurementPlanTest.class, //
		PersonManagerSessionTest.class, //
		ItemManagerSessionTest.class, //
		APPManagerSessionTest.class, //
		ItemSearcherTest.class, //
		IIRUPSearcherTest.class, //
		APPReportTest.class })
public class TestSuite {

}
