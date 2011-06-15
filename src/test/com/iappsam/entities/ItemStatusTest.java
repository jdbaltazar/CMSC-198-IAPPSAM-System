package com.iappsam.entities;

import static org.junit.Assert.*;

import org.junit.Test;

import com.iappsam.ItemStatus;

public class ItemStatusTest {

	@Test
	public void sameItemStatus() {
		ItemStatus status = new ItemStatus("stat");
		ItemStatus status2 = new ItemStatus("stat");

		assertEquals(status, status2);
	}
}
