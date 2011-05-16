package com.iappsam.managers;

import java.util.List;

import com.iappsam.entities.forms.ModeOfProcurement;
import com.iappsam.entities.forms.PurchaseOrder;
import com.iappsam.entities.forms.PurchaseOrderLine;
import com.iappsam.managers.exceptions.TransactionException;

public interface POManager {

	// PO

	void addPO(PurchaseOrder purchaseOrder) throws TransactionException;

	String savePO(PurchaseOrder purchaseOrder) throws TransactionException;

	void updatePO(PurchaseOrder purchaseOrder) throws TransactionException;

	PurchaseOrder getPO(String poNumber) throws TransactionException;

	boolean containsPO(PurchaseOrder purchaseOrder) throws TransactionException;

	List<PurchaseOrder> getAllPO() throws TransactionException;

	// POLine

	void addPOLine(PurchaseOrderLine purchaseOrderLine)
			throws TransactionException;

	void updatePOLine(PurchaseOrderLine purchaseOrderLine)
			throws TransactionException;

	List<PurchaseOrderLine> getPOLineByPO(String poNumber)
			throws TransactionException;

	boolean containsPOLine(PurchaseOrderLine purchaseOrderLine)
			throws TransactionException;

	List<PurchaseOrderLine> getAllPOLine() throws TransactionException;

	// ModeOfProcurement

	void addModeOfProcurement(ModeOfProcurement modeOfProcurement)
			throws TransactionException;

	void updateModeOfProcurement(ModeOfProcurement modeOfProcurement)
			throws TransactionException;

	boolean containsModeOfProcurement(ModeOfProcurement modeOfProcurement)
			throws TransactionException;

	List<ModeOfProcurement> getAllModeOfProcurement()
			throws TransactionException;
}
