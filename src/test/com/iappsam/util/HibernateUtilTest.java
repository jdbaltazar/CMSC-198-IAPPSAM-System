package com.iappsam.util;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Test;

public class HibernateUtilTest {

	@Test
	public void hotBoot() {
		assertTrue(HibernateUtil.hotBoot());
		assertTrue(HibernateUtil.evaluate("root", "123456"));

		assertFalse(HibernateUtil.hotBoot());
	}

	@Test
	public void invalidAccount() {
		assertFalse(HibernateUtil.evaluate("root", ""));
	}

	@After
	public void cleanup() {
		HibernateUtil.close();
	}
}
