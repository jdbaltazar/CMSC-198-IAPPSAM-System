package com.iappsam.managers.sessions;

import java.util.List;

import com.iappsam.entities.forms.PurchaseRequest;
import com.iappsam.managers.AbstractManager;
import com.iappsam.managers.PRManager;
import com.iappsam.managers.exceptions.TransactionException;

public class PRManagerSession extends AbstractManager implements PRManager {

	@Override
	public void addPR(PurchaseRequest pr) throws TransactionException {
		if (pr.isValid())
			add(pr);
	}

	@Override
	public void updatePR(PurchaseRequest pr) throws TransactionException {
		update(pr);
	}

	@Override
	public PurchaseRequest getPR(int id) throws TransactionException {
		return (PurchaseRequest) get(PurchaseRequest.class, id);
	}

	@Override
	public boolean containsPR(PurchaseRequest pr) throws TransactionException {
		return getPR(pr.getId()) != null;
	}

	@Override
	public List<PurchaseRequest> getAllPR() throws TransactionException {
		return getAll(PurchaseRequest.class);
	}

	@Override
	public void removePR(PurchaseRequest pr) throws TransactionException {
		remove(pr);
	}

	@Override
	public PurchaseRequest getPR(PurchaseRequest pr) throws TransactionException {
		return getPR(pr.getId());
	}
}
