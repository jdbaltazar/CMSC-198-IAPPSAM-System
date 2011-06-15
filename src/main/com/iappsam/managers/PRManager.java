package com.iappsam.managers;

import java.util.List;

import com.iappsam.forms.PR;
import com.iappsam.managers.exceptions.TransactionException;

public interface PRManager {

	// PR

	void addPR(PR purchaseRequest) throws TransactionException;

	void updatePR(PR purchaseRequest) throws TransactionException;

	PR getPR(int purchaseRequestID) throws TransactionException;

	boolean containsPR(PR purchaseRequest) throws TransactionException;

	List<PR> getAllPR() throws TransactionException;

	void removePR(PR pr) throws TransactionException;

	PR getPR(PR pr) throws TransactionException;

}
