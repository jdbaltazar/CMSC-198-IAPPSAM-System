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
		// TODO Auto-generated method stub
		add(purchaseRequest);
	}

	@Override
	public int savePR(PurchaseRequest purchaseRequest) throws TransactionException {
		// TODO Auto-generated method stub
		return (Integer) save(purchaseRequest);
	}

	@Override
	public void updatePR(PurchaseRequest purchaseRequest) throws TransactionException {
		// TODO Auto-generated method stub
		update(purchaseRequest);
	}

	@Override
	public PurchaseRequest getPR(int purchaseRequestID) throws TransactionException {
		// TODO Auto-generated method stub
		return (PurchaseRequest) get(PurchaseRequest.class, purchaseRequestID);
	}

	@Override
	public boolean containsPR(PurchaseRequest purchaseRequest) throws TransactionException {
		// TODO Auto-generated method stub
		return contains(purchaseRequest);
	}

	@Override
	public List<PurchaseRequest> getAllPR() throws TransactionException {
		// TODO Auto-generated method stub
		return getList(PurchaseRequest.class);
	}

	@Override
	public void addPRLine(PurchaseRequestLine purchaseRequestLine) throws TransactionException {
		// TODO Auto-generated method stub
		add(purchaseRequestLine);
	}

	@Override
	public void updatePRLine(PurchaseRequestLine purchaseRequestLine) throws TransactionException {
		// TODO Auto-generated method stub
		update(purchaseRequestLine);
	}

	@Override
	public List<PurchaseRequestLine> getPRLineByPR(int purchaseRequestID) throws TransactionException {
		// TODO Auto-generated method stub
		List<PurchaseRequestLine> prLines = getAllPRLine();
		List<PurchaseRequestLine> result = new ArrayList<PurchaseRequestLine>();
		for (PurchaseRequestLine prLine : prLines) {
			if (prLine.getPrID() == purchaseRequestID)
				result.add(prLine);
		}
		return result;
	}

	@Override
	public boolean containsPRLine(PurchaseRequestLine purchaseRequestLine) throws TransactionException {
		// TODO Auto-generated method stub
		return contains(purchaseRequestLine);
	}

	@Override
	public void removePRLine(PurchaseRequestLine purchaseRequestLine) throws TransactionException {
		// TODO Auto-generated method stub
		remove(purchaseRequestLine);
	}

	@Override
	public List<PurchaseRequestLine> getAllPRLine() throws TransactionException {
		// TODO Auto-generated method stub
		return getList(PurchaseRequestLine.class);
	}

}
