package com.iappsam.managers.sessions;

import org.junit.After;
import org.junit.Test;

import com.iappsam.entities.BasicItemEntities;
import com.iappsam.managers.exceptions.TransactionException;

public class ItemManagerSessionTest {

	private ItemManagerSession im = new ItemManagerSession();
	private BasicItemEntities entities = new BasicItemEntities(im);

	@Test
	public void addItemAndRemove() throws TransactionException {
		entities.addAll();
		entities.removeAllIfExist();
	}

	@Test(expected = TransactionException.class)
	public void addItemThenRemoveTwice() throws TransactionException {
		entities.addAll();
		entities.removeAllIfExist();
		im.removeItem(entities.getItem());
	}

	@After
	public void removeAllAndClose() throws TransactionException {
		entities.close();
	}
}
