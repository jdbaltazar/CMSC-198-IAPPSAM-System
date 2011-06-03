package com.iappsam.test;

import org.junit.runner.RunWith;
import org.junit.runners.Suite;
import org.junit.runners.Suite.SuiteClasses;

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
import com.iappsam.managers.sessions.ItemManagerSessionTest;
import com.iappsam.managers.sessions.PersonManagerSessionTest;
import com.iappsam.managers.sessions.SupplierManagerSessionTest;
import com.iappsam.reporting.APPReportTest;
import com.iappsam.search.IIRUPSearcherTest;
import com.iappsam.search.ItemCategorySearcherTest;
import com.iappsam.search.ItemConditionSearcherTest;
import com.iappsam.search.ItemSearcherTest;
import com.iappsam.search.ItemStatusSearcherTest;
import com.iappsam.search.UnitSearcherTest;
import com.iappsam.util.HibernateUtilTest;

@RunWith(Suite.class)
@SuiteClasses({ HibernateUtilTest.class, //
		ItemTest.class,//
		ContactTest.class, //
		DivisionOfficeTest.class, //
		EmployeeTest.class,//
		ItemCategoryTest.class, //
		ItemConditionTest.class, //
		ItemStatusTest.class, //
		PersonTest.class, //
		SignatoryTest.class, //
		SupplierTest.class, //
		AnnualProcurementPlanTest.class, //
		PersonManagerSessionTest.class, //
		SupplierManagerSessionTest.class, //
		ItemManagerSessionTest.class, //
		APPManagerSessionTest.class, //
		ItemSearcherTest.class, //
		ItemCategorySearcherTest.class,//
		ItemConditionSearcherTest.class, //
		ItemStatusSearcherTest.class, //
		UnitSearcherTest.class, //
		IIRUPSearcherTest.class, //
		APPReportTest.class })
public class TestSuite {

}
