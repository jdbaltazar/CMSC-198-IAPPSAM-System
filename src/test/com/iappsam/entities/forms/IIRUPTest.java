package com.iappsam.entities.forms;

import static org.junit.Assert.*;

import org.junit.Test;

public class IIRUPTest {

	@Test
	public void sameIIRUP() {
		IIRUP iirup = new IIRUP();
		iirup.setId(1);

		IIRUP iirup2 = new IIRUP();
		iirup2.setId(1);

		assertEquals(iirup, iirup2);
	}
}
