package com.iappsam.managers.sessions;

import org.junit.Before;

import com.iappsam.entities.EntityRemover;
import com.iappsam.managers.exceptions.TransactionException;

public class ManagerSessionTestCase {

	public ManagerSessionTestCase() {
		super();
	}

	@Before
	public void init() throws TransactionException {
		EntityRemover.removeAll();
		afterInit();
	}

	protected void afterInit() {

	}
}