package com.iappsam.entities;

import static org.junit.Assert.*;

import org.junit.Test;

public class EmployeeTest {

	@Test
	public void sameEmployee() {
		Employee e = new Employee();
		e.setId(1);

		Employee e2 = new Employee();
		e2.setId(1);

		assertEquals(e, e2);
	}
}
