package com.iappsam.entities;

import static org.junit.Assert.*;

import java.sql.Date;

import org.junit.Before;
import org.junit.Test;

import com.iappsam.Item;

public class ItemTest {

	private Item item;

	@Before
	public void init() {
		item = Item.create("des", "cat", "unit", "stat", "con");
	}

	@Test
	public void shouldBeValidIfRequiredFieldsFilled() {
		assertTrue(item.validate());
	}

	@Test
	public void shouldNotBeValidIfNullDescription() {
		item.setDescription(null);
		assertFalse(item.validate());
	}

	@Test
	public void shouldNotBeValidIfEmptyDescription() {
		item.setDescription("");
		assertFalse(item.validate());
	}

	@Test
	public void shouldNotBeValidIfNullCategory() {
		item.setCategory(null);
		assertFalse(item.validate());
	}

	@Test
	public void shouldNotBeValidIfNullUnit() {
		item.setUnit(null);
		assertFalse(item.validate());
	}

	@Test
	public void shouldNotBeValidIfNullStatus() {
		item.setStatus(null);
		assertFalse(item.validate());
	}

	@Test
	public void shouldNotBeValidIfNullCondition() {
		item.setCondition(null);
		assertFalse(item.validate());
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
	public void shouldNotChangedPriceIfNotFloat() {
		item.setPrice("a");
		assertEquals(0.0f, item.getPrice(), 0);
	}

	@Test
	public void shouldSetPriceByString() {
		item.setPrice("1.50");
		assertEquals(1.50, item.getPrice(), 0);
	}
}
