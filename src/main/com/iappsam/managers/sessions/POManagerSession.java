package com.iappsam.managers.sessions;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.Transaction;

import com.iappsam.forms.ModeOfProcurement;
import com.iappsam.forms.PO;
import com.iappsam.managers.AbstractManager;
import com.iappsam.managers.POManager;
import com.iappsam.managers.exceptions.DuplicateEntryException;
import com.iappsam.managers.exceptions.TransactionException;
import com.iappsam.util.HibernateUtil;

public class POManagerSession extends AbstractManager implements POManager {

	@Override
	public void addPO(PO purchaseOrder) throws TransactionException {
		add(purchaseOrder);
	}

	@Override
	public void updatePO(PO purchaseOrder) throws TransactionException {
		update(purchaseOrder);
	}

	@Override
	public PO getPO(String poNumber) throws TransactionException {
		return (PO) get(PO.class, poNumber);
	}

	@Override
	public boolean containsPO(PO po) throws TransactionException {
		return getPO(po.getPoNumber()) != null;
	}

	@Override
	public List<PO> getAllPO() throws TransactionException {
		Session session = HibernateUtil.startSession();
		Transaction tx = session.beginTransaction();

		List<PO> list = session.createQuery("from PO").list();

		tx.commit();
		session.close();
		return list;
	}

	@Override
	public void removePurchaseOrder(PO po) throws TransactionException {
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
