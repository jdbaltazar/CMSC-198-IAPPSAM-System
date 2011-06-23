package com.iappsam.test;

import org.junit.runner.RunWith;
import org.junit.runners.Suite;
import org.junit.runners.Suite.SuiteClasses;

import com.iappsam.search.IIRUPSearcherTest;
import com.iappsam.search.ItemSearcherTest;
import com.iappsam.search.PrSearcherTest;
import com.iappsam.search.SupplierSearcherTest;

@RunWith(Suite.class)
@SuiteClasses({ ItemSearcherTest.class, //
		IIRUPSearcherTest.class, //
		PrSearcherTest.class, //
		SupplierSearcherTest.class })
public class SearcherTestSuite {

}
