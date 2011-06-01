package com.iappsam.managers.sessions;

import java.util.List;

import com.iappsam.entities.forms.PTRPA;
import com.iappsam.managers.AbstractManager;
import com.iappsam.managers.PTRPAManager;
import com.iappsam.managers.exceptions.TransactionException;

public class PTRPAManagerSession extends AbstractManager implements PTRPAManager {

	@Override
	public void addPTRPA(PTRPA ptrpa) throws TransactionException {
		add(ptrpa);
	}

	@Override
	public int savePTRPA(PTRPA ptrpa) throws TransactionException {
		return (Integer) save(ptrpa);
	}

	@Override
	public void updatePTRPA(PTRPA ptrpa) throws TransactionException {
		update(ptrpa);
	}

	@Override
	public PTRPA getPTRPA(int ptrpaID) throws TransactionException {
		return (PTRPA) get(PTRPA.class, ptrpaID);
	}

	@Override
	public boolean containsPTRPA(PTRPA ptrpa) throws TransactionException {
		return contains(ptrpa);
	}

	@Override
	public List<PTRPA> getAllPTRPA() throws TransactionException {
		return getAll(PTRPA.class);
	}
}
