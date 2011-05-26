package com.iappsam.managers.sessions;

import java.util.ArrayList;
import java.util.List;

import com.iappsam.entities.forms.PurchaseRequest;
import com.iappsam.entities.forms.PurchaseRequestLine;
import com.iappsam.managers.AbstractManager;
import com.iappsam.managers.PRManager;
import com.iappsam.managers.exceptions.TransactionException;

public class PRManagerSession extends AbstractManager implements PRManager {

	@Override
	public void addPR(PurchaseRequest purchaseRequest) throws TransactionException {
		add(purchaseRequest);
	}

	@Override
	public int savePR(PurchaseRequest purchaseRequest) throws TransactionException {
		return (Integer) save(purchaseRequest);
	}

	@Override
	public void updatePR(PurchaseRequest purchaseRequest) throws TransactionException {
		update(purchaseRequest);
	}

	@Override
	public PurchaseRequest getPR(int purchaseRequestID) throws TransactionException {
		return (PurchaseRequest) get(PurchaseRequest.class, purchaseRequestID);
	}

	@Override
	public boolean containsPR(PurchaseRequest purchaseRequest) throws TransactionException {
		return contains(purchaseRequest);
	}

	@Override
	public List<PurchaseRequest> getAllPR() throws TransactionException {
		return getList(PurchaseRequest.class);
	}

	@Override
	public void addPRLine(PurchaseRequestLine purchaseRequestLine) throws TransactionException {
		add(purchaseRequestLine);
	}

	@Override
	public void updatePRLine(PurchaseRequestLine purchaseRequestLine) throws TransactionException {
		update(purchaseRequestLine);
	}

	@Override
	public List<PurchaseRequestLine> getPRLineByPR(int purchaseRequestID) throws TransactionException {
		List<PurchaseRequestLine> prLines = getAllPRLine();
		List<PurchaseRequestLine> result = new ArrayList<PurchaseRequestLine>();
		for (PurchaseRequestLine prLine : prLines) {
			if (prLine.getId() == purchaseRequestID)
				result.add(prLine);
		}
		return result;
	}

	@Override
	public boolean containsPRLine(PurchaseRequestLine purchaseRequestLine) throws TransactionException {
		return contains(purchaseRequestLine);
	}

	@Override
	public void removePRLine(PurchaseRequestLine purchaseRequestLine) throws TransactionException {
		remove(purchaseRequestLine);
	}

	@Override
	public List<PurchaseRequestLine> getAllPRLine() throws TransactionException {
		return getList(PurchaseRequestLine.class);
	}

	@Override
	public void removePR(PurchaseRequest pr) throws TransactionException {
		remove(pr);
	}
}
