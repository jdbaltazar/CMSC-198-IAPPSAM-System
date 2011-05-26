package com.iappsam.managers;

import java.util.List;

import com.iappsam.entities.forms.Disposal;
import com.iappsam.entities.forms.WasteMaterialsReport;
import com.iappsam.entities.forms.WasteMaterialsReportLine;
import com.iappsam.managers.exceptions.TransactionException;

public interface WMRManager {
	
	//WMR
	
	void addWMR(WasteMaterialsReport wasteMaterialsReport) throws TransactionException;
	
	int saveWMR(WasteMaterialsReport wasteMaterialsReport) throws TransactionException;
	
	void updateWMR(WasteMaterialsReport wasteMaterialsReport) throws TransactionException;
	
	WasteMaterialsReport getWMR(int wasteMaterialsReportID) throws TransactionException;
	
	boolean containsWMR(WasteMaterialsReport wasteMaterialsReport) throws TransactionException;
	
	List<WasteMaterialsReport>getAllWMR(WasteMaterialsReport wasteMaterialsReport) throws TransactionException;
	
	//WMRLine
	
	void addWMRLine(WasteMaterialsReportLine wasteMaterialsReportLine) throws TransactionException;
	
	void updateWMRLine(WasteMaterialsReportLine wasteMaterialsReportLine) throws TransactionException;
	
	List<WasteMaterialsReportLine>getWMRLineByWMR(int wasteMaterialsReportID) throws TransactionException;
	
	boolean containsWMRLine(WasteMaterialsReportLine wasteMaterialsReportLine) throws TransactionException;
	
	List<WasteMaterialsReportLine>getAllWMRLine() throws TransactionException;
	
	//Disposal
	
	void addDisposal(Disposal disposal) throws TransactionException;
	
	String saveDisposal(Disposal disposal) throws TransactionException;
	
	void removeDisposal(Disposal disposal) throws TransactionException;
	
	boolean containsDisposal(Disposal disposal) throws TransactionException;
	
	List<Disposal>getAllDisposal() throws TransactionException;
	
}
