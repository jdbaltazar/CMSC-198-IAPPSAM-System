package com.iappsam.managers;

import java.util.List;

import com.iappsam.forms.APP;
import com.iappsam.managers.exceptions.TransactionException;

public interface APPManager {

	// APP

	void addAPP(APP annualProcurementPlan) throws TransactionException;


	void updateAPP(APP annualProcurementPlan) throws TransactionException;

	APP getAPP(int appID) throws TransactionException;

	boolean containsAPP(APP annualProcurementPlan) throws TransactionException;

	List<APP> getAllAPP() throws TransactionException;

	void removeAPP(APP app) throws TransactionException;

}
