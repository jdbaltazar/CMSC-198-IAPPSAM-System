package com.iappsam.managers;

import java.util.List;

import com.iappsam.entities.forms.IIRUP;
import com.iappsam.managers.exceptions.TransactionException;

public interface IIRUPManager {

	void addIIRUP(IIRUP iirup) throws TransactionException;


	void updateIIRUP(IIRUP iirup) throws TransactionException;

	IIRUP getIIRUP(int iirupID) throws TransactionException;

	boolean containsIIRUP(IIRUP iirup) throws TransactionException;

	List<IIRUP> getAllIIRUP() throws TransactionException;

	void removeIIRUP(IIRUP iirup) throws TransactionException;

}
