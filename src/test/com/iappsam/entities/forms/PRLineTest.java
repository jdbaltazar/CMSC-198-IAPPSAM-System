package com.iappsam.entities.forms;

import static org.junit.Assert.*;

import org.junit.Test;

import com.iappsam.forms.PRLine;

public class PRLineTest {

	@Test
	public void samePRLine() {
		PRLine prLine1 = new PRLine();
		prLine1.setId(1);

		PRLine prLine2 = new PRLine();
		prLine2.setId(1);

		assertEquals(prLine1, prLine2);
	}
}
