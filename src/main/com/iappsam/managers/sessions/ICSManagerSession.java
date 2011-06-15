package com.iappsam.managers.sessions;

import java.util.List;

import com.iappsam.forms.ICS;
import com.iappsam.managers.ICSManager;
import com.iappsam.managers.AbstractManager;
import com.iappsam.managers.exceptions.TransactionException;

public class ICSManagerSession extends AbstractManager implements ICSManager {

	@Override
	public void addICS(ICS inventoryCustodianSlip) throws TransactionException {
		add(inventoryCustodianSlip);
	}

	@Override
	public void updateICS(ICS inventoryCustodianSlip) throws TransactionException {
		update(inventoryCustodianSlip);
	}

	@Override
	public ICS getICS(int inventoryCustodianSlipID) throws TransactionException {
		return (ICS) get(ICS.class, inventoryCustodianSlipID);
	}

	@Override
	public boolean containsICS(ICS inventoryCustodianSlip) throws TransactionException {
		return getICS(inventoryCustodianSlip.getIcsID()) != null;
	}

	@Override
	public List<ICS> getAllICS() throws TransactionException {
		return getAll(ICS.class);
	}
}
