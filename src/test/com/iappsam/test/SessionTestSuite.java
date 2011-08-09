package com.iappsam.test;

import org.junit.runner.RunWith;
import org.junit.runners.Suite;
import org.junit.runners.Suite.SuiteClasses;

import com.iappsam.managers.sessions.APPManagerSessionTest;
import com.iappsam.managers.sessions.IEManagerSessionTest;
import com.iappsam.managers.sessions.IIRUPManagerSessionTest;
import com.iappsam.managers.sessions.ItemManagerSessionTest;
import com.iappsam.managers.sessions.POManagerSessionTest;
import com.iappsam.managers.sessions.PRManagerSessionTest;
import com.iappsam.managers.sessions.PersonManagerSessionTest;
import com.iappsam.managers.sessions.SupplierManagerSessionTest;

@RunWith(Suite.class)
@SuiteClasses({ PersonManagerSessionTest.class, //
		SupplierManagerSessionTest.class, //
		ItemManagerSessionTest.class, //
		IIRUPManagerSessionTest.class, //
		APPManagerSessionTest.class, //
		IEManagerSessionTest.class, //
		PRManagerSessionTest.class, //
		POManagerSessionTest.class //
})
public class SessionTestSuite {

}
