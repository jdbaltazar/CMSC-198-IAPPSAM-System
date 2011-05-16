package com.iappsam.managers;

import java.util.List;

import com.iappsam.entities.forms.RequisitionAndIssueSlip;
import com.iappsam.entities.forms.RequisitionAndIssueSlipLine;
import com.iappsam.managers.exceptions.TransactionException;

public interface RISManager {
	
	//RIS
	
	void addRIS(RequisitionAndIssueSlip requisitionAndIssueSlip) throws TransactionException;
	
	int saveRIS(RequisitionAndIssueSlip requisitionAndIssueSlip) throws TransactionException;
	
	void updateRIS(RequisitionAndIssueSlip requisitionAndIssueSlip) throws TransactionException;
	
	RequisitionAndIssueSlip getRIS(int requisitionAndIssueSlipID) throws TransactionException;
	
	boolean containsRIS(RequisitionAndIssueSlip requisitionAndIssueSlip) throws TransactionException;
	
	List<RequisitionAndIssueSlip>getAllRIS() throws TransactionException;
	
	//RISLine
	
	void addRISLine(RequisitionAndIssueSlipLine requisitionAndIssueSlipLine) throws TransactionException;
	
	void updateRISLine(RequisitionAndIssueSlipLine requisitionAndIssueSlipLine) throws TransactionException;

	List<RequisitionAndIssueSlipLine>getRISLineByRIS(int requisitionAndIssueSlipID) throws TransactionException;
	
	boolean containsRISLine(RequisitionAndIssueSlipLine requisitionAndIssueSlipLine) throws TransactionException;
	
	List<RequisitionAndIssueSlipLine>getAllRISLine() throws TransactionException;

}
