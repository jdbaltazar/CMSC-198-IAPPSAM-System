package com.iappsam.entities;

import static org.junit.Assert.*;

import org.junit.Test;

public class ItemTest {

	@Test
	public void sameItem() {
		Item i = new Item();
		i.setId(1);
		
		Item i2 = new Item();
		i2.setId(1);

		assertEquals(i, i2);
	}
}
