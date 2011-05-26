package com.iappsam.entities.forms;

import static org.junit.Assert.*;

import org.junit.Test;

public class PurchaseRequestLineTest {

	@Test
	public void samePRLine() {
		PurchaseRequestLine prLine1 = new PurchaseRequestLine();
		prLine1.setId(1);

		PurchaseRequestLine prLine2 = new PurchaseRequestLine();
		prLine2.setId(1);

		assertEquals(prLine1, prLine2);
	}
}
