package com.iappsam.entities.forms;

import static org.junit.Assert.*;

import org.junit.Test;

public class AnnualProcurementPlanLineTest {

	@Test
	public void sameAppLine() {
		AnnualProcurementPlanLine line = new AnnualProcurementPlanLine();
		line.setId(1);

		AnnualProcurementPlanLine line2 = new AnnualProcurementPlanLine();
		line2.setId(1);
		
		assertEquals(line, line2);
	}
}
