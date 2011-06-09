package com.iappsam.managers;

import java.util.List;

import com.iappsam.entities.forms.PTRPA;
import com.iappsam.managers.exceptions.TransactionException;

public interface PTRPAManager {

	// PTRPA

	void addPTRPA(PTRPA ptrpa) throws TransactionException;

	void updatePTRPA(PTRPA ptrpa) throws TransactionException;

	PTRPA getPTRPA(int ptrpaID) throws TransactionException;

	boolean containsPTRPA(PTRPA ptrpa) throws TransactionException;

	List<PTRPA> getAllPTRPA() throws TransactionException;

}
