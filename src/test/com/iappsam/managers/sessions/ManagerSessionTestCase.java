package com.iappsam.managers.sessions;

import com.iappsam.entities.EntityRemover;
import com.iappsam.managers.exceptions.DuplicateEntryException;
import com.iappsam.managers.exceptions.TransactionException;

public class ManagerSessionTestCase {

	public ManagerSessionTestCase() {
		super();
	}

	public void init() throws Exception {
		EntityRemover.removeAll();
	}

}