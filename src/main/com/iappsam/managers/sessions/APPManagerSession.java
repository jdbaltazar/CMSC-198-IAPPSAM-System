package com.iappsam.managers.sessions;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.Transaction;

import com.iappsam.entities.forms.AnnualProcurementPlan;
import com.iappsam.managers.APPManager;
import com.iappsam.managers.AbstractManager;
import com.iappsam.managers.exceptions.TransactionException;
import com.iappsam.util.HibernateUtil;

public class APPManagerSession extends AbstractManager implements APPManager {

	@Override
	public void addAPP(AnnualProcurementPlan annualProcurementPlan) throws TransactionException {
		add(annualProcurementPlan);
	}

	@Override
	public void updateAPP(AnnualProcurementPlan annualProcurementPlan) throws TransactionException {
		update(annualProcurementPlan);
	}

	@Override
	public AnnualProcurementPlan getAPP(int appID) throws TransactionException {
		return (AnnualProcurementPlan) get(AnnualProcurementPlan.class, appID);
	}

	@Override
	public boolean containsAPP(AnnualProcurementPlan app) throws TransactionException {
		return getAPP(app.getId()) != null;
	}

	@Override
	public List<AnnualProcurementPlan> getAllAPP() throws TransactionException {

		Session session = HibernateUtil.startSession();
		Transaction tx = session.beginTransaction();

		List<AnnualProcurementPlan> list = session.createQuery("from AnnualProcurementPlan").list();

		tx.commit();
		session.close();
		return list;
	}

	@Override
	public void removeAPP(AnnualProcurementPlan app) throws TransactionException {
		remove(app);
	}
}
