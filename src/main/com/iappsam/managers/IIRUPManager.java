package com.iappsam.managers;

import java.util.List;

import com.iappsam.entities.forms.IIRUP;
import com.iappsam.entities.forms.IIRUPLine;
import com.iappsam.managers.exceptions.TransactionException;

public interface IIRUPManager {
	
	//IIRUP
	
	void addIIRUP(IIRUP iirup) throws TransactionException;
	
	int saveIIRUP(IIRUP iirup) throws TransactionException;
	
	void updateIIRUP(IIRUP iirup) throws TransactionException;
	
	IIRUP getIIRUP(int iirupID) throws TransactionException;
	
	boolean containsIIRUP(IIRUP iirup) throws TransactionException;
	
	List<IIRUP>getAllIIRUP() throws TransactionException;
	
	//IIRUPLine
	
	void addIIRUPLine(IIRUPLine iirupLine) throws TransactionException;
	
	void updateIIRUPLine(IIRUPLine iirupLine) throws TransactionException;
	
	List<IIRUPLine>getIIRUPLineByIIRUP(int iiruID) throws TransactionException;
	
	boolean containsIIRUPLine(IIRUPLine iirupLine) throws TransactionException;
	
	List<IIRUPLine>getAllIIRUPLine() throws TransactionException;
	
	
}
