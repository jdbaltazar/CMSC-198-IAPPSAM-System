package com.iappsam.entities.forms;

import static org.junit.Assert.*;

import org.junit.Test;

public class DisposalTest {

	@Test
	public void sameDisposal() {
		Disposal disposal = new Disposal();
		disposal.setId(1);

		Disposal disposal2 = new Disposal();
		disposal2.setId(1);

		assertEquals(disposal, disposal2);
	}
}
