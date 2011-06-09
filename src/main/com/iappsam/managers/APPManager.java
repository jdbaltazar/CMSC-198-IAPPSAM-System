package com.iappsam.managers;

import java.util.List;

import com.iappsam.entities.forms.AnnualProcurementPlan;
import com.iappsam.entities.forms.AnnualProcurementPlanLine;
import com.iappsam.managers.exceptions.TransactionException;

public interface APPManager {

	// APP

	void addAPP(AnnualProcurementPlan annualProcurementPlan) throws TransactionException;


	void updateAPP(AnnualProcurementPlan annualProcurementPlan) throws TransactionException;

	AnnualProcurementPlan getAPP(int appID) throws TransactionException;

	boolean containsAPP(AnnualProcurementPlan annualProcurementPlan) throws TransactionException;

	List<AnnualProcurementPlan> getAllAPP() throws TransactionException;

	void removeAPP(AnnualProcurementPlan app) throws TransactionException;

}
