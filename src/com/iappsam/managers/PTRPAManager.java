package com.iappsam.managers;

import java.util.List;

import com.iappsam.entities.forms.PTRPA;
import com.iappsam.entities.forms.PTRPALine;
import com.iappsam.managers.exceptions.TransactionException;

public interface PTRPAManager {
	
	//PTRPA

	void addPTRPA(PTRPA ptrpa) throws TransactionException;

	int savePTRPA(PTRPA ptrpa) throws TransactionException;

	void updatePTRPA(PTRPA ptrpa) throws TransactionException;

	PTRPA getPTRPA(int ptrpaID) throws TransactionException;

	boolean containsPTRPA(PTRPA ptrpa) throws TransactionException;

	List<PTRPA> getAllPTRPA() throws TransactionException;
	
	//PTRPALine
	
	void addPTRPALine(PTRPALine ptrpaLine) throws TransactionException;
	
	void updatePTRPALine(PTRPALine ptrpaLine) throws TransactionException;
	
	List<PTRPALine>getPTRPALineByPTRPA(int ptrpaID) throws TransactionException;
	
	boolean containsPTRPALine(PTRPALine ptrpaLine) throws TransactionException;
	
	List<PTRPALine>getAllPTRPALine() throws TransactionException;

}
