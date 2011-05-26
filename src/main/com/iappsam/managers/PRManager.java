package com.iappsam.managers;

import java.util.List;

import com.iappsam.entities.forms.PurchaseRequest;
import com.iappsam.entities.forms.PurchaseRequestLine;
import com.iappsam.managers.exceptions.TransactionException;

public interface PRManager {

	// PR

	void addPR(PurchaseRequest purchaseRequest) throws TransactionException;

	int savePR(PurchaseRequest purchaseRequest) throws TransactionException;

	void updatePR(PurchaseRequest purchaseRequest) throws TransactionException;

	PurchaseRequest getPR(int purchaseRequestID) throws TransactionException;

	boolean containsPR(PurchaseRequest purchaseRequest) throws TransactionException;

	List<PurchaseRequest> getAllPR() throws TransactionException;

	// PRLine

	void addPRLine(PurchaseRequestLine purchaseRequestLine) throws TransactionException;

	void updatePRLine(PurchaseRequestLine purchaseRequestLine) throws TransactionException;

	List<PurchaseRequestLine> getPRLineByPR(int purchaseRequestID) throws TransactionException;

	boolean containsPRLine(PurchaseRequestLine purchaseRequestLine) throws TransactionException;

	void removePRLine(PurchaseRequestLine purchaseRequestLine) throws TransactionException;

	List<PurchaseRequestLine> getAllPRLine() throws TransactionException;

	void removePR(PurchaseRequest pr) throws TransactionException;

}
