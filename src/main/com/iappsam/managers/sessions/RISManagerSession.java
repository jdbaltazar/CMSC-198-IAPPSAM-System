package com.iappsam.managers.sessions;

import java.util.List;

import com.iappsam.forms.RAIS;
import com.iappsam.managers.AbstractManager;
import com.iappsam.managers.RISManager;
import com.iappsam.managers.exceptions.TransactionException;

public class RISManagerSession extends AbstractManager implements RISManager {

	@Override
	public void addRIS(RAIS requisitionAndIssueSlip) throws TransactionException {
		add(requisitionAndIssueSlip);
	}

	@Override
	public void updateRIS(RAIS requisitionAndIssueSlip) throws TransactionException {
		update(requisitionAndIssueSlip);
	}

	@Override
	public RAIS getRIS(String requisitionAndIssueSlipID) throws TransactionException {
		return (RAIS) get(RAIS.class, requisitionAndIssueSlipID);
	}

	@Override
	public boolean containsRIS(RAIS ris) throws TransactionException {
		return getRIS(ris.getRisNumber()) != null;
	}

	@Override
	public List<RAIS> getAllRIS() throws TransactionException {
		return getAll(RAIS.class);
	}

}
