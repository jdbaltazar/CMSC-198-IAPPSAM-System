package com.iappsam.managers.sessions;

import java.util.ArrayList;
import java.util.List;

import com.iappsam.entities.forms.ModeOfProcurement;
import com.iappsam.entities.forms.PurchaseOrder;
import com.iappsam.entities.forms.PurchaseOrderLine;
import com.iappsam.managers.AbstractManager;
import com.iappsam.managers.POManager;
import com.iappsam.managers.exceptions.TransactionException;

public class POManagerSession extends AbstractManager implements POManager {

	@Override
	public void addPO(PurchaseOrder purchaseOrder) throws TransactionException {
		add(purchaseOrder);
	}

	@Override
	public String savePO(PurchaseOrder purchaseOrder) throws TransactionException {
		return (String) save(purchaseOrder);
	}

	@Override
	public void updatePO(PurchaseOrder purchaseOrder) throws TransactionException {
		update(purchaseOrder);
	}

	@Override
	public PurchaseOrder getPO(String poNumber) throws TransactionException {
		return (PurchaseOrder) get(PurchaseOrder.class, poNumber);
	}

	@Override
	public boolean containsPO(PurchaseOrder purchaseOrder) throws TransactionException {
		return contains(purchaseOrder);
	}

	@Override
	public List<PurchaseOrder> getAllPO() throws TransactionException {
		return getAll(PurchaseOrder.class);
	}

	@Override
	public void addModeOfProcurement(ModeOfProcurement modeOfProcurement) throws TransactionException {
		add(modeOfProcurement);
	}

	@Override
	public void updateModeOfProcurement(ModeOfProcurement modeOfProcurement) throws TransactionException {
		update(modeOfProcurement);
	}

	@Override
	public boolean containsModeOfProcurement(ModeOfProcurement modeOfProcurement) throws TransactionException {
		return contains(modeOfProcurement);
	}

	@Override
	public List<ModeOfProcurement> getAllModeOfProcurement() throws TransactionException {
		return getAll(ModeOfProcurement.class);
	}

	@Override
	public ModeOfProcurement getModeOfProcurement(int id) throws TransactionException {
		return (ModeOfProcurement) get(ModeOfProcurement.class, id);
	}

	@Override
	public ModeOfProcurement getModeOfProcurement(String name) throws TransactionException {
		// TODO Auto-generated method stub
		List<ModeOfProcurement> mops = getAllModeOfProcurement();
		for (ModeOfProcurement m : mops) {
			if (m.getModeOfProcurement().equalsIgnoreCase(name))
				return m;
		}
		return null;
	}

}
