package com.iappsam.entities;

import static org.junit.Assert.*;

import org.junit.Test;

import com.iappsam.ItemCategory;

public class ItemCategoryTest {

	@Test
	public void sameCategory() {
		ItemCategory cat = new ItemCategory("Cat");
		ItemCategory cat2 = new ItemCategory("Cat");

		assertEquals(cat, cat2);
	}

	@Test
	public void toStringIsName() {
		ItemCategory cat = new ItemCategory("Cat");
		assertEquals(cat.getName(), cat.toString());
	}
}
