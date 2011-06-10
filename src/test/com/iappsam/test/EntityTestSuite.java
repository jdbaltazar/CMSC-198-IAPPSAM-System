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

@RunWith(Suite.class)
@SuiteClasses({ ItemTest.class,//
		ContactTest.class, //
		DivisionOfficeTest.class, //
		EmployeeTest.class,//
		ItemCategoryTest.class, //
		ItemConditionTest.class, //
		ItemStatusTest.class, //
		PersonTest.class, //
		SignatoryTest.class, //
		SupplierTest.class, //
		AnnualProcurementPlanTest.class })
public class EntityTestSuite {

}
