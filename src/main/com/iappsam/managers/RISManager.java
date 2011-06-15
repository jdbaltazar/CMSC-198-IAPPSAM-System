package com.iappsam.managers;

import java.util.List;

import com.iappsam.forms.RAIS;
import com.iappsam.managers.exceptions.TransactionException;

public interface RISManager {
	
	//RIS
	
	void addRIS(RAIS requisitionAndIssueSlip) throws TransactionException;
	
	void updateRIS(RAIS requisitionAndIssueSlip) throws TransactionException;
	
	RAIS getRIS(String requisitionAndIssueSlipID) throws TransactionException;
	
	boolean containsRIS(RAIS requisitionAndIssueSlip) throws TransactionException;
	
	List<RAIS>getAllRIS() throws TransactionException;
	
}
