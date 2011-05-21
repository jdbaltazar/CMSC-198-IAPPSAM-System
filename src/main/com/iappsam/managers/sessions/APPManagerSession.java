package com.iappsam.managers.sessions;

import java.util.List;

import com.iappsam.entities.forms.AnnualProcurementPlan;
import com.iappsam.entities.forms.AnnualProcurementPlanLine;
import com.iappsam.managers.APPManager;
import com.iappsam.managers.AbstractManager;
import com.iappsam.managers.exceptions.TransactionException;

public class APPManagerSession extends AbstractManager implements APPManager {

	@Override
	public void addAPP(AnnualProcurementPlan annualProcurementPlan) throws TransactionException {
		add(annualProcurementPlan);
	}

	@Override
	public int saveAPP(AnnualProcurementPlan annualProcurementPlan) throws TransactionException {
		return (Integer) save(annualProcurementPlan);
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
		return contains(app);
	}

	@Override
	public List<AnnualProcurementPlan> getAllAPP(AnnualProcurementPlan annualProcurementPlan) throws TransactionException {
		return getList(AnnualProcurementPlan.class);
	}

	@Override
	public void addAPPLine(AnnualProcurementPlanLine appLine) throws TransactionException {
		add(appLine);
	}

	@Override
	public void updateAPPLine(AnnualProcurementPlanLine appLine) throws TransactionException {
		update(appLine);
	}

	@Override
	public boolean containsAPPLine(AnnualProcurementPlanLine annualProcurementPlanLine) throws TransactionException {
		return contains(annualProcurementPlanLine);
	}

	@Override
	public List<AnnualProcurementPlanLine> getAllAPPLine() throws TransactionException {
		return getList(AnnualProcurementPlanLine.class);
	}

	@Override
	public void removeAPP(AnnualProcurementPlan app) throws TransactionException {
		remove(app);
	}
}
