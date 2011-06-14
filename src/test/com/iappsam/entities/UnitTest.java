package com.iappsam.entities;

import static org.junit.Assert.*;

import org.junit.Test;

import com.iappsam.Unit;

public class UnitTest {

	@Test
	public void sameUnit() {
		Unit unit = new Unit("unit");
		Unit unit2 = new Unit("unit");

		assertEquals(unit, unit2);
	}
}
