package com.iappsam.entities;

import static org.junit.Assert.*;

import org.junit.Test;

public class ItemCategoryTest {

	@Test
	public void sameCategory() {
		ItemCategory cat = new ItemCategory("Cat");
		ItemCategory cat2 = new ItemCategory("Cat");

		assertEquals(cat, cat2);
	}
}
