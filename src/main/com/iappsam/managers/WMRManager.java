package com.iappsam.managers;

import java.util.List;

import com.iappsam.forms.Disposal;
import com.iappsam.forms.WMR;
import com.iappsam.managers.exceptions.TransactionException;

public interface WMRManager {

	// WMR

	void addWMR(WMR wasteMaterialsReport) throws TransactionException;

	void updateWMR(WMR wasteMaterialsReport) throws TransactionException;

	WMR getWMR(int wasteMaterialsReportID) throws TransactionException;

	boolean containsWMR(WMR wasteMaterialsReport) throws TransactionException;

	List<WMR> getAllWMR(WMR wasteMaterialsReport) throws TransactionException;

	// Disposal

	void addDisposal(Disposal disposal) throws TransactionException;

	void updateDisposal(Disposal disposal) throws TransactionException;

	Disposal getDisposal(int disposalID) throws TransactionException;

	Disposal getDisposal(String disposal) throws TransactionException;

	void removeDisposal(Disposal disposal) throws TransactionException;

	boolean containsDisposal(Disposal disposal) throws TransactionException;

	List<Disposal> getAllDisposal() throws TransactionException;

	void addDisposal(String string) throws TransactionException;

}
