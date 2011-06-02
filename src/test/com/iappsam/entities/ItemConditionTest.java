package com.iappsam.entities;

import static org.junit.Assert.*;

import org.junit.Test;

public class ItemConditionTest {

	@Test
	public void sameItemCondition() {
		ItemCondition condition = new ItemCondition("cond");
		ItemCondition condition2 = new ItemCondition("cond");
		
		assertEquals(condition, condition2);
	}
}
