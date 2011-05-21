package com.iappsam.entities;

import static org.junit.Assert.*;

import org.junit.Test;

public class DivisionOfficeTest {

	@Test
	public void sameDivisionOffice() {
		DivisionOffice d = new DivisionOffice();
		d.setId(1);

		DivisionOffice d2 = new DivisionOffice();
		d2.setId(1);

		assertEquals(d, d2);
	}
}
