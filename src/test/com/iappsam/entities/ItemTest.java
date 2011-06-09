package com.iappsam.entities;

import static org.junit.Assert.*;

import java.sql.Date;

import org.junit.Before;
import org.junit.Test;

public class ItemTest {

	private Item item;

	@Before
	public void init() {
		item = new Item();
	}

	@Test
	public void sameItem() {
		item.setId(1);

		Item item2 = new Item();
		item2.setId(1);

		assertEquals(item, item2);
	}

	@Test(expected = RuntimeException.class)
	public void nullDescriptionNotAllowed() {
		item.setDescription(null);
	}

	@Test(expected = RuntimeException.class)
	public void nullCategoryNotAllowed() {
		item.setCategory(null);
	}

	@Test(expected = RuntimeException.class)
	public void nullUnitNotAllowed() {
		item.setUnit(null);
	}

	@Test(expected = RuntimeException.class)
	public void nullStatusNotAllowed() {
		item.setStatus(null);
	}

	@Test(expected = RuntimeException.class)
	public void nullConditionNotAllowed() {
		item.setCondition(null);
	}

	@Test
	public void dateIsInvalid() {
		assertFalse(Item.isDateValid("a", "b", "c"));
	}

	@Test
	public void dateIsValid() {
		assertTrue(Item.isDateValid("2010", "01", "01"));
	}

	@Test
	public void setDateAcquiredStringArgs() {
		Date date = Date.valueOf("2010-01-01");
		item.setDateAcquired("2010", "01", "01");
		assertEquals(date, item.getDateAcquired());
	}

	@Test
	public void setDateAcquiredInSqlDateFormat() {
		Date date = Date.valueOf("2010-01-01");
		item.setDateAcquired("2010-01-01");
		assertEquals(date, item.getDateAcquired());
	}

	@Test
	public void priceNotChangedIfNotFloat() {
		item.setPrice("a");
		assertEquals(0.0f, item.getPrice(), 0);
	}

	@Test
	public void setPriceByString() {
		item.setPrice("1.50");
		assertEquals(1.50, item.getPrice(), 0);
	}
}
