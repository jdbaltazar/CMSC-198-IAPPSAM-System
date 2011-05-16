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
		// TODO Auto-generated method stub
		add(purchaseOrder);
	}

	@Override
	public String savePO(PurchaseOrder purchaseOrder)
			throws TransactionException {
		// TODO Auto-generated method stub
		return (String) save(purchaseOrder);
	}

	@Override
	public void updatePO(PurchaseOrder purchaseOrder)
			throws TransactionException {
		// TODO Auto-generated method stub
		update(purchaseOrder);
	}

	@Override
	public PurchaseOrder getPO(String poNumber) throws TransactionException {
		// TODO Auto-generated method stub
		return (PurchaseOrder) get(PurchaseOrder.class, poNumber);
	}

	@Override
	public boolean containsPO(PurchaseOrder purchaseOrder)
			throws TransactionException {
		// TODO Auto-generated method stub
		return contains(purchaseOrder);
	}

	@Override
	public List<PurchaseOrder> getAllPO() throws TransactionException {
		// TODO Auto-generated method stub
		return getList(PurchaseOrder.class);
	}

	@Override
	public void addPOLine(PurchaseOrderLine purchaseOrderLine)
			throws TransactionException {
		// TODO Auto-generated method stub
		add(purchaseOrderLine);
	}

	@Override
	public void updatePOLine(PurchaseOrderLine purchaseOrderLine)
			throws TransactionException {
		// TODO Auto-generated method stub
		update(purchaseOrderLine);
	}

	@Override
	public List<PurchaseOrderLine> getPOLineByPO(String poNumber)
			throws TransactionException {
		// TODO Auto-generated method stub
		List<PurchaseOrderLine> poLines = getAllPOLine();
		List<PurchaseOrderLine> result = new ArrayList<PurchaseOrderLine>();
		for (PurchaseOrderLine poLine : poLines) {
			if (poLine.getPoNumber().equalsIgnoreCase(poNumber)) {
				result.add(poLine);
			}
		}
		return result;
	}

	@Override
	public boolean containsPOLine(PurchaseOrderLine purchaseOrderLine)
			throws TransactionException {
		// TODO Auto-generated method stub
		return contains(purchaseOrderLine);
	}

	@Override
	public List<PurchaseOrderLine> getAllPOLine() throws TransactionException {
		// TODO Auto-generated method stub
		return getList(PurchaseOrderLine.class);
	}

	@Override
	public void addModeOfProcurement(ModeOfProcurement modeOfProcurement)
			throws TransactionException {
		// TODO Auto-generated method stub
		add(modeOfProcurement);
	}

	@Override
	public void updateModeOfProcurement(ModeOfProcurement modeOfProcurement)
			throws TransactionException {
		// TODO Auto-generated method stub
		update(modeOfProcurement);
	}

	@Override
	public boolean containsModeOfProcurement(ModeOfProcurement modeOfProcurement)
			throws TransactionException {
		// TODO Auto-generated method stub
		return contains(modeOfProcurement);
	}

	@Override
	public List<ModeOfProcurement> getAllModeOfProcurement()
			throws TransactionException {
		// TODO Auto-generated method stub
		return getList(ModeOfProcurement.class);
	}

}
