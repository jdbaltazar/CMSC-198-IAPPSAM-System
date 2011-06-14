package com.iappsam.managers.sessions;

import java.util.List;

import com.iappsam.entities.forms.RequisitionAndIssueSlip;
import com.iappsam.managers.AbstractManager;
import com.iappsam.managers.RISManager;
import com.iappsam.managers.exceptions.TransactionException;

public class RISManagerSession extends AbstractManager implements RISManager {

	@Override
	public void addRIS(RequisitionAndIssueSlip requisitionAndIssueSlip) throws TransactionException {
		add(requisitionAndIssueSlip);
	}

	@Override
	public void updateRIS(RequisitionAndIssueSlip requisitionAndIssueSlip) throws TransactionException {
		update(requisitionAndIssueSlip);
	}

	@Override
	public RequisitionAndIssueSlip getRIS(String requisitionAndIssueSlipID) throws TransactionException {
		return (RequisitionAndIssueSlip) get(RequisitionAndIssueSlip.class, requisitionAndIssueSlipID);
	}

	@Override
	public boolean containsRIS(RequisitionAndIssueSlip ris) throws TransactionException {
		return getRIS(ris.getRisNumber()) != null;
	}

	@Override
	public List<RequisitionAndIssueSlip> getAllRIS() throws TransactionException {
		return getAll(RequisitionAndIssueSlip.class);
	}

}
