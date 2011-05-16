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
	public void addRIS(RequisitionAndIssueSlip requisitionAndIssueSlip)
			throws TransactionException {
		// TODO Auto-generated method stub
		add(requisitionAndIssueSlip);
	}

	@Override
	public int saveRIS(RequisitionAndIssueSlip requisitionAndIssueSlip)
			throws TransactionException {
		// TODO Auto-generated method stub
		return (Integer) save(requisitionAndIssueSlip);
	}

	@Override
	public void updateRIS(RequisitionAndIssueSlip requisitionAndIssueSlip)
			throws TransactionException {
		// TODO Auto-generated method stub
		update(requisitionAndIssueSlip);
	}

	@Override
	public RequisitionAndIssueSlip getRIS(int requisitionAndIssueSlipID)
			throws TransactionException {
		// TODO Auto-generated method stub
		return (RequisitionAndIssueSlip) get(RequisitionAndIssueSlip.class,
				requisitionAndIssueSlipID);
	}

	@Override
	public boolean containsRIS(RequisitionAndIssueSlip requisitionAndIssueSlip)
			throws TransactionException {
		// TODO Auto-generated method stub
		return contains(requisitionAndIssueSlip);
	}

	@Override
	public List<RequisitionAndIssueSlip> getAllRIS()
			throws TransactionException {
		// TODO Auto-generated method stub
		return getList(RequisitionAndIssueSlip.class);
	}

	@Override
	public void addRISLine(
			RequisitionAndIssueSlipLine requisitionAndIssueSlipLine)
			throws TransactionException {
		// TODO Auto-generated method stub
		add(requisitionAndIssueSlipLine);
	}

	@Override
	public void updateRISLine(
			RequisitionAndIssueSlipLine requisitionAndIssueSlipLine)
			throws TransactionException {
		// TODO Auto-generated method stub
		update(requisitionAndIssueSlipLine);
	}

	@Override
	public List<RequisitionAndIssueSlipLine> getRISLineByRIS(
			int requisitionAndIssueSlipID) throws TransactionException {
		// TODO Auto-generated method stub
		List<RequisitionAndIssueSlipLine> risLines = getAllRISLine();
		List<RequisitionAndIssueSlipLine> result = new ArrayList<RequisitionAndIssueSlipLine>();
		for (RequisitionAndIssueSlipLine risLine : risLines) {
			if (risLine.getRisNumber() == requisitionAndIssueSlipID) {
				result.add(risLine);
			}
		}
		return result;
	}

	@Override
	public boolean containsRISLine(
			RequisitionAndIssueSlipLine requisitionAndIssueSlipLine)
			throws TransactionException {
		// TODO Auto-generated method stub
		return contains(requisitionAndIssueSlipLine);
	}

	@Override
	public List<RequisitionAndIssueSlipLine> getAllRISLine()
			throws TransactionException {
		// TODO Auto-generated method stub
		return getList(RequisitionAndIssueSlipLine.class);
	}

}
