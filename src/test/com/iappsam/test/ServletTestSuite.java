package com.iappsam.test;

import org.junit.runner.RunWith;
import org.junit.runners.Suite;
import org.junit.runners.Suite.SuiteClasses;

import com.iappsam.servlet.LoginServletTest;
import com.iappsam.servlet.app.APPParserTest;
import com.iappsam.servlet.item.ItemServletTest;
import com.iappsam.servlet.pr.PRLineServletTest;
import com.iappsam.servlet.pr.PRServletTest;

@RunWith(Suite.class)
@SuiteClasses({ ItemServletTest.class, // Servlet
		PRServletTest.class,//
		PRLineServletTest.class, //
		APPParserTest.class,//
		LoginServletTest.class })
//
public class ServletTestSuite {

}
