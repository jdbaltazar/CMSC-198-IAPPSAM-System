package com.iappsam.managers;

import java.util.List;

import com.iappsam.entities.forms.InventoryCustodianSlip;
import com.iappsam.entities.forms.InventoryCustodianSlipLine;
import com.iappsam.managers.exceptions.TransactionException;

public interface ICSManager {

	// ICS

	void addICS(InventoryCustodianSlip inventoryCustodianSlip)
			throws TransactionException;

	int saveICS(InventoryCustodianSlip inventoryCustodianSlip)
			throws TransactionException;

	void updateICS(InventoryCustodianSlip inventoryCustodianSlip)
			throws TransactionException;

	InventoryCustodianSlip getICS(int inventoryCustodianSlipID)
			throws TransactionException;

	boolean containsICS(InventoryCustodianSlip inventoryCustodianSlip)
			throws TransactionException;

	List<InventoryCustodianSlip> ICS() throws TransactionException;

	// ICSLine

	void addICSLine(InventoryCustodianSlipLine inventoryCustodianSlipLine)
			throws TransactionException;

	void updateICSLine(InventoryCustodianSlipLine inventoryCustodianSlipLine)
			throws TransactionException;

	List<InventoryCustodianSlipLine> getICSLineByICS(int inventoryCustodianSlipID)
			throws TransactionException;

	boolean containsICSLine(InventoryCustodianSlipLine inventoryCustodianSlipLine)
			throws TransactionException;

	List<InventoryCustodianSlipLine> getAllICSLine()
			throws TransactionException;

}
