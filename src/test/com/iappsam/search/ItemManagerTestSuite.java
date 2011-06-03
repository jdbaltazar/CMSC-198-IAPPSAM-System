package com.iappsam.search;

import org.junit.Before;
import org.junit.BeforeClass;

import com.iappsam.entities.EntityRemover;
import com.iappsam.managers.ItemManager;
import com.iappsam.managers.exceptions.TransactionException;
import com.iappsam.managers.sessions.ItemManagerSession;

public abstract class ItemManagerTestSuite {

	protected static ItemManager im;

	@BeforeClass
	public static void initItemManager() {
		im = new ItemManagerSession();
	}

	@Before
	public void init() throws Exception {
		EntityRemover.removeAll();
		initAfter();
	}

	protected void initAfter() throws Exception {

	}
}