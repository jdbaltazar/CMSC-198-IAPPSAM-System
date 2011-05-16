package com.iappsam.managers.sessions;

import java.util.ArrayList;
import java.util.List;

import com.iappsam.entities.forms.InventoryCustodianSlip;
import com.iappsam.entities.forms.InventoryCustodianSlipLine;
import com.iappsam.managers.ICSManager;
import com.iappsam.managers.AbstractManager;
import com.iappsam.managers.exceptions.TransactionException;

public class ICSManagerSession extends AbstractManager implements ICSManager {

	@Override
	public void addICS(InventoryCustodianSlip inventoryCustodianSlip)
			throws TransactionException {
		// TODO Auto-generated method stub
		add(inventoryCustodianSlip);
	}

	@Override
	public int saveICS(InventoryCustodianSlip inventoryCustodianSlip)
			throws TransactionException {
		// TODO Auto-generated method stub
		return (Integer) save(inventoryCustodianSlip);
	}

	@Override
	public void updateICS(InventoryCustodianSlip inventoryCustodianSlip)
			throws TransactionException {
		// TODO Auto-generated method stub
		update(inventoryCustodianSlip);
	}

	@Override
	public InventoryCustodianSlip getICS(int inventoryCustodianSlipID)
			throws TransactionException {
		// TODO Auto-generated method stub
		return (InventoryCustodianSlip) get(InventoryCustodianSlip.class,
				inventoryCustodianSlipID);
	}

	@Override
	public boolean containsICS(InventoryCustodianSlip inventoryCustodianSlip)
			throws TransactionException {
		// TODO Auto-generated method stub
		return contains(inventoryCustodianSlip);
	}

	@Override
	public List<InventoryCustodianSlip> ICS() throws TransactionException {
		// TODO Auto-generated method stub
		return getList(InventoryCustodianSlip.class);
	}

	@Override
	public void addICSLine(InventoryCustodianSlipLine inventoryCustodianSlipLine)
			throws TransactionException {
		// TODO Auto-generated method stub
		add(inventoryCustodianSlipLine);
	}

	@Override
	public void updateICSLine(
			InventoryCustodianSlipLine inventoryCustodianSlipLine)
			throws TransactionException {
		// TODO Auto-generated method stub
		update(inventoryCustodianSlipLine);
	}

	@Override
	public List<InventoryCustodianSlipLine> getICSLineByICS(
			int inventoryCustodianSlipID) throws TransactionException {
		// TODO Auto-generated method stub
		List<InventoryCustodianSlipLine> icsLines = getAllICSLine();
		List<InventoryCustodianSlipLine> result = new ArrayList<InventoryCustodianSlipLine>();
		for (InventoryCustodianSlipLine icsLine : icsLines) {
			if (icsLine.getIcsID() == inventoryCustodianSlipID)
				result.add(icsLine);
		}
		return result;
	}

	@Override
	public boolean containsICSLine(
			InventoryCustodianSlipLine inventoryCustodianSlipLine)
			throws TransactionException {
		// TODO Auto-generated method stub
		return contains(inventoryCustodianSlipLine);
	}

	@Override
	public List<InventoryCustodianSlipLine> getAllICSLine()
			throws TransactionException {
		// TODO Auto-generated method stub
		return getList(InventoryCustodianSlipLine.class);
	}

}
