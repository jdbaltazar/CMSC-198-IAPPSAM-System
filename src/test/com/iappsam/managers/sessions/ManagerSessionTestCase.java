package com.iappsam.managers.sessions;

import com.iappsam.entities.EntityRemover;

public class ManagerSessionTestCase {

	public ManagerSessionTestCase() {
		super();
	}

	public void init() throws Exception {
		EntityRemover.removeAll();
	}

}