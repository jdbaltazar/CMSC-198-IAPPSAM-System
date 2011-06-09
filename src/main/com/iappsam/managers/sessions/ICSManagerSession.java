package com.iappsam.managers.sessions;

import java.util.List;

import com.iappsam.entities.forms.InventoryCustodianSlip;
import com.iappsam.managers.ICSManager;
import com.iappsam.managers.AbstractManager;
import com.iappsam.managers.exceptions.TransactionException;

public class ICSManagerSession extends AbstractManager implements ICSManager {

	@Override
	public void addICS(InventoryCustodianSlip inventoryCustodianSlip) throws TransactionException {
		add(inventoryCustodianSlip);
	}

	@Override
	public void updateICS(InventoryCustodianSlip inventoryCustodianSlip) throws TransactionException {
		update(inventoryCustodianSlip);
	}

	@Override
	public InventoryCustodianSlip getICS(int inventoryCustodianSlipID) throws TransactionException {
		return (InventoryCustodianSlip) get(InventoryCustodianSlip.class, inventoryCustodianSlipID);
	}

	@Override
	public boolean containsICS(InventoryCustodianSlip inventoryCustodianSlip) throws TransactionException {
		return getICS(inventoryCustodianSlip.getIcsID()) != null;
	}

	@Override
	public List<InventoryCustodianSlip> getAllICS() throws TransactionException {
		return getAll(InventoryCustodianSlip.class);
	}
}
