package com.iappsam.managers.sessions;

import java.util.List;

import com.iappsam.forms.RIS;
import com.iappsam.managers.AbstractManager;
import com.iappsam.managers.RISManager;
import com.iappsam.managers.exceptions.TransactionException;

public class RISManagerSession extends AbstractManager implements RISManager {

	@Override
	public void addRIS(RIS requisitionAndIssueSlip) throws TransactionException {
		add(requisitionAndIssueSlip);
	}

	@Override
	public void updateRIS(RIS requisitionAndIssueSlip) throws TransactionException {
		update(requisitionAndIssueSlip);
	}

	@Override
	public RIS getRIS(String requisitionAndIssueSlipID) throws TransactionException {
		return (RIS) get(RIS.class, requisitionAndIssueSlipID);
	}

	@Override
	public boolean containsRIS(RIS ris) throws TransactionException {
		return getRIS(ris.getRisNumber()) != null;
	}

	@Override
	public List<RIS> getAllRIS() throws TransactionException {
		return getAll(RIS.class);
	}

}
