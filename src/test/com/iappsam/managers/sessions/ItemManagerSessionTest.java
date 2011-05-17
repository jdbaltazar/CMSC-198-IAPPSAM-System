package com.iappsam.managers.sessions;

import org.junit.After;
import org.junit.Test;

import com.iappsam.entities.BasicItemEntities;
import com.iappsam.managers.exceptions.TransactionException;

public class ItemManagerSessionTest {

	private BasicItemEntities entities = new BasicItemEntities(new ItemManagerSession());

	@Test
	public void addItemAndRemove() throws TransactionException {
		entities.addAll();
		entities.removeAll();
	}

	@After
	public void removeAllAndClose() throws TransactionException {
		entities.close();
	}
}
