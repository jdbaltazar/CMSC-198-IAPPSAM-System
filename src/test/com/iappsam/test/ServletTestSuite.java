package com.iappsam.test;

import org.junit.runner.RunWith;
import org.junit.runners.Suite;
import org.junit.runners.Suite.SuiteClasses;

import com.iappsam.servlet.LoginServletTest;
import com.iappsam.servlet.item.ItemServletTest;
import com.iappsam.servlet.pr.PurchaseRequestServletTest;

@RunWith(Suite.class)
@SuiteClasses({ ItemServletTest.class, // Servlet
		PurchaseRequestServletTest.class, //
		LoginServletTest.class })
//
public class ServletTestSuite {

}
