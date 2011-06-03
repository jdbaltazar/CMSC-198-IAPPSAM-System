package com.iappsam.util;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import com.iappsam.entities.EntityRemover;
import com.iappsam.managers.exceptions.TransactionException;

public class HibernateUtilTest {

	@Before
	public void removeAll() throws TransactionException {
		EntityRemover.removeAll();
	}

	@Test
	public void isConnected() {
		assertTrue(HibernateUtil.isConnected());
	}
}
