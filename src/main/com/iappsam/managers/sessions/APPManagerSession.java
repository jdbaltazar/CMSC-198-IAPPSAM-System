package com.iappsam.managers.sessions;

import java.util.ArrayList;
import java.util.List;

import com.iappsam.entities.forms.AnnualProcurementPlan;
import com.iappsam.entities.forms.AnnualProcurementPlanLine;
import com.iappsam.managers.APPManager;
import com.iappsam.managers.AbstractManager;
import com.iappsam.managers.exceptions.TransactionException;

public class APPManagerSession extends AbstractManager implements APPManager{

	@Override
	public void addAPP(AnnualProcurementPlan annualProcurementPlan)
			throws TransactionException {
		// TODO Auto-generated method stub
		add(annualProcurementPlan);
	}

	@Override
	public int saveAPP(AnnualProcurementPlan annualProcurementPlan)
			throws TransactionException {
		// TODO Auto-generated method stub
		return (Integer)save(annualProcurementPlan);
	}

	@Override
	public void updateAPP(AnnualProcurementPlan annualProcurementPlan)
			throws TransactionException {
		// TODO Auto-generated method stub
		update(annualProcurementPlan);
	}

	@Override
	public AnnualProcurementPlan getAPP(int year, int divisionOfficeID)
			throws TransactionException {
		// TODO Auto-generated method stub
//		return (AnnualProcurementPlan)get(AnnualProcurementPlan.class, annualProcurementPlanID);
		throw new TransactionException();
	}

	@Override
	public boolean containsAPP(AnnualProcurementPlan annualProcurementPlan)
			throws TransactionException {
		// TODO Auto-generated method stub
		return contains(annualProcurementPlan);
	}

	@Override
	public List<AnnualProcurementPlan> getAllAPP(
			AnnualProcurementPlan annualProcurementPlan)
			throws TransactionException {
		// TODO Auto-generated method stub
		return getList(AnnualProcurementPlan.class);
	}

	@Override
	public void addAPPLine(AnnualProcurementPlanLine annualProcurementPlanLine)
			throws TransactionException {
		// TODO Auto-generated method stub
		add(annualProcurementPlanLine);
	}

	@Override
	public void updateAPPLine(
			AnnualProcurementPlanLine annualProcurementPlanLine)
			throws TransactionException {
		// TODO Auto-generated method stub
		update(annualProcurementPlanLine);
	}

	@Override
	public List<AnnualProcurementPlanLine> getAPPLineByAPP(int year, int divisionOfficeID)
			throws TransactionException {
		// TODO Auto-generated method stub
		
		List<AnnualProcurementPlanLine>appLines = getAllAPPLine();
		List<AnnualProcurementPlanLine>result = new ArrayList<AnnualProcurementPlanLine>();
//		for(AnnualProcurementPlanLine appLine: appLines){
//			if(appLine.getAppID()==appID){
//				result.add(appLine);
//			}
//		}
		throw new TransactionException();
//		return result;
	}

	@Override
	public boolean containsAPPLine(
			AnnualProcurementPlanLine annualProcurementPlanLine)
			throws TransactionException {
		// TODO Auto-generated method stub
		return contains(annualProcurementPlanLine);
	}

	@Override
	public List<AnnualProcurementPlanLine> getAllAPPLine()
			throws TransactionException {
		// TODO Auto-generated method stub
		return getList(AnnualProcurementPlanLine.class);
	}

}
