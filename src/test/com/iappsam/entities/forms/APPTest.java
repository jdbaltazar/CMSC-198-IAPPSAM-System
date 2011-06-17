package com.iappsam.entities.forms;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import com.iappsam.DivisionOffice;
import com.iappsam.Employee;
import com.iappsam.forms.APP;

public class APPTest {

	private APP app;

	@Before
	public void initApp() {
		app = new APP(2010, new DivisionOffice("division", "office"), Employee.create("des", "name"), Employee.create("des", "name"));
	}

	@Test
	public void shouldBeInvalidDateZero() {
		app.setYear(0);
		assertFalse(app.validate());
	}
}
