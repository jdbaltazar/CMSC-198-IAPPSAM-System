package com.iappsam.managers;

import java.util.List;

import com.iappsam.entities.forms.RSMI;
import com.iappsam.entities.forms.RSMILine;
import com.iappsam.entities.forms.RecapitulationLine;
import com.iappsam.managers.exceptions.TransactionException;

public interface RSMIManager {
	
	//RSMI
	
	void addRSMI(RSMI rsmi) throws TransactionException;
	
	int saveRSMI(RSMI rsmi) throws TransactionException;
	
	void updateRSMI(RSMI rsmi) throws TransactionException;
	
	RSMI getRSMI(int rsmiID) throws TransactionException;
	
	boolean containsRSMI(RSMI rsmi) throws TransactionException;
	
	List<RSMI>getAllRSMI() throws TransactionException;
	
	//RSMILine
	
	void addRSMILine(RSMILine rsmiLine) throws TransactionException;
	
	void updateRSMILine(RSMILine rsmiLine) throws TransactionException;
	
	List<RSMILine>getRSMILineByRSMI(int rsmiID) throws TransactionException;
	
	boolean containsRSMILine(RSMILine rsmiLine) throws TransactionException;
	
	List<RSMILine>getAllRSMILine() throws TransactionException;
	
	//RecapitulationLine
	
	void addRecapitulationLine(RecapitulationLine recapitulationLine) throws TransactionException;
	
	void updateRecapitulationLine(RecapitulationLine recapitulationLine) throws TransactionException;
	
	List<RecapitulationLine>getRecapitulationLineByRSMI(int rsmiID) throws TransactionException;
	
	boolean containsRecapitulationLine(RecapitulationLine recapitulationLine) throws TransactionException;
	
	List<RecapitulationLine>getAllRecapitulationLine() throws TransactionException;

}
