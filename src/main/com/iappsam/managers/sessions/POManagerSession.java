package com.iappsam.managers.sessions;

import java.util.ArrayList;
import java.util.List;

import com.iappsam.entities.forms.ModeOfProcurement;
import com.iappsam.entities.forms.PurchaseOrder;
import com.iappsam.entities.forms.PurchaseOrderLine;
import com.iappsam.managers.AbstractManager;
import com.iappsam.managers.POManager;
import com.iappsam.managers.exceptions.DuplicateEntryException;
import com.iappsam.managers.exceptions.TransactionException;

public class POManagerSession extends AbstractManager implements POManager {

	@Override
	public void addPO(PurchaseOrder purchaseOrder) throws TransactionException {
		add(purchaseOrder);
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
	public boolean containsPO(PurchaseOrder po) throws TransactionException {
		return getPO(po.getPoNumber()) != null;
	}

	@Override
	public List<PurchaseOrder> getAllPO() throws TransactionException {
		return getAll(PurchaseOrder.class);
	}

	@Override
	public void removePurchaseOrder(PurchaseOrder po) throws TransactionException {
		remove(po);
	}

	@Override
	public void addModeOfProcurement(ModeOfProcurement modeOfProcurement) throws TransactionException, DuplicateEntryException {
		ModeOfProcurement mop = getModeOfProcurement(modeOfProcurement.getName());
		if (mop == null)
			add(modeOfProcurement);
		else
			modeOfProcurement.setId(mop.getId());
	}

	@Override
	public void updateModeOfProcurement(ModeOfProcurement mop) throws TransactionException {
		update(mop);
	}

	@Override
	public boolean containsModeOfProcurement(ModeOfProcurement mop) throws TransactionException {
		return getModeOfProcurement(mop.getId()) != null;
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
		List<ModeOfProcurement> mops = getAllModeOfProcurement();
		for (ModeOfProcurement m : mops) {
			if (m.getName().equalsIgnoreCase(name))
				return m;
		}
		return null;
	}

	@Override
	public void removeModeOfProcurement(ModeOfProcurement mop) throws TransactionException {
		remove(mop);
	}
}
