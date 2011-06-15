package com.iappsam.managers;

import java.util.List;

import com.iappsam.forms.ICS;
import com.iappsam.managers.exceptions.TransactionException;

public interface ICSManager {

	void addICS(ICS inventoryCustodianSlip) throws TransactionException;

	void updateICS(ICS inventoryCustodianSlip) throws TransactionException;

	ICS getICS(int inventoryCustodianSlipID) throws TransactionException;

	boolean containsICS(ICS inventoryCustodianSlip) throws TransactionException;

	List<ICS> getAllICS() throws TransactionException;
}
