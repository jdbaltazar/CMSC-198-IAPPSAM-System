package com.iappsam.managers;

import java.util.List;

import com.iappsam.forms.Form;
import com.iappsam.forms.ModeOfProcurement;
import com.iappsam.forms.PO;
import com.iappsam.managers.exceptions.DuplicateEntryException;
import com.iappsam.managers.exceptions.TransactionException;

public interface POManager {

	// PO

	void addPO(PO purchaseOrder) throws TransactionException;

	void updatePO(PO purchaseOrder) throws TransactionException;

	Form getPO(int id) throws TransactionException;

	boolean containsPO(PO purchaseOrder) throws TransactionException;

	List<PO> getAllPO() throws TransactionException;

	// ModeOfProcurement

	void addModeOfProcurement(ModeOfProcurement modeOfProcurement) throws TransactionException, DuplicateEntryException;

	void updateModeOfProcurement(ModeOfProcurement modeOfProcurement) throws TransactionException;

	ModeOfProcurement getModeOfProcurement(int id) throws TransactionException;

	ModeOfProcurement getModeOfProcurement(String name) throws TransactionException;

	boolean containsModeOfProcurement(ModeOfProcurement modeOfProcurement) throws TransactionException;

	List<ModeOfProcurement> getAllModeOfProcurement() throws TransactionException;

	void removePurchaseOrder(PO po) throws TransactionException;

	void removeModeOfProcurement(ModeOfProcurement mop) throws TransactionException;

}
