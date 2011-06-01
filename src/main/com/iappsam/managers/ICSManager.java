package com.iappsam.managers;

import java.util.List;

import com.iappsam.entities.forms.InventoryCustodianSlip;
import com.iappsam.managers.exceptions.TransactionException;

public interface ICSManager {

	void addICS(InventoryCustodianSlip inventoryCustodianSlip) throws TransactionException;

	int saveICS(InventoryCustodianSlip inventoryCustodianSlip) throws TransactionException;

	void updateICS(InventoryCustodianSlip inventoryCustodianSlip) throws TransactionException;

	InventoryCustodianSlip getICS(int inventoryCustodianSlipID) throws TransactionException;

	boolean containsICS(InventoryCustodianSlip inventoryCustodianSlip) throws TransactionException;

	List<InventoryCustodianSlip> getAllICS() throws TransactionException;
}
