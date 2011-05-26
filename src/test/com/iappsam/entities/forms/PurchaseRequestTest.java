package com.iappsam.entities.forms;

import static org.junit.Assert.*;

import org.junit.Test;

public class PurchaseRequestTest {

	@Test
	public void samePR() {
		PurchaseRequest pr = new PurchaseRequest();
		pr.setId(1);

		PurchaseRequest pr2 = new PurchaseRequest();
		pr2.setId(1);

		assertEquals(pr, pr2);
	}
}
