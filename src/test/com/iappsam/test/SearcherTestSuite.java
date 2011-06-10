package com.iappsam.test;

import org.junit.runner.RunWith;
import org.junit.runners.Suite;
import org.junit.runners.Suite.SuiteClasses;

import com.iappsam.search.IIRUPSearcherTest;
import com.iappsam.search.ItemSearcherTest;

@RunWith(Suite.class)
@SuiteClasses({ ItemSearcherTest.class, // Search
		IIRUPSearcherTest.class })
public class SearcherTestSuite {

}
