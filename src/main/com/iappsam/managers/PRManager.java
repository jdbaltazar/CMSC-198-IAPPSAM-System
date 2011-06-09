package com.iappsam.managers;

import java.util.List;

import com.iappsam.entities.forms.PurchaseRequest;
import com.iappsam.entities.forms.PurchaseRequestLine;
import com.iappsam.managers.exceptions.TransactionException;

public interface PRManager {

	// PR

	void addPR(PurchaseRequest purchaseRequest) throws TransactionException;

	void updatePR(PurchaseRequest purchaseRequest) throws TransactionException;

	PurchaseRequest getPR(int purchaseRequestID) throws TransactionException;

	boolean containsPR(PurchaseRequest purchaseRequest) throws TransactionException;

	List<PurchaseRequest> getAllPR() throws TransactionException;

	void removePR(PurchaseRequest pr) throws TransactionException;

}
