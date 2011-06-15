package com.iappsam.entities;

import static org.junit.Assert.*;

import org.junit.Test;

import com.iappsam.Signatory;

public class SignatoryTest {

	@Test
	public void sameSignatory() {
		Signatory signatory = new Signatory();
		signatory.setId(1);
		
		Signatory signatory2 = new Signatory();
		signatory2.setId(1);
		
		assertEquals(signatory, signatory2);
	}
}
