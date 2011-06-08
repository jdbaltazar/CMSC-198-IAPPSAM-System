package com.iappsam.search;

import org.junit.BeforeClass;

import com.iappsam.managers.ItemManager;
import com.iappsam.managers.exceptions.TransactionException;
import com.iappsam.managers.sessions.ItemManagerSession;

public abstract class ItemManagerTestSuite {

	protected static ItemManager im;

	@BeforeClass
	public static void initClass() throws TransactionException {
		im = new ItemManagerSession();
	}

}