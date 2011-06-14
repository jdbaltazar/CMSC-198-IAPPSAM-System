package com.iappsam.entities.forms;

import static org.junit.Assert.*;

import org.junit.Test;

import com.iappsam.forms.APP;

public class AnnualProcurementPlanTest {

	@Test
	public void sameAPP() {
		APP plan1 = new APP();
		plan1.setAppID(1);

		APP plan2 = new APP();
		plan2.setAppID(1);

		assertEquals(plan1, plan2);
	}
}
