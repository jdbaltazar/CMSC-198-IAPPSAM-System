package com.iappsam.managers;

import java.util.List;

import com.iappsam.entities.forms.Disposal;
import com.iappsam.entities.forms.WasteMaterialsReport;
import com.iappsam.managers.exceptions.TransactionException;

public interface WMRManager {

	// WMR

	void addWMR(WasteMaterialsReport wasteMaterialsReport) throws TransactionException;

	void updateWMR(WasteMaterialsReport wasteMaterialsReport) throws TransactionException;

	WasteMaterialsReport getWMR(int wasteMaterialsReportID) throws TransactionException;

	boolean containsWMR(WasteMaterialsReport wasteMaterialsReport) throws TransactionException;

	List<WasteMaterialsReport> getAllWMR(WasteMaterialsReport wasteMaterialsReport) throws TransactionException;

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
