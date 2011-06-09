package com.iappsam.managers.sessions;

import java.util.List;

import com.iappsam.entities.forms.IIRUP;
import com.iappsam.entities.forms.IIRUPLine;
import com.iappsam.managers.IIRUPManager;
import com.iappsam.managers.AbstractManager;
import com.iappsam.managers.exceptions.TransactionException;

public class IIRUPManagerSession extends AbstractManager implements IIRUPManager {

	@Override
	public void addIIRUP(IIRUP iirup) throws TransactionException {
		add(iirup);
	}

	@Override
	public void updateIIRUP(IIRUP iirup) throws TransactionException {
		update(iirup);
	}

	@Override
	public IIRUP getIIRUP(int iirupID) throws TransactionException {
		return (IIRUP) get(IIRUP.class, iirupID);
	}

	@Override
	public boolean containsIIRUP(IIRUP iirup) throws TransactionException {
		return getIIRUP(iirup.getId()) != null;
	}

	@Override
	public List<IIRUP> getAllIIRUP() throws TransactionException {
		return getAll(IIRUP.class);
	}

	@Override
	public void removeIIRUP(IIRUP iirup) throws TransactionException {
		remove(iirup);
	}
}
