package com.iappsam.managers.sessions;

import java.util.List;

import com.iappsam.forms.APP;
import com.iappsam.managers.APPManager;
import com.iappsam.managers.AbstractManager;
import com.iappsam.managers.exceptions.TransactionException;

public class APPManagerSession extends AbstractManager implements APPManager {

	@Override
	public void addAPP(APP annualProcurementPlan) throws TransactionException {
		add(annualProcurementPlan);
	}

	@Override
	public void updateAPP(APP annualProcurementPlan) throws TransactionException {
		update(annualProcurementPlan);
	}

	@Override
	public APP getAPP(int appID) throws TransactionException {
		return (APP) get(APP.class, appID);
	}

	@Override
	public boolean containsAPP(APP app) throws TransactionException {
		return getAPP(app.getId()) != null;
	}

	@Override
	public List<APP> getAllAPP() throws TransactionException {
		return getAll(APP.class);
	}

	@Override
	public void removeAPP(APP app) throws TransactionException {
		remove(app);
	}
}
