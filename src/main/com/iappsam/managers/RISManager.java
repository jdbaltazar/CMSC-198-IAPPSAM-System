package com.iappsam.managers;

import java.util.List;

import com.iappsam.forms.RIS;
import com.iappsam.managers.exceptions.TransactionException;

public interface RISManager {

	void addRIS(RIS requisitionAndIssueSlip) throws TransactionException;

	void updateRIS(RIS requisitionAndIssueSlip) throws TransactionException;

	RIS getRIS(String requisitionAndIssueSlipID) throws TransactionException;

	boolean containsRIS(RIS requisitionAndIssueSlip) throws TransactionException;

	List<RIS> getAllRIS() throws TransactionException;

	RIS getRIS(int id) throws TransactionException;

}
