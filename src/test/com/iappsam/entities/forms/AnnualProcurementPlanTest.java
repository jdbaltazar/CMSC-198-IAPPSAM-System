package com.iappsam.entities.forms;

import static org.junit.Assert.*;

import org.junit.Test;

public class AnnualProcurementPlanTest {

	@Test
	public void sameAPP() {
		AnnualProcurementPlan plan1 = new AnnualProcurementPlan();
		plan1.setAppID(1);

		AnnualProcurementPlan plan2 = new AnnualProcurementPlan();
		plan2.setAppID(1);

		assertEquals(plan1, plan2);
	}
}
