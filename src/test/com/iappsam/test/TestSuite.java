package com.iappsam.test;

import org.junit.runner.RunWith;
import org.junit.runners.Suite;
import org.junit.runners.Suite.SuiteClasses;

import com.iappsam.LoginModuleTest;
import com.iappsam.entities.ContactTest;
import com.iappsam.entities.DivisionOfficeTest;
import com.iappsam.entities.EmployeeTest;
import com.iappsam.entities.ItemCategoryTest;
import com.iappsam.entities.ItemConditionTest;
import com.iappsam.entities.ItemStatusTest;
import com.iappsam.entities.ItemTest;
import com.iappsam.entities.PersonTest;
import com.iappsam.entities.SignatoryTest;
import com.iappsam.entities.SupplierTest;
import com.iappsam.entities.forms.AnnualProcurementPlanTest;
import com.iappsam.managers.sessions.APPManagerSessionTest;
import com.iappsam.managers.sessions.IIRUPManagerSessionTest;
import com.iappsam.managers.sessions.ItemManagerSessionTest;
import com.iappsam.managers.sessions.PersonManagerSessionTest;
import com.iappsam.managers.sessions.SupplierManagerSessionTest;
import com.iappsam.reporting.APPReportTest;
import com.iappsam.search.IIRUPSearcherTest;
import com.iappsam.search.ItemSearcherTest;
import com.iappsam.servlet.LoginServletTest;
import com.iappsam.servlet.item.ItemServletTest;
import com.iappsam.servlet.pr.PurchaseRequestServlet;
import com.iappsam.servlet.pr.PurchaseRequestServletTest;
import com.iappsam.util.HibernateUtilTest;

@RunWith(Suite.class)
@SuiteClasses({ LoginModuleTest.class, //
		HibernateUtilTest.class, //
		EntityTestSuite.class, //
		SessionTestSuite.class, //
		SearcherTestSuite.class, //
		APPReportTest.class, // Report
		ServletTestSuite.class })
public class TestSuite {

}
