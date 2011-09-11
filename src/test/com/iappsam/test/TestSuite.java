package com.iappsam.test;

import org.junit.runner.RunWith;
import org.junit.runners.Suite;
import org.junit.runners.Suite.SuiteClasses;

import com.iappsam.LoginModuleTest;
import com.iappsam.reporting.APPReportTest;
import com.iappsam.reporting.ReportTestSuite;
import com.iappsam.util.HibernateUtilTest;

@RunWith(Suite.class)
@SuiteClasses({ LoginModuleTest.class, //
		HibernateUtilTest.class, //
		EntityTestSuite.class, //
		SessionTestSuite.class, //
		SearcherTestSuite.class, //
		ReportTestSuite.class,
		ServletTestSuite.class })
public class TestSuite {

}
