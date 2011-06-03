package com.iappsam.managers.sessions;

import java.util.ArrayList;
import java.util.List;

import com.iappsam.entities.forms.RequisitionAndIssueSlip;
import com.iappsam.entities.forms.RequisitionAndIssueSlipLine;
import com.iappsam.managers.AbstractManager;
import com.iappsam.managers.RISManager;
import com.iappsam.managers.exceptions.TransactionException;

public class RISManagerSession extends AbstractManager implements RISManager {

	@Override
	public void addRIS(RequisitionAndIssueSlip requisitionAndIssueSlip) throws TransactionException {
		add(requisitionAndIssueSlip);
	}

	@Override
	public int saveRIS(RequisitionAndIssueSlip requisitionAndIssueSlip) throws TransactionException {
		return (Integer) save(requisitionAndIssueSlip);
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
	public boolean containsRIS(RequisitionAndIssueSlip requisitionAndIssueSlip) throws TransactionException {
		return contains(requisitionAndIssueSlip);
	}

	@Override
	public List<RequisitionAndIssueSlip> getAllRIS() throws TransactionException {
		return getAll(RequisitionAndIssueSlip.class);
	}

}
