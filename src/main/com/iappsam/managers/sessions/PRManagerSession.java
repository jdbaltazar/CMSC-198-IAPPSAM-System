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
		return getAll(PurchaseRequest.class);
	}

	@Override
	public void removePR(PurchaseRequest pr) throws TransactionException {
		remove(pr);
	}
}
