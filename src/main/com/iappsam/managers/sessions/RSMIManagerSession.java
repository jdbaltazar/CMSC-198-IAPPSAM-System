package com.iappsam.managers.sessions;

import java.util.ArrayList;
import java.util.List;

import com.iappsam.entities.forms.RSMI;
import com.iappsam.entities.forms.RSMILine;
import com.iappsam.entities.forms.RecapitulationLine;
import com.iappsam.managers.AbstractManager;
import com.iappsam.managers.RSMIManager;
import com.iappsam.managers.exceptions.TransactionException;

public class RSMIManagerSession extends AbstractManager implements RSMIManager {

	@Override
	public void addRSMI(RSMI rsmi) throws TransactionException {
		// TODO Auto-generated method stub
		add(rsmi);
	}

	@Override
	public int saveRSMI(RSMI rsmi) throws TransactionException {
		// TODO Auto-generated method stub
		return (Integer) save(rsmi);
	}

	@Override
	public void updateRSMI(RSMI rsmi) throws TransactionException {
		// TODO Auto-generated method stub
		update(rsmi);
	}

	@Override
	public RSMI getRSMI(int rsmiID) throws TransactionException {
		// TODO Auto-generated method stub
		return (RSMI) get(RSMI.class, rsmiID);
	}

	@Override
	public boolean containsRSMI(RSMI rsmi) throws TransactionException {
		// TODO Auto-generated method stub
		return contains(rsmi);
	}

	@Override
	public List<RSMI> getAllRSMI() throws TransactionException {
		// TODO Auto-generated method stub
		return getAllRSMI();
	}

	@Override
	public void addRSMILine(RSMILine rsmiLine) throws TransactionException {
		// TODO Auto-generated method stub
		add(rsmiLine);
	}

	@Override
	public void updateRSMILine(RSMILine rsmiLine) throws TransactionException {
		// TODO Auto-generated method stub
		update(rsmiLine);
	}

	@Override
	public List<RSMILine> getRSMILineByRSMI(int rsmiID)
			throws TransactionException {
		// TODO Auto-generated method stub
		List<RSMILine> rsmiLines = getAllRSMILine();
		List<RSMILine> result = new ArrayList<RSMILine>();
		for (RSMILine rsmiLine : rsmiLines) {
			if (rsmiLine.getRsmiID() == rsmiID)
				result.add(rsmiLine);
		}
		return result;
	}

	@Override
	public boolean containsRSMILine(RSMILine rsmiLine)
			throws TransactionException {
		// TODO Auto-generated method stub
		return contains(rsmiLine);
	}

	@Override
	public List<RSMILine> getAllRSMILine() throws TransactionException {
		// TODO Auto-generated method stub
		return getList(RSMILine.class);
	}

	@Override
	public void addRecapitulationLine(RecapitulationLine recapitulationLine)
			throws TransactionException {
		// TODO Auto-generated method stub
		add(recapitulationLine);
	}

	@Override
	public void updateRecapitulationLine(RecapitulationLine recapitulationLine)
			throws TransactionException {
		// TODO Auto-generated method stub
		update(recapitulationLine);
	}

	@Override
	public List<RecapitulationLine> getRecapitulationLineByRSMI(int rsmiID)
			throws TransactionException {
		// TODO Auto-generated method stub
		List<RecapitulationLine> recapLines = getAllRecapitulationLine();
		List<RecapitulationLine> result = new ArrayList<RecapitulationLine>();
		for (RecapitulationLine recapLine : recapLines) {
			if (recapLine.getRsmiID() == rsmiID)
				result.add(recapLine);
		}
		return result;
	}

	@Override
	public boolean containsRecapitulationLine(
			RecapitulationLine recapitulationLine) throws TransactionException {
		// TODO Auto-generated method stub
		return contains(recapitulationLine);
	}

	@Override
	public List<RecapitulationLine> getAllRecapitulationLine()
			throws TransactionException {
		// TODO Auto-generated method stub
		return getList(RecapitulationLine.class);
	}

}
