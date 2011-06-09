package com.iappsam.managers;

import java.util.List;

import com.iappsam.entities.forms.RSMI;
import com.iappsam.entities.forms.RSMILine;
import com.iappsam.entities.forms.RecapitulationLine;
import com.iappsam.managers.exceptions.TransactionException;

public interface RSMIManager {

	// RSMI

	void addRSMI(RSMI rsmi) throws TransactionException;

	void updateRSMI(RSMI rsmi) throws TransactionException;

	RSMI getRSMI(int rsmiID) throws TransactionException;

	boolean containsRSMI(RSMI rsmi) throws TransactionException;

	List<RSMI> getAllRSMI() throws TransactionException;
}
