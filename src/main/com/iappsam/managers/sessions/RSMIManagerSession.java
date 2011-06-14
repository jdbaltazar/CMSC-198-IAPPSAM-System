package com.iappsam.managers.sessions;

import java.util.List;

import com.iappsam.forms.RSMI;
import com.iappsam.managers.AbstractManager;
import com.iappsam.managers.RSMIManager;
import com.iappsam.managers.exceptions.TransactionException;

public class RSMIManagerSession extends AbstractManager implements RSMIManager {

	@Override
	public void addRSMI(RSMI rsmi) throws TransactionException {
		add(rsmi);
	}

	@Override
	public void updateRSMI(RSMI rsmi) throws TransactionException {
		update(rsmi);
	}

	@Override
	public RSMI getRSMI(int rsmiID) throws TransactionException {
		return (RSMI) get(RSMI.class, rsmiID);
	}

	@Override
	public boolean containsRSMI(RSMI rsmi) throws TransactionException {
		return getRSMI(rsmi.getRsmiID()) != null;
	}

	@Override
	public List<RSMI> getAllRSMI() throws TransactionException {
		return getAllRSMI();
	}

}
